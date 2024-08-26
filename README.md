# Banking_Application
A Spring Boot-based backend for a simple banking application.  

This project provides a RESTful API for managing bank accounts, including functionalities such as creating an account, deleting an account, depositing money, withdrawing money, and retrieving account information by ID or listing all accounts.


# Features

Create Account: Add new bank accounts with a unique account number.

Delete Account: Remove an existing account from the system.

Deposit Money: Add funds to a specific account.

Withdraw Money: Withdraw funds from a specific account.

Get Account by ID: Retrieve details of a specific account using its unique ID.

Get All Accounts: List all accounts stored in the system.


# Technologies Used

Spring Boot: Framework for building the backend API.

Spring Data JPA: For managing database operations.

H2 Database: In-memory database for development and testing.

Lombok: To reduce boilerplate code with annotations.

Maven: For dependency management and project build.


# API Endpoints

POST /accounts: Create a new account.

DELETE /accounts/{id}: Delete an account by ID.

PUT /accounts/{id}/deposit: Deposit money into an account.

PUT /accounts/{id}/withdraw: Withdraw money from an account.

GET /accounts/{id}: Retrieve account details by ID.

GET /accounts: Retrieve a list of all accounts.


# Contributing

Feel free to fork this repository and contribute by submitting a pull request. For major changes, please open an issue first to discuss what you would like to change.
