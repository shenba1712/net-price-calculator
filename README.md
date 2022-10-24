# Net Price Calculator
This is a simple Spring Boot application that calculates the net price of a product based on the country code.

The tech stack includes:
* Java 11
* Spring boot 2.7.5
* Gradle

The project comprises:
* RestController with a rest endpoint.
* Service to calculate the net price.
* Enum class to provide tax rate.
* JUnit Tests for controller and service methods.

# Getting Started
Once you have Java and Gradle installed, navigate to the project directory and run ```./gradlew bootRun```

Once the application is up, you can access the app via API platforms like POSTMAN, CURL, Advanced REST Client, 
or even the browser.

* Endpoint: ```http://localhost:8080/net-price```
* It has two required query parameters:
  * grossPrice: a BigDecimal value
  * countryCode: a String value

Eg calls:
* ```http://localhost:8080/net-price?grossPrice=100&countryCode=DE```
This call should return ```81.00``` because Germany's Tax Rate is 19%.

* If the countryCode is null or invalid, this call should return a Bad Request (404) error.
```http://localhost:8080/net-price?grossPrice=100&countryCode=null``` or
```http://localhost:8080/net-price?grossPrice=100&countryCode=random```

* We don't know the tax rate of some countries. So, instead of misleading the user with false information, 
i.e., for example, using 0% as tax rate, the app returns an Unprocessable Entity (422) error.
```http://localhost:8080/net-price?grossPrice=100&countryCode=VU```

This way we can differentiate between invalid requests and valid requests where the application has no data.

# Decision behind the choices made
* To simulate the experience of the user to an extent, the web application has been created. Hence, the rest endpoint.
* Since Enums are typically more efficient, type safe, and readable, the tax rates are provided as Enum.
* Since BigDecimal provide better precision than Double, especially when representing money, BigDecimal is used.
