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
  * END OF CLASS 1 ------



### 2.Microservices Design and Architecture
* Microservices design based on Business Capability
  * So we can have different microservices following some business capability and each microservices has more services within that domain.
* Based on Team also microservices can be divided.
* Advantages and features of Microservices:
 * 1. An application can be divided into multiple microservices based on single responsibility principle either by /business capability
 * 2. Microservices are independent services that perform their own business functionality
  Limitations that we have seen in the monolithic are eliminated
 * 3. Each microservice will have their own code base,own server, have its own devops cycle(CI/CD)- build, testing, releases
  Because of this feature, microservices are used in agile environment
 * 4. Microservice can also be considered for product development, research and innovations
 * 5. There is no dependency on 3rd party heavy components like ESB for service orchestrations or integrations
 * 6. They are platform independent and follow polyglot architecture
 * 7. We can build or add new functionality without affecting the current code base.
 * 8. Each service/small microservice in microservice can be build in different tech stack.
      * And connect with each other over API calls. This is called heterogeneous tech stack known as polyglot architecture.
      * They connect on WEB URLs using REstFul APIs. URL : https://<ipAddress> or <hostName>/Appname/ApiPath
      * Methods like : http POST, UPDATE, DELETE, GET (These response are send by client or other service to connect and get the data)
      * So all other techStack understands API response, so heterogeneous tech stack will work here in micirservices.
      * RestFul Webservices  : Representational state transfer
      * Representation - Data exchange format between server and client : JSON/XML
      * JSON is widely used in Restful webservices
      * They use http to communicate and are stateless
 * Limitations of Microservices.
    * 1. Microservice has more maintenance as each service is running in it's own servers
    * 2. Debugging becomes complex in microservice, as they are different code base code stack
      3. Latency Issue: Local call is faster as compared to remote API call.
      4. Dependencies and transactions. : payment in microservice is done by external services so it is bit difficult to manage
      5. Separate Database or same database: which to chose.
* when you need to decide to implement a microservices architecture
 * 1. when number of services is more than 5 to 10 and business growing with different subdomains - definitely you can start proposing microservices
 * 2. when the number of services is fixed in between 5 to 10 or less than 5 and the business will not grow atleast for 2 years,
      * client wants this to be started as a minimum viable product - this can   be started with monolithic

* Patterns Used In Microservices
1. Communication Patterns -- Asynchronous and Synchronous
 * Synchronous: Where one Microservice will wait for a service call to complete when that service is called, this is synchronous. It gets blocked until a request is complete
 * Asynchronous: when service doesn't wait for a response, it is asynchronous. 1. Point to point queue model and 2. publish subscribe model.
2. API Gateway Pattern (from next class) ------
3. Transactional patterns(Saga patterns)
4. Event sourcing
5. CQRS
6. Service Discovery
7. Load Balancing
8. Circuit breaker
9. Monitoring
10. Shared database pattern
11. Single database per service pattern
12. External config pattern
13. Chained pattern


### 3.Introduction to Springboot and Spring framework - I (But we only did pattern in microservices notes learning, no codes)
* Patterns Used In Microservices (Continue where we left in previous class)
2. API Gateway Pattern (from next class)0
  * In layman word, it is just URL from which you can access the microservice/or service api's.
  * there are different ways to connect between to client and services for API.
  * Ways like routing (path based routing [example like /orders for orders and /product for product service and so on], header based and host based)
  * api gateway connects client to service, usually using api url call. which gives JSON response,
  * api gateway also provides caching in memory data.
  * api gateway is also like service/microservice.
  * but we have third party app running this service, we don't have to write our own code for api gateway.
  * TTL, time to live for cache data is 24 hours, after that it gets deleted.
  * An api which you have created can be monetized if more than 10000 requests are received in a day.
  * Features of API gateway.
     * Routing, Security (API gateway will handle authentication and authorization),
     * Caching, Rate Limiting/Throttling, Load Balancing, (Service Discovery and Circuit breaker = This two is bit separate we will check)
3. Transactional patterns(Saga patterns)
 * Let's understand by an example
 * //start transaction (Let's  say we have following steps in our transaction)
 * insert into orders table, insert into payments table, update inventory, generate invoice, process for shipment
 * //end transaction or commit transaction
 * NOW if there is an exception occuring in inventory table updation, like data not found
 * orders has been generated, payment has been dedcuted but data not found in inventory --this leads to data inconsistencies
 * In order to avoid data inconsistencies, we use transactions across multiple db operations
 * SO in microservices we have LOG BASED JOURNAL, so any db operation will be logged in this journal which is managed by DB and Transaction manager,
 *  and when the commit is successful, then only it will update in DB tables.
 * Once the failure is recorded, the exception will be generated, then it won't go to next line, and the log entrys will be deleted, and nothing gets updated in the table.
4. Orchestrator Pattern (Responsible of managing transaction across microservices) and Choreography Pattern (This pattern is used when orchestrator transaction fails)
   * pattern In choreogrpahy, there is no seperate service like orchestrator to manage transactions
   * Here services will interact directly with other services through message queues (asynch communication) and manage transactions
   * We will understand this more with the project
5. Event sourcing and CQRS
 * 5. CQRS
 * You can learn about this in google search dzone blog by kiran sir only, our mentor
 * Example in event sourcing, first customer selected pizza and ice-cream, and later deleted ice-cream, and order only pizza, so to log all this event in somewhere
 * so htat our business can track this event. and based on this event we can take some decisions, like cookies., analytics etc we do by AI/ML algos.
 * so this all about it.
 * In CQRS : like we have write operation in one data base and read (select) in other server database, so there must be read replica service between them to sync data between
 * read and write servers.
 * END of Class 3 -------
6. Service Discovery
7. Load Balancing
8. Circuit breaker
9. Monitoring
10. Shared database pattern
11. Single database per service pattern
12. External config pattern
13. Chained pattern
   
### 4. Springboot and Spring Framework - II
* Spring FrameWork and Spring Boot
* In Microservice, single database per service is the ideal pattern, but it has limitation, as we see in previous lecture.
* To know the spring Boot we need to first know the basics of spring framework, because spring boot is developed over spring framework.
* Microservice can use any programming language to implement, like java, c#, goLang, Python etc.
* But we will use Java Spring boot to implement microservice architecture.
* SPRING FRAMEWORK
  * Spring started fundamentally two patterns
     * 1. Inversion of Control (IOC) (Better check image, everything is mentioned there)
     * 2. Dependency Injection (DI)
     * Inversion of Control : From Image, extra Point
        * The pattern where the responsbility of creating and managing the object is not from the main application class but from the factory component is called Inversion of control
        * Factory component is spring container or sprint context or bean factory.
        * Previously we use xml in configuration, but now we use annotation in configuration, annotations is modern way of doing this.
        * This classe B, which we call POJOs, (Means plain old java object), it can be any normal class.
        * So this all is fundamental principle of IOC
     * Dependency Injection :
        *  IOC uses the Dependency Injection to manage the objects.
        *  DI is the subset of IOC. So IOC also injects the object in the container. You don't have to write setter or getter method to get other object in current object.
        *  So responsiblity of creating the object and managing the dependency object is all taken care by spring framework to use the object and call the respective methods of the object.
        *  So this is the fundamental concept of spring framework
       
* SPRING CORE : So using these concept SPRING CORE has come in the picture. Spring core includes IOC and DI.
* So spring slowlly started developing modules or templates for enterprise applications on top of this like shown below
    * SPRING CORE (IOC and DI)
       * Spring AOP (Aspect oriented Programming)
       * Spring JDBC (for database management)
       * Spring MVC (on top of it we have Spring Rest) (This for developing restful web services and web applications)
       * Spring Security (For Implementing security)
       * Spring Data
       * spring messaging
       * Spring Integration (For lightweight applications like light weight ESB)
       * Above all of this SPRINGBOOT is build. (Check in image note)
     
* So now using springboot we can develop some applicatoin in 5 weeks then using simple spring core only it would have or otherwise take 8 weeks.
* So Spring boot saves 30-35% of effort and develops application faster.


### 5.Microservices with Springboot and Cloud
### 6.Microservices Security
### 7.Docker with Microservices using Spring Boot - I
### 8.Docker with Microservices using Spring Boot - II
### 9.Final Project
