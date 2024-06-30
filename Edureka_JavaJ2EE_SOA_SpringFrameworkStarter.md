# Edureka Course Learning : Java, J2E, SOA, Weblets, Servlets, JDBC, Spring Framework
* This is regarding what is included in the course we learned in this.


### Course Contents
#### 1. Introduction to Java
* In this module, you will learn about Java, Java architecture, advantages of Java, develop the code with various data types, conditions and loops with examples and Programs.
*
#### 2.Data Handling and Functions
* In this module, you will learn how to code with arrays, functions and strings using examples and Programs.
*

#### 3.Object Oriented Programming in Java
* In this module, you will learn object oriented programming through Java using Classes, Objects and various Java concepts like Abstract, Final etc with examples and programs.

#### 4.Packages and Multi Threading
* In this module, you will learn about packages in Java and scope specifiers of Java. You will also learn exception handling and how multi-threading works in Java.

#### 5.Collections
* In this module, you will learn how to write code with Wrapper Classes, Inner Classes and Applet Programs. How to use io, lang and util packages of Java and Collections.

#### 6.XML
* In this module, you will learn how to write XML files and how to parse XML files using DOM and SAX in Java.

#### 7.JDBC
* In this module, you will learn SQL, Architecture of JDBC, Different drivers of JDBC and to write code in JDBC to communicate with Database.

#### 8.Servlets
* In this module, you will learn Web Technologies and developing applications using Servlets.

#### 9.JSP
* In this module, you will learn how to develop code with JSP.


#### 10.Hibernate
* In this module, you will learn about hibernate framework and how to interact with the database using hibernate. You will learn to perform various operations on database like Insert, Update, Delete and Select Operations.


#### 11.Spring (Started with Spring Framework, IOC Container and Dependency Injection Explained)
* Class 11 Recording, After 1:30 Hours, the spring topic is started
* So Why Spring Framework
  * We want a loosely coupled project app (Very Very important, that's why we have DI and IOC concept in spring)
  * We want scalable
  * We can develop stand-alone, distributed, web-app applications. We can generate all types of applications.
  * A framework is based on top of existing technology. So we don't have to do more coding. Spring framework is a framework of frameworks.
  * Spring can replace EJB (Enterprise Java Beans, J2EE way of building application)
  * Spring enables us to build application based on POJO (Plain old java object)
  * Spring simiplifies java development
  * java Frameworks : Hibernate, Struts, Log4j etc.
  * Spring Framework is developed in modular fashion : Spring Core, spring context, Spring DAO, Spring Web, Spring AOP, etc.
  * spring Framework provides 20+ Module :
    * Spring Core Module
    * Spring Data Access Module
    * Spring AOP Module
    * Spring Web Module
    * Spring Test Module
    * Spring Cloud Module, etc
      
* Very Very Important :
  * POJO : If a java class is not coupled with any technology or framework is called as a Plain Old Java Object (POJO).
      * class MyClass implements javax.servlet.Servlet   => Not a POJO class (as it is coupled with javax.servlet.Servlet as my class will be implementing the methods of Servlet class))
      * class MyClass extends MyOtherClass               => Not a POJO class (as it is copule with MyOtherClass, so if something changes in other class, here also it will be affected) 
      * class MyClass extends Serializable               => a POJO Class (As Serializable does not have any of it's method declared so it's POJO class)
      * class MyClass                                    => a POJO class (Not dependent on any class)
  
* Understanding Tight Coupling
  * Let's say we have class A and Class B.
  * Now we want to call some method of Class B in class A.
  * So we need to first create an instance of Class B in Class A.
  * So this is called collaboration and hence this will result in tight coupling.
 
* IOC Container :
  * In Layman words (For more detail see the video only, and code will add)
  * Very Imp Definition :
    * Spring IoC (Inversion of Control) Container is the core of Spring Framework.
    * It creates the objects, configures and assembles their dependencies, manages their entire life cycle.
    * The Container uses Dependency Injection (DI) to manage the components that make up the application.
  * We need to spring-context dependency in our pom.xml file which in return will add 5 min must required dependency to make it spring project. See in video that 5 automatically gets added.
  * IOC Container is the xml file where we create Beans for a class. Beans is the object of that class. And then we will call those beans in our main method
  * Example for a class User we will have xml file as user-beans.xml and here we will create beans. And using context we will call this in our main method.
  * This user-beans.xml can have multiple beans (object) of User class created there. There are different ways to create beans there like using constuctors we can assign value
  * or by set get method we can assign value to that object bean
  * This user-beans.xml is a container
  * We can have init attribute and scope attribute to run some methods before creating this beans, we can have lazy attribute in beans to not to create object unless it is called.
  * So this is all about IOC Container of User Container. This container will only take care of creating object. We don't have to create object to avoid tight coupling.
 
* Dependency Injection :
  * In Lay man word (For more detail see in video and codes)
  * Very Imp Definition : Dependency Injection is a pattern/design pattern for creating the objects that depend on other objects not knowing at compile time.
  * This is mainly used to bringing loose coupling.
  * There are two types of Dependency Injection
      * Setter Method
      * Constructor Method
  * Here also add spring-context dependency in our pom.xml file
  * Today we will see Setter Method of Dependency Injection
  * So Create a Customer Class, Car class. Inside Customer Class we will have Private Car class object.
  * Now Create customer-car-beans.xml bean container xml file. There create Customer bean/object and then also create Car object, In Customer object add reference of car bean/object.
  * In this way we added car object in our customer object using beans only. This way it will be loosely coupled. Later if we want to add other car object then we can do that
  * without much changes in the Car class. so this way we achieve Dependency injection,
  * Here we just injected via setter method of dependency injection. In next class we will see how to inject via constructor method.

* Next class we will see how to implement dependency injection using Constructor method.
* ------ END of Class 11 -------



#### 12.Spring, Ajax, and Design Patterns
* According to course : In this module, you will learn advanced concepts of Spring Framework like AOP, Transaction Management Operations Commit and Rollback operations on database. Interacting * with server using Ajax framework and J2EE design patterns.
* 
* Self Video Seeing and notes
* Dependency Injection :
  * Using constructor method
    * Here in code while creating customer bean/object, use constructor parameter args to pass the customer name and ref also using constructor only for the car object.
    * Hence this is Dependency Injection using constructor method.
    * Rest you can see the code. and video. Nothing more in it.
   
      
* AutoWiring : (Spring Dependency Injection using Autowiring)
  * This is just third way of Dependency Injection
  * Here you make car bean and customer bean in the customer-car-beans.xml file. But in customer bean don't pass car attribute and value. Don't add car bean reference in customer bean.
  * Instead we will use @Autowired annotation just above the private Car car data member inside the Customer class.
  * So this will search for car bean in IOC Configuration Container, and automatically assign car bean to customer bean if there is any bean of car present in Container.
  * So this is how Autowiring dependency injection works.
  * To support Annotation, You have to make your beans in context-annotation-config tag. see the code you will understand.
  * Check in code for more understanding.
  * But what happens if we have two beans of car, then how would container decide to which to chose, so at that time it will give errors.
  * so in this case you use primary=true in attribute of bean, then that will be called if multiple beans of car then.
  * There is other way in which you can give preference, by using @Qualifier("audi"), so in this case Audi car object will be given preferences. Add this annotation just below @Autowired.
  * In Real Projects, We mustly depend on @Autowired.

* Spring DI - Collection :
  * Until now we were setting single value object, but now we can set a list of values to a property in XML through collection


* ----END of Class 12 ------
  





#### 13. SOA
* In this module, you will learn SOA and SOA Architecture. You will also learn how SOA is useful between organizations to perform the required task easily and how it can be implemented in web services.

#### 14. Web Services and Project
* In this module, you will learn SOA and implementation of web services. We will also discuss how to develop a project using Spring and Hibernate. This is a banking project with web services.

#### Final Project
* 


## After this we find that Spring is only like setting up whole project template ourselves, however, springBoot will give us direct templates as per our requirement

### So now starts with SpringBoot, for that you can check SpringBoot Microservices Edureka Course Learning












