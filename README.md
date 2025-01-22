# Maven Automation Testing Framework

## Overview
This is a robust and scalable automation testing framework designed for a simple to-do list web application. The framework leverages modern testing tools and libraries to ensure reliable testing of both the frontend (UI) and backend (API) components of the application.

---

## Features
- **UI Testing**: Automates user interactions with the web application's interface.
- **API Testing**: Covers backend API endpoints for creating and deleting tasks.
- **Cross-Browser Testing**: Supports Chrome, Firefox, Safari, and Edge.
- **Reports**: Generates detailed test reports with Allure Reporting including screenshots.
- **Data-Driven Testing**: Uses Java Faker for generating dynamic test data.
- **Parallel Test Execution**: Optimized test execution using TestNG.

---

## Tools and Technologies Used
- **Selenium WebDriver**: Automates browser interactions.
- **TestNG**: Provides test configuration and execution.
- **REST Assured**: Facilitates API testing.
- **Maven**: Manages project dependencies and build lifecycle.
- **Allure Reporting**: Generates detailed test reports.
- **Java Faker**: Generates random test data.

---

## Prerequisites
- Java Development Kit (JDK) 19 or higher installed.
- Apache Maven installed and configured.
- An IDE like IntelliJ IDEA or Eclipse.
- A web browser (Chrome, Firefox, etc.) for testing.

---

## Setup and Usage Instructions
### Clone the Repository
```
git clone https://github.com/Karim-Sameh/MavenAutomationFramework.git
```

### Navigate to the Project Directory
```
cd MavenAutomationFramework
```

### Install Dependencies
Run the following Maven command to install all required dependencies:
```
mvn clean install
```

### Run Tests
Execute the tests using Maven:
```
mvn clean test
```

### Generate Allure Reports
After running the tests, generate an Allure report with the following command:
```
allure serve allure-results
```

---

## Configuration
The framework uses a **production.properties** file to store configuration details. Update the following file to match your testing environment:
```
src/test/java/com/qacart/todo/config/production.properties
```
Key properties:
```
baseURL=https://todo.qacart.com
email=your_email@example.com
password=your_password
```

---

## Sample Test Scenarios
1. **User Authentication**: Verify login functionality with valid credentials.
2. **Task Creation**: Ensure a new task can be successfully added.
3. **Task Deletion**: Confirm a task can be deleted and the UI reflects the change.

---

## Project Structure
The project follows a modular structure to ensure maintainability and scalability:
```

src/
├── main/
├── test/
│   └── java/
|       ├── com.qacart.todo.api         # API utilities and test logic
│       ├── com.qacart.todo.base        # Base classes for tests and pages
│       ├── com.qacart.todo.config      # Configuration and endpoints
│       ├── com.qacart.todo.factory     # WebDriver factory
│       ├── com.qacart.todo.objects     # Data model classes (e.g., User, Todo)
│       ├── com.qacart.todo.pages       # Page Object Model classes
│       ├── com.qacart.todo.testcases   # Test cases for Login and Todo functionalities
│       └── com.qacart.todo.utils       # Utility classes (e.g., cookies, properties)
allure-results/                         # Allure test results
```
