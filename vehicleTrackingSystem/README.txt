Application URL:
================
http://localhost:8080/VehicleTrackingSystem/dispatcher

Note: Before Run or compile any of here, "spring-cloud-config" and "eureka-service-registry" applications must first 
      compile and RUN before even compile or RUN other applications


Database URL:
=============
http://localhost:8080/VehicleTrackingSystem/dispatcher/h2-console

Driver Class =====>  org.h2.Driver
JDBC URL =====> jdbc:h2:file:./Database
Username ====> sa
password ===> (leave it Blank)


Username and passwords:
=======================

dba@gmail.com
Cou******1

admin@gmail.com
Cou**********1

syoogesh@gmail.com
Cou*********1


Steps to compile:
=================

1) Right click on project select Run ----> Maven build ... 
2) Under Main Tab in Goal Section do the following ---> clean install
3) Under JRE tab, select alternate JRE and select the JDK you have setup from Runtime environment
4) Save a name as VehicleTrackingSystem_COMPILER and then Run


Steps to Run an application Using Tradional way
===============================================

1) select com.codetutr.vehicleTrackingSystem.VehicleTrackingSystemApplication.java ----> run as -----> Java Application 



How to get Google Map keys?
===========================

1) Go to "https://developers.google.com/maps/documentation/javascript/get-api-key"
2) Click on "Get key" tab
3) Select term and condition
4) You will get the key now







                                          TECHNOLOGY USED FOR MICROSERVICES
=======================================================================================================================================================

1) Eureka Service Discovery/Registry -----------> To configure all applications Running port on Eureka server where all Elient Eureka will 
                                                  read those from server 
                                                  
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











