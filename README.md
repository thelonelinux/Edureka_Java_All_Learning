# JAVA SPRING FRAMEWORK SPRING BOOT MICROSERVICES LEARNING
* For detailed understanding check EdurekaSpringBootMicroservice readme file.
* You will understand how everything works in java and what is the end point from where we have to start. we don't have to learn legacy things tech stack of java.
* Springboot Microservices Learning and Full Stack Project Build Up (Backend, frontend and Cloud, Docker)
* Learning Microservices with Springboot in Edureka will be enough to do starter as well as advance.
* Anyways starter are not required. In Edureka Microservices, Starter are explained, so leave starter and start with spring boot only
* For IOC and DI, you can see bit spring framework working example with code, that too explained in spring boot microservice lecture.



## REPO CONTENT
## 1.Edureka Java J2EE SOA Certification
* Contains topics like Core Java, Threading, Collection, XML, JDBC, Hibernate, Servlets, Applets, Spring, SpringBoot
* Batch Status : Batch is completed in year 2023, Learning and notes to be done, if required

## 2.Edureka Microservices Certification
* Contains Microservice architecture using Spring Boot.
* Topics Include: Monolithic vs Microservices, SOA vs Microservices, Spring, SpringBoot, IOC, DI, Microservices patterns like load balancer, registry service, API Gateway, Spring JPA, Spring Security, Docker etc.
* Batch Status : Batch was completed in year 2023 only, Learning and notes have been made, the course certification, notes is all prepared here. whole course learning is done.

## 3. MYSELFLEARNING TOPICS WISE SPRINGBOOT MICROSERVICES LEARNING TOP OF EDUREKA
* Check this folder, as this is main folder where I am doing actual learning and properly build up notes and codes defined there.
* This learning will follow edureka microservice course learning with enhance learning.


## PROJECT BUILD UP FROM THIS YOUTUBE PLAYLIST ( FOR YOUR REFERENCE )
* https://www.youtube.com/playlist?list=PLXXDXNrmlgEVMp_dPpVzWvylBAs52CxLw


## TOOLS/SOFTWARE REQUIREMENT FOR THIS  PROJECT  LEARNING
### JAVA ENVIRONMENT SETUP TOOLS
* 1. JDK 1.8 (Please check this link below to install openJDK in your windows 10 laptop, and also how to setup environment variables and configuration)
  *  https://www.youtube.com/watch?v=-O4QVijnA7Y&t=300s&ab_channel=LearningLad
* 2. Maven Build Tool
* 3. IDEs
  * Spring Tool Suite (STS) IDE
      * (Please check this link to install Spring tool suite and get along with project creation => https://www.youtube.com/watch?v=P1N-RGJ2820&t=315s&ab_channel=GeekyScript)
  * IntellijIdea or Eclipse IDE
* 4. Other Required Tools
  * Git Bash
  * Postman

## JAVA ENVIRONMENT SETUP IN INTELLIJIDEA (Windows/Ubuntu/MacOS - Almost same requirement for setting up Java Environment)
### Setting up Java and Maven
* Download openJDK (Version according to your requirement)
* Check by command $$java --version (to check java version)
* Check by command $$javac --version (to check java compiler version)
* Setup JAVA_HOME environment variable pointing to the path where this installation folder is created.
* Download Maven build tool
* Setup MAVEN_HOME (MVN_HOME) environment variable and also set MAVEN_HOME/bin url in path environment variable.
* Some Useful links
* Setting up Java Environment with JDK and Maven in MacOS - https://www.youtube.com/watch?v=t_TtZHda5-I&ab_channel=qavbox
* Setting up Java Environment with JDK and Maven in Windows and Ubuntu - https://www.simplilearn.com/tutorials/maven-tutorial/how-to-install-maven

### Setting up IntellijIdea and Configuration Setup for maven projects and spring boot projects (Pending task - In Progress)
* Download IntellijIdea (Community Edition will be fine to run microservices project)
* Checking on youtube blog to setup spring configurations and way to run the spring boot projects in tomcat.
* Previously only done in eclipse ide.

## PREREQUISITES
* Java
* Spring Framework
* SpringBoot (Springboot gives full project setup whereas in Spring Framework we have to set it up, which is time consuming)
* Restful Webservices

## CREATE SPRING BOOT PROJECT FROM SPRING INITIALIZER
* https://start.spring.io/
* Chose Maven only and chose your required dependencies and then download the zip file, extract zip file and then open the project in Spring Tool Suite
* So how to import that project in your Spring Tool Suite, to do that check this below video link
* https://www.youtube.com/watch?v=G6CtysUkmJs&ab_channel=TecnoTab


## EXTRA STUFFS : GIT Issues
* 1. Git Issue : When cloning, first merge the current branch to Main, then only clone in git bash
* 2. Git Issue : Also when doing $$ git add . 
  * We are getting errors like- LF will be replaced by CRLF the next time Git touches it 
  * To resolve that issue just write this command next, it will add  $$git config --global core.autocrlf true
