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
- **Selenium WebDriver**:
- **TestNG**:
- **REST Assured**:
- **Maven**:
- **Allure Reporting**:
- **Java Faker**:

---

## Prerequisites
- Java Development Kit (JDK) 19 or higher installed.
- Maven installed and configured.
- An IDE like IntelliJ IDEA or Eclipse.
- A web browser (Chrome, Firefox, etc.) for testing.

---

## Setup Instructions
### 1. Clone the Repository
```
git clone https://github.com/Karim-Sameh/MavenAutomationFramework.git
```

### 2. Navigate to the Project Directory
```
cd MavenAutomationFramework
```

### 3. Install Dependencies
Ensure all required dependencies are installed by running:
```
mvn clean install
```

---

## Usage
### Run Tests
You can execute tests using Maven:
```
mvn clean test
```
### Generate Allure Reports
After running tests, generate an Allure report:
```
allure serve allure-results
```

---

## Key Dependencies
The project relies on the following key libraries and tools:

- **Selenium WebDriver**: For browser automation.
- **TestNG**: For managing test execution.
- **REST Assured**: For testing API endpoints.
- **Allure**: For detailed and visually appealing test reports.
- **Java Faker**: For generating fake test data.
- **WebDriverManager**: For automatically managing browser drivers.

---

## Configuration
Update the configuration in "**src/test/java/com/qacart/todo/config/production.properties**":
```
baseURL=https://todo.qacart.com
email=your_email@example.com
password=your_password
```

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
