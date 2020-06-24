# AutoOpentracing

The project deals with  instrumentation of spring boot application.

This project reliases of AUTO Instrumentation of application.

The projects is consisted of 3 Microservices

1.Demo Application 
2.Subscription Application 
3.Special Services Application

We have added dependancy of opentracing and jaeger client in pom.xml for instrumentation

The application microservices is set to run on port 8090,8091,8092 respectively.

If you do not have maven install you can use ./mvnw executable script.

to run application, you can run on seperate terminals:

./mvnw spring-boot:run -Dmain.class=opentracinng.DemoApplication 
./mvnw spring-boot:run -Dmain.class=opentracinng.subscription.SubscriptionApp 
./mvnw spring-boot:run -Dmain.class=opentracinng.specialservice.SpecialSubApp

In Application.properties I have explicitly set service name for tracing and other properties.


(Knowledge Base) 
No code changes required but packaging changes required
Packaging with dependency
io.opentracing.contrib:opentracing-spring-jaeger-web-starter:2.0.3
Final adds the required beans to initialize the tracer so that traces can be sent.
With this all REST requests produce spans.
