
<%@page import="kr.co.acorn.dto.CloseDto"%>
<%@page import="kr.co.acorn.dao.CloseDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page pageEncoding="utf-8"%>

<%@ include file="inc/header.jsp"%>

<%
	int start = 0;
	int len = 5;

	// plot을 그리기 위한 db에서 데이터 획득
	/*
	BitcoinDao bitcoinDao = BitcoinDao.getInstance();
	GoldDao goldDao = GoldDao.getInstance();
	DowJonesDao dowJonesDao = DowJonesDao.getInstance();
	
	ArrayList<BitcoinDto> bitcoinList = bitcoinDao.select();
	ArrayList<GoldDto> goldList = goldDao.select();
	ArrayList<DowJonesDto> dowJonesList = dowJonesDao.select();
	*/
	CloseDao closeDao = CloseDao.getInstance();

	ArrayList<CloseDto> closeList = closeDao.select();
%>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load('current', {'packages':['line','corechart']});
      google.charts.setOnLoadCallback(drawChart);
		<%-- 3가지 값을 받아서 넣는데 이거보니까 중간에 빈값확인해봐야겠는걸? --%>
		
      function drawChart() {
    	var data = new google.visualization.DataTable();
        data.addColumn('date','Date');
        data.addColumn('number','Bitcoin');
        data.addColumn('number','Gold(kg)');
        data.addColumn('number','DowJones');
        
        <%for (CloseDto dto : closeList) {%>
        data.addRows([
        	[new Date('<%=dto.getDate().substring(0, 4)%>','<%=dto.getDate().substring(5, 7)%>', '<%=dto.getDate().substring(8)%>'),<%=dto.getBitcoin()%>,<%=dto.getGold() * 35.274%>,<%=dto.getDowjones()%>] ]);
<%}%>
	var options = {
			chart : {
				title : 'Stock for Bitcoin, Gold, DowJones'
			},
			width : 900,
			height : 500,
			axes : {
				x : {
					0 : {
						side : 'top'
					}
				}
			}
		};

		var chart = new google.charts.Line(document
				.getElementById('line_top_x'));

		chart.draw(data, google.charts.Line.convertOptions(options));
	}
</script>
<%--
  <!-- breadcrumb start -->
  <nav aria-label="breadcrumb">
    <ol class="breadcrumb">
      <li class="breadcrumb-item"><a href="<%=contextPath %>/index.jsp">Home</a></li>
      <li class="breadcrumb-item active" aria-current="page">Correlation</li>
    </ol>
  </nav>
--%>
<!-- breadcrumb end -->

<!-- main start -->

<div class="container">
	<div class="col-sm-12">

		<%-- input content --%>
		<div class='col-sm-12 row'>
			<h3>All Data Chart</h3>
		</div>
		<div id="line_top_x"></div>
		<%-- input correlation analysis img data --%>
		
		
			<h5>Correlation - BitCoin, Gold, DowJones</h5>
		<div class='col-sm-12 row'>
			<div class='col-sm-8'>
				<img id="corr" name="corr" src="info/img/corr_scale.jpg"/>			
			</div>
			<div class='col-sm-4'>
				<strong> Bitcoin - Gold 
				<br> Gold - DowJones
				<br> 간에는 상관관계를 어느정도보이나
				<br> DowJones와 Bitcoin 간에는 
				<br> 작은 상관관계를 보인다</strong>			
			</div>
		</div>
		
	</div>

</div>

<!-- main end -->


<%@ include file="inc/footer.jsp"%>
