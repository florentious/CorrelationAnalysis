
<%@ page pageEncoding="utf-8" %>

<!doctype html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

  <title> Correlation Analysis - CrytoCurrency, Gold, DowJones </title>
</head>

<body>
  <!-- navbar start -->
  <nav class="navbar navbar-expand-lg navbar-dark " style="background-color: #563d7c;">
    <a class="navbar-brand" href="/CA/index.jsp">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
      aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
<%
	// 해당부분을 강조하기 위해서 시작값이 다름- 해당위치에 있다는 것을 강조하기 위해서
	String uri = request.getRequestURI();
	String contextPath = request.getContextPath();
	
%>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
      <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
        <%-- 
        <li class="nav-item <%if(uri.startsWith("/analysis/")) {%>active<%} %>">
          <a class="nav-link" href="<%=contextPath %>/analysis/info.jsp">Analysis <span class="sr-only">(current)</span></a>
        </li>
         --%>
        <li class="nav-item <%if(uri.startsWith("/bitcoin/")) {%>active<%} %>">
          <a class="nav-link" href="<%=contextPath %>/bitcoin/info.jsp">Bitcoin <span class="sr-only">(current)</span></a>
        </li>
        
        <li class="nav-item <%if(uri.startsWith("/gold/")) {%>active<%} %>">
          <a class="nav-link" href="<%=contextPath %>/gold/info.jsp">Gold <span class="sr-only">(current)</span></a>
        </li>
        
        <li class="nav-item <%if(uri.startsWith("/dowjones/")) {%>active<%} %>">
          <a class="nav-link" href="<%=contextPath %>/dowjones/info.jsp">DowJones <span class="sr-only">(current)</span></a>
        </li>
      </ul>
        
      
      <ul class="navbar-nav">
     
      </ul>
      
      
    </div>
  </nav>
  <!-- navbar end -->
  
  
  