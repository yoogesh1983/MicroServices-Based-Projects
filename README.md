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
- Eureka client is configured on "Positiontracking" and "vehicleTracking" application</br>




1) Eureka Service Discovery/Registry -----------> 
                                                  
        => Eureka Server is configured on "eureka-Service-Registry" application     
        => Eureka client is configured on "Positiontracking" and "vehicleTracking" application
                                          
        
                                                  
                                                  
2) Ribbon ------------------> For ClientSide load balancing ( Multiple instances of same application)

         => Configured on "Positiontracking" and "vehicleTracking" application 
         => Need to do a configuration on "PositionTracking" application so that seperate instances created when started more than one times
         => need to call "LoadBalancing" class's  "choose"  method instead of "DiscoveryClient" class's getInstance method  in "VehicleTracking"
           application so that when Rest call is called, it will load balance and call seperate instances 
         => Need to start the "positiontracking" application more than one times





3) Hystrix -----------------> hystrix provides two major features:

           1) Hystrix FallBack:     --------------------> If the service you are calling fails(exception), then a fallback method is executed
                                    --------------------> Using Hystrix fallback, you can define fall back method.That means put the sensative code 
                                                          inside hystrix method and also define which method to execute when exception occur in that 
                                                          sensative method
                                  
                             => Configured only on "vehicleTracking" application 
                             


           2) Hystrix Circuit Bracker:   ---------------> If the situation is dire, then a circuit breaker kicks into prevent any further network calls,
                                                          i.e. it prevent the cascading of failure
                                         ---------------> if it get an excption more then ... times, then now it will not call the hystrix method, 
                                                          and instead it will directly call the fallback method instead.     
                                                          
                                                                    
                                                          
4) Feign ---------------------> it is a kind of spring data for microservices rest call where you create an interface and call like spring MVC
                        ------> Internally Ribbon is included here, so you don't need Ribbon(loadBalancer) seperately.

            => Configured only on "vehicleTracking" application          
           


5) Spring Cloud Config -------------->  It is to manage global values. ex: in our every properties file, there is same thing on all. this 
                                        means if we need to change any one let's  say eureka location, or jms location we need to go every
                                        properties file of the every applacion and do it, which is cumbursome.
                                        
                                        One option to get rid of this is create another microservice applacion which will manage this, but we
                                        don't another level of coupling,right? so for this we do for "Spring Cloud Config" provided by spring boot.
                                        
                                        Remember, this did not come from netflix, it is from boot itself.
                                        

              => Need seperate application as a config server ( may do in git or may do in file path)
              => Need to configure as a client in other application i.e. just add the pom dependency and that's it!!








