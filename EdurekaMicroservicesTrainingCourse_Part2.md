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



## 8.Docker with Microservices using Spring Boot - II (We did Resiliency and Circuit breaker, API Gateway and then Spring Cloud Config - Config Server)
* Start of class 8
* RESILIENCY and CIRCUIT BREAKER (Not be adding in very detail. later you can check video for in detail)
       * dependencies we will add resilience4j only, see in pom.xml file.
       * Cirucit breaker we will add this in orderserviceloadbalancer service project only, we will add the code in orderserviceloadbalancerController.java class only
       * We will add there annotation as @circuitBreaker, rest see the code. In this annotation only we will add some method which will be called when circuit is broken.
       * See different configuration for circuit breaker in Resiliency document, they will do different task for circuit break method as per our requirement.
       * We will add these configuration in yml file.
            * Example : sliding-window-size=10
                           * Means our circuit breaker will maintain a window of the records of last 10 calls. as we have mentioned size = 10.
                      * minimum-number-of-call
                           * Atleast 10 calls must fail to start the circuit breaker, and other confiuration details you can check in video later.
                      * permitted-number-of-call-in-half-open-state
                           * Here is three request check is done during half open state and sent to ms3. if this time all 3 request works without error, then circuit will move from
                           * half open state to close state and our cirucit will again start working fine. the request will be send by client only. and if next 3 are good, close the circuit
                           * and everything is fine now, circuit is good. so this is  also one of the configuration.
                      * sliding-window-type=COUNT
                           * So this we do as count based, we can also have TIME based to deal with circuit breaker details.
       * So we can also add cache seding respose in our circuit breaker method. that we can do later,
* So this is all in resiliency and circuit breaker.
* for very detail you can see the vidoe and code.
* Roight now I think this much will do, until you are directly working someday in Resiliency and cirucit breaker in you live code, then that time come here and check

* So now we will go with next topic

* So for now we have completed first three patterns of Microservice
     * 1. Service Registry and Discovery
     * 2. Load balancer
     * 3. Resiliency and circuit breaker

* Now we will see next topic in this

* API GATEWAY (Much you can see in detail by watching the video and again and write in detail about it - for now writing in lay man word in brief)
       * API Gateway is also a spring boot microserviec project will just connect with following services
            * orderserviceloadbalancer
            * Productservice
            * UserSevice
       * So this is just like one path definer, this time localhost will be common and will be of ApiGateway service only,
       * Registry will be one only. where all these services will be registered, API Gateway will also make use of this registry only to find the services and there path
       * here OrderServiceLoadBalancer is that same project which we implemented last class. So this loadBalanceer is also using registry service only to manager orders services internally
       * So registry service can be used by any service. There will be only one registry service. We will define all three above services in this registry service only.
       * APIGateway also takes care of LoadBalancer in it. It also take care of security. (Security part we will discuss later)
       * We could have also directly called orderService only instead of orderServiceLoadBalancer, so this way also it works but internal load balancer would not work. We have to then take
       * help of apiGateway load balancer only. So this is how it is.
       * Eureka server is registry service only.
       * So we will keep apiGatewayService in public subnet and other service in private subnet. so that no one else can access directly, but only via Api-gateway.
  * So this is all about API Gateway
 
* No we will do new topic
* SPRING CLOUD CONFIG (Much you can see in detail by watching the video and again and write in detail about it - for now writing in lay man word in brief)
       * In layman words
       * This just stores the application.properties or application.yml file in centralized location in github,
       * As there can be diffrent environment like stage, deve and Prodcution. So properties will be different for each environment.
       * So if we have let's say 17 microservice then we have to maintain like 17*3 = 21 properties files. so it is bit a lot of work. so we will keep all our properties files in one location
       * In Spring cloud config in github. And use bootstrap.settings file to connect with these files.
       * When the service starts that time it will take the data from config file and later keep it in cache, so cached later can be updated if some changes are done, we have code for that too
       * @Values is used to search property files for each service from the config server.
  * Next class we will do the coding of this task
 
* --- END OF CLASS 8 ------
  



  


## 9.Final Project (4 Class in one)
### CLASS 9 (Config Server Implementation)
* CONFIG SERVER (For more detail see video and code and write detail notes later)
* In Lay man words
  * ConfigServer Spring project we will build.
  * In POM.xml we have config-server dependency added. There is actuator also, we will see in next topic, It is for monitoring health check. Memory, cpu usage and all that.
  * In Config server app we will define the configuration to connect to github. See in application.yml file to see details there.
  * Sir has created all the application.properties file for each environment for each service in that repo (Testprivaterepo) you can check the link in the code repo.
  * Simce this is private repo so we need to generate ssh key to get authentication to connect with this repo. In notes.txt file alongside properties file there it is present on
  * how to generate ssh key.
        * #connecting to private git repo
        *  generate private and public ssh keys
        *  ssh-keygen -m PEM -t ecdsa -b 256
        *  it will be stored in c:\users\hp\.ssh\
        *  copy the private key in application.yml
        *  copy the public key in github repo in deploy key
    * The match between public key and private key will authenticate the user.
   
* Now let's connect this config server with user service. for that let's add bootstrap.yml in user service. Also add @EnableConfigServer in user service spring boot application.
* In bootstrap file use same url port that we are using in config server. And then also add application name and profile for wihch environment you want.
* This we all add in spring.cloud.config properties type in user service bootstrap.yml file.
* In configserver private repo, there in user properties file, we have "myKey" value defined there, which we will inject in our userController with @Value annotation.
* This will search for our file in repo and try to link with that. It will search all properties file with user service name.
* So now run the config server and then user service project, once the connection will made you will see that port number is overriden from local properties file to private repo
* settings file. in local it was 5400 and in github properties file it is 5600. so now user service will run in 5600. as remote properties file has overrriden the properties.
* SO OVERALL IT IS LIKE THIS
       * config server will connect with github private repo with ssh key in it's application.properties file
       * user service will connect with config server using bootstrap.yml file using the url of config server.
       * So now when the connection is made and user service is run, we can see the properties being fetched from private repo of github.
       * but if we now change the properties file values in github. we will see it is not changing in user service, as we are getting cached file. so we need to restart the services
       * But that is not a good practise. so for that we have Actuator library
            * ACTUATOR LIBRARY in Spring boot (Mainly used for checking health of the spring boot project )
                 * Add this library in both config server and user service
                 * And then implement POST/ Request
                      * /actuator/refresh => This will at backend update/refresh the cache without restarting the microservice.
                 * coding part to add actuator
                      * In usersController add @RefreshScope : So this will update the custom properties which are injected through @Value annotation.
       * Now again start all the services.
       * Now in postMan do localhost:2300/actuator/refresh and run it after making changes in the git properties file. You will see the cache will get updated.
       * this 2300 port is from that properties file only, which is used by user service by overridden, so in that only POST will work, as post logic defined in user service.
       * So this is all you have to do to update the caches.
       * But now we also need some batch service to run this POST reqeust which is updating the cache data for users service.
       * So in video sir has shown we can create any random rest call spring project. there add this post batch job, and we can use some spring scheduler, which will run this api
       * after certain interval and keeps our cache data updated
  * So that's all it is.
  * Dev/Stag/Prod profile we can pass as an argument in java command line while calling from the command prompt while running the java jar file.
  * Argument of that stirngp[] args in the main class. that you can pass from command prompt. you know the command.
  * $$ java -Dprofile.active=DEV userservice.jar (for dev environment)
  * $$ java -Dprofile.active=PROD userservice.jar (for prod environment)
* So done with spring config server
* 
* Now next topic
* 
* SPRING BOOT ACTUATOR - we check about this above also
* but it has more advantages (It checks the health monitor of the spring boot applications.)


### CLASS 10
### CLASS 11
### CLASS 12
