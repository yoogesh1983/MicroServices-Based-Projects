# What is the Application about ? </br>
- This is a Spring Boot Microservice application that tracks Vehicle using the GoogleMap. It contains five following independent applicaions which are loosely coupled : </br>
> SpringCloudConfig</br>
> eurekaDiscovery </br>
> positionSimulator </br>
> positionReceiver </br>
> vehicleTrackingSystem </br>

- This application follows <a href= "https://www.virtualpairprogrammers.com/training-courses/Spring-Boot-Microservices-training.html">this </a> training video
- This application cannot be run until <strong>spring-cloud-config</strong> and <strong>eureka-service-registry</strong> are compiled and Run first. So, it is Strongly recommonded to compile and run these two applications even before compile other three applications. </br>

# How to compile and run the application ?
- A Message-Driven-Queue <b>ActiveMQ</b> needs to be run first (before compile and run any application)
> Start the ActiveMq by doubleclicking on activemq.bat that is at C:\Users\yooge\Desktop\GlassFish\01 - STS in Local\apache-activemq-5.14.3\bin\win64 </br>
> Hit the url http://localhost:8161/ with username/password as admin/admin </br>
> Click to <b>Manage ActiveMQ broker</b> </br>
> Click to <b>Queues</b> </br>
> you can see the positionQueue there (after the <b>positionSimulator</b> application starts running) </br>

- Each applications need to be run seperately and need to be performed below steps to compile and run : </br>
> Right click on project -> Run As -> Maven build ... </br>
> clean install (Under Goal Section) -> Apply </br>
> Under JRE tab, select alternate JRE and select the JDK you have setup from Runtime environment </br>
> Save a name as ${ApplicationName_COMPILER} and then Run </br>
> Now to run the application, Go to MainMethod of the applications -> run as -> Java Application </br>

# Application's Running on Ports
> vehicleTrackingSystem -----> http://localhost:8080/VehicleTrackingSystem/dispatcher </br>
> spring-cloud-config -------> http://localhost:8088/application/default  &nbsp;(don't know why it didn't work on 8081)</br>
> positionSimulator ---------> http://localhost:8082/vehicles/city_truck && http://localhost:8082/vehicles/village_truck</br>
> Eureka-Service-Registry ---> http://localhost:8083 </br>
> positionReceiver -----------> Automatic port is assigned by eureka server </br>

# How to get Google Keys ? </br>
> Go to https://developers.google.com/maps/documentation/javascript/get-api-key </br>
> Click on "Get key" tab </br>
> Select term and condition </br>
> You will get the key now </br>

# Technology Used for Application</br>
<strong>1) Eureka Service Discovery/Registry :</strong>
- To configure all applications Running port on Eureka server where all Elient Eureka will read those from server </br>
- Eureka Server is configured on <b>eureka-Service-Registry</b> application</br>
- Eureka client is configured on <b>Positiontracking</b> and <b>vehicleTracking</b> application</br>

<strong>2) Ribbon :</strong>
- This is For ClientSide load balancing ( Multiple instances of same application) </br>
- Configured on <b>Positiontracking</b> and <b>vehicleTracking</b> application</br>
- Need to do a configuration on <b>PositionTracking</b> application so that seperate instances created when started more than one times</br>
- need to call "LoadBalancing" class's  "choose"  method instead of "DiscoveryClient" class's getInstance method in
<b>VehicleTracking</b> application so that when Rest call is called, it will load balance and call seperate instances </br>
- Need to start the <b>positiontracking</b> application more than one times </br>

<b>3) Hystrix : </b> It provides two major features: </br> </br>
&nbsp;&nbsp;&nbsp;&nbsp;3.1) Hystrix FallBack : </br>
- If the service you are calling fails(exception), then a fallback method is executed </br>
- Using Hystrix fallback, you can define fall back method. That means put the sensative code inside hystrix method and also define which method to execute when exception occur in that sensative method </br>
- Configured only on "vehicleTracking" application </br>

&nbsp;&nbsp;&nbsp;&nbsp;3.2) Hystrix Circuit Bracker : </br></br>
- If the situation is dire, then a circuit breaker kicks into prevent any further network calls i.e. it prevent the cascading of failure </br>
- if it get an excption more then ... times, then now it will not call the hystrix method, and instead it will directly call the fallback method instead </br>

<strong>4) Feign :</strong> </br>
- it is a kind of spring data for microservices rest call where you create an interface and call like spring MVC </br>
- Internally Ribbon is included here, so you don't need Ribbon(loadBalancer) seperately </br>
- Configured only on <b>vehicleTracking</b> application  </br>

<strong>5) Spring Cloud Config :</strong> </br>
- It is to manage global values. ex: in our every properties file, there is same thing on all. this means if we need to change any one let's  say eureka location, or jms location we need to go every properties file of the every application and do it, which is cumbursome.
- One option to get rid of this is create another microservice application which will manage this, but we don't want another level of coupling, right? so for this we do for <b>Spring Cloud Config</b> provided by spring boot. </br>
- Remember, this did not come from netflix, it is from boot itself. </br>
- Need seperate application as a config server (may do in git or may do in file path) </br>
- Need to configure as a client in other application i.e. just add the pom dependency and that's it!!
