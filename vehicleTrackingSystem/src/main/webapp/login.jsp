<%@include  file = "/WEB-INF/view/common/header.jsp" %>

<style>

.forInputTypeTextAndSelect {
    width: 400px;
    padding: 12px 20px;
    margin: 5px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    size:20;
}


.forInputTypeSubmit {
    width: 170px;
    background-color: #006800;
    color: white;
    padding: 14px 20px;
    margin: 85px 0px 0px 390px ;
    border: none;
    border-radius: 22px;
    cursor: pointer;
    font-family:"lemonde-courrier",Georgia,serif;
    font-weight:700;
}


.forInputTypeSubmit:hover {
    background-color: #006800;
}

#forDivs {
	position: relative;
    border-radius: 5px;
    padding: 20px;
	background-color: #f2f2f2;
	top:20px;
	left:200px;
	height:300px;
	width: 1100px;
}

#upperDiv {
	background-color: #c0c0c0;
	height:90px;
	width: 1532px;
	text-font:bold;
}

#loginText {
	position: relative;
	background-color: #c0c0c0;
	left: 550px;
	top:45px;
	height:40px;
	width: 400px;
}

</style>

<div id="upperDiv">
	<div id="loginText"> <span class="textfont" style="color:#005c3e; font-variant:none; font-family:lemonde-courrier, Georgia,serif;">Login to my Account</span></div>
</div>

<div id="forDivs">

<springform:form action="${pageContext.request.contextPath}/login"  method="post">
 	<p class="text-danger center"><springform:errors class="text-danger center" path=""/></p>
	
	<c:choose>
        <c:when test="${param.error != null}">
		         <p style="color:red; align:center">Login failed. Check that your username and password are correct.</p>
	     </c:when>    
	</c:choose>
	
    <label for="username">Username (email address)*</label><br>
    <input type="email" id="username" name="username" class="forInputTypeTextAndSelect" autofocus="autofocus"  required="required" value="" maxlength="255"/> <br><br> 

    <label for="password">Password*</label><br>
    <input type="password"  id="userPassword" name="password" class="forInputTypeTextAndSelect" required="required" value="" maxlength="16"/><br><br>
    
    <div>
		<label>
			 <input type="checkbox"  name='_spring_security_remember_me'/> Remember me
             <!-- <input type="checkbox"  name='_spring_security_remember_me' checked="checked"/> Remember me -->
		 </label>
	</div>
    
    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" /> <!-- This must be provided -->
<!-- 
    <label for="country">Country</label><br>
    <select id="country" name="country" class="forInputTypeTextAndSelect">
      <option value="australia">Australia</option>
      <option value="canada">Canada</option>
      <option value="usa">USA</option>
    </select><br>
 -->
 
    <input type="submit" name="LOGIN" value="Login" class="forInputTypeSubmit" style="outline: none;">
</springform:form>
</div>

<br><br><div style="padding-left: 220px;">Required fields marked with an asterisk (*)</div>
<%@include  file = "/WEB-INF/view/common/footer.jsp" %>
