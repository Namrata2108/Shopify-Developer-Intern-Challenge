# Shopify-Developer-Intern-Challenge
Building an inventory tracking web application for a logistics company.


# Inventory Management System (IMS)

Inventory management system is a simple web application that demostartes the CRUD operations using Spring Boot, Hibernate and MySQL.

## Requirements

1. Java
2. Maven
3. MySQL
4. Hibernate
5. Spring Boot

## Getting Started

1. Clone the application from the below github repository

https://github.com/Namrata2108/Shopify-Developer-Intern-Challenge


2. Create Mysql database

CREATE DATABASE shopifydb;


Select the database,

USE shopifydb;


3. Change mysql username and password as per your installation

+ open `src/main/java/hibernate.cfg.xml`
+ change `db.username` and `db.password` as per your mysql installation

4. Build and run the app using springboot app

bash
mvn package


The app will start running at <http://localhost:8080/welcome>.

## Find the screenshots of the application below:

![AddProduct](https://github.com/Namrata2108/Shopify-Developer-Intern-Challenge/blob/main/images/AddProduct.png)
![ProductData](https://github.com/Namrata2108/Shopify-Developer-Intern-Challenge/blob/main/images/Product_Data.png)
![UpdateProduct](https://github.com/Namrata2108/Shopify-Developer-Intern-Challenge/blob/main/images/UpdateProduct.png)
![UpdateWarehouse](https://github.com/Namrata2108/Shopify-Developer-Intern-Challenge/blob/main/images/UpdateWarehouse.png)
![Warehouse Data](https://github.com/Namrata2108/Shopify-Developer-Intern-Challenge/blob/main/images/Warehouse_Data.png)
