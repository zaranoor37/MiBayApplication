/* 
 * This is the product exception class that is used to throw exceptions for the product.
 * 
 * @author Zara Noor (s3804936)
 * @version 1.0
 * @since 2019-10-11
 */

package MiBay;

//creation of the product exception class
public class ProductException extends RuntimeException {

	public ProductException (String message) {
		super (message);
	}
	
	public ProductException () {
		super ();
	}
}
