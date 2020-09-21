/** This is the menu class that displays the menu and calls methods from the mibay application class
 *  
 * @author Zara Noor (s3804936)
 * @version 1.0
 * @since 2019-10-11
 */

package MiBay;

import java.util.InputMismatchException;
import java.util.Scanner;

//creation of the menu class
public class Menu {

	public static void main(String[] args) {
		
		//making object of the miBay application class
		
		MiBayApplication application = new MiBayApplication ();
		application.read();
		String userInput, UI ;
		Scanner console = new Scanner (System.in);

		//do while loop for displaying the menu
		do {
		System.out.println("*** MiBayApplication System Menu *** ");
		System.out.println("Add Customer\t\t\t\t\tAC\nAdd Product\t\t\t\t\tAP\nPrepare Order\t\t\t\t\tPP"
				+ "\nDisplay ALL Deliveries(sorted by Name)\t\tDA\nDelivery Search (display deliveries on date)"
				+ "\tDS\nSeed Data\t\t\t\t\tSD\nExit Program\t\t\t\t\tEX");
		System.out.println("Enter Selection:");
		
		userInput = console.nextLine();
		UI = userInput.toLowerCase();
		switch(UI) {
		case "ac" :
			Address address;
			Address addressAlt;
			try {
			System.out.println("Enter customer details: ");
			System.out.print("Enter First Name:");
			String firstName = console.nextLine();
			System.out.print("Enter Last Name:");
			String lastName = console.nextLine();
			System.out.print("Enter street number:");
			String streetNo = console.nextLine();
			System.out.print("Enter street name:");
			String streetName = console.nextLine();
			System.out.print("Enter suburb:");
			String suburb = console.nextLine();
			System.out.print("Enter postcode:");
			String postCode = console.nextLine();
			address = new Address (streetNo, streetName, suburb, postCode);
		    System.out.println("Do you have an alternative address? (Y/N)");
		    String alt = console.nextLine();
		    if (alt.equals("Y") || (alt.equals("y"))){
		    	System.out.print("Enter your 2nd street No:");
		    	String sNo = console.nextLine();
		    	System.out.print("Enter your 2nd street Name:");
		    	String sName = console.nextLine();
		    	System.out.print("Enter your 2nd suburb :");
		    	String sb = console.nextLine();
		    	System.out.print("Enter your 2nd postCode:");
		    	String pC = console.nextLine();
		    	addressAlt = new Address (sNo, sName, sb, pC);
		    	application.addC(firstName, lastName, address, addressAlt);
		    } else if (alt.equals("N") || (alt.equals("n"))) {
		    	 application.addCustomer(firstName, lastName, address);
		    }	
		    System.out.println(firstName + " " + lastName + " " + "was successfully added to the system");
			} catch (AddressException e) {
				System.out.println("The address input is not appropriate");
				System.out.println(e.toString());
			} catch (CustomerException e) {
				System.out.println("The customer input is not appropriate");
				System.out.println(e.toString());
			}
			break;
				
		case "ap" :
			try {
			System.out.println("Enter products details: ");
			System.out.print("Enter Name:");
			String name = console.next();
			System.out.print("Enter weight:");
			double weight  = console.nextDouble();
			console.nextLine();
			System.out.print("Enter cost:");
			double cost = console.nextDouble();
			console.nextLine();
			
			application.addProduct(name, weight, cost);
			System.out.println(name + " " + "successfully added to the system.");
			} catch (ProductException e){
				System.out.println("The product input is not appropriate");
				System.out.println(e.toString());
			} catch (InputMismatchException e) {
				System.out.println("The product input is not appropriate (enter integers)");
				System.out.println(e.toString());
			}
			break;
		
		case "pp" :
			try {
				application.prepareOrder();
			} catch (PackageException e) {
				System.out.println("Invalid member number!");
				System.out.println(e.toString());
			} catch (NullPointerException e) {
				System.out.println("The list is empty! Enter again.");
				System.out.println(e.toString());
			}
			break;
		
		case "da" :
			try {
				System.out.println("Enter sort order (A/D): ");
				String sortOrder = console.next();
				application.displayOrder(sortOrder);
			} catch (NullPointerException e) {
				System.out.println("The list is empty! Enter again.");
				System.out.println(e.toString());
			}
			break;
		
		case "ds" :
			try {
				System.out.println("Enter your selection");
			    System.out.println("Enter day:");
			    int d = Integer.parseInt(console.nextLine());
//			    console.nextLine();
			    System.out.println("Enter month:");
			    int m = console.nextInt();
			    console.nextLine();
			    System.out.println("Enter year:");
			    int y = console.nextInt();
			    console.nextLine();
				application.deliverySearch(y, m, d);
			} catch (NullPointerException e) {
				System.out.println("The list is empty! Enter again.");
				System.out.println(e.toString());
			}
		    
			break;
		
		case "sd" :
			
			application.seedData ();
			System.out.println("Success - Data seeded");
			break;
		
		case "ex" :
			
			System.out.println("Success Exit");
			break;
		}
		
		} while (!UI.equals("ex"));
		
		application.write();
		}
	

}
