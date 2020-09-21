/* 
 * This is the test customer class that is used to properly test out all components of the customer class.
 * 
 * @author Zara Noor (s3804936)
 * @version 1.0
 * @since 2019-10-11
 */

package MiBay;


//creation of the test customer class
public class TestCustomer {
	
	public static void testValid ()  {
		
		//check - for customer with one address 
		Address address1 = new Address ("21", "Chambers Street", "Brusnwick", "3056");
		Customer customer1 = new Customer ("Zara", "Noor", address1);
		
		System.out.println(customer1.getDetails());
		System.out.println(customer1.toString());
		System.out.println();
	}
	
	public static void testInvalid ()  {
		
		//checking null values in customer (exceptions)
		try {
			Address address1 = new Address ("90", "Chambers Street", "Brusnwick", "3056");
			Customer customer1 = new Customer (null, "Noor", address1);
			System.out.println(customer1.getDetails());
			System.out.println(customer1.toString());
			System.out.println();
		} catch (CustomerException e) {
			System.out.println("Invalid customer entry");
			System.out.println(e.toString());
		} 
		
		//null values check in address (exceptions)
		try {
			Address address2 = new Address (null, "La trobe st", "Melbourne", "3000");
			address2.toString();
		} catch (AddressException e) {
			System.out.println("Invalid address entry");
			System.out.println(e.toString());
		}
		
		//Wrong post code check in address (exceptions)
		try {
			Address address2 = new Address ("50", "La trobe st", "Melbourne", "abc");
			address2.displayAddress();
		} catch (AddressException e) {
			System.out.println("Invalid address entry");
			System.out.println(e.toString());
		}
		
	}
	
	public static void operations() {
		//check for customers with 2 addresses
		Address address2 = new Address ("30", "Benson st", "Burwood", "3065");
		Address address3 = new Address ("8", "Dennis st", "Clayton", "3076");
		Customer customer2 = new Customer ("Nina", "Dobrev", address2, address3);	
		
		System.out.println(customer2.getDetails());
		System.out.println(customer2.toString());
		
		//check - a third address is not possible as constructor overriding is used.. 
	}
	
	public static void main(String[] args)  {
		
		testValid();
		testInvalid();
		operations();
	}

}
