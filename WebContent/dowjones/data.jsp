

<%@page import="kr.co.acorn.dto.DowJonesDto"%>
<%@page import="kr.co.acorn.dao.DowJonesDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page pageEncoding="utf-8" %>

<%@ include file="../inc/header.jsp"%>

<%
	int start = 0;
	int len = 5;
	
	DowJonesDao dowJonesDao = DowJonesDao.getInstance();
	
	ArrayList<DowJonesDto> dowJonesList = dowJonesDao.select();
	int totalRows = dowJonesDao.getTotalRows();
	
%>

  <!-- breadcrumb start -->
  <nav aria-label="breadcrumb">
    <ol class="breadcrumb">
      <li class="breadcrumb-item"><a href="<%=contextPath %>/dowjones/info.jsp">Info</a></li>
      <li class="breadcrumb-item active" aria-current="page"><a href="<%=contextPath %>/dowjones/data.jsp">Data</a></li>
    </ol>
  </nav>
  
  <!-- breadcrumb end -->
  
  <!-- main start -->

  <div class="container">
      <div class="col-sm-12 row">

   <%-- input content --%>
			
			
			<div class="col-sm-12">
				<%-- wanted --%>
				<strong>CorrelationAnalysis - DowJones</strong>(total : <%=totalRows %>)
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
							 
							 if(dowJonesList.size() != 0) {
								for(DowJonesDto dowJonesDto : dowJonesList) {
							 
							 %>
						
								    <tr>			    	
								      <td><%=dowJonesDto.getDate() %></td>
								      <td><%=dowJonesDto.getClose() %></td>
								      <td><%=dowJonesDto.getOpen() %></td>								      
								      <td><%=dowJonesDto.getHigh() %></td>
								      <td><%=dowJonesDto.getLow() %></td>
								      <td><%=dowJonesDto.getVolume() %></td>
								      
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
  
  
<%@ include file ="../inc/footer.jsp" %>