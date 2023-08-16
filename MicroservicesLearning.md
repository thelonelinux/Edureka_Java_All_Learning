# MICROSERVICES

## What is Microservices
* In short, the microservice architectural style is an approach to developing a single application as a suite of small services,
* each running in its own process and communicating with lightweight mechanisms, often an HTTP resource API.
* Microservices are a method of developing software applications which are made up of independently deployable, modular services

* This is helpful when there are huge requirements in your package, and requirements keep on changing during project development.
* So in this case monolithic approach fails and hence we have to go through Microservices way of building the project.




## Microservices GK

1. Why use Spring tool suite IDE over Eclipse or IntellijIdea or any other IDE
=> Spring tool suite stores all the dependencies ready when you create a new project
=> You don't have to manually add many files like properties, and dependencies, you can all chose during project creation
and they will add themselves
=> Spring tool suite has a built-in Tomcat server, which you don't have to add separately, it will add itself, whereas in other IDE,
We have to manually add these servers which is a hefty task
=> So overall springboot saves a lot of code setup timing. and Spring tool suite IDE has many functions, dependencies, and servers already 
ready to use.
=> So this is the reason we are using SpringBoot over Spring, and Spring Tool Suite IDE over other IDEs
=> Simply we can say that spring boot is made especially to make our work faster with Rest Service and web service development


2. Design Patterns of Microservices (Needed to build our project as microservices and not as monolithic)
Microservices architecture is an approach to designing and building software applications as a collection of loosely coupled, independently deployable, and scalable services. Each service in a microservices architecture focuses on a specific business capability and communicates with other services through well-defined APIs. Design patterns are recurring solutions to common architectural challenges. Here are some key design patterns used in microservices architecture:

* 1. **Service Decomposition Patterns:**
   - **Single Responsibility Principle (SRP):** Each microservice should have a single, well-defined responsibility. This helps maintain the independence and autonomy of services.
   - **Domain-Driven Design (DDD):** Services are organized around specific business domains, ensuring that each service models a distinct aspect of the business logic.

* 2. **Communication Patterns:**
   - **API Gateway:** Provides a single entry point for clients to interact with various microservices. It handles routing, authentication, load balancing, and other cross-cutting concerns.
   - **Event-Driven Architecture:** Services communicate asynchronously through events, enabling decoupled interactions. Common implementations include publish-subscribe (Pub/Sub) and message queues.

* 3. **Data Management Patterns:**
   - **Database per Service:** Each microservice has its own dedicated database, ensuring service autonomy and data isolation.
   - **Shared Database Pattern:** Some data is shared among multiple services, allowing for simplified data access but potentially introducing coupling.

* 4. **Resilience Patterns:**
   - **Circuit Breaker:** Prevents cascading failures by temporarily blocking requests to a failing service, allowing it time to recover.
   - **Bulkhead:** Isolates failures in one part of the system from affecting others, ensuring that the entire system doesn't go down due to a single service failure.

* 5. **Scalability Patterns:**
   - **Autoscaling:** Services automatically adjust their resources (e.g., containers, instances) based on demand.
   - **Shared Nothing:** Services are designed to operate independently, with no shared state, enabling easy horizontal scaling.

* 6. **Deployment Patterns:**
   - **Blue-Green Deployment:** Involves having two identical environments ("blue" and "green") and switching traffic between them to minimize downtime during releases.
   - **Canary Deployment:** Gradually rolls out new features or updates to a subset of users, allowing for testing and validation before a full release.

* 7. **Observability Patterns:**
   - **Centralized Logging:** Aggregates and centralizes logs from different services to enable easier troubleshooting and analysis.
   - **Distributed Tracing:** Monitors and traces requests as they flow through various microservices, providing insights into performance bottlenecks.

* 8. **Security Patterns:**
   - **Token-Based Authentication:** Uses tokens (e.g., JWT) for secure authentication and authorization between services.
   - **OAuth2:** Enables secure delegation of access rights across services and APIs.

* 9. **UI Patterns:**
   - **Server-Side Rendering (SSR) vs. Client-Side Rendering (CSR):** Choosing between rendering UI on the server or the client based on performance and user experience requirements.

These are just a few examples of design patterns in microservices architecture. The specific patterns chosen for a project depend on the application's requirements, the team's preferences, and the desired balance between flexibility, maintainability, scalability, and other factors.
