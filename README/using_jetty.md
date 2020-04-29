# Using jetty server

Goto Project folder and execute  

mvn clean install -Pjetty
    
1. Create links to war files 
```
 /dskovoronski-airport/airport-rest-app/target/airport-rest-app-1.0-SNAPSHOT.war
```
```
 /dskovoronski-airport/airport-web-app/target/airport-web-app-1.0-SNAPSHOT.war
```
in the directory jetty server
 ```
/webapps
 ```

[source link]( https://www.baeldung.com/deploy-to-jetty "click")


2. Start the Jetty server from the Jetty folder

 ```
 java -jar start.jar 
 ```
3. The application is available at

 ```
http://localhost:8080/airport-web-app-1.0-SNAPSHOT/flights
 ```



