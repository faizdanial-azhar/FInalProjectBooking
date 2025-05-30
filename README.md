# Facility Booking System

This is a JavaFX application for a facility booking system with student authentication.

## Prerequisites

- Java 17 or later
- Maven 3.6 or later

## How to Run the Project

### Option 1: Using Maven

1. Open a command prompt or terminal
2. Navigate to the project root directory
3. Run the following command:

```
mvn clean javafx:run
```

This will compile the project and launch the StudentAuthGUI application.

### Option 2: Using an IDE (IntelliJ IDEA, Eclipse, etc.)

1. Open the project in your IDE
2. Make sure the project is configured to use Java 17
3. Run the `StudentAuthGUI.java` file located in the `src\main\java\StudentAuthGUI` directory

## Troubleshooting

If you encounter any issues:

1. Make sure you have Java 17 installed. You can check by running `java -version` in your terminal.
2. Make sure you have Maven installed. You can check by running `mvn -version` in your terminal.
3. If you're using an IDE, make sure the project is properly imported as a Maven project.
4. If you get module-related errors, make sure the module-info.java file is properly configured.

## Project Structure

- `StudentAuthGUI`: Contains classes for student authentication
- `FacilityBooking`: Contains classes for facility booking functionality