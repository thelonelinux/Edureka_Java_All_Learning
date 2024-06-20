# This is continuation of EdurekaMicroservicesTrainingCourse.md

## 6.Microservices Security (Continued...)
## Starting from Lecture 6 Continued.
* From here we will be doing Ecommerce microservice implementation using Spring boot.
* ECommerce Application :
      * 1. Orders Microservice (Spring Boot Project)
          * Code Components: OrdersController, OrdersService, OrdersRepository. Similar code components we will have for below microservice spring boot projects also
      * 2. Product Microservice (Spring Boot Project)
      * 3. Customer Microservice (Spring Boot Project)
      * 4. Inventory Microservice (Spring Boot Project)
  * So for this 4 spring boot projects we will have 4 spring boot servers running this project. So this is the building block of microservices.
  * In production, we need to scale(expanding to larger way) these microservices. We can scale these services using spring Cloud, other patterns we use in Microservices are as follows;
      1. service registration and discovery
      2. service or client side load balancing
      3. resiliency using / circuitbreaker
      4. monitoring with spring boot actuator, micrometer and prometheus
      5. API tracing with Zipkin and spring cloud sleuth
      6. Spring cloud config
      7. API Gateway with Spring Cloud gateway
      8. After completing the above items we will be doing => Spring Security (Basic Auth, OAuth2, JWT)

* We will be also doing DOCKER in our project, But kubernetes is not part of our syllabus. So whatever Kubernetes is providing , that we can find in Spring Cloud also.
* Next class we will start with Service Registration and Discovery
* --- END OF CLASS 6 -------


## 7.Docker with Microservices using Spring Boot - I (Actually includes order service, service registry and discovery, and load balancer)
* Lecture 7 class starts
* Some doubts discussion :
* @ComponentScan is used to scan all the beans under the same pckage project. What we have to do to include other package/project beans.
* for that we have below code
       * com.myapp -- base package
        *  @Configuration
        *  @ComponentScan class A scan for the spring beam @Component present in com. myapp example beans like com. mypp. controller com. myapp. service.
        *  Now we have com.newapp.services. then we can include this in below way
        *  @ComonenScan (basePackages={" com. myapp", "com. newpp"})
        *  Similarly for SpringBootApplicaiton we do sme thing to include other package/Project
        *  @SpringBootApplication=@Configuration + @ComponentScan +@EnableAutoConfiguration
         * @SpringBootApplication(scanBasePackages={"com.myapp", "com. newapp" })

* So now we can start with Microservice Project
* SERVICE REGISTRATION AND DISCOVERY
* See video, includes code and concept to and write in detail
* FOR NOW = In layman words I will write what we did hhere
       * Service Registry spring boot project we create, We will also create order spring boot project, just right now we will not connect db, just return hardcoded as api return data
       * So in service registry project we will connect these orders project. You can check in yml file. this time we have remove application.settings file and instead using
       * application.yml file as we can store our configuration here in more detailed way. So once all the connecctions is registered in registry service we will run the registry
       * and in browser link we can see order service we are seeing in the registry link localhost.
       * So we will just make jar file of the orders at the end and run the jar file from command prompto in different port to see if both the orders service are there in registry service.
       * So registry service is used only to keep track of all our services used in microservice, it will help to keep services and apis in one place. 
* LATER = write in detail by re-visting the lecture video again

* LOAD BALANCER
* See video, includes code and concept to and write in detail
* FOR NOW = In layman words I will write what we did hhere
       * Load balancer is also a springboot microservice project which we create especially for balancing orders service only.
       * Remember one load balancer at a time is only used to balance one microservice. what load balancer will do is, it will talk to registry service and check there
       * How many instance of orders service are running, and then it will try to load the balance by putting some check in its code using roundRobin Algorithm.
       * So this is all about it.
* LATER = write in detail by re-visting the lecture video again


* RESILIENCY and CIRCUIT BREAKER
* Only concepts, code in next class
* FOR NOW = In layman words I will write what we did hhere
       * Resiliency means to resilient, means when Micrsoervice 1 is calling to microservice 2 which calls to microservice 3. and let say there is error found when
       * Microservice 2 try to connect with microservice 3. so to handle this situation, we can have differnt tactics. for now we will have Resiliency and Circuti breaker.
            * This will have algorithm like,
            * If ms3 is giving error, then it will send for 20 more requests from ms2 to ms3, if aall 20 failed, then curcuit will break, and it will send some cached data to ms1
            * Once the circuit between ms2 and ms3 is restored, then it will again start sending the response instead of using cached data. so this is like open state, inactive state and
            * active state, so this is the loop which Resiliency and Circuit breaker will handle.
* LATER = write in detail by re-visting the lecture video again

* 
---- END OF class 7 (Need to write notes though, will do later)-----



## 8.Docker with Microservices using Spring Boot - II
* Start of class 8
* RESILIENCY and CIRCUIT BREAKER




## 9.Final Project (Here some additional classes were taken to complete the other topics of this Training)
