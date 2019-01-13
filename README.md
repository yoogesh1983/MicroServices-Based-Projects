# What is the Application about ? </br>
- This is a Spring Boot Microservice application that tracks Vehicle using the GoogleMap. It contains five following independent applicaions which are loosely coupled : </br>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; => SpringCloudConfig</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; => eurekaDiscovery </br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; => positionSimulator </br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; => positionReceiver </br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; => vehicleTrackingSystem </br>

- This application cannot be run until <strong>spring-cloud-config</strong> and <strong>eureka-service-registry</strong> are compiled and Run first. So, it is Strongly recommonded to compile and run these two applications even before compile other three applications. </br>

# How to compile and run the application ?
- Each applications need to be run seperately and need to be performed below steps to compile and run : </br>
> Right click on project -> Run As -> Maven build ... </br>
> clean install (Under Goal Section) -> Apply </br>
> Under JRE tab, select alternate JRE and select the JDK you have setup from Runtime environment </br>
> Save a name as ${ApplicationName_COMPILER} and then Run </br>
> Now to run the application, Go to MainMethod of the applications -> run as -> Java Application </br>

# How to get Google Keys ? </br>
> Go to https://developers.google.com/maps/documentation/javascript/get-api-key </br>
> Click on "Get key" tab </br>
> Select term and condition </br>
> You will get the key now </br>

# What are the technologies are used to complete this MicroService Project ? </br>
<strong>1) Eureka Service Discovery/Registry :</strong> </br>
- To configure all applications Running port on Eureka server where all Elient Eureka will read those from server </br>
- Eureka Server is configured on <b>eureka-Service-Registry</b> application</br>
- Eureka client is configured on <b>Positiontracking</b> and <b>vehicleTracking</b> application</br>

<strong>2) Ribbon :</strong> </br>
- This is For ClientSide load balancing ( Multiple instances of same application) </br>
- Configured on <Positiontracking" and "vehicleTracking" application</br>
- Need to do a configuration on "PositionTracking" application so that seperate instances created when started more than one times</br>
- need to call "LoadBalancing" class's  "choose"  method instead of "DiscoveryClient" class's getInstance method  in "VehicleTracking" application so that when Rest call is called, it will load balance and call seperate instances </br>
- Need to start the "positiontracking" application more than one times </br>

<strong>3) Hystrix :</strong> It provides two major features: </br>
1) Hystrix FallBack: </br>
2) 2) Hystrix Circuit Bracker: </br>


                                
