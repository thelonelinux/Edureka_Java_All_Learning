# Here we will see use of Eclipse for SpringBoot Microservices Project.

## Importing the SpringBoot Maven Project
* Once you have created the project in spring initializer : https://start.spring.io/;
* Download that project, that project must be maven project, and JDK versoin you can chose whatever you have downloaded in the system.
* You don't have to download tomcat server. As in springboot project they come pre-installed.
* Once the project is downloaded, extract the project.
* Now open Eclipse : You must have this eclipse version to run spring/springboot projects : Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)
* Also you must download JDK
* So now that project you can open in eclipse :
* Just follow below steps
    * Open the eclipse ide,
    * Goto File, click on Import Project, Expand maven folder in sub-window, click on Existing maven project, browse the file, select the folder and then finish.
    * hence our project is imported, Open the pom.xml file to update it, as it will download all the dependency.

## Running the springboot project in TomCat Server
* To run the project service on tomcat server. first make sure it is spring boot application. As springboot annotation must be there in the projectNamed java file.
* Only the springboot project has pre-installed Tomcat server, as you have to install yourself.
* Open that projectNamedjava file.
* Righg click on it.
* click on Run As, and then click Run As java application. Your project will run in tomcat server
* You can check the port in settings.properties file the port in which your project is running, or check in console when the tomcat server is started, it will show you there only the port id.

## Create the jar file of the application in Eclipse
* You can build your project and create the jar file, which is a executable application file. You can run thie jar file from command prompt.
* You can also use this jar file to run in docker or any other services

## Running the jar file from Command Prompt
* If we want to run same api application in different port in same computer/host. then we can create the jar file of it and run via different command prompts in same computer.
