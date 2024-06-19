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


## 7.Docker with Microservices using Spring Boot - I
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
* See video, includes code and concept

* LOAD BALANCER
* See videos, including code and concept


* RESILIENCY and CIRCUIT BREAKER
* Only concepts, code in next class
---- END OF class 7 (Need to write notes though, will do later)-----



## 8.Docker with Microservices using Spring Boot - II
* Start of class 8
* RESILIENCY and CIRCUIT BREAKER




## 9.Final Project (Here some additional classes were taken to complete the other topics of this Training)
