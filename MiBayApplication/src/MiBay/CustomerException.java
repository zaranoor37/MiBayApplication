/**
 * This is the customer exception class that is used to throw exceptions for the customer.
 * 
 * @author Zara Noor (s3804936)
 * @version 1.0
 * @since 2019-10-11
 */

package MiBay;

//creation of the customer exception class
public class CustomerException extends RuntimeException {
	
	public CustomerException (String message) {
		super (message);
	}
	
	public CustomerException () {
		super ();
		
	}
	

	
}
