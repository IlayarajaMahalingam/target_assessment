# target_assessment
# message_notification_system

Problem Statement 
Most applications have the need to implement notifications for a variety of use cases and scenarios. Create a centralized generic service for notification that can be used by a variety consuming application for their notification needs e.g. an incident workflow system may use this system when each incident ticket moves from one state to another, similarly a order management system may use this service to notify the customer of the status of the order whenever it changes 
 
The system should allow for the following capabilities: 
 
1.	Accept messages including from, to and subject 
2.	Ability to notify on multiple channels (e.g email, slack, you can stub out/mock if required) 
3.	Deliver messages in correct order for each consumer of this  
 
Deliverables 
1.	The code for the service in github with instructions on how to set it up and run it 
-----------------------------------------------------------------------------------------------------------------------------------------

Solution:

Created an SpringBoot JAVA Application with REST APIs for the implementation. 
Note: Instead of going with APIs we can implement the same functionality asynchronously with Message brokers.

Steps to run and test the application:
1. Build the project with Maven(mvn clean package)
2. Run the executable jar built in the '\target' folder with java like "java -jar MessageNotificationSystem-0.0.1.jar"
3. Application will run on the embedded Tomcat server and exposed on port '8080'
4. The exposed API could be reached with 'http://localhost:8080/notify' url
5. And since this API is of POST oeration, you need to add the following json payload in the request body of 'raw' type
      {
        "mailSender" : "***@***.com",
        "mailReceiver" : "***@***.com",
        "mailSubject" : "subject",
        "slackWebhookUrl" : "url",
        "message" : "message"
      }
6. I have added only 2 clients for sending email message and to Slack platform but the project can be expanded to serve multiple clients/customers
7. Once the message has been sent, you will get a 200 OK response with 'Notified the users successfully' reponse text.

Note: The exact line of code to call the email host and slack host has been commented out to avoid connectivity issues.
