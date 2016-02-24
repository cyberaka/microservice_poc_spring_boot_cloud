# microservice_poc_spring_boot_cloud
Micro Service POC Spring Boot cloud

Instructions
    Pre-Requisites
        JDK 1.8
        Maven 3.1.x
        Redis Server (No authentication)
    Step 1: Download the zip file
    Step 2: Unzip in a convenient location
        Switch to folder ./codebase/globomart-retail-parent
        Execute:
            mvn clean package install -DskipTests=true
    Step 3: Boot Config Server
        Switch to folder ./codebase/globomart-retail-parent/globomart-config-server
        Execute: 
            mvn spring-boot:run
        Ensure the service starts successfully
            http://localhost:9000/application/master
            http://localhost:9000/globomart-eureka-service/master
            http://localhost:9000/globomart-hystrix-dashboard/master
            http://localhost:9000/globomart-product-catalog-service/master
            http://localhost:9000/globomart-product-price-service/master
    Step 4: Boot Eureka Server
        Switch to folder ./codebase/globomart-retail-parent/globomart-eureka-server
        Execute: 
            mvn spring-boot:run
        Ensure the service starts successfully
            http://localhost:9001/
    Step 5: Boot Hystrix Dashboard
        Switch to folder ./codebase/globomart-retail-parent/globomart-hystrix-dashboard
        Execute: 
            mvn spring-boot:run
        Ensure the service starts successfully
            http://localhost:9002/hystrix.html
    Step 6: Boot Catalog Service
        Switch to folder ./codebase/globomart-retail-parent/globomart-product-catalog-service
        Execute: 
            mvn spring-boot:run
        Ensure the service starts successfully
            http://localhost:9003/products
        Testing
            Use any REST client to do full CRUD operation
            Example
                http://localhost:9003/products
                    POST
                    o
                POST Request
                URL
                    http://localhost:9003/products
                Headers
                    Accept: application/json 
                    Content-Type: application/json 
                Payload
                    {       "productName" : "iPhone Clone",       "productDescription" : "iPhone Clone Description",       "productType" : "iPhone Clone type",       "stockInHand" : "10" }
    Step 7: Boot Price Service
        Switch to folder ./codebase/globomart-retail-parent/globomart-product-price-service
        Execute: 
            mvn spring-boot:run
        Ensure the service starts successfully
            http://localhost:9004/products/names
            http://localhost:9004/products/find_price_by_product_id?productId=1
            http://localhost:9004/products/find_price_by_product_id?productId=2
            http://localhost:9004/products/find_price_by_product_id?productId=3
        Testing
            Use any REST client to do query
