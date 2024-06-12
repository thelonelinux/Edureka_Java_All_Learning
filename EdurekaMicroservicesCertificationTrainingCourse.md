# Edureka Microservices Certification Training Course

## Course Content: (Total 8 Modules, Sessions of 3 hours each)
### 1. Introduction to Microservices
* Class 1 Recording Learning
* Pre-requisites: Java
* So To Implement Microservices Architecture in our Project: We will be using the following tech Stacks
  * We will be doing practicals in Java and SpringBoot Framework (Basics of Core Java, Basics of Spring Framework like IOC Dependency Injection)
  * We will be dealing with RestFUL Web Services (Which will be using SpringBoot which in turn uses Spring MVC only)
  * SpringBoot Database - JPA and Spring Data (MySql Database)
  * Spring Boot Caching and Actuator
  * Scale Microservices using Spring Cloud (Kubernetes is not part of this course.
  * Spring AOP (Aspect Oriented Program)
  * Design Patterns in Microservices
  * Once this is made we need to deploy, which we will be doing using DOCKER, for hosting and running microservices in docker container
* Tool Requirements (All are open source only, none are paid tools)
  * JDK 17, Maven 3, Eclipse latest version or STS Tool Suite (Spring Tool Suite), MySQL 5.5
  * ActiveMQ - Message Broker, or Kafka (Streaming message)
  * PostMan (To Test Back end Rest Services)
  * Swagger (OpenAPI), Zipkin (API Tracing Libraries)
  * Docker (Supported by Linux Based OS/System) (Not usually supported in Windows, but you need to do by Virtual Box and inside install Ubuntu/Linux OS)
  * Sir has Google Cloud account, where he will host himself. He will setup virtual Machine there only, and install Docker there.
  * You can take free Google Cloud Free tier account, with 300$ free usage, 3 months free subsriptions. Take when docker class is started, that time you can do
  * Once you done with docker, then close/delete the instance else you will be charged.
* First three lectures will be only about understanding the architecture, from fourth class we will doing hands-on code and practical.
* START with MICROSERVICES Architecture
  * Microservices Architecture: Small services (To achieve some business functionality).
  * So Previously: Like if we need to do some functionality, let's say we want to measure the distance between two places, then we make class and write functionality there
  * and other client will take the jar file of it and use it's functionality by keeping it in some central folder.
  * But NOW what we do is we make services and host it somewhere, and then other clients will just use our functionality by calling the services.
  * In jar client can know about whole code implementation, whereas in API the code is hidden from the client.
  * APIs can be reachable only using Web/Internet, hence they are called web services. They can be also accessed through URLs only
  * Different way of Implementing WebServices: RESTful Web Services (We will be using this only) and SOAP-based webservices. (HTTP is Protocol to connect Webservices)
  * Monolithic Architecture: All code services/modules are bundled in the same project jar/war file.
     * (J2E based or Spring MVC) (You Create Java Packages: Users, Payments, Products, Orders etc within same project)
     * Each of these packages will contain classes like APIs, controllers, SQL, etc in same for each Package.
     * When you build this maven, you will get one jar/war file and then deploy it in application servers.
     * jar examples like APIs, simple Java class projects, etc
     * war is like web applications, need a website to run
     * Advantage: Simple Project, 1 server only - so cost-effective.
     * Disadvantage:
     * 1. Tight Coupling :  Users, Payments, Products, Orders since all of them in same Project. Lets say we have some frequent enhancements in Product Module only so we will be taking
     * some changes and test all other modules also, so this way we keep on doing however other modules no changes is required. So due to some product change functionality is not
     * allowing to do other functionality, as it is tight coupled, customer are unable to make payments. so this way one module is affecting other module as they are tightly
     * coupled, so this way we are disturbing other code. so this type of issue can come.
     * 2. Scaling Issue: let's say if we have more request is coming for Product Service, but not for Payments and Orders. Example 900 request only for Products but not ordering them.
     * So we need to scale up Product as servers will be loaded as more request are coming. which in monolithic we can't specifically scale for Product only, whereas in microservices
     * we could have only scaled the Product services, as they are not tightly coupled.
     * So scaling means to increase more load and handle more client request, we need to increase more RAM and CPU within Server which in turn will increase the capacity of machine/server
     * So this is called Vertical Scaling. So we can go upto 64 GB of RAM as much as high.
     * So there is Horizontal Scaling, here we increase the number of Instances (VM), Like multiple TomCat Server running in different Instances/VMs/EC2 Instance.
     * And in between we can keep Load Balancer, Load balancer will distribute the load, Load Balancer uses round robin, Algo etc will distribute the request.
     * So in horizontal scaling, you can create as many as instances, whereas in Vertical Scaling, you can't go beyond 128 GB Max. so horizontal scaling is better.
     * So we want only scaling for Products Module, hence independent scaling is not possible in Monolithic as they are tightly coupled.
     * so these limitations led to Service Oriented Architecture called SOA.
     * In SOA, We have independent Services whereas in Monolithic we have tightly coupled services.
     * In SOA, we will have separate serices with separate JAR file, which can be combined together in one folder to work together.
     * So SOA is  SOAP based service and not RESTFul service (Now Rest has come). We have to pass WAR/JAR to connect to different services to work together.
     * In SOA they connect services using ESB Middleware, ESB take care of client to service and service to service connection. No direct connection, Proxy is used between client and service.
     * ESB supports many protocols like HTTP, SMTP, SFTP, JDBC etc. ESB also take cares of routing, security, transactions. ESB tools like Mulesoft etc.
     * So now here ESB is doing the main role.
     * BUT : What happens when ESB fails, as this is the only one connecting our services with the client.
     * So the main limitations in SOA based Architecture is : Single Point of Failure. However ESB is also server only, we can have more ESB, but ESB is costly component, not all
     * organization can afford the cost. So the cost of MuleSoft ESB is very high.
     * So if we have only one ESB and it fails, then all the services will be down.
     * SO WITH ALL THIS LIMITATIONS, WHY CAN'T WE JUST GO WITH SERVICE BASED MODEL ONLY WITHOUT USE OF ESB. So this let to evolution of microservices.
     * So microservice is subset of SOA without ESB.
     * In both SOA and Microservices Architecture: Services are the fundamental Building Block.
     * In Microservice we have smaller services and follow the single responsibility principle. Which make services more smaller and granuler.
     * In Micorservice we don't have ESB so here we will write our own connector code or built-in connectors are there. So there is tradeoff between SOA and Microservices.
     * So a organization/company must check which to choose, cost or work. Considering the cost factore and client requirement factor.
     * Microservices usually supports RESTFul only, SOAP also it can support, but we do RESTFul Services only. Recommended is REST Services
     * All APIs are not webservices, but all WebServices are APIs. APis can be called Locally also like in Jar file put in central folder.
  * Microservices Architecture: Services are prepared separately in any code language, and connected by using web services connectors.
  * END OF CLASS 1



### 2.Microservices Design and Architecture
### 3.Introduction to Springboot and Spring framework - I
### 4. Springboot and Spring Framework - II
### 5.Microservices with Springboot and Cloud
### 6.Microservices Security
### 7.Docker with Microservices using Spring Boot - I
### 8.Docker with Microservices using Spring Boot - II
### 9.Final Project
