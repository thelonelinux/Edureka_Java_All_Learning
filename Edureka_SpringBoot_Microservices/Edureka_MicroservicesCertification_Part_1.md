# Edureka Microservices Certification Training Course
SpringBoot is a foundation of Microservices
## Course Content: (Total 8 Modules, Sessions of 3 hours each) : [All the code and notes, ppt and images of microservice class are added, IMP***]
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
   
### 4. Springboot and Spring Framework - II (Here we did spring framework IOC and DI understand via code and using spring MVC we created the rest service project)
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
* Rest you can check in the image : SpringBoot on top of spring core.

* Next now we start with coding and spring, but first we will see IOC and DI, how it is done in spring.
* Install JDK-17, Eclipse IDE for Enterprise Java and Web Developers and STS (Spring Tool Suite)
* PostMan
* Coding part : IOC, DI, Maven, Spring Projct, Annotations, Pom.xml, AppicationContext, Configuration, Bean, Simple Spring Project
* We learn about annotations, beans object, configuration, component, componentScan, autowired annotation, Rest you need to write code and save codes with comment in this repo to understand
* Explained how IOC and DI is used in Spring etc.
* Next we see about Rest and Spring  MVC Architecture.
* Some good notes and lengthy notes,
* CODING PROJECT : Now start with programming with spring rest.
* To Develop Restful Webservice using MVC and then convert to spring boot.
* So a simple rest api was created using spring framework, spring MVC.
 * AppInitializer.java Class - This is used to register Dispatcher servlet, some libraries added in pom.xml to use it by extending that library in this class.
   * This will work like web.xml, where any url pattern is send url servlet.
   * Here we have to add some override methods. Here we do servlet mappings
 * AppConfig class (Configuration Class) - for Creating Beans and Configuration and Component Scan. This take cares of IOC and DI. Following annotations will be used in this class
   * @Configuration : Defines configuratoin of spring beans (object)
   * @ComponentScan : Scans for the @Component and create spring beans
   * @EnableWebMvc : This will enable MVC functionality (like dispatcher servlet loading) This will work with Jackson library added in Pom.xml to convert json to java and vice versa
   * this config class is given in parameter in AppInitializer dispatcher servlet. Dispatcher servlet will use this config class to create spring beans, manage beans in this mvc framework.
 * Customer class - for our POJO class, to store data of customer object and send as json.
    * For now we have just created hardcoded customer object and added some value in it to send it as API response.
 * AppController.java Class :  To make Rest API calls class
  *  @RestController annotation is used to identify it as our API controller in making URLs,
  *  @GetMapping("/customer") annotation used in Method as url 
 * Pom.xml for storing required dependency
 * In spring framework we had to install TomCat server to run/deploy our project on the browser, In springBoot Tomcat server is pre-installed.
 * We did all this in Eclipse IDE
 * Json Response of GET Method was created, next time we will see for other method like PUT, POST etc
 * Rest URL : http://localhost:8080/springRestApiDemoProject/customer :
   * HTTP(This is protocol) ://localhost (Tomcat server or host name or IP address):8080 (Port)/springRestApiDemoProject (Application name)/customer (Api Path - GET customer)
* Next clas we will see how to do same task Using SpringBoot.
* End of Class 4 -------


### 5.Microservices with Springboot and Cloud
* Class 5 Learning
* Yesterday's Project using SpringBoot. Previously done in Spring MVC.
* So to create a springboot project, It is recommended to create a project from scratch using Spring boot Initializer.
* Open like : https://start.spring.io (And there you can create a spring project from scratch)
* Over there create a project : 
 * Select maven, java 17, jar file, name artifacts and group name as project name and package name as com.projectname, and then after add dependencies,
 * In dependencies you can add Spring Web (Restful one), This will also have embedded Tomcat server in it.
 * And then click on GENERATE, it will generate a zip folder.
 * Extract that project.
 * Import that project in Eclipse as a maven project. You could have done this in Spring Tool Suite IDE also. Check outsing youtube videos to follow full course.
 * Now let's compare with the old project in last class that spring mvc one.
 * You will see many base codes have been generated on it's own, structure is already generated.
* SPRING BOOT STARTER dependency : (Very important), This helps in solving in our dependencies and versions of dependency management. check lecture for more insight.
* So as compared to spring MVC project and this spring boot project we have following advantage
   *  1. Spring boot starter packs - This solves dependency management issues in the project.
         * spring boot team does a lot of research in starter packs. This also manage version compatibility.
         * This will be under parent starter parent pack version, so this will be inherit to child version, so no version change update is required.
   *  2. With the spring starter web - we also get embedded Tomcat server to setup or deploy
   *  3. spring boot autoconfiguration - Like in previous Spring MVC class we had Appconfig.java class and AppInitializer class.
         * But in today's spring boot project this two classes are not required.
         * So because of spring boot autonconfigure, that two class is not required, only customer and appController class copy and past and run the project. it will run.
         * This will automatically take care of all those configuration and beans things.
         * So we have a new class named with project named (SpringBootDemoApplication.java)
         * where @SpringBootApplication annotation is used to take care of all those annotation functionality required in
         * Appconfig and AppInitializer class in previous mvc project.
         * Spring boot auto configuration Working : (See image in class video only)
            * this will find the libraries in the class path and create the configuration beans automatically
            * example: spring boot auto configuration will find mvc libraries in the class path and create mvc configuration beans automatically
            *  when we add spring-boot-starter-web in pom. xm1, the mvc libraries will be added to classpath
            *  WebMvcAutoConfiguration :  @EnableMvc -   enable mvc functionality register dispatcher servlet
            *  which AppInitializer.java is doing
            *  @SpringBootApplication = @Configuration  + @ComponentScan + @EnableAutoConfiguration 
            *  @Configuration (create spring beans)
            *  @ComponentScan ( scan for the @Component and create spring beans)
            *  @EnableAutoConfiguration (will trigger the auto configuration  functionality)
* We can also do POST Mapping here, previously we only did Get mapping.
* PostMapping("/customers") in AppController.java class
* So to test this, we can't test this on browser, we need client like PostMan. (Very very important learning)
* Only GET request can be checked in browser (Very Very important learning)
* So open that url in postman and send the data in json format only as we get for GET request, format should be that only. So this is how we send post request.
* So this will be send to spring dispatcher. The post we have done will be sent to spring dispatcher servlet.
* dispatcher servlet will use jackson library and transform json to java object and call the controller bean. So this is how POST request will work.
* --
* Now Next Topic : Spring Boot Data
* SPRING BOOT DATA :
  * How to connect java object to database. We will use JDBC. JDBC is a framework library, which will connect with database and do database task.
  * Evolution of Spring DATA JPA from legacy JDBC Base.
   * JDBC to Spring Data JPA (Java Persistence API) Evolution.png (Check this image for more details and pic and notes)
   * Initially we used JDBC to connect java object with Database in java. (but it will take 10-15 lines of code to make connection and others work)
   * So later we introduced Hibernate, EclipsLink, IBatis third pary library to make simplify these steps.
   * But hibernate become more popular and Spring Boot Data also uses hibernate only, So JPA Hibernate was build above JDBC knows as JPA Hibernate, JPA provides ORM Specificatoin
   * And then later in Spring Boot Spring Data JPA was build on top of JPA Hibernate. And so now we will be using this in our code.
   * There is also Spring JDBC, which is also build on top of JDBC like JPA Hibernate, But Spring Boot Data JPA uses JPA Hibernate only.
   * So we will now learn about Spring Data JPA (Spring BOOT DATA)
   * In JPA a class should be marked with @Entity annotation to map with the table with Database.
   * So if JDBC takes 10-15 line of codes then for same task Hibernate JPA will take 3-5 lines of code, and again Spring Data JPA will take just one line of code.
   * JPA is method only, all the implementation is provided by Hibernate.***IMP
   * SpringBoot Supports Hibernate by default.
   * next----
* Let's start with code in Spring Boot Data : Spring Data JPA
* Spring Data JPA
   * We will be using MySql Database
   * Spring Data JPA is model provided by spring with various repositories.
   * Repositories in Spring Data JPA
      * CRUDRepository (This contains methods for below types of DBs ,ike we had ADO, etc in .net) (This contains Basic methods like Create, Read, Update, Delete Data Operations)
         * JPA Repository - (Include JPA Methods for RDBMS Database like Oracle, Mysql, SqlServer) We will use mysql DB, in which we will work by using this repository
         * Mongo Repository - For MongoDB Database
         * Cassandra Repository - This is also NoSql like mongo above
       * Crud Operations like Create, Read, etc wihch means insert, and select data, have already defined by default few methods to do data query in spring data JPA.
       * So you don't have to add this method separately in the programs, however, we can have some user-defined methods to do operations according to our need also.
* Separate Spring Project create for to implement sring data JPA working.
   * similarly go to springBoot initializer.io (Name project as : springbootdatademo1, add dependency "Spring Data JPA") (Code added in same repo, you can check there)
   * You need to also add mySQL Driver dependency if you are using mySQL driver to connect to database. check in the code, you can add manually also and save the pom.xml file to download.
   * Remember JPA is the one which is giving us this pre-defined method to do crud operations on Sql Table.
   * So open the project in eclipse or STS.
   * Open the pom.xml file, there you can see along with "spring-data-starter-web" dependency there is one more dependency "spring-boot-starter-data-jpa"
   * "spring-boot-starter-data-jpa" so this contains internally all the hibernate dependencies.
   * So here this two dependencies, web for mvc and data for sql.
   * Now goto src/main/java : there you will see the java class with the project name only, this has annotation as @SpringBootApplication, so this means this is your Spring boot application.
   * Now let's open the MySql setup, DB IDE and get DB Connection configuration details., let's say we have Student DB.
   * Now goto src/main/resources : there is this "application.properties" file, there you can add DB details like dbsource, username, password to make db connection.
      * So here we have pre-defined properties name/variables to use to define this property. You can check in the code present in this repo
   * Now we will create Contorller class. "StudentController" and put @RestController annotation. And inside this class we will make @GetMapping urls method
   * So get all the list of all the students from this table we can do @GetMapping("/students"), and define method below it.
   * But first let's create Student @Entity class. In JPA this class should be marked with @Entity. and mapped this with @Table(name="student"). hence table student is mapped with entity class
      * Student.java: It's properties/data memebers will be mapped with columns. Example @ColumnName(name="columnName"), Example for firstName, add firstName. as private string firstName.
      * also we have ID as primary key, so we indicate this with id annotation, @Id (Mapped to primary key column)
  * So now going to StudentController, there you can call this student method to get all student in that mapping url method. see in code only.
* Controller class, Service Class, Repository Class
  * @Controller   =>calls=>  @Service  =>calls=>  @Repository  =>This will connect to DB=>   Database
     * @Controller : Contains Url Mapping, takes request gives response.
     * @Service : This contains the business logic, handles transactions and business logic
     * @Repository : This contains JDBC, Hibernate code and Db Operations.
 * Architecture is
    * @Component (All our classes are component only, this means, which follows DI and IOC and can use this beans)
       * @Controller
          * @RestController
       * @Service
       * @Repository
* So now studentController will call the StudentService. In order to call StudentService in Controller, we have to inject service bean in controller.
* So to inject this bean, we will use @AutoWired annotation in Controller class. so code as @AutoWired and create StudentService studentService object.
* So now let's create StudentService.java class. We will annotate this service class with @Service.
* In this StudentService.java class create method, GetAllStudents. Inside this method we will call Repository class crud operation, so first get StudentRepository bean/object in this class.
* so do @AutoWired in this class for StudentRepository. So now since StudentRepository class is not there, so we will create this StudentRepository Interface class.
* StudentRepository interface extends JPARepository<Student, Integer>; So this takes Entity class Student and the primary key Data type of this class. which was ID which was integer.
* So now using this bean studentRepository bean in StudentService class inside GetAllStudents method, just inside this method do studentRepository.(You will see many DB operations for student)
* studentRepository.findAll(). Will return all the table content. These are pre-defined Db operations provided by JPA.
* So this is all about the beauty of how fast we do DB operations in Spring Data JPA.
* In simple JDBC, we have more complex, but here we do so easily.
* Some complex methods we can define and make our own uesr defined operations on our table. that we see in next class.
* Now we are done with the code part.

* NOW let's understand the underlying principle of this code
   * whenever spring-boot-starter-data-jpa is specified in pom. xml,
   * spring boot auto configuration will create 3 beans automatically which is required for JPA/hibernate
   * 1. Datasource bean: this bean is created by reading the properties specified in application.properties files. where we add our connecction string details of our datasoure and db.
        * Datasource bean is a connection pool object, This is a db connection. This contains multiple DB connection pool objects
           * Very Imp
           * Previously we use to store our connection in Thread Pool, and whenever we get reqeust say one to 5 or more reqeust then we will create the connection and close them.
           * This used to be the expensive task to do, Creating and closing the connection is expensive task. This was in Usual JDBC.
           * BUT now we in JPA DataSource, we are creating the connection in Connection Pool. here in connection pool we can specify number of connection we want to connect in the
           * application.poperties file only. Example this code : spring.datasource.initial-size=10 (Here it is saying initially we created 10 connection pool for our connection.
           * So this we can specify in advance according to our need, acording to our client needs, who is sending the request.
           * So here no new connection is created when client requests. Instead we will get the connection. Once they are used this connection, this connection will get close and get back to
           * connection pool, so here it is not destroyed, here it is restored in connection pool to be used again.
           * So here overall what is happening is : During the time of request, connection object is not getting created, instead getting the connection object from pool
           * and once the connection is close, connection object is returned backed to pool, where to connection object can be used to serve others.
           * So if you application required 500 connection then you can do initial-size as 500. so size of connection pool depends on load. Based on concurrent request. like 500 users at a time.
           * there are several third party library to make this datasource bean connection pool
           * spring uses Hikari Connection Pool library for connection Pool
         * DataSource bean creates another bean call EntityManager bean
    * 2 EntityManager bean : This is responsible for executing the db operations (like create, read, update, delete entity) --all the ORM operations are done here. example that findAll().
       * From this EntityManager bean TransactionalManager bean is created.
    * 3 TransactionalManager bean : Used to manager local transactions. will work with spring @Transactional.
   * So these 3 beans are created as part of spring boot auto configuration.
   * So now in StudentController class in the getAllStudent mapping. inside that method, do studentService.getAllStudent();
   * so now run in tomcat server: localhost:8080/students (This will call controller mapping class which in turn will call service class which in turn will call repository and get details)
   * repository (JPARepository) internally uses datasource bean, entitymanager bean and transactional manager bean, this will provide will all the default methods.
   * For getStudentById we can have mapping with path variable as GetMapping("/student/{id}") and methond as getStudentByid(@PathVariable Integer id)
   * and the url for this will be : localhost:8080/student/5  (This will give studnt with id=5) So this is how path variable or url variable way of mapping is done.
   * Also let's create POST methond PostMapping("/studnet"), rest see in code. as we have to make it's function in service also, so just see there, that's all it is.
   * and then post them using Postman and so on.
   * So these are basic operations like findAll(), findByID() provided by JPA, so in next class we will make custom function for our table for non primary keys also.
   * We will make Custom Queries in next class. like getting student by mail and first name, and etc etc. Not all are pre-defined so we can make on our own, we will do that in next class.
   * ------ end of class 5 ------
 



### 6.Microservices Security
* Class 6 begins
* Custom Sql methods we will make today, continued from the previous lecture.
* So just go to StudentRepositry class and create this custom method signature only, don't do any thing in method, JPA Internally will implement this method.
  * //whenever the method starts with findBy, JPA Repository will query the
  * //data based on properties specified after findBy name in the method
  *	//this will internally generate an sql query to select by first_name and last_name columns
  * 	public List<Student> findByFirstNameAndLastName(String firstName, String lastName);
  * 	So this you can get in service and then map in controller and call this api. see code in repo.
  * 	Other custom query you can see code in this repoitory only, not writing about it in here.
* 	Custom Query also we can create for more complex implementation in repository class.
  *  //this will select id and email when firstName and lastName are given
  *	 //this is jpql/hql(hibernate query language) where this is associated with entity classnames and property name
  * 	@Query("SELECT s.id,s.email FROM Student s where firstName=?1 and lastName=?2")
  * 	public List<Object[]> getIdAndEmailByFirstAndLastName(String firstName, String lastName);
  * 	Now this method is not by findby, Instead we are doing get, so this is our custom method with custom query
  * 	Rest you call this in service class and then in controller class and you can see code there.
  * 	In this @Query annotation you can write any query, even join queries, bcoz hql supports all this queries. Internall it will convert into sql query only.
  * 	You only have to deal with entity class and it's properties name while making such queries.
  * 	the queries gets executed during the runtime.
  * 	So here we are returning an object array
     * public List<Object[]> getIdAndEmailByFirstAndLastName(String firstName, String lastName);
     * so for this Object array, we need to make another pojo, or say DTO class for student having only Id and Email, as that only we want as output in our query.
     * So create a new Class StudentDTO.java : DTO means data to object. DTO class are used for response request mapping, Here this is not entity class.
     * entity class is used for ORM Mapping, using whihc our table queries methods are pre-build by Repository class.
     * So DTO class is normal POJO (Plain java class) used only when we want to give some response by mapping this object class.
     * and Entity class is the Class which will take care of ORM Mapping.
     * And use this to implement method in service class. Object[] array will passed as StudentDTO and we will get the list of id and email.
  * So now run the code in tomcat server, everything will work fine.
  * So this is it. Now starti with next topic.
    
  * PAGINATION
    * Want to display only first 100 records, and then go to next page, then gives next 100 recrods and so on.
    * So Pagination can be done, here only in the code, as JPARepository provides that also.
    * So code this way
       * Pageable method  add in JPARepository (you can check the code in code repo here, in same project)
       * In service do that method with offset and limit
       * In Controller call that with mapping.
       * Url : localhost:8080/studentsByPage/3/7   (Starts from 3 and fetch next 7 row in the table, this is how offset limit works)
       * once first offset is fetched, next offset will be from next row after that used or fetched records. Working explained below with the formula
         * next record:
         *  getOffset()+getPageSize()---next offset position
         * getPageSize() -- limit position
         * previous record getOffset ( )-getPageSize()
         * getPageSize()--limit
*
* Done with Spring DATA JPA
* Next topic will be caching now
* CACHING .
 * Spring Boot Caching
  * caching happens in ram, which is faster than disk memory.
  * Cache Data Working and Flow Explained
     * Let's say a user requests for some data, then the Controller gets called which will call Service and this will call JPARepository.
     * JPARespository will call database and get that data. But first it will store that data in Cache Memory (cache memory is an in memory data store (RAM) within the application from
     * where the client has called. so this data will be also stored in the cache.
     * Next time the client will call the same request, then first it will check if that data is present in cache memory of the application or not, if present then that data is sent to client
     * this task will be fast as database call is skipped.
     * In case the request data is not preesn in cache memory of the application, then first it will get data from database and then stores it in cache memory and then send data to client.
   * So this all above logic is provided by the Spring Boot Caching, by just simple annotation and few line of code. In spring boot caching we don't have to write huge code to use that logic.
   * @Cacheable annotation : This logic is implement by just this annotation.
   * Project Code - springbootcachedemo(Let's create a separate maven project to implement this logic)
     * Add extra dependencies "Spring Cache Abstraction", rest previous dependencies which you have added in previous code that you need to add here also. like data and web and mysql starter.
     * You can do sql setup in application.properties. check in code only present in this repo there.
     * We will be using product table. create Product class entity. And then ProductRepository and ProductController and ProductService.
     * make getProductByID method, Also add message fetching the data in console, so whenever you call you will see that it is fetching from the database.
     * So right now we have not added caching in our project.
     * so just add @Cacheable annotation on service class above that method, just check the code in this repo.
     * @Cacheable(value="product", key="#id")
        * here value="product" is cache name and key is key, as in java spring boot caching, cache is stored in hashmap. HashMap is in memory data structure, cotaining key value pair.
        * so whaterver id search you are passing, it is storing it as key, like student by id, then id will be the key for our cache valje and stored in hashmap.
        * when it is first time called then only value will get stored in cache by creating the key value pair and store in the hashmap.
        * this annotation will be implementing the whole cache logice explained above.
        * Also in @SpringBootApplication, below this we have to also add @EnableCaching annotation to enable caching.
        * So now run the project, you will see that second time it wont call db to get data, it will get the data from the cache.
        * SCENARIO :
           * Let's say now the data we are sending from cache to client. now someone at backend has update the data with new value, but in cache we have old data.
           * So in this situation, we will be giving him outdated data.
           * So we need to think about some mechanism, to sync data in cache and db.
           * There is a mechanism to handle such cases, it is called TTL (Time to Live). In TTL, we set expiry to cache, whenever cache expires, data will be fetched from db and update in cache.
           * Spring boot default cache uses concurrent hashmap data structure, and it won't have TTL. (So not advised for Prod Environment).
           * So we need to Spring boot cache with  third party library like Redis, Memcache, EHcache etc to implement TTL. Redis is popular no sql distributed cache.
           * EHCache also internally used HashMap only.
           * EHCache Integration with Spring Boot Cache : 
              * We will add two library/dependency in our current cache project to use this EHCache in our project. org.ehcache and javax.cache. this two libraru added, check code in repo.
              * After this in application.properties we will override spring boot default cache with EHCache, so code will be like
              * #we are overriding spring boot default cache to ehcache
              * spring.cache.jcache.config=classpath:ehcache.xml
              * Also this ehcache.xml file will be generated. And will have value matched with the alias used in our project only. This contains cache configuration.
              * Also you can see there is TTL also, like 20 seconds. for now just to show you how it expires and gets updated. Else we can put hours and days also.
              * Adding CacheEventListener class to check how the cache is create expired etc. to check TTL etc. You can see in the code. So this listeners is in that ehcahce.xml file also
              * Also there is heap memory you can see, the size of heap you want. So there you can see 2000 objects are stored in the meomry.
              * So now run the program, and after 20seconds again call that, you will see new value got stored in the cache.
     
            
* So this is all it.
* Now we will start with microservices, and we can now understand why spring boot is preferred choice to implement microservices.
* Now Start with MIRCROSERVICES
   * Microservices need separate compute environment (Tomcat server) - embedded tomcat servers.
   * Need restful web services layer for exporting rest api's
   * caching
   * monitoring
   * Quicker developoment and deployment - agile methods
 * So spring boot provides all this features. so we use springboot for microservices.
   
* So now we will see a Ecommerce application to implement microservices.
* 



### 7.Docker with Microservices using Spring Boot - I
### 8.Docker with Microservices using Spring Boot - II
### 9.Final Project
