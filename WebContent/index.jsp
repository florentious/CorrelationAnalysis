
<%@page import="kr.co.acorn.dto.DowJonesDto"%>
<%@page import="kr.co.acorn.dto.GoldDto"%>
<%@page import="kr.co.acorn.dao.DowJonesDao"%>
<%@page import="kr.co.acorn.dao.GoldDao"%>
<%@page import="kr.co.acorn.dto.BitcoinDto"%>
<%@page import="kr.co.acorn.dao.BitcoinDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page pageEncoding="utf-8" %>

<%@ include file="inc/header.jsp"%>

<%
	int start = 0;
	int len = 5;
	
	// plot을 그리기 위한 db에서 데이터 획득
	BitcoinDao bitcoinDao = BitcoinDao.getInstance();
	GoldDao goldDao = GoldDao.getInstance();
	DowJonesDao dowJonesDao = DowJonesDao.getInstance();
	
	ArrayList<BitcoinDto> bitcoinList = bitcoinDao.select();
	ArrayList<GoldDto> goldList = goldDao.select();
	ArrayList<DowJonesDto> dowJonesList = dowJonesDao.select();
	
%>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
		<%-- 3가지 값을 받아서 넣는데 이거보니까 중간에 빈값확인해봐야겠는걸? --%>
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Year', 'Sales', 'Expenses'],
          ['2004',  1000,      400],
          ['2005',  1170,      460],
          ['2006',  660,       1120],
          ['2007',  1030,      540]
        ]);

        var options = {
          title: 'Company Performance',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
    </script>

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
			<div id="curve_chart" style="width: 900px; height: 500px"></div>
 
			
			
          
      </div>
  </div>

  <!-- main end -->
  
  
<%@ include file ="inc/footer.jsp" %>
