</div> <!--  div of Main-Section ended -->

 <footer class="footer"> 
		
		<c:if test = "${currentUserRole == 'ROLE_DBA'}">
         	<div class="textfont">Database Administrator</div><br/>
      	</c:if>
      	
      	<c:if test = "${currentUserRole == 'ROLE_ADMIN'}">
         	<div class="textfont">Administrator</div><br/>
      	</c:if>
      	
      	<c:if test = "${currentUserRole == 'ROLE_USER'}">
         	<div class="textfont">User</div><br/>
      	</c:if>
</footer>

 </body>
 
 </html>