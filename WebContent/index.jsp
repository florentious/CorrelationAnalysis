
<%@page import="kr.co.acorn.dto.BitcoinDto"%>
<%@page import="kr.co.acorn.dao.BitcoinDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page pageEncoding="utf-8" %>

<%@ include file="inc/header.jsp"%>

<%
	int start = 0;
	int len = 5;
	
	BitcoinDao bitcoinDao = BitcoinDao.getInstance();
	
	ArrayList<BitcoinDto> bitcoinList = bitcoinDao.select();
	int totalRows = bitcoinDao.getTotalRows();
	
%>

  <!-- breadcrumb start -->
  <nav aria-label="breadcrumb">
    <ol class="breadcrumb">
      <li class="breadcrumb-item"><a href="<%=contextPath %>/index.jsp">Home</a></li>
      <li class="breadcrumb-item active" aria-current="page">Library</li>
    </ol>
  </nav>
  
  <!-- breadcrumb end -->
  
  <!-- main start -->

  <div class="container">
      <div class="col-sm-12 row">

   <%-- input content --%>
			
			
			<div class="col-sm-12">
				<%-- wanted --%>
				<strong>CorrelationAnalysis - Bitcoin</strong>(total : <%=totalRows %>)
				<br>
				<div class='col-sm-12 row'>
					<label for="startDate" class="col-sm-3 col-form-label">Start Date</label>
					<div class="col-sm-9">
						<input type="date" name="stratDate" id="startDate" value="2013-01-01"/>
					</div>
					<label for="endDate" class="col-sm-3 col-form-label">End Date</label>
					<div class="col-sm-9">
						<input type="date" name="endDate" id="endDate" value="2020-01-20"/>
					</div>
				
				</div>
				
				
				<table class="table table-hover">
					<colgroup>
						<col width="35%"/>
						<col width="10%"/>
						<col width="10%"/>
						<col width="10%"/>
						<col width="10%"/>
						<col width="25%"/>
						
						
					</colgroup>
					  <thead>
					    <tr>		  		
					      <th scope="col">Date</th>
					      <th scope="col">Close</th>
					      <th scope="col">Open</th>
					      <th scope="col">High</th>   
					      <th scope="col">Low</th>   
					      <th scope="col">Volume</th>   
					    </tr>
					  </thead>
					  <tbody>
					  
							 <%
							 
							 if(bitcoinList.size() != 0) {
								for(BitcoinDto bitcoinDto : bitcoinList) {
							 
							 %>
						
								    <tr>			    	
								      <td><%=bitcoinDto.getDate() %></td>
								      <td><%=bitcoinDto.getClose() %></td>
								      <td><%=bitcoinDto.getOpen() %></td>								      
								      <td><%=bitcoinDto.getHigh() %></td>
								      <td><%=bitcoinDto.getLow() %></td>
								      <td><%=bitcoinDto.getVolume() %></td>
								      
								    </tr>
							    <%
									}
								 } else {
								
							    %>
							    
							    <tr>
							    	<td colspan="6"> Don't Exist Data </td>
							    </tr>
							    
							 	<%
							 	} 
							 	%>
							
							
						
					  </tbody>
				</table>
				
				
			</div>
          
      </div>
  </div>

  <!-- main end -->
  
  
<%@ include file ="inc/footer.jsp" %>
