/* 
 * This is the package exception class that is used to throw exceptions relating to the package.
 * 
 * @author Zara Noor (s3804936)
 * @version 1.0
 * @since 2019-10-11
 */

package MiBay;

//creation of the package exception class
public class PackageException extends RuntimeException {
	
	public PackageException (String message) {
		super (message);
	}
	
	public PackageException () {
		super ();
	}


}
