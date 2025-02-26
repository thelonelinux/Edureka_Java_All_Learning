# This is continuation of EdurekaMicroservicesTrainingCourse.md

## 6.Microservices Security (Continued...)
### Starting from Lecture 6 Continued.
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

* ---- END OF class 7 (Need to write notes though, will do later)-----

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
### CLASS 9 (Config Server Program (single repo for application.settings file, Spring boot Actuator: Health monitor, Zipkin - API tracing and debugging, Spring Security - Basic Auth (Authentication and Authorization)
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
* SPRING BOOT ACTUATOR - we check about this above also (For more detail check in video only)
* but it has more advantages (It checks the health monitor of the spring boot applications.)
* In orderserviceloadbalancer add micrometer dependency and then add management endpoints in settings file
* Now run this orderserviceloadbalancer and regsitry service, localhost:6200/actuator/prometheus.
* You will see all the details of the system.
* Later you will see in docker using grafana how we can make this in graph representation.

* Now Next topic

* API TRACING with Zipkin and Spring Cloud Sleuth
       * So this is used for debugging purpose in our microservices. This will trace the reqeust-response in our microservices
       * So all we have to do is in all micriservices add spring cloud sleuth and zipkin dependencies (See in code of orderserviceloadbalanceer and in order service pom.xml file)
       * And we have to download Zipkin server separately and run this zipkin server from command prompt. Check the port in which this zipkin server is running.
       * Now run the orderserviceloadbalancer and orderservice. Send request response to this service.
       * Now open the zipkin server with it's port. there you can see whatever request response has been send in orderservice and orderserviceload balancer, the details are present there.
       * So this is how it is doing tracing of our microservice request-response
       * No code changes here, Just add the required dependencies in the microservice you want to trace, and that service will send it's log to separate Zipkin server.
       * Zipkin is open source, we have other tools like jaeggaer, datadog etc to do API tracing
  * So this is all it
    
* Now we will be doing next topic

* SPRING SECURITY (Basic auth, OAuth, JWT)
  * We will first check with code and notes (More detail you can re-check code and lecture video)
  * In Lay Man words
       * We did BASIC AUTH Spring Security, Sir has already made the codes ready, dependencies were added.
       * We will be doing authentication (User log in with user name and password) and authorization (what kind of access that user should have)
       * So we will have two tables (Userauthentication and UserAuthorization) in our securityDatabase in mysql which will contain user details and password.
       * authorization based on the roles.
       * So this password should be in hashcode form using MD5 (Message Digest). Password should not be stored in plain text. MD5 form can't be reversed like encrypted code.
       * So password are stored as irreversable hash code rather than in plain text or encrypted form. so when the user enter the user name and password, password is first encoded via MD5
       * and then compared with the MD5 present in the table, and then it will login if both hash are same. so this is how it works. Password is encrypted using BCrypt.
       * To use as plain password in db table we will use {noop} see videos to understand more.
       * encoder code how it works you can see in java class PasswordEncoder.java, And you can pick that and put in table as hash rather than plain.
       * So one we add all the details, we will run/add some code in SecurityConfig.java class. that will take care of both authenticatin and also have authorization check there and filteration
       * .httpBasic() : This code in that code will help us to open small window to login user and password when we try to open or send request to that service.
       * DaoAuthenticationProvider this and other beans used in SecurityConfig.java are pre-build class by java spring boot security dependencies.
       * use csrf also explained, check it in video only.
* So this is all it

* Next class we will be doing OAuth Authentication and JWT Security

* --END OF CLASS 9 ---------

### CLASS 10 (Sir was out due to personal reasons - check from class 11, nothing taught here)
* This is 1 Hour class, unlike the previous ones where we used to have 3 hours classes in all of them.
* There is no class, Sir was absent due to personal reasons
* Just some QnA happened, that too for 15 minutes. not to learn anything in this class for now.


### CLASS 11 (Spring Security - for Authentication login, Docker - to deploy our microservice in containers)
* SPRING SECURITY using OAUTH
  * OAuth is Open Authentication, which means like you can login by using google login, or facebook or github login, In that case the client (that website) will have access to your google mails
  * So this is Open Authentication. Here client ID and client secret are generated to be used by third party website from google to validate login and generate OAuth token.
  * There are different flows in OAuth, We will focusing mainly on CLIENT CREDENTIALS FLOW for Microservices. (To see other flows please see video class only)
    * CLIENT CREDENTIALS FLOW for Microservices : This is for service to service authentication.
         * Similar flow for this also, check in video only, how it flows, token etc.
         * In lay man word flow will be like this :
              * Let's say microservice client will call OAuth Server  (Google, github login) by giving client id and client secret to it.
              * Now OAuth server will give back Oauth token to client microservice
              * Now client microservice will send this token to resource server (which client is trying to access it's APIs etc)
              * Now resource server will send this Oauth token given by client microservice and validate with OAuth server, so here introspection is done by resource server for oauth token
              * Once the validation is successful, Client Microservice will be able to access the Resource servers api's etc.
              * If token not valid then token not valid message to send and Client Microservice will be unable to access resource apis.
              * so this is CLIENT CREDENTIALS FLOW in microservice.
          * So now we will do code project design to implement this
          * CODE PART:
            * We will have our own Spring Server Authorization microservice instead of google,github which will access to oauth_client_details table
            * We will have Client Microservice User which will try to authenticate like the same above flow, It will send POST oauth/token with parameter user id and user secret as request data.
            * Once the validation is done we will able to access API gateway, API gateway is that same project which will have orderserviceloadbalancer, product service, which we have developed.
            * OAuth token is also of two types
                 * Opaque token (Simple token like normal password)
                 * JWT token (Heavy token where we store the client side state information) (This contains header,body and signature)
             
                   
* Project program with OAuth jwt token
  * Sir has already created the project, also see in this repo to understand more about the code.
  * check in code SecurityConfig.java, there you will also find comment sir has written in the code to understand.
  * Security filter chain is also used here. You will also fine table sql script for datasource to that oauth_client_details.
  * Client Microservice is like calling Post from Postman with details to run the project. You can see in video lecture only.
  * You will get the JWT token as postman response which you can check in jwt.io website to see parts of this JWT token.
  * Now using this token call apis like localhost://orders/ in postman we have authorization optiion, add first Bearer and then space and then token and run, you will get response.
  * springcloudgatewayjwt : this project also extact and check code there in this repo, it is present there
  * So this is the whole flow and code
 
    
* So security part is also completed.
* Now we will be starting with dockers.

* DOCKERS
  * IN LAYMAN WORDS (More detail see lecture video)
  * Docker is an Application based Container that contains a jar file, a docker file, and required libraries like jdk to run that single application in the host machine.
  * We can have multiple container in a machine
  * Docker engine take cares for all this container by some commands.
  * Container is not VM, VM has it's own OS, Container Don't    

* In next class we will run our microservice in docker containers.
* 
* -- END of CLASS 11 --




### CLASS 12 (Docker - For Container in AWS, Swagger - For checking all the apis present in microservice, Prometheus, Grafane - to Visualize Metric like CPU, ram usage)
* DOCKER
  * IN LAYMAN WORDS (For detail - please check in video only)
  * Sir used AWS EC2 Instance of Ubuntu as a host machine
  * Installed Docker in this EC2 Ubuntu Instance
  * Copied jar file of our RegistryServie, LoadBalancerOrderService, and LoadBalancer microservice from his local windows machine to EC2 Ubuntu Machine using SFTP file transfer software
  * Check video lecture on how to do jar file transfer.
  * After creating the Docker File for each application jar file and run this appication microservice in separate container
  * Used the public IP to request the service and it was working fine, all the microservices were working fine in the container.
 
* SWAGGER
  * IN LAYMAN WORDS (For detail - please check in video only)
  * Sir just added the openAPI dependencies in the orderserviceloadbalancer to add swagger in our microservice
  * This is only used to check what all api's call are preesnt in our microservice,
  * You can check by opening this url in the browser => localhost://6200/swagger-ui/index.html
  * A UI will open up, there you will see all the list of get, post thing you are doing in that current microservice in orderserviceloadbalancer.
 
* PROMETHEUS
  * IN LAYMAN WORDS (For detail - please check in video only)
  * Visualizing Spring Boot Metrics from Prometheus Dashboard in Graph or better manner.
  * This is that metric displaying dashboard which we learn previously in Actuator in previous classes
  * This will give you the stats of your machine, RAM, CPU in better format
  * So here we will run Prometheus image in separate docker Container in AWS EC2 Instance only and then run the docker container where our microservices are there.
  * In it's docker file we will set port of orderserviceloadbalancer, so it will pull the metric of this orderserviceloadbalancer after every 5 minutes, specified in it's docker file.
  * It has time series DB where metric details after every certain interval is stored.
  * And now open this apis. You will see prometheus Dashboard.
  * GRAFANA
    * Grafana is better way to show all the metrics,
    * So run this Grafana also in the Docker Container in some port . we will do this in AWS EC2 instance only.
    * Here we will add prometheus api and visualize the metrics in graph format.
   
* SPRING AOP 
  * (See video and code for more understanding)
  * IN LAYMAN WORDS
  * AOP (Aspect Oriented Programming) is like we have trigger in sql.
  * So it will help us to perform different types of action  when certain type of action is performed or defined in the aspect code.
  * Example we want to print something when any Method with method name "ADd" is called.
  * Example if we call "AddEmployee" method then before calling this method we want to print something, so this is how aspect oriented programming will help us.
  * There can be other types of aspect, like logging etc.
  * You can see more details later
 
* PROJECT DISCUSSION
  * At the end sir discuss about the project, and it is done.
  * The training is over.


* ------ END OF CLASS 12 ------
* ------ END OF TRAINING CUM CERTIFICATION ------









