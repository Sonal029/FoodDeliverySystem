# Food Delivery System

![image](https://i.ibb.co/yfQTbdK/Screenshot-81.png" )

This is a simple Spring Boot application that emulates a food delivery system similar to Swiggy. The application allows users to manage Restaurants, Customers, Orders, and Delivery Partners. It does not require a database and stores all data in memory during runtime.

## Features

1. **Add new Restaurants, Customers, and Delivery Partners:** The application allows administrators to add new Restaurants, Customers, and Delivery Partners to the system.

2. **Place an order from a Customer to a Restaurant:** Customers can place food orders from available Restaurants through the application.

3. **Assign a Delivery Partner to an Order:** Once an order is placed, a Delivery Partner can be assigned to the order for delivery.

4. **Update the order status:** The order status can be updated to reflect its progress, such as cooking, on the way, or delivered.

5. **Fetch a Customer's order history:** Customers can view their order history, including the status and details of previous orders.

## Prerequisites

Before running the application, ensure you have the following installed on your system:

- Java Development Kit (JDK) 8 or later
- Maven (for building and running the application)

## How to Run the Application

Follow these steps to run the application:

1. Clone the repository to your local machine.

2. Open a terminal or command prompt and navigate to the project's root directory.

3. Build the application using Maven:

```bash
mvn clean install
```

4. Run the application using Maven:

```bash
mvn spring-boot:run
```

The application should now be up and running locally.

## Usage

Once the application is running, you can interact with it through API calls using tools like cURL, Postman, or any web browser. The API endpoints and their functionalities are described below:

### API Endpoints

1. **Add new Restaurants, Customers, and Delivery Partners:**

   - Endpoint: `POST /restaurants`
   - Endpoint: `POST /customers`
   - Endpoint: `POST /delivery-partners`

   Example request body for adding a new restaurant:
   ```json
   {
       "name": "Restaurant Name",
       "address": "Restaurant Address"
   }
   ```

2. **Place an order from a Customer to a Restaurant:**

   - Endpoint: `POST /orders`

   Example request body for placing an order:
   ```json
   {
       "customerId": "customer_id_here",
       "restaurantId": "restaurant_id_here",
       "items": [
           {
               "itemId": "item_id_1",
               "quantity": 2
           },
           {
               "itemId": "item_id_2",
               "quantity": 1
           }
       ]
   }
   ```

3. **Assign a Delivery Partner to an Order:**

   - Endpoint: `PUT /orders/{orderId}/assign`

   Example request body for assigning a delivery partner to an order:
   ```json
   {
       "deliveryPartnerId": "delivery_partner_id_here"
   }
   ```

4. **Update the order status:**

   - Endpoint: `PUT /orders/{orderId}/status`

   Example request body for updating the order status:
   ```json
   {
       "status": "on_the_way"
   }
   ```

5. **Fetch a Customer's order history:**

   - Endpoint: `GET /customers/{customerId}/orders`

   This endpoint will return a list of all orders placed by the specified customer.

## Shakamabhari ("https://github.com/Sonal029")
