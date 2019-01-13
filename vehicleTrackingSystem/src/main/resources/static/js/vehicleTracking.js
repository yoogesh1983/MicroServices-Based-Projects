
//Declaring CSS Dynamically
var myStyle = document.createElement('style');
myStyle.type = 'text/css';
myStyle.innerHTML = '.tableHeaderColor { color: #a5a49a;}';
document.getElementsByTagName('head')[0].appendChild(myStyle);

//Declaring global variable
var tempVehicleName = undefined;


function showContent(event) {
	if (event.id === 'mdc1' || event.id === 'dc1') {
		$("#dc1.dropdown-content").css("display", "inline");
	} else if (event.id === 'mdc2' || event.id === 'dc2') {
		$("#dc2.dropdown-content").css("display", "inline");
	}
}

function hideContent(event) {
	if (event.id === 'mdc1' || event.id === 'dc1') {
		$("#dc1.dropdown-content").css("display", "none");
	} else if (event.id === 'mdc2' || event.id === 'dc2') {
		$("#dc2.dropdown-content").css("display", "none");
	}

}

function show(event) {
	if (event.id === 'showAllVehicles') {
		ajax_showAllVehicles();
	}
	else if (event.id === 'GetVehicleByName') 
	{
		var currentVal = "<html><header><title>Yoogesh Profile</title></header>" +
        "<body>" +
        			//First Div starts here
         			"<div class='vehicleTracking_js_css_upperDiv ' ><div> <span class='textfont' style='color:#005c3e; font-variant:none; font-family:lemonde-courrier, Georgia,serif;'>FIND VEHICLE BY NAME</span></div></div>" +
         			//First Div ends here
         
                 
         			//Second Div Starts here
         			"<div class='jsCss_forDivs' style='height:450px;'>" +				                    					                   
         				"<input type='text' name='carName' placeholder='Enter vehicle name' id='js-vehicle-search-vehicleName' autofocus='autofocus' value=''  required='true' maxlength='255' class='forInputTypeTextAndSelect'>" +
         				"<input type='submit' style='outline: none;' value='Search' class='forInputTypeSubmit' id='js-vehicle-search' onclick='ajax_findVehicle_By_Name()'><br/><br/>" +      					                   
           
         				"<table id='ajax_findVehicle_By_Name_tableId' class='table table-bordered table-striped table-hover'>" +
         					"<tr style='background-color:green'>" +
         					"<th class='tableHeaderColor'>ID</th>" +
         					"<th class='tableHeaderColor'>Name</th>" +
         					"<th class='tableHeaderColor'>Odometer</th>" +
         					"<th class='tableHeaderColor'>Status</th>" +
         					"<th class='tableHeaderColor'>Latlong</th>" +
         					"<th class='tableHeaderColor'>Chasiss Number</th>" +
         					"<th class='tableHeaderColor'>Current Driver</th>" +
         					"<th class='tableHeaderColor'>Owner</th>" +
         					"<th class='tableHeaderColor'>UserName</th>" +
         					"<th class='tableHeaderColor'>Role</th>" +					                                		
         					"<th class='tableHeaderColor'>Action</th>" +
         					"</tr>" +				                               				                   					                                						                               
         				"</table>" +					                                     		
         			"<div>"
                    //Second Div ends here
           					                   					                   					                   					                   					                   
     +"</body>" 
     +"</html>";
	$('#contents_vehicleTracking').html(currentVal);
	}
	else if (event.id === 'SaveVehicle') 
	{
		ajax_saveVehicle();
	}
	else if (event.id === 'AllProfiles') {
		ajax_AllProfiles();
	}
}



function ajax_showAllVehicles(){
	//$('.js-unregister-account').after("<img class='loading-img js-loading-img' alt='Loading' src='static/asset/my_country_spinner.gif'>");
	$.ajax({
		url:"http://localhost:8080/VehicleTrackingSystem/dispatcher/vehicle",
		type:"GET",
		data:{profileGuid: "", userName: ""},
		success: function(data){
			var htmlValue = "<html><header><title>Yoogesh Profile</title></header>" +
			                "<body>" +
			                    
			                         //First Div starts here
			                          "<div class='vehicleTracking_js_css_upperDiv'><div> <span class='textfont' style='color:#005c3e; font-variant:none; font-family:lemonde-courrier, Georgia,serif;'>VEHICLE INFORMATION</span></div></div>" +
					                //First Div ends here
			                          
			                          
			                          
					                  //Second Div Starts here
					                   "<div class='jsCss_forDivs'><br/>" +
					                  					                    					                   
					                                "<table id='ajax_showAllVehicles_tableId' class='table table-bordered table-striped table-hover'>" +
					                                	"<tr style='background-color:green'>" +
					                                		"<th class='tableHeaderColor'>ID</th>" +
					                                		"<th class='tableHeaderColor'>Name</th>" +
					                                		"<th class='tableHeaderColor'>Odometer</th>" +
					                                		"<th class='tableHeaderColor'>Status</th>" +
					                                		"<th class='tableHeaderColor'>Latlong</th>" +
					                                		"<th class='tableHeaderColor'>Chasiss Number</th>" +
					                                		"<th class='tableHeaderColor'>Current Driver</th>" +
					                                		"<th class='tableHeaderColor'>Owner</th>" +
					                                		"<th class='tableHeaderColor'>UserName</th>" +
					                                		"<th class='tableHeaderColor'>Role</th>" +					                                		
					                                		"<th class='tableHeaderColor'>Action</th>" +
					                                	"</tr>" 				                               				                   					                                						                               
					                               + "</table>"					                                
					                            					                   
					                   +"<div>"
					                  //Second Div ends here
					                   
					                   					                   					                   					                   					                   					                   
					          +"</body>" 
					          +"</html>";
			
			$('#contents_vehicleTracking').html(htmlValue);
			
        	var $table = $("#ajax_showAllVehicles_tableId");
	        for (var i = 0; i < data.length; i++) 
	        { 
	        	var id = data[i].id; if(id === undefined){id="-"}
	        	var name = data[i].name; if(name === undefined){name="-"}
	        	var odometer = data[i].odometer; if(odometer === undefined){odometer="-"}
	        	var status = data[i].status; if(status === undefined){status="-"}
	        	var latLong = data[i].latLong; if(latLong === undefined){latLong="-"}
	        	var chassisNumber = data[i].chassisNumber; if(chassisNumber === undefined){chassisNumber="-"}
	        	var currentDriver = data[i].currentDriver; if(currentDriver === undefined){currentDriver="-"}
	        	
	        	var firstName ='';
	        	var lastName='';
	        	var username='';
	        	var role='';
	        	
	        	if(data[i].profile != null)
	        	{
		        	firstName = data[i].profile.firstName; 
		        	lastName = data[i].profile.lastName; 
		        	username = data[i].profile.username; 
		        	role = data[i].profile.role; 
	        	}
	        	
	        	if(firstName === undefined || firstName === '' ){firstName="-"}
	        	if(lastName === undefined || lastName === ''){lastName=""}
	        	if(username === undefined || username === '' ){username="-"}
	        	if(role === undefined || role === ''){role="-"}
	        	
	        	var $tr = $("<tr></tr>");
	        	
	        	$tr.append( "<td>" + id + "</td>" +
	        			    "<td>" + name + "</td>" +  
	        			    "<td>" + odometer + "</td>" +
	        			    "<td>" + status + "</td>" +
	        			    "<td>" + latLong + "</td>" +
	        			    "<td>" + chassisNumber + "</td>" +
	        			    "<td>" + currentDriver + "</td>" +
	        			    "<td>" + firstName + " " + lastName + "</td>" +
	        			    "<td>" + username  + "</td>" +
	        			    "<td>" + role  + "</td>" +					                                		
    					                                		
	        			    "<td style='width:190px;'>" +					                           
	        			    "<a href='#' class='btn btn-danger'>Delete &nbsp;<span class='glyphicon glyphicon-trash'></span></a> &nbsp;" +
	        			    "<a href='#'  class='btn btn-success'>Edit &nbsp; <span class='glyphicon glyphicon-pencil'></span></a>" +
	        				"</td>");

	        	$table.append($tr);
	        	
	        	firstName ='';
	        	lastName='';
	        	username='';
	        	role='';
	        }	

			//$(".js-loading-img").remove();
		},
		error: function(error){
		       alert("error occured");
		}
		
	});
}


function ajax_findVehicle_By_Name(){

	var vehicleName = $( "#js-vehicle-search-vehicleName").val();
		
    if(vehicleName === '' || vehicleName === undefined)
    {
    	alert("Please provide a value.");
    }
    else
    {
    	$("#ajax_findVehicle_By_Name_tableId").find("tr:gt(0)").remove();
    	
		//$('.js-unregister-account').after("<img class='loading-img js-loading-img' alt='Loading' src='static/asset/my_country_spinner.gif'>");
		
		$.ajax({
			url:"http://localhost:8080/VehicleTrackingSystem/dispatcher/vehicle/name/"+ vehicleName.toUpperCase(),
			type:"GET",
			data:{profileGuid: "", userName: ""},
			success: function(data){
				
			    if(data.length < 1){
			    	var $table = $("#ajax_findVehicle_By_Name_tableId");
			    	var $tr = $("<tr></tr>");
			    	$tr.append( "<td colspan='11'><span class='menu-text' style='color:red;'>Could not find the Car You are Searchig For. Please Search another one....<span></td>");
			    	$table.append($tr);
			    	$('#myMap_js').html("");
			    }
			    
			    else
			    {
		        	var $table = $("#ajax_findVehicle_By_Name_tableId");
			        for (var i = 0; i < data.length; i++) 
			        { 
			        	var id = data[i].id; if(id === undefined){id="-"}
			        	var name = data[i].name; if(name === undefined){name="-"}
			        	var odometer = data[i].odometer; if(odometer === undefined){odometer="-"}
			        	var status = data[i].status; if(status === undefined){status="-"}
			        	var latLong = data[i].latLong; if(latLong === undefined){latLong="-"}
			        	var chassisNumber = data[i].chassisNumber; if(chassisNumber === undefined){chassisNumber="-"}
			        	var currentDriver = data[i].currentDriver; if(currentDriver === undefined){currentDriver="-"}
			        	
			        	var firstName;
			        	var lastName;
			        	var username;
			        	var role;
			        	
			        	if(data[i].profile != null)
			        	{
				        	firstName = data[i].profile.firstName; 
				        	lastName = data[i].profile.lastName; 
				        	username = data[i].profile.username; 
				        	role = data[i].profile.role; 
			        	}
			        	
			        	if(firstName === undefined){firstName="-"}
			        	if(lastName === undefined){lastName=""}
			        	if(username === undefined){username="-"}
			        	if(role === undefined){role="-"}			        	
			        	
			        	//var $curl = "vehicle/currentPosition/" + name;
			        	var $tr = $("<tr></tr>");
			        	
			        	$tr.append( "<td>" + id + "</td>" +
			        			   // "<td>" + "<a href=" + $curl + ">" + name +  "</a></td>" +  
			        			    "<td>" + name +  "</td>" + 
			        			    "<td>" + odometer + "</td>" +
			        			    "<td>" + status + "</td>" +
			        			    "<td>" + latLong + "</td>" +
			        			    "<td>" + chassisNumber + "</td>" +
			        			    "<td>" + currentDriver + "</td>" +
			        			    "<td>" + firstName + " " + lastName + "</td>" +
			        			    "<td>" + username  + "</td>" +
			        			    "<td>" + role  + "</td>" +					                                		
		    					                                		
			        			    "<td style='width:190px;'>" +					                           
			        			    "<a href='#' id='tt' class='btn btn-success' style='width:170px;' onclick='ajax_updateMap()'>Refresh &nbsp; <span class='glyphicon glyphicon-pencil'></span></a>" +
			        				"</td>");
			        	
			        	$table.append($tr);
			        	
			        	
			        	tempVehicleName = vehicleName.toUpperCase();
			        	//Embedding Microservices Map vehicle/currentPosition
			        	$.ajax({
			    			url:"http://localhost:8080/VehicleTrackingSystem/dispatcher/vehicle/currentPosition/"+ vehicleName.toUpperCase(),
			    			type:"GET",
			    			data:{profileGuid: "", userName: ""},
			    			success: function(data){$('#myMap_js').html(data);},
			    			error: function(error){ $('#myMap_js').html("<span class='menu-text' style='color:red;'>Could not find the Car You are Searchig For. Please Search another one....<span>");}
			        	});
			        	
			        	$table.append( "<td colspan='11'>" +
			        						"<div style='height:240px;'>" +
			        						        "<div id='myMap_js'></div>" +
			        						"</div>" +
			        					"</td>");
			        }
			        
			    }
			    
			    document.getElementById('js-vehicle-search-vehicleName').value='';
				//$(".js-loading-img").remove();
			},
			error: function(error){
				   document.getElementById('js-vehicle-search-vehicleName').value='';
			       alert("error occured");
			}
			
		});	
    	
    }
}





function ajax_AllProfiles(){
	//$('.js-unregister-account').after("<img class='loading-img js-loading-img' alt='Loading' src='static/asset/my_country_spinner.gif'>");
	$.ajax({
		url:"http://localhost:8080/VehicleTrackingSystem/dispatcher/profile",
		type:"GET",
		data:{profileGuid: "", userName: ""},
		success: function(data){
			var htmlValue = "<html><header><title>Yoogesh Profile</title></header>" +
			                "<body>" +
			                    
			                         //First Div starts here
			                          "<div class='vehicleTracking_js_css_upperDiv'><div> <span class='textfont' style='color:#005c3e; font-variant:none; font-family:lemonde-courrier, Georgia,serif;'>PROFILE INFORMATION</span></div></div>" +
					                //First Div ends here
			                          
			                          
			                          
					                  //Second Div Starts here
					                   "<div class='jsCss_forDivs'><br/>" +
					                  					                    					                   
					                                "<table id='ajax_showAllVehicles_tableId' class='table table-bordered table-striped table-hover'>" +
					                                	"<tr style='background-color:green'>" +
					                                		"<th class='tableHeaderColor'>ID</th>" +
					                                		"<th class='tableHeaderColor'>Username</th>" +
					                                		"<th class='tableHeaderColor'>First Name</th>" +
					                                		"<th class='tableHeaderColor'>Last Name</th>" +
					                                		"<th class='tableHeaderColor'>Role</th>" +					                                		
					                                		"<th class='tableHeaderColor'>Action</th>" +
					                                	"</tr>" 				                               				                   					                                						                               
					                               + "</table>"					                                
					                            					                   
					                   +"<div>"
					                  //Second Div ends here
					                   
					                   					                   					                   					                   					                   					                   
					          +"</body>" 
					          +"</html>";
			
			$('#contents_vehicleTracking').html(htmlValue);
			
        	var $table = $("#ajax_showAllVehicles_tableId");
	        for (var i = 0; i < data.length; i++) 
	        { 
	        	var id = data[i].id; if(id === undefined){id="-"}
	        	var username = data[i].username; if(username === undefined){username="-"}
	        	var firstName = data[i].firstName; if(firstName === undefined){firstName="-"}
	        	var lastName = data[i].lastName; if(lastName === undefined){lastName="-"}
	        	var role = data[i].role; if(role === undefined){role="-"}
	        	
	        	
	        	var $tr = $("<tr></tr>");
	        	
	        	$tr.append( "<td>" + id + "</td>" +
	        			    "<td>" + username + "</td>" +  
	        			    "<td>" + firstName + "</td>" +
	        			    "<td>" + lastName + "</td>" +
	        			    "<td>" + role + "</td>" +				                                		
    					                                		
	        			    "<td style='width:190px;'>" +					                           
	        			    "<a href='#' class='btn btn-danger'>Delete &nbsp;<span class='glyphicon glyphicon-trash'></span></a> &nbsp;" +
	        			    "<a href='#'  class='btn btn-success'>Edit &nbsp; <span class='glyphicon glyphicon-pencil'></span></a>" +
	        				"</td>");

	        	$table.append($tr);
	        }	

			//$(".js-loading-img").remove();
		},
		error: function(error){
		       alert("error occured");
		}
		
	});
}



function ajax_saveVehicle(){
	//$('.js-unregister-account').after("<img class='loading-img js-loading-img' alt='Loading' src='static/asset/my_country_spinner.gif'>");
	$.ajax({
		url:"http://localhost:8080/VehicleTrackingSystem/dispatcher/save-vehicle-using-ajax",
		type:"GET",
		data:{profileGuid: "", userName: ""},
		success: function(data){
			$('#contents_vehicleTracking').html(data);
 	
			//$(".js-loading-img").remove();
		},
		error: function(error){
		       alert("error occured");
		}
		
	});
	
}



function ajax_updateMap()
{  
	if(tempVehicleName != undefined){
		//Embedding Microservices Map vehicle/currentPosition
		$.ajax({
			url:"http://localhost:8080/VehicleTrackingSystem/dispatcher/vehicle/currentPosition/"+ tempVehicleName,
			type:"GET",
			data:{profileGuid: "", userName: ""},
			success: function(data){ $('#myMap_js').html(data);},
			error: function(error){ $('#myMap_js').html("<span class='menu-text' style='color:red;'>Could not find the Car You are Searchig For. Please Search another one....<span>");}
		});
	}

}






