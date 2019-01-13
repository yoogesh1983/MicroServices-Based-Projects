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

