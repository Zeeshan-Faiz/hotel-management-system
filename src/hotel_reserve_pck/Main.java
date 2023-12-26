package hotel_reserve_pck;

import java.util.Scanner;

public class Main {

	public static void menu() {
		System.out.println("\n1. Reserve a Room."
					+ "\n2. View Reservations."
					+ "\n3. Get Room Number."
					+ "\n4. Update Reservation."
					+ "\n5. Delete Reservation."
					+ "\n0. Exit.");
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		DaoImplementationService dao = new DaoImplementationService();
		Scanner sc = new Scanner(System.in);
		System.out.println("**********Welcome To Hotel Reservation System**********");
		boolean order = true;
		
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

	}

}
