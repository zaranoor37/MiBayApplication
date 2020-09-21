/** This is the miBay application class that manages all the deliveries and contains methods for the menu class.
 *  
 * 
 * @author Zara Noor (s3804936)
 * @version 1.0
 * @since 2019-10-11
 */

package MiBay;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

//creation of the miBay application class
public class MiBayApplication {
	
	Scanner console = new Scanner (System.in);
	
	//declaration of variables as well as arrays.
	private Customer [] cList  = new Customer [20];
	private Product [] pList = new Product [20];
	private Package [] packageList = new Package [50];
	private LocalDate localDate;
	
	//method for adding customer with one address (for AC in menu)
	public void addCustomer (String firstName, String lastName, Address address) {
		
		for (int i = 0; i < cList.length; i++) {
			if (cList[i] == null) {
			cList [i]= new Customer(firstName, lastName, address);
			break;
			}
		}
	}
	
	//method for adding customers with an alternative address (for AC in menu)
	public void addC (String firstName, String lastName, Address address, Address addressAlt) {
		for (int i = 0; i < cList.length; i++) {
			if (cList[i] == null) {
			cList [i]= new Customer(firstName, lastName, address, addressAlt);
			break;
	        }
		}	
	}
	
	//method for adding products (for AP in menu)
	public void addProduct (String name, double weight, double cost) {
		
		for(int i = 0; i < pList.length; i++) {
			if (pList[i] == null) {
				pList[i] = new Product (name, weight, cost);
				break;
			}
		}
	}
	
	//method for prepare order in menu (pp)
	public void prepareOrder () {
		
		int position = 0;
		
		    //selecting customers from the list
			System.out.println("Please choose a customer from the list: ");
			for (int i = 0; i <cList.length; i++) {
				if (cList[i] != null) {
				System.out.println((i+1) + "." + cList[i].getfirstName() + " " + cList[i].getlastName()); 
			} 
		  }
		
		int inputC = Integer.parseInt(console.nextLine());
		
		    //selecting products from the product list
			System.out.println("Please choose a product from the list: ");
			for (int i = 0; i < pList.length; i++) { 
				if (pList[i] != null) {
					System.out.println((i+1) + " " + pList[i].getName());
				}
		      }
		
		int inputP = Integer.parseInt(console.nextLine()); 
		
		    //adding the selected customer and product into the array
			for(int i=0;i<packageList.length;++i){
				if  (packageList[i] == null) {
				packageList[i] = new Package(cList[inputC-1], pList[inputP -1]);
				position=i;
				break;
			  }
			}
		
		//adding the delivery date for the package
		System.out.println("Please enter the delivery date: ");
		System.out.print("Enter Day:");
		int Day = Integer.parseInt(console.nextLine());
		System.out.print("Enter Month:");
		int Month = Integer.parseInt(console.nextLine());
		System.out.print("Enter Year:");
		int Year = Integer.parseInt(console.nextLine());
		
		//System.out.println(packageList[position].returnDate());
		
		String pSelect;
		
		//adding more products into the array
		do {
			System.out.println("Would you like to add another product (Y/N):");
		    pSelect = console.nextLine();
			if (pSelect.equals("Y") || (pSelect.equals("y"))) {
			System.out.println("Please choose a product from the list: ");
			for (int i = 0; i < pList.length; i++) { 
				if (pList[i] != null) {
					System.out.println((i+1) +"." +" " + pList[i].getName());
				 }
			   }
			int inputAP = Integer.parseInt(console.nextLine());
			packageList[position].addProduct(pList[(inputAP-1)]);
		       }
			
		} while (pSelect.equals("Y") || pSelect.equals("y"));
		
		
		    //creation of package or platinum package 
			System.out.println("Is this a Platinum Package (Y/N)");
			
			String ppSelect = console.nextLine();
			
			if (ppSelect.equals("N") || ppSelect.equals("n")) {
				System.out.println("Package for" + " " + cList[inputC-1].getfirstName() + " " +
						cList[inputC-1].getlastName() + " "+ "prepared");
				

			} else if (ppSelect.equals("Y") || ppSelect.equals("y")){
				System.out.println("Please input your member number:");
				String mnSelect = console.nextLine();
	
				System.out.println("Package for" + " " +cList[inputC-1].getfirstName() + " " +
						cList[inputC-1].getlastName() + " " +"prepared");
				
				packageList[position] = new PlatinumPackage(packageList[position], mnSelect);
				
				}
			localDate = LocalDate.of(Year,  Month, Day);
			packageList[position].addDate(localDate);
			}
	
	//method for display order for the menu
	public void displayOrder (String sortOrder) {
		Package sortPackage;
		
		if (sortOrder.equals("A") || sortOrder.equals("a")){
			for (int i = 0; i < packageList.length; i++) {
				for (int j = 0; j < packageList.length; j++) {
				if (packageList[j] != null && packageList[j+1] != null) {
				if (packageList[j].customer.getlastName().charAt(0) > packageList[j+1].customer.getlastName().charAt(0)) {
					sortPackage = packageList [j];
					packageList [j]= packageList [j+1];
					packageList [j+1] = sortPackage;
				 }
			    }
		       }

		    }

      } else if (sortOrder.equals("D") || sortOrder.equals("d")){
			for (int i = 0; i < packageList.length; i++) {
				for (int j = 0; j < packageList.length; j++) {
				if (packageList[j] != null && packageList[j+1] != null) {
				if (packageList[j].customer.getlastName().charAt(0) < packageList[j+1].customer.getlastName().charAt(0)) {
					sortPackage = packageList [j];
					packageList [j]= packageList [j+1];
					packageList [j+1] = sortPackage;
		        }
			   }
		      }
	       }
			
          }  
		for (int i = 0; i < packageList.length; i++) {
			if (packageList[i] != null) {
				System.out.println("________________________________________");
				System.out.println(packageList[i].getDetails());
			}
		 }
	   }
	
	//method for delivery search in menu
	public void deliverySearch (int y, int m, int d) {
		LocalDate searchDate = LocalDate.of(y, m, d);
		//System.out.println(searchDate);
		
		for (int i = 0; i < packageList.length; i++) {
			if (packageList[i] != null && searchDate.equals(packageList[i].returnDate())) {
				System.out.println(packageList[i].getDetails());
			} 	
		  }
	  }
	
	//creation of method for seed data in menu
	public void seedData () {
		Address address = new Address ("50", "Chambers st", "Brunswick", "3056");
		Address address1 = new Address ("29", "Cempaka st", "Kebayoran", "3090");
		Address address2 = new Address ("15", "Agung st", "Sunter", "3007");
		Address address3 = new Address ("05", "Dennis st", "Clayton", "3168");
		addCustomer("Zoya", "Aziz", address);
		addCustomer("Naura","Shahani", address1);
		addCustomer("Cindy", "William", address2);
		addCustomer("Zeshan", "Ziz", address3);
		addProduct("Chilli Packet", 10, 5);
		addProduct("Chocolate muffins", 60, 6);
		addProduct("Tim tam", 80, 7.99);
		addProduct("Miniso headphones", 55, 10);
     }

	//method for file handling for write
	public void write () {
		try {
			PrintWriter pW = new PrintWriter(new BufferedWriter(new FileWriter("application.txt")));
			
			for (int i = 0; i < cList.length; i++) {
				if (cList[i] != null) {
					pW.println(cList[i].toRead());
				}	
			}
			for (int i = 0; i <pList.length; i++) {
				if (pList[i] != null) {
					pW.println(pList[i].toRead());
				}
			}
			pW.close();
		} catch (IOException e) {
			System.out.println("File could not be found");
			System.out.println(e.toString());
		}
	}
	
	//method for file handling for read
	public void read () {
		Scanner console = null;
		
		try {
			console = new Scanner (new File("application.txt"));
			console.useDelimiter(":");
		} catch (FileNotFoundException e) {
			System.out.println("Error openning this file!!!");
			System.exit(0);
		}
		while (console.hasNextLine()){
			String line = console.nextLine();
			if (line.equals("Customers:")) {
				
				String firstName = console.nextLine();
				String lastName = console.nextLine();
				String streetNo = console.nextLine();
				String streetName = console.nextLine();
				String suburb = console.nextLine();
				String postCode = console.nextLine();
				Address addressIn = new Address (streetNo, streetName, suburb, postCode);
				String search = console.nextLine();
			
			Customer customerIn = new Customer (firstName, lastName, addressIn);	
			
			for (int i =0; i < cList.length; i++) {
				if(cList[i]==null){ 
					cList[i] = customerIn;
					break;
				}
			 }
			}
			
			if (line.equals("Product:")) {
				 String name = console.nextLine();
				 double weight = Double.parseDouble(console.nextLine());
				 double cost = Double.parseDouble(console.nextLine());;
				 
			Product productIn = new Product (name, weight, cost);
					
				 for (int i = 0; i < pList.length; i++) {
					 if(pList[i]==null)
						{
							pList[i] = productIn;
							break;
						}
				}
			}
		}
		console.close();
	}
}
