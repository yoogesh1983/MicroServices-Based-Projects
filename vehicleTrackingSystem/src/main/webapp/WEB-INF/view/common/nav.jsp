<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<nav class="nav">
 				<section id="myCountrylogo">
 					<a href="https://www.countryfinancial.com"><img style="width:160px; heigh:55px;" src="<c:url value="/images/logo.png"/>" /></a>
 				</section>
 				<section id="header_Menu_firstLayer">
 					<section id="vehicleTrackingText">
 					     <div> 
 					     	<br><span class="textfont">Vehicle Tracking System</span>
 					     </div>
 					</section>
 					
 					<section id="MenuItems_FirstLayer">											

 						<div id="MenuItems-actual">
 							<div class="menus"> 
 								<c:if test = "${currentPageName != 'login' && currentPageName != 'signUp'}">
 							    	<ul class="menus_ul">
 							    		<li class="menu_li"><a id="mdc2" class="menu-text" href=""  onmouseover="showContent(this)" onmouseout="hideContent(this)">Home</a></li>
 							    		<li class="menu_li dropdown"><a id="mdc1" class="menu-text" href="" onmouseover="showContent(this)" onmouseout="hideContent(this)">Menu</a></li>
 							  		</ul> 
 							    </c:if>								
						 	</div>
 						</div>
 						
 						
 					<c:choose>
						<c:when test="${authenticationStateBean.authenticated eq true}">
							<div id="loginuser-signout-signals-icon">
 								<div id="sign-up-icon-role">
 									<a href=""><span class="glyphicon glyphicon-user" style="color:#e974a9;"></span ><span style="color:#e974a9;"> ${currentUser} [<c:if test = "${currentPageName == 'myAccountUser'}">User</c:if><c:if test = "${currentPageName == 'myAccountAdmin'}">Admin</c:if><c:if test = "${currentPageName == 'MyAccountDba'}">Dba</c:if>]</a>
 								</div>
 							
 								<div id="sign-in-icon">
 									<a href="${pageContext.request.contextPath}/"><span class="glyphicon glyphicon-log-out" style="color:#e974a9;"></span> <span style="color:#e974a9;">Sign Out</span></a>
 								</div>
 							</div>
						</c:when>

						<c:otherwise>
							<div id="signup-signin-signals-icon">
 								<div id="sign-up-icon">
 									<a href="${pageContext.request.contextPath}/Sign-Up.do"><span class="glyphicon glyphicon-user" style="color:#e974a9;"></span ><span style="color:#e974a9;"> Sign Up</span></a>
 								</div>
 							
 								<div id="sign-in-icon">
 									<a href="${pageContext.request.contextPath}/"><span class="glyphicon glyphicon-log-in" style="color:#e974a9;"></span> <span style="color:#e974a9;">Sign In</span></a>
 								</div>
 							</div>
				 		</c:otherwise>
					</c:choose>	
				
 					</section>
 					
 				</section>
 </nav> 
	