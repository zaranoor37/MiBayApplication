/* 
 * This is the test product class that is used to properly test out all components of the product class.
 * 
 * @author Zara Noor (s3804936)
 * @version 1.0
 * @since 2019-10-11
 */

package MiBay;

//creation of the test product class
public class TestProduct {
	
	public static void testValid() {
		
		//Valid Inputs for product
		Product product = new Product ("Lion King DVD", 2.05, 4.99);
		Product product1 = new Product ("KitKat", 4.00, 3.00);
		
	    System.out.println(product.getDetails());
		System.out.println(product.toString());
		System.out.println();
		System.out.println(product1.getDetails());
	    System.out.println(product1.toString());
	    System.out.println();
	}
	
	public static void testInvalid () {
		
		//null value input (Checking exceptions)
		try {
			Product product = new Product (null, 4, 5.99);
			System.out.println(product.getDetails());
			System.out.println(product.toString());
		} catch (ProductException e) {
			System.out.println("Invalid entry for product");
			System.out.println(e.toString());
		}
		
		//empty string input (checking exceptions)
		try {
			Product product1 = new Product (" ", 7, 9);
			System.out.println(product1.getDetails());
			System.out.println(product1.toString());
		} catch (ProductException e) {
			System.out.println("Invalid entry for product");
			System.out.println(e.toString());
		}
		
		System.out.println();
		//Zero as an input for weight (checking exceptions)
		try {
			Product product2 = new Product ("The proposal DVD", 0, 3.00);	
			System.out.println(product2.getDetails());     
			System.out.println(product2.toString());
		} catch (ProductException e) {
			System.out.println("Invalid entry for product");
			System.out.println(e.toString());
		}
		System.out.println();
		//Zero as an input for cost (checking exceptions)
		try {
			Product product3 = new Product ("Ice Cream", 2, 0);
			System.out.println(product3.getDetails());     
			System.out.println(product3.toString());
		} catch (ProductException e) {
			System.out.println("Invalid entry for product");
			System.out.println(e.toString());
		}
	}
	
	public static void main(String[] args) {
		testValid();
		testInvalid();
	}

}
