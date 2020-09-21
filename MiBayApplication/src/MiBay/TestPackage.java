/* 
 * This is the test package class that is used to properly test out all components of the package class.
 * 
 * @author Zara Noor (s3804936)
 * @version 1.0
 * @since 2019-10-11
 */

package MiBay;

//creation of the test package class
public class TestPackage {
	
	public static void testValid () {    
		//Check for package with valid entries
		Address address1 = new Address ("80", "Chambers st", "Brusnwick", "3456");
		Customer customer1 = new Customer ("Zara", "Noor", address1); 
		Product product1 = new Product ("Shoes", 10, 25);
		Package package1 = new Package (customer1, product1);

		System.out.println(package1.getDetails());
		System.out.println(package1.toString());
	}
	
	public static void testInvalid() {
		Address address1 = new Address ("80", "Chambers st", "Brusnwick", "3456");
		Customer customer1 = new Customer ("Zara", "Noor", address1); 
		Product product1 = new Product ("Shoes", 10, 25);
		Package package1 = new Package (customer1, product1);
	}
	
	public static void addRemove () {
		//testing the add product method for packages
		Address address1 = new Address ("80", "Chambers st", "Brusnwick", "3456");
		Customer customer1 = new Customer ("Zara", "Noor", address1); 
		Product product1 = new Product ("Shoes", 10, 25);
		Package package1 = new Package (customer1, product1);
		
		Product product2 = new Product ("Bottle", 100, 9.99);
		package1.addProduct(product2);
		
		System.out.println(package1.getDetails());
		System.out.println(package1.toString());
	
		System.out.println();
		//testing the remove product method for packages
		Package package2 = new Package (customer1, product1);
		package2.addProduct(product2);
		Product product3 = new Product ("Bowl", 25, 8.99);
		package2.addProduct(product3);
		package2.removeProduct(product3);
		
		System.out.println(package2.getDetails());
		System.out.println(package2.toString());
	}
	
	public static void main(String[] args) {
		testValid();
		System.out.println();
		addRemove();
	}

}
