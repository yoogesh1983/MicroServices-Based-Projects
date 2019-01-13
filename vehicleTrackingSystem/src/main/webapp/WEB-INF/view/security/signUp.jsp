<%@include  file = "/WEB-INF/view/common/header.jsp" %>

<style>

.forInputTypeTextAndSelect {
    width: 400px;
    padding: 12px 20px;
    margin: 3px 0;
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
    margin: 340px 0px 0px -75px ;
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
	top:10px;
	left:200px;
	height:430px;
	width: 1100px;
}

#upperDiv {
	background-color: #c0c0c0;
	height:60px;
	width: 1532px;
	text-font:bold;
}

#loginText {
	position: relative;
	background-color: #c0c0c0;
	left: 550px;
	top:10px;
	height:40px;
	width: 400px;
}

#LeftHandDiv {
	position: relative;
    background-color: #f2f2f2;
	top:5px;
	left:10px;
	height:390px;
	width: 430px;
}

#RightHandDiv {
	position: relative;
	background-color: #f2f2f2;
	top:-385px;
	left:480px;
	height:390px;
	width: 430px;
}

</style>

<div id="upperDiv">
	<div id="loginText"> <span class="textfont" style="color:#005c3e; font-variant:none; font-family:lemonde-courrier, Georgia,serif;">Create an Account</span></div>
</div>

<div id="forDivs">

<springform:form  action="${pageContext.request.contextPath}/Sign-Up.do" commandName="profile" method="POST">
 	<p class="text-danger center"><springform:errors class="text-danger center" path=""/></p>
	
	<c:choose>
        <c:when test="${param.error != null}">
		         <p style="color:red; align:center">Could not Create an Account.Please try again later..</p>
	     </c:when>    
	</c:choose>
	
	<div id="LeftHandDiv">
    	<label for="username">Username (email address)*</label><br> 
    	<springform:input path="username" autofocus="autofocus" type="email" required="true" value="" maxlength="255" class="forInputTypeTextAndSelect"/><br><br>

    	<label for="password">Password*</label><br>
    	<springform:input id="password" path="password" type="password" required="true"  value="" maxlength="16" class="forInputTypeTextAndSelect" /><br><br>
    
    	<label for="firstName">FirstName*</label><br>
    	<springform:input id="firstName" path="firstName" type="text" required="true"  value="" maxlength="16" class="forInputTypeTextAndSelect"/><br><br>
    
    	<label for="lastName">LastName*</label><br>
    	<springform:input id="lastName" path="lastName" type="text"  value="" maxlength="16" class="forInputTypeTextAndSelect"/><br><br>
    
    
    	<div id="RightHandDiv">
        	<label for="country">Country</label><br>
    		<select id="country" name="country" class="forInputTypeTextAndSelect">
      			<option value="australia">Australia</option>
      			<option value="canada">Canada</option>
      			<option value="usa">USA</option>
    		</select><br>

               <input type="submit" name="LOGIN" value="Continue" class="forInputTypeSubmit" style="outline: none;">
    	</div>
    </div>

</springform:form>
</div>

<br><br><div style="padding-left: 220px;">Required fields marked with an asterisk (*)</div>

<%@include  file = "/WEB-INF/view/common/footer.jsp" %>