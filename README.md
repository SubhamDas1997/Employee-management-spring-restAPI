<h1 align="center">Employee Management API</h1>

### 🔴 [Project Demo](https://youtu.be/JptAYx8fm8U)

# Features
A backend application with APIs for employee management in any generic business:
  - Basic user authentication check for all API calls
  - Specific calls such as DELETE, POST etc requires user to have authority by means of appropriate roles
  - View, create and delete roles using appropriate fetch methods
  - View, update, create and delete user details using appropriate fetch methods
  - View, update, create, delete and sort employee details using appropriate fetch methods
  - Adequate server response messages for all requests

# APIs
List of all the API calls for specific use cases:
  - ROLES
      - Fetch all roles using `/employee-management/roles` as a **GET** request
      - View a particular role using `/employee-management/roles/${id}` as a **GET** request
      - Create a new role using `/employee-management/roles` as a **POST** request
      - Delete an existing role using `/employee-management/roles/${id}` as a **DELETE** request

  - USERS
      - Fetch all users using `/employee-management/users` as a **GET** request
      - View a particular user using `/employee-management/users/${id}` as a **GET** request
      - Create a new user using `/employee-management/users` as a **POST** request
      - Update a user using `/employee-management/users/${id}` as a **PUT** request
      - Delete an existing user using `/employee-management/users/${id}` as a **DELETE** request
