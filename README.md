# What is the Application about ? </br>
- This is a Spring Boot Microservice application that tracks Vehicle using the GoogleMap. It contains five following independent applicaions which are loosely coupled : </br>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; => SpringCloudConfig</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; => eurekaDiscovery </br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; => positionSimulator </br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; => positionReceiver </br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; => vehicleTrackingSystem </br>

- This application cannot be run until <strong>spring-cloud-config</strong> and <strong>eureka-service-registry</strong> are compiled and Run first. So, it is Strongly recommonded to compile and run these two applications even before compile other three applications. </br>

# How to compile and run the application ?
> Right click on project select Run -> Maven build ... </br>
> Under Main Tab in Goal Section do the following -> clean install </br>
> Under JRE tab, select alternate JRE and select the JDK you have setup from Runtime environment </br>
> Save a name as ${ApplicationName_COMPILER} and then Run </br>
> Now to run the application, Go to MainMethod of the applications -> run as -> Java Application

&nbsp; - Upon running this command will create style.css under the 'public/owner' folder. However sometimes the command may hangs on while runnig this command. in this case, you may need to change 'dev' with 'compile:sass' in package.json and run the command 'npm run compile:sass'. Now once this runs successfully, you may change back it to 'dev' from then onwards it should start working on 'npm run dev' too. Bug!! </br>

&nbsp; - You can now run this project directly in Visual-Code live-server at http://127.0.0.1:5500/ (Bypassing the below live-server installation step which is optional if you would like to run using npm live-server) </br>
> npm install live-server -g </br>
> live-server </br>
