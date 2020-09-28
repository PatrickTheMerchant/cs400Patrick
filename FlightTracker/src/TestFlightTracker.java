
import java.util.Scanner;

public class TestFlightTracker {
	
	public static void TestAddAndLookup() {
		String flightNum1 = "UA5108";
		String flightNum2 = "AA1106";
		String flightNum3 = "AA335";
		
		Scanner flight1 = new Scanner(flightNum1 + "	Clarksburg (CKB)	12:00 pm	En Route - Delayed");
		Scanner flight2 = new Scanner(flightNum2 + "	Dallas (DFW)	12:00 pm	En Route - On-time");
		Scanner flight3 = new Scanner(flightNum3 + "	Miami (MIA)	12:11 pm	Canceled");
		
		FTInterfacePatrickVER1.addFlight(flight1);
		FTInterfacePatrickVER1.addFlight(flight2);
		FTInterfacePatrickVER1.addFlight(flight3);
		
		Scanner num1 = new Scanner(flightNum1);
		Scanner num2 = new Scanner(flightNum2);
		Scanner num3 = new Scanner(flightNum3);
		
		System.out.println(flightNum1 + "	Clarksburg (CKB)	12:00 pm	En Route - Delayed");
		FTInterfacePatrickVER1.search(num1);
		System.out.println(flightNum2 + "	Dallas (DFW)	12:00 pm	En Route - On-time");
		FTInterfacePatrickVER1.search(num2);
		System.out.println(flightNum3 + "	Miami (MIA)	12:11 pm	Canceled");
		FTInterfacePatrickVER1.search(num3);
	}
	
	public static void TestAddDuplicates() {
		String flightNum1 = "UA5108";
		
		Scanner flight1 = new Scanner(flightNum1 + "	Clarksburg (CKB)	12:00 pm	En Route - Delayed");

		System.out.println("If working: error message about adding duplicate flights below");
		FTInterfacePatrickVER1.addFlight(flight1);
		FTInterfacePatrickVER1.addFlight(flight1);

	}
	
	public static void TestLookupImagFlight() {
		String flightNum1 = "UA5108";
		String flightNum2 = "AA1106";
		String flightNum3 = "AA335";
		
		Scanner flight1 = new Scanner(flightNum1 + "	Clarksburg (CKB)	12:00 pm	En Route - Delayed");
		Scanner flight2 = new Scanner(flightNum2 + "	Dallas (DFW)	12:00 pm	En Route - On-time");
		Scanner flight3 = new Scanner(flightNum3 + "	Miami (MIA)	12:11 pm	Canceled");
		
		FTInterfacePatrickVER1.addFlight(flight1);
		FTInterfacePatrickVER1.addFlight(flight2);
		
		Scanner num3 = new Scanner(flightNum3);
		
		System.out.println("If working: error about looking up a nonexistant flight");
		FTInterfacePatrickVER1.search(num3);
	}
	
	public static void TestModifyFlight() {
		String flightNum1 = "UA5108";
		String flightNum2 = "AA1106";
		
		Scanner flight1 = new Scanner(flightNum1 + "	Clarksburg (CKB)	12:00 pm	En Route - Delayed");
		Scanner flight2 = new Scanner(flightNum2 + "	Dallas (DFW)	12:00 pm	En Route - On-time");
		Scanner flight2New = new Scanner(flightNum2 + "	Miami (MIA)	12:11 pm	Canceled");
		
		FTInterfacePatrickVER1.addFlight(flight1);
		FTInterfacePatrickVER1.addFlight(flight2);
		FTInterfacePatrickVER1.modifyFlight(flight2New);
		
		Scanner num1 = new Scanner(flightNum1);
		Scanner num2 = new Scanner(flightNum2);
		
		System.out.println(flightNum2 + "	Miami (MIA)	12:11 pm	Canceled");
		FTInterfacePatrickVER1.search(num2);
	}
	
	public static void testInvalidInput() {
		String flightNum1 = "UA5108";
		String flightNum2 = "AA1106";
		
		Scanner flight1 = new Scanner(flightNum1 + "	Clarksburg (CKB)	12:00 pm	En Route - Delayed");
		Scanner flight2 = new Scanner(flightNum2 + "	Dallas (DFW)	12:00 pm	En Route - On-time");
		Scanner flight2New = new Scanner(flightNum2 + "	Miami (MIA)	14:92 pm");
		
		FTInterfacePatrickVER1.addFlight(flight1);
		FTInterfacePatrickVER1.addFlight(flight2);
		
		System.out.println("If working: should be a error message about invalid modifications.");
		FTInterfacePatrickVER1.modifyFlight(flight2New);
	}
	
	public static void main(String[] args) {
		System.out.println("TestAddAndLookup");
		TestAddAndLookup();
		System.out.println("TestAddDuplicates");
		TestAddDuplicates();
		System.out.println("TestLookupImagFlight");
		TestLookupImagFlight();
		System.out.println("TestModifyFlight");
		TestModifyFlight();
		System.out.println("testInvalidInput");
		testInvalidInput();
	}
}