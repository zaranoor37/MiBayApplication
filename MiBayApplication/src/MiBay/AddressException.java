/** 
 * This is the address exception class that is used to throw exceptions for the address.
 * 
 * @author Zara Noor (s3804936)
 * @version 1.0
 * @since 2019-10-11
 */

package MiBay;

//creation of the address exception class
public class AddressException extends RuntimeException{
	
	public AddressException (String message) {
		super (message);
	}

	public AddressException () {
		super ();
	}
}
