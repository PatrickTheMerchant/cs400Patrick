/// --== CS400 File Header Information ==--
// Name: Patrick Merchant
// Email: plmerchant@wisc.edu
// Team: GC
// TA: Dan
// Lecturer: Florian
// Notes to Grader: none
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Interface for the flight tracker.
 * @author Patrick Merchant
 */
public class FTInterfacePatrickSKELETON {

	private static HashTableMap flightInfo = new HashTableMap(20);
	/**
	 * Adds flight information to hash table 
	 * @param in scanner
	 * @param flightInfo hash table
	 */
	private static void addFlight(Scanner in) {
		System.out.print("Enter flight information (fight number) (Destination) (time XX:XX am/pm) (status): ");
		String input = in.nextLine();
		if (input.split(" ").length == 4) {		
			String fn = input.split(" ")[0];
			String destination = input.split(" ")[1];
			String time = input.split(" ")[2];
			String stat = input.split(" ")[3];
			// calls method adding flight info with arguments fn time stat
			System.out.println("Flight information added");
		} else {
			System.out.println("Invalid flight information syntax.");
		}

	}
	
	/**
	 * searches hash table for flight information based on input flight number
	 * @param in scanner
	 * @param flightInfo hash table
	 */
	private static void search(Scanner in) {
		System.out.print("Enter flight number: ");
		String input = in.nextLine();
		String output = "";          //calls method that searches hashTable and outputs flight value information
		if (output == null) {
			System.out.println("Flight information not found.");
			return;
		} else {
			System.out.println(output);
		}
		
	}
	
	/**
	 * searches for file with flight information and adds all flight information into hash table.
	 * @param in scanner
	 * @param flightInfo hash table
	 */
	private static void addfile(Scanner in) {
//		try {
//			System.out.print("Enter file name: ");
//			String input = in.nextLine();
//			//calls method that looks for file
//		} catch (FileNotFoundException e){
//			System.out.println("file not found");
//			return;
//		}
		System.out.println("Flight information added.");
	}
	
	/**
	 * deletes flight information from hash table based on input flight number
	 * @param in scanner
	 * @param flightInfo hash table
	 */
	private static void delete(Scanner in) {
		System.out.print("Enter flight number to be deleted: ");
		String flightNum = in.nextLine();
		//calls method that deletes flight with argument flightNum
		if (true) {
			System.out.println(flightNum + "deleted");
		} else {
			System.out.println("Flight no found.");
		}
	}
	
	/**
	 * runs the interface that prompts user commands and reads user commands.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to O'Hare Flight Traker!");
		System.out.println("             .------,\r\n" + 
				"              =\\      \\\r\n" + 
				" .---.         =\\      \\\r\n" + 
				" | C~ \\         =\\      \\\r\n" + 
				" |     `----------'------'----------,\r\n" + 
				".'     LI.-.LI LI LI LI LI LI LI.-.LI`-.\r\n" + 
				"\\ _/.____|_|______.------,______|_|_____)\r\n" + 
				"                 /      /\r\n" + 
				"               =/      /\r\n" + 
				"              =/      /\r\n" + 
				"             =/      /\r\n" + 
				"             /_____,'");
		System.out.println("(A)dd flight information.\n" +
				   "(C)lear flight information.\n" +
				   "(D)elete flight information by flight number.\n" +
				   "(L)oad flight information.\n" + 
				   "(S)earch for flight information by flight number.\n" + 
				   "(?) Display this full menu.\n" + 
				   "(Q)uit.");
		System.out.println();
		System.out.print("Action (? for full menu): ");
		HashTableMap flightInfo = new HashTableMap();            // calls method that initializes hashTable
		while(in.hasNextLine()) { 
			String input = in.nextLine();
			if (input.isEmpty()) {
				System.out.println("Unknown option: " + '\0');
				System.out.println("(A)dd flight information.\n" +
						   "(C)lear flight information.\n" +
						   "(D)elete flight information by flight number.\n" +
						   "(L)oad flight information.\n" + 
						   "(S)earch for flight information by flight number.\n" + 
						   "(?) Display this full menu.\n" + 
						   "(Q)uit.");
				System.out.println();
				System.out.print("Action (? for full menu): ");
				
			} else if (input.toLowerCase().charAt(0) == '?') {
				System.out.println("(A)dd flight information.\n" +
						   "(C)lear flight information.\n" +
						   "(D)elete flight information by flight number.\n" +
						   "(L)oad flight information.\n" + 
						   "(S)earch for flight information by flight number.\n" + 
						   "(?) Display this full menu.\n" + 
						   "(Q)uit.");
				System.out.println();
				System.out.print("Action (? for full menu): ");
				
			} else if (input.toLowerCase().charAt(0) == 'a') {
				addFlight(in);
				System.out.println();
				System.out.print("Action (? for full menu): ");
				
			} else if (input.toLowerCase().charAt(0) == 'c') {
				//calls method that empties hashTable
				System.out.println("Flights deleted");
				System.out.println();
				System.out.print("Action (? for full menu): ");
				
			} else if (input.toLowerCase().charAt(0) == 'd') {
				delete(in);
				System.out.println();
				System.out.print("Action (? for full menu): ");
				
			} else if (input.toLowerCase().charAt(0) == 'l') {
				addfile(in);
				System.out.println();
				System.out.print("Action (? for full menu): ");
				
			} else if (input.toLowerCase().charAt(0) == 's') {
				search(in);
				System.out.println();
				System.out.print("Action (? for full menu): ");
				
			} else if (input.toLowerCase().charAt(0) == 'q') {
				break;
				
			} else {
				System.out.println("Unknown option: " + input.toLowerCase().charAt(0));
				System.out.println("(A)dd flight information.\n" +
						   "(C)lear flight information.\n" +
						   "(D)elete flight information by flight number.\n" +
						   "(L)oad flight information.\n" + 
						   "(S)earch for flight information by flight number.\n" + 
						   "(?) Display this full menu.\n" + 
						   "(Q)uit.");
				System.out.println();
				System.out.print("Action (? for full menu): ");
			}
		}
		in.close();
		System.out.println();
		System.out.println("             .------,\r\n" + 
				"              =\\      \\\r\n" + 
				" .---.         =\\      \\\r\n" + 
				" | C~ \\         =\\      \\\r\n" + 
				" |     `----------'------'----------,\r\n" + 
				".'     LI.-.LI LI LI LI LI LI LI.-.LI`-.\r\n" + 
				"\\ _/.____|_|______.------,______|_|_____)\r\n" + 
				"                 /      /\r\n" + 
				"               =/      /\r\n" + 
				"              =/      /\r\n" + 
				"             =/      /\r\n" + 
				"             /_____,'");
		System.out.println("Blue skies and tailwinds!");
	}


}
