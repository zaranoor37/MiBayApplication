/* 
 * This is the platinum package class that is a child-inherited class of the package class.
 * 
 * @author Zara Noor (s3804936)
 * @version 1.0
 * @since 2019-10-11
 */

package MiBay;

import java.util.regex.*;

//creation of the platinum package class (extended from the parent class - package)
public class PlatinumPackage extends Package {
	
	//declaration of the attribute
	private String memberNumber;
	
	//creation of the platinum package constructor
	public PlatinumPackage (Customer customer, Product product, String memberNumber) {
		super (customer, product);	
		updateMemberNumber(memberNumber);
	}
	
	// HACK. (Overriding constructor for miBay application)
	public PlatinumPackage(Package p, String memberNumber)
	{
		this(p.customer, p.prodArray[0], memberNumber);
		
		for(int i = 1; i < p.prodArray.length; i++)
		{
			this.addProduct(p.prodArray[i]);	
		}
	}
	
	//getter method for member number
	public String getMemberNumber () {
		return memberNumber;
	}
	
	//updating member number method
	public boolean updateMemberNumber(String memberNumber) {
		
		Pattern pattern;
		Matcher matcher;
		String rule = ("[a-zA-Z]{1}[0-9]{1}[a-zA-Z]{1}[0-9]{1}[a-zA-Z]{1}[0-9]{1}[a-zA-Z]{1}[0-9]{1}[a-zA-Z]{1}[0-9]{1}");
		pattern = Pattern.compile(rule);

		//setting pattern for the member number (business rule) using regex.
		if (memberNumber.matches(rule)) {
			this.memberNumber = memberNumber;
			return true;
		}else {
			throw new PackageException ("Member number digits invalid");
//			this.memberNumber = "N/A";
//		    return false;
		}
	}
	
	//implementing a getDetails method for platinum package.
    @Override
	public String getDetails() {
		return (super.getDetails() + "\nMember Number:" + this.memberNumber);
	}
	//implementing a toString method for platinum package.
    @Override
    public String toString () {
    	return (super.toString() + ":" + this.memberNumber);
    }
	
	
}
