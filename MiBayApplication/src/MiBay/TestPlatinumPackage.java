/* 
 * This is the test platinum package class that is used to properly test out all components of the platinum package class.
 * 
 * @author Zara Noor (s3804936)
 * @version 1.0
 * @since 2019-10-11
 */

package MiBay;

//creation of the platinum package class
public class TestPlatinumPackage {

	public static void testValid() {
		//check of valid entry for package
		Address address1 = new Address ("80", "Chambers st", "Brusnwick", "3456");
		Customer customer1 = new Customer ("Zara", "Noor", address1); 
		Product product1 = new Product ("Shoes", 10, 25);
		Package pp1 = new PlatinumPackage (customer1, product1, "a2s3d4f5g6");
		System.out.println(pp1.getDetails());
		System.out.println(pp1.toString());

	}
	
	public static void testInvalid () {
		Address address1 = new Address ("15", "Coventry st", "South Bank", "3006");
		Customer customer1 = new Customer ("Zoya", "Aziz", address1);
		Product product1 = new Product ("Maybelline mascara", 20, 10);
		
		//check for 9 characters member number (exceptions)
		try {
			Package pp1 = new PlatinumPackage (customer1, product1, "a2s3d4f5g");
			System.out.println(pp1.getDetails());
			System.out.println(pp1.toString());
		} catch (PackageException e) {
			System.out.println("Invalid entry for package");
			System.out.println(e.toString());
		}
		//check for 11 characters member number (exceptions)
		try {
			Package pp2 = new PlatinumPackage (customer1, product1, "a2s3d4f5g6y");
			System.out.println(pp2.getDetails());
			System.out.println(pp2.toString());
		}catch (PackageException e) {
			System.out.println("Invalid entry for package");
			System.out.println(e.toString());
		}
		//check for non-alternating member number (Exceptions)
		try {
			Package pp3 = new PlatinumPackage (customer1, product1, "a223d4f5g6y");
			System.out.println(pp3.getDetails());
			System.out.println(pp3.toString());
		}catch (PackageException e) {
			System.out.println("Invalid entry for package");
			System.out.println(e.toString());
		} 
	    //check for non-alphanumeric member number (Exceptions)	
		try {
			Package pp4 = new PlatinumPackage (customer1, product1, "a2$3d4f5g6y");
			System.out.println(pp4.getDetails());
			System.out.println(pp4.toString());
		}catch (PackageException e) {
			System.out.println("Invalid entry for package");
			System.out.println(e.toString());
		}
		
	}
	
	public static void update () {
		//check for the update member number method.
		Address address1 = new Address ("7", "Collins st", "Melbourne", "3000");
		Customer customer1 = new Customer ("Cindy", "William", address1);
		Product product1 = new Product ("Nike Air", 200, 99);
		PlatinumPackage pp1 = new PlatinumPackage (customer1, product1, "a1b2c3d4e5");
		pp1.updateMemberNumber("s3d4f5g6h7");
		System.out.println(pp1.getDetails());
		System.out.println(pp1.toString());
	}
	
	public static void main(String[] args) {
		testValid();
		System.out.println();
		testInvalid();
		System.out.println();
		update();
	}

}
