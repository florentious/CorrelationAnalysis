
<%@page import="kr.co.acorn.util.ChangeMark"%>
<%@page import="kr.co.acorn.dto.PredictDto"%>
<%@page import="kr.co.acorn.dao.PredictDao"%>
<%@page import="kr.co.acorn.dto.MakedDataDto"%>
<%@page import="kr.co.acorn.dao.MakedDataDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page pageEncoding="utf-8" %>

<%@ include file="../inc/header.jsp"%>

<%
	int start = 0;
	int len = 5;
	
	MakedDataDao makedDataDao = MakedDataDao.getInstance();
	PredictDao predictDao = PredictDao.getInstance();
	
	
	ArrayList<MakedDataDto> mdList = makedDataDao.select();
	PredictDto predictDto = predictDao.select();
	
%>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['line','corechart']});
      google.charts.setOnLoadCallback(drawChart);
		<%-- 3가지 값을 받아서 넣는데 이거보니까 중간에 빈값확인해봐야겠는걸? --%>
		
      function drawChart() {
    	var data = new google.visualization.DataTable();
        data.addColumn('date','Date');
        data.addColumn('number','close');
        data.addColumn('number','MA_5');
        data.addColumn('number','MA_60');
        
        <%
        for(MakedDataDto dto : mdList) {
        	
        
        %>
        data.addRows([
        	[new Date('<%=dto.getDate().substring(0,4) %>','<%=dto.getDate().substring(5,7) %>', '<%=dto.getDate().substring(8) %>'), <%=dto.getBit_close() %>, <%=dto.getBit_ma5() %>, <%=dto.getBit_ma60() %>]
        ]);
        
        
        <%
        }
        %>
		
        var options = {
   		  chart: {
   	          title: "Bitcoin's close, MA_5, MA_60"
   	      },
   	      width: 900,
   	      height: 500,
	   	   axes: {
	           x: {
	             0: {side: 'top'}
	           }
	         }
        };

        var chart = new google.charts.Line(document.getElementById('line_top_x'));

        chart.draw(data, google.charts.Line.convertOptions(options));
      }
    </script>



  <!-- breadcrumb start -->
  <nav aria-label="breadcrumb">
    <ol class="breadcrumb">
      <li class="breadcrumb-item"><a href="<%=contextPath %>/bitcoin/info.jsp">Info</a></li>
      <li class="breadcrumb-item active" aria-current="page"><a href="<%=contextPath %>/bitcoin/data.jsp">Data</a></li>
    </ol>
  </nav>
  
  <!-- breadcrumb end -->
  
  <!-- main start -->

  <div class="container">
      <div class="col-sm-12 row">
      	<div><h3>BitCoin's Machine Learning Data</h3></div>

   <%-- input content --%>
			<div id="line_top_x"></div>
			
			
			<h4>BitCoing's Machine Learning Predict </h4>
			<h6>(Arima & Classifier) </h6>
			<table class="table table-hover">
					<colgroup>
						<col width="25%"/>
						<col width="15%"/>
						<col width="10%"/>
						<col width="10%"/>
						<col width="10%"/>
						<col width="10%"/>
						<col width="10%"/>
						<col width="10%"/>
						
					</colgroup>
					  <thead>
					    <tr>		  		
					      <th scope="col">Date</th>
					      <th scope="col">ARIMA</th>
					      <th scope="col">Vote</th>
					      <th scope="col">KNN</th>   
					      <th scope="col">SVM</th>   
					      <th scope="col">RFC</th>   
					      <th scope="col">XGBC</th>   
					      <th scope="col">LGBC</th>   
					    </tr>
					  </thead>
					  <tbody>
					  	<%
							 
							 if(predictDto != null) {
							
							 %>
						
								    <tr>			    	
								      <td><%=predictDto.getDate() %></td>
								      <td><%=predictDto.getBit_arima() %></td>
								      <td><%=ChangeMark.change(predictDto.getBit_vote()) %></td>								      
								      <td><%=ChangeMark.change(predictDto.getBit_knc()) %></td>								      
								      <td><%=ChangeMark.change(predictDto.getBit_svc()) %></td>								      
								      <td><%=ChangeMark.change(predictDto.getBit_rfc()) %></td>								      
								      <td><%=ChangeMark.change(predictDto.getBit_xgbc()) %></td>								      
								      <td><%=ChangeMark.change(predictDto.getBit_lgbc()) %></td>								      
								      
								    </tr>
							    <%
									
								 } else {
								
							    %>
							    
							    <tr>
							    	<td colspan="8"> Don't Exist Data </td>
							    </tr>
							    
							 	<%
							 	} 
							 	%>
					  
					  </tbody>
			</table>
      </div>
  </div>

  <!-- main end -->
  
  
<%@ include file ="../inc/footer.jsp" %>