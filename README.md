# Automated Database Testing

This repository contains automated tests using Selenium and TestNG frameworks in Java for performing database testing on MySQL. The tests ensure data integrity and validate database operations (CRUD) through automated scripts. All the test cases were conducted in Visual Studio Code.

## Technologies Used

- **Java**: Programming language used for writing the tests.
- **Selenium**: Framework for automating web applications for testing purposes and for browser automation.
- **TestNG**: Testing framework inspired by JUnit and NUnit, designed for test configuration and management.
- **MySQL**: Relational database management system used for storing and managing test data.

## Test Cases

- ***Create* Data Tests**: Verifies the correct insertion of new records into MySQL tables.
- ***Read* Data Tests**: Ensures the accuracy and integrity of data retrieved from the database.
- ***Update* Data Tests**: Tests the ability to modify existing records in MySQL tables.
- ***Delete* Data Tests**: Validates the proper deletion of records from MySQL tables.

The test cases can be found in the file [TestCases.java](src/test/java/TestCases.java).

**Note**: [Magento](https://magento.softwaretestingboard.com/) is only used for testing the retrieved data from the database.
