
# Merchant Purchase Data System Using Spring Boot

This is a system that enables merchants to feed their purchases data using a REST API and a Kafka consumer. The system saves the orders data into an PostgreSQL database and publishes an applicative event to another Kafka topic.

![image](https://github.com/tehilabk/orderService/blob/master/projectDiagram.PNG)


## Prerequisites

To run the system, you need to have the following tools installed:

- Docker
- Java
- Maven

## Installation

1. Clone the repository:

```
git clone <repository-url>
```

2. Build the application:

```
mvn clean install
```

3. Run the application as a Docker container:

```
docker-compose up
```

## Usage

The system exposes a REST API that accepts order data:

```
POST /{store_id}/orders
```

The endpoint accepts the following data in the request body:

- Order date
- Shopper email
- Shopper's first & last name
- List of line items (purchased products). Each line item has the following:
  - External Product id (the id that was assigned to the product by the merchant)
  - Product name
  - Product Description
  - Product price
  - Quantity

Example body:

```
{
     
        "date": "2032-05-07T14:45",
        "email": "tehilabk123@gmail.com",
        "firstName": "tehila",
        "lastName": "ben kalifa",
        "lineItems":[{
            "productId": 1211,
            "productName": "computer",
            "productDescription": "black computer",
            "productPrice":5000,
            "quantity":1
        }]
    
}
```


