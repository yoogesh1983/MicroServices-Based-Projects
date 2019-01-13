Application's Running on following port:
#######################################

vehicleTrackingSystem -------> 8080
spring-cloud-config ---------> 8088 (don't know why it didn't work on 8081)
positionSimulator -----------> 8082
Eureka-Service-Registry -----> 8083
positiontracking ------------> Automatic port is assigned by eureka server





How to look the setup properties?
##################################

- Go to "http://localhost:8088/application/default"
- now you can see the configured properties inside configured sources
- Remember, that was default. similarly we can configured for dev and prod also.


How to open the ActiveMQ
###########################

1) Start the ActiveMq by doubleclicking on activemq.bat that is at "C:\Users\yooge\Desktop\GlassFish\01 - STS in Local\apache-activemq-5.14.3\bin\win64"
2) Hit the below URL:
                      - http://localhost:8161/
                      - Username: admin
                      - Password: admin
                      
3) Click to "Manage ActiveMQ broker"
4) Click to "Queues"
5) Now, you can see the positionQueue there