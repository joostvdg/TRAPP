TRAPP = Travel Planning App

The main idea behind the application is trying to find a sure way to build and maintain a backend REST API.

In order to make the development more focused and to add some use to the end result, it does have a business case.

There is also a related TRAPP Client, which is a reference application build with Angular JS.

== Business Case ==
The business case is the development of an application that allows the storage of travel plans.
This should be seen as travel plans in the broadest sense, ranging from "Someday I want to visit Niagara Falls" to 
"August 1st 2013 I will go to Amsterdam to visit the Red Light District".
It should also be possible to update these travels as you go, so it should also be able to store travels you've actually done as well.

There are so many things that can be done with planning travels, so in order to keep it manageble to start learning/developing the primary focus is kept small.
It should, first and foremost, be possible to create travels and trips with a (vague) location and (vague) idea of when and whom.

== Start ==
The application is Java 7 application build with Maven 3. Currently its build with Tomcat 7 in mind as container and a Mysql 5.x or similar as (relational) database.
As the project will progress, more requirements will be added.

Requirements:
- JDK 7
- Maven 3
- Mysql 5.x (or similar)
- Java web container capable of running Spring 3.x (for example, Tomcat 7.x)
- Tool to test REST api's (like SOAP UI, see below)

Confuration
- Database: db=trapp, user=trapp, pass=trapp (configuration=web/main/resources/hibernate.properties)
- Tomcat: mysql connector (in case of mysql)

== Test ==
To test the application you will need a tool that can do REST calls.
Of course, the most basic calls will just require a browser (such as /trapp/user to get all users).
But to test the other calls and keep it maintanable I would advise using a decent tool for this.

My personal preference is SoapUI (http://www.soapui.org/), to get started with testing the rest API see http://www.soapui.org/REST-Testing/getting-started.html.
For your convenience there is already a SoapUI project you can open and use in the trunk.
*NOTE* If you are going to do some tests which do not add to the project, please create your own test project instead of contimating the project's one.
