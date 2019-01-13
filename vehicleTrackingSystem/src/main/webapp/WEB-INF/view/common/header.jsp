<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<jsp:useBean id="now" class="java.util.Date"/>
<c:set var="currentViewPath" value="${fn:split(pageContext.request.servletPath, '/')}" />
<c:set var="currentView" value="${currentViewPath [fn:length(currentViewPath)-1]}" />   
<c:set var="currentPageName" value="${fn:substringBefore(currentView, '.')}" />  
<c:set var="currentUser" value="${authenticationStateBean.name}" /> 
<c:set var="currentUserRole" value="${authenticationStateBean.role}" /> 
 
<!DOCTYPE html>

 <html> 

<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta content="IE=edge" http-equiv="X-UA-Compatible">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui"/>
	<meta http-equiv="Cache-control" content="no-cache">	
	
	<!-- BootStrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
    <!-- Custom defined css -->
	<link href="${pageContext.request.contextPath}/css/signup.css" rel="stylesheet" type="text/css">
	<%-- <link  rel="stylesheet"  href="<c:url value="/css/common/header.css" />"></link> --%>

	
    <title>MYCOUNTRY - ${currentPageName}</title>
     
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="<c:url value="/js/vehicleTracking.js"/>"></script>
	<!-- <script type="text/javascript" src="//use.typekit.net/bmk6quo.js"></script> -->
	<%-- <script type="text/javascript" src="<c:url value="/dispatcher/static/js/MyCountryMVC/MyCountry.js"/>"></script> --%>
	 

 </head>
 
 <body class="body"> 
 
 
 		<c:if test = "${currentPageName ne 'saveVehicle'}">
 					<%@include  file = "/WEB-INF/view/common/nav.jsp" %>				
					<div class="Main-Section">
 	          
 								<div id="dc1" class="dropdown-content" style="width: 150px;" onmouseover="showContent(this)" onmouseout="hideContent(this)">
 	  									<c:if test = "${currentUserRole == 'ROLE_DBA'}">
 	  										<c:if test = "${currentPageName == 'MyAccountDba'}">
 	  											<a href="h2-console">Database</a>
 	  										</c:if>
 	  									</c:if>
      											<a href="#" id="AllProfiles" onclick="show(this)">All Profiles</a>
      											<a href="#" id="showAllVehicles" onclick="show(this)">All Vehicles</a>
      											<a href="#" id="GetVehicleByName" onclick="show(this)">Search Vehicle</a>
      											<a href="#" id="SaveVehicle" onclick="show(this)">Add Vehicle</a>
    							</div>
 	     
 	     
 	 							<div id="dc2" class="dropdown-content" style="left:571px;" onmouseover="showContent(this)" onmouseout="hideContent(this)">
 										<c:if test = "${currentUserRole == 'ROLE_DBA'}">
 		        								<c:if test = "${currentPageName == 'myAccountUser'}">
         											<a href="${pageContext.request.contextPath}/my-account-dba">DBA</a>
         											<a href="${pageContext.request.contextPath}/my-account-admin">Admin</a>
         										</c:if>
         		
         										<c:if test = "${currentPageName == 'myAccountAdmin'}">
         											<a href="${pageContext.request.contextPath}/my-account-dba">DBA</a>
         											<a href="${pageContext.request.contextPath}/my-account-user">User</a>
         										</c:if>
         		
         										<c:if test = "${currentPageName == 'MyAccountDba'}">
         											<a href="${pageContext.request.contextPath}/my-account-admin">Admin</a>
         											<a href="${pageContext.request.contextPath}/my-account-user">User</a>
         										</c:if>
      									</c:if>
      	
 										<c:if test = "${currentUserRole == 'ROLE_ADMIN'}">
 		        								<c:if test = "${currentPageName == 'myAccountUser'}">
         											<a href="${pageContext.request.contextPath}/my-account-admin">Admin</a>
         										</c:if>
         		
         										<c:if test = "${currentPageName == 'myAccountAdmin'}">
         											<a href="${pageContext.request.contextPath}/my-account-user">User</a>
         										</c:if>
      									</c:if>
    							</div>   
 			 </c:if>
 			 
 			 