# microservice_poc_spring_boot_cloud
Micro Service POC Spring Boot cloud

## Instructions
    
### Pre-Requisites
    JDK 1.8
    Maven 3.1.x
    Redis Server (No authentication)

### Step 1: Clone the git repository or download as zip 
### Step 2: Unzip in a convenient location

Switch to folder ./codebase/globomart-retail-parent
 
```sh
mvn clean package install -DskipTests=true
```

This will build the entire application without running the test cases and builds the common api for further usage.

### Step 3: Boot Config Server

Switch to folder ./codebase/globomart-retail-parent/globomart-config-server
Execute: 
```sh
mvn spring-boot:run
```
Ensure the service starts successfully. You can do that by checking the following links in your browser.
```sh
http://localhost:9000/application/master
http://localhost:9000/globomart-eureka-service/master
http://localhost:9000/globomart-hystrix-dashboard/master
http://localhost:9000/globomart-product-catalog-service/master
http://localhost:9000/globomart-product-price-service/master
```

### Step 4: Boot Eureka Server

Switch to folder ./codebase/globomart-retail-parent/globomart-eureka-server and execute: 
```sh
mvn spring-boot:run
```

Ensure the service starts successfully by checking the following URL:
```sh
http://localhost:8761/
```

### Step 5: Boot Hystrix Dashboard

Switch to folder ./codebase/globomart-retail-parent/globomart-hystrix-dashboard and execute: 

```sh
mvn spring-boot:run
```
Ensure the service starts successfully
```sh
http://localhost:9002/hystrix.html
```

### Step 6: Boot Catalog Service

Switch to folder ./codebase/globomart-retail-parent/globomart-product-catalog-service and execute: 
```sh
mvn spring-boot:run
```

Ensure the service starts successfully by checking the following link:
```sh
http://localhost:9003/products
```
#### Testing
Use any REST client to do full CRUD operation. An example is listed below:
```sh
Request Type: POST
URL: http://localhost:9003/products
Headers: Accept: application/json; Content-Type: application/json 
Payload: 
{  
   "productName":"iPhone Clone",
   "productDescription":"iPhone Clone Description",
   "productType":"iPhone Clone type",
   "stockInHand":"10"
}
```
### Step 7: Boot Price Service
Switch to folder ./codebase/globomart-retail-parent/globomart-product-price-service and execute: 
```sh
mvn spring-boot:run
```

Ensure the service starts successfully by checking the following URLs
```sh
http://localhost:9004/products/names
http://localhost:9004/products/find_price_by_product_id?productId=1
http://localhost:9004/products/find_price_by_product_id?productId=2
http://localhost:9004/products/find_price_by_product_id?productId=3
```
## Binaries
If you want to download the binaries directly and make it work then use the following link to download the different jar files which are built as part of the package goal.
```sh
https://www.dropbox.com/sh/zqmhyul759gjyim/AACeMhtsKYDmVlii6lU1jSfra?dl=0
```

