
# Merchant Purchase Data System Using Spring Boot

This service helps merchants to maintain their purchases data. It exposes a REST API to receive requests from merchants, uses a Kafka consumer to handle the requests and save the data to a PostgreSQL DB. The system afterwards publishes an applicative event to another Kafka topic.

![image](https://github.com/tehilabk/orderService/blob/master/projectDiagram.PNG)



## Installation

1. Clone the repository:

```
git clone <repository-url>
```

2. Open Windows cmd in the project directory


3. Run the application using the script:

```
start-order-service.bat
```

4. The Server is ready for requests now :)

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

## Prerequisites

To run the system, you need to have the following tools installed:

- Docker
- Java
- Maven


