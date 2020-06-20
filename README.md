#selenium-cucumber-java

##Selenium-cucumber : Automation Testing Using Java
######BDD- Behavioral Driven Development is based on Test Driven Development (TDD) and it aims to bridge the gap between Business analyst and developers

##prerequisite
######Setup and configure the BDD Test Automation Solution on your local machine:`
```
1. Java SDK                 
2. IntellJ IDEA
3. Maven
4. Cucumber
5. Selenium WebDriver
```

##Writing a new scenario test
######The feature files go in the feature package and shall have an extension ".feature" 
```
You can start out by looking at features/vehicleRegistrationNumber.feature. 
You can extend this feature or make your own features using some of the predefined 
steps that come with selenium-cucumber.
```
Feature file snapshot: ![Alt Text](/D:/first.png)

##Running test
######Go to your package directory called runner and execute the class 'CucumberRunner.java' 
Runner class snapshot: ![Alt Text](/D:/second.png)

##Documentation
######Hooks class 
```
TestInitialize class - is most important class as it performs the following functions:
1. Initialize all java libraries and closing of the browser
2. Ensures feature files trigger test results posted to test rail 
```
Runner class snapshot: ![Alt Text](/D:/third.png)

######Cucumber Reports 
```
Cucumber has a built in report generation whereby Feature files tested are automatically written 
to cucumbers own reporting system
```
Reporting: ![Alt Text](/D:\fourth.png)

######Object properties 
properties file snapshot: ![Alt Text](/D:/five.png)

