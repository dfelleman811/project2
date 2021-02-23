# Escape Room Retail Application

#### Developers:  
Dan Felleman  
Louella Estillero  
Ben Simon  

The Escape Room Retail Application is a web application designed to provide a fictional escape room product supplier, named Excape, with an online storefront for customers to purchase items in the store's inventory. This system also provides employees of Excape with information regarding business metrics and sales.  

## Project Description  
Excape's web application is an online retail store that sells Puzzles, Locks, and more items
to Room Escape builders across the United States. Users can access the home page,
which displays featured products, and categorizes products by their type. 
An employee user has the added capability of an Employee Portal, where they can 
add new products to the inventory as well as view aggregated details pertaining to sales.

## Features  
- Employee user can add product inventory  
- Customer user can navigate shop page, view item details, and add items to cart for purchase  
- Employee user has access to an Dashboard/Portal to view basic business reports  

## Testing  
- 70.8% code coverage using Spring Boot Test  
- UI Testing with Cucumber and Selenium  

## Further Development  
In future development, we would like to encorporate the below functionalities:  
  - Customer user can leave reviews  
  - Customer user can access their order history  
  - Employee user can view specific order history based on customer  
  - Employee user receives automatic updates when inventory is low on any item  
  - Employee user can view transaction history on specific inventory items  


## Technologies Used
- Java
- JavaScript
- HTML5
- CSS
- Bootstrap 5
- Spring Boot
- Spring Data
- Spring MVC
- Spring Test
- Mockito
- JUnit 5
- Selenium
- Cucumber
- PostgreSQL 
- Amazon RDS
- DBeaver
- Git
- Eclipse
- Maven
- Visual Studio Code  

## Spring Modules  
- Spring Boot  
- Spring Data JPA  
- Spring Web MVC


## Required Dependencies  
The below depencies are required in te pom.xml file in order to ensure proper execution of application.
```
<dependencies>
		<!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<version>42.2.18</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>3.8.1</version>
		</dependency>
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-chrome-driver</artifactId>
			<version>3.8.1</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/info.cukes/cucumber-junit -->
		<dependency>
			<groupId>info.cukes</groupId>
			<artifactId>cucumber-junit</artifactId>
			<version>1.2.4</version>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/info.cukes/cucumber-java -->
		<dependency>
			<groupId>info.cukes</groupId>
			<artifactId>cucumber-java</artifactId>
			<version>1.2.4</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
  ```
