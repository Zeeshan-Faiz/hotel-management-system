package hotel_reserve_pck;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {

	public static final String RED="\u001B[31m";
	public static final String RESET="\u001B[0m";
	private static Pattern GUEST_Name =Pattern.compile("^[a-zA-Z]+$");
	private static Pattern Room_Number =Pattern.compile("^\\d{3}$");
	private static Pattern Emp_Designation =Pattern.compile("^[a-zA-Z ]+$");
	Scanner sc = new Scanner(System.in);
	
	public String validateGuestName(){
        
    	String guestName;
    	
    	while(true){
    		
    		guestName=sc.nextLine();
            if(!GUEST_Name.matcher(guestName).matches()){
                System.out.print(RED+"Please Enter Valid Name With No Numeric Characters:"+RESET);
            }
            else{
                break;
            }
    	}
           return guestName;
    }

	public String validateRommNumber() {
		
		String roomNumber;
    	
    	while(true){
    		
    		roomNumber=sc.nextLine();
            if(!Room_Number.matcher(roomNumber).matches()){
                System.out.print(RED+"Please Enter Valid Room Number :"+RESET);
            }
            else{
                break;
            }
    	}
           return roomNumber;
	}

	public String validateContactNumber() {
		
		String contactNumber;
		
		while(true) {
			
			contactNumber = sc.nextLine();
			if(contactNumber.length()==10)
				break;
			
			else
				System.out.println(RED+"Contact Number Should be of 10 digits: "+RESET);
		}
		return contactNumber;
	}

}
