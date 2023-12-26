# Hotel Management Application

## Overview

The Hotel Management Application is a simple Java application that utilizes JDBC to interact with a MySQL database as its backend. The application allows users to perform various tasks related to room reservations within a hotel.

## Functionalities

### 1. Reserving a Room

- **Description:** Users can reserve a room by providing necessary details.
- **Workflow:**
  1. User selects the "Reserve a Room" option.
  2. Enters customer details (name, contact, etc.).
  3. The application checks for room availability.
  4. If a room is available, the reservation is confirmed and added to the database.

### 2. View Booked Reservations

- **Description:** Users can view a list of booked reservations.
- **Workflow:**
  1. User selects the "View Booked Reservations" option.
  2. The application retrieves and displays a list of booked reservations from the database.

### 3. Update Reservation

- **Description:** Users can update an existing reservation.
- **Workflow:**
  1. User selects the "Update Reservation" option.
  2. Enters the Guest ID to be updated.
  3. Modifies the necessary details (dates, customer information, etc.).
  4. The application updates the reservation in the database.

### 4. Delete Reservation

- **Description:** Users can cancel and delete an existing reservation.
- **Workflow:**
  1. User selects the "Delete Reservation" option.
  2. Enters the Guest ID to be canceled.
  3. The application removes the reservation from the database.

### 5. Room Availability Check

- **Description:** The application checks for room availability before confirming a reservation.
- **Workflow:**
  1. During the reservation process, the application queries the database to ensure the selected room is available for the specified dates.
  2. If the room is not available, the user is notified, and the reservation is not confirmed.

## Installation

1. **Java Development Kit (JDK):** Ensure you have Java installed on your system.
2. **MySQL Connector/J:** Download and install the MySQL Connector/J from [MySQL Downloads](https://dev.mysql.com/downloads/connector/j/).
3. **Add Connector to Classpath:** Add the MySQL Connector/J JAR file to your project's classpath.

## Database Setup

1. **Create Database:** Run the SQL script provided to create the necessary database and tables.
2. **Configure Connection:** Update the JDBC connection details in your Java code.

## Running the Application

1. Compile and run the Java application.
2. Follow the on-screen prompts to navigate through the functionalities.

## Dependencies

- Java
- MySQL Database
- MySQL Connector/J

## Conclusion

The Hotel Management Application simplifies the process of handling room reservations, providing a user-friendly interface to manage bookings effectively. Users can reserve, view, update, and delete reservations while ensuring room availability through seamless integration with a MySQL backend.

```Java

//sample Java code

do {
			menu();
			System.out.print("Please Enter your choice: ");
			int choice = sc.nextInt();
			switch(choice) {
				case 1:
					System.out.println("Room Reservation.");
					dao.addReservation();
					break;
					
				case 2:
					System.out.println("View Reservations.");
					dao.viewReservation();
					break;
					
				case 3:
					System.out.println("Getting Room Number.");
					dao.getRoomNumber();
					break;
					
				case 4:
					System.out.println("Updating Reservation.");
					dao.updateReservation();
					break;
					
				case 5:
					System.out.println("Deleting Reservation");
					dao.deleteReservations();
					break;
					
				case 0:
					dao.exit();
					System.out.println("\nThank For Using Hotel Reservation System.");
					order = false;
					break;
					
				default:
					System.out.print("Please enter valid choice:");
					break;
				}
			
		}while(order);
