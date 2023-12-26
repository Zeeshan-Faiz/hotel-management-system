package hotel_reserve_pck;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DaoImplementationService {

	Validation validator = new Validation();
	Scanner sc = new Scanner(System.in);
	String guestName,room_number,contact_number;
	Connection con;
	
	public void addReservation() {
		
		System.out.print("Enter Guest Name:");
		guestName = validator.validateGuestName();
		System.out.print("Enter Appointed Room Number:");
		room_number = validator.validateRommNumber();
		System.out.print("Enter Contact Number:");
		contact_number = validator.validateContactNumber();
		
		con = DBConnection.createDBConnection();
		String query = "insert into reservations (guest_name, room_number, contact_number)" 
		+ "values('" + guestName + "' ," + room_number + ", '" + contact_number + "' )";
		
		
		try {
			
			Statement statement = con.createStatement();
			int check = statement.executeUpdate(query);
			
			if(check != 0)
				System.out.println("\nRoom is reserved Successfully!!! ");
			else
				System.out.println("Something went wrong!!!");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	
	public void viewReservation() {
		
		con = DBConnection.createDBConnection();
		String query = "select * from reservations";
		System.out.format("%s\t%s\t%s\t%s\t\t%s\n","RESERVATION_ID","GUEST_NAME","ROOM_NUMBER","CONTACT_NUMBER","RESERVATION_DATE");
		
		try {
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				System.out.format("%d\t\t%s\t\t%d\t\t%s\t\t%s\n",
						result.getInt(1),
						result.getString(2),
						result.getInt(3),
						result.getString(4),
						result.getTimestamp(5).toString());
			}
			
			System.out.println("\n---------------------------------------------------------------------------------------------");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void getRoomNumber() {
		
		System.out.print("Enter Guest's id:");
		int id = sc.nextInt();
		con = DBConnection.createDBConnection();
		String query = "select * from reservations where reservation_id="+id;
		
		try {
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			if(result.next()) {
				
				System.out.format("%s\t%s\t%s\t%s\t\t%s\n","RESERVATION_ID","GUEST_NAME","ROOM_NUMBER","CONTACT_NUMBER","RESERVATION_DATE");
				System.out.format("%d\t\t%s\t\t%d\t\t%s\t\t%s\n",
						result.getInt(1),
						result.getString(2),
						result.getInt(3),
						result.getString(4),
						result.getTimestamp(5).toString());
				System.out.println("\n---------------------------------------------------");
				
			}
			else {
				System.out.printf("\nWe didn't find any record with Guest id: %d\n",id);
			}
				
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void updateReservation() {
		
		while(true) {
			
			System.out.print("Enter Guest ID You Want To Update:");
			int id = sc.nextInt();
			sc.nextLine();
			
			if(reservationExists(id)) {
				
				System.out.print("Enter New Guest Name:");
				guestName = validator.validateGuestName();
				System.out.print("Enter New Appointed Room Number:");
				room_number = validator.validateRommNumber();
				System.out.print("Enter New Contact Number:");
				contact_number = validator.validateContactNumber();
				con = DBConnection.createDBConnection();
				String query = "update reservations set guest_name= '" + guestName 
						+ "', " + "room_number= " + room_number + " ," + "contact_number= '" + contact_number
						+ "' where reservation_id = "+id;
				
				try {
					
					Statement statement = con.createStatement();
					int affected_row = statement.executeUpdate(query);
					if(affected_row>0)
						System.out.println("\nReservations Updated Successfully!!");
					else
						System.out.println("Reservations Update Failed");
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
			else {
				System.out.println("\nSorry We Didn't Find Any Matching Reservation For The Given Id: "+id);
			}
		}
	}
	
	public void deleteReservations() {
		
		while(true) {
			System.out.print("Enter Guest ID You Want To Delete:");
			int id = sc.nextInt();
			
			con = DBConnection.createDBConnection();
			String query = "delete from reservations where reservation_id="+id;
			
			if(reservationExists(id)) {
				try {
					Statement statement = con.createStatement();
					int affected_rows = statement.executeUpdate(query);
					
					if(affected_rows>0)
						System.out.println("\nReservation Deleted Successfully!!");
					else
						System.out.println("Reservation Deletion Failed");
					
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				break;
			}
			else {
				System.out.println("\nPlease Enter Correct Reservation Id!!");
			}
		}
	}
	
	public boolean reservationExists(int id) {
		
		con = DBConnection.createDBConnection();
		String query = "select reservation_id from reservations where reservation_id="+id;
		
		try {
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			return result.next();
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public void exit() throws InterruptedException{
		
		System.out.print("\nExiting System");
		int i=5;
		while(i!=0) {
			
			System.out.print(".");
			Thread.sleep(500);
			i--;
		}
	}
	
	
	
	
}
