<div id="contents_vehicleTracking">


<div class='vehicleTracking_js_css_upperDiv' style="left:250px;"><div> <span class='textfont' style='color:#005c3e; font-variant:none; font-family:lemonde-courrier, Georgia,serif;'>MY PROFILE</span></div></div>
<div class='jsCss_forDivs' style="left:30px; width:700px;"><br/>				                  					                    					                   
 <table class='table table-bordered table-striped table-hover'>
       <tr style='background-color:green'>
       		<th class='tableHeaderColor'>ID</th>
       		<th class='tableHeaderColor'>Username</th>
       		<th class='tableHeaderColor'>FirstName</th>
       		<th class='tableHeaderColor'>LastName</th>
       		<th class='tableHeaderColor'>Role</th>
		</tr>	
		<tr>
       		<td>${profile.id}</td>
       		<td>${profile.username}</td>
       		<td>${profile.firstName}</td>
       		<td>${profile.lastName}</td>
       		<td>${profile.role}</td>
		</tr>			                               				                   					                                						                               
</table>				                                				                            					                   
</div>

<div class='vehicleTracking_js_css_upperDiv' style="left:1000px; top:-394px;"><div> <span class='textfont' style='color:#005c3e; font-variant:none; font-family:lemonde-courrier, Georgia,serif;'>MY VEHICLE</span></div>
<div class='jsCss_forDivs' style="left:-245px; width:750px; top:25px;"><br/>				                  					                    					                   
 <table class='table table-bordered table-striped table-hover'>
       <tr style='background-color:green'>
       		<th class='tableHeaderColor'>ID</th>
       		<th class='tableHeaderColor'>Name</th>
       		<th class='tableHeaderColor'>Current Driver</th>
       		<th class='tableHeaderColor'>Status</th>
       		<th class='tableHeaderColor'>Odometer</th>
       		<th class='tableHeaderColor'>Latlong</th>
       		<th class='tableHeaderColor'>Chasiss</th>
		</tr>	
		
	<c:forEach items="${vehicles}" var="vehicle">
    	<tr>      
        	<td>${vehicle.id}</td>
        	<td>${vehicle.name}</td>
        	<td>${vehicle.currentDriver}</td>
        	<td>${vehicle.status}</td>
        	<td>${vehicle.odometer}</td> 
        	<td>${vehicle.latLong}</td> 
        	<td>${vehicle.chassisNumber}</td>  
    	</tr>
	</c:forEach>			                               				                   					                                						                               
</table>				                                				                            					                   
</div>
</div>


</div>