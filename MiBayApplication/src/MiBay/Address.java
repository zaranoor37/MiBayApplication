/* 
 * This is the address class that contains the address constructor that is in accordance of the address business rules.
 * This address class is further used for the customer constructor.
 * 
 * @author Zara Noor (s3804936)
 * @version 1.0
 * @since 2019-10-11
 */

package MiBay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//creation of the address class
public class Address {
	
	//declaration of the attributes
	private String streetNo;
	private String streetName;
	private String suburb;
	private String postCode;
	
	//Address constructor 
	public Address (String streetNo, String streetName, String suburb, String postCode) {
		
		//initialising the attributes
		this.streetNo = streetNo;
		this.streetName = streetName;
		this.suburb = suburb;
		this.postCode = postCode;
		
		//regex for postcode (pattern) business rules
		Pattern pattern;
		Matcher matcher;
		String rule = ("[1-8]{1}[0-9]{3}");
		pattern = Pattern.compile(rule);
		
		//Throwing exceptions for inputs that violate the business rules for the address.
		if (this.streetNo == null || this.streetNo.isEmpty()) {
			throw new AddressException ("Invalid Street number");
		}
		
		if (this.streetName == null || this.streetName.isEmpty()) {
			throw new AddressException ("Invalid Street Name");
		}
		
		if (this.suburb == null || this.suburb.isEmpty()) {
			throw new AddressException ("Invalid Suburb");
		}
		
		if (this.postCode == null || this.postCode.isEmpty()) {
			throw new AddressException ("Invalid postcode (empty)");
		} else if (this.postCode.matches(rule)) {
			this.postCode = postCode;
		} else {
			throw new AddressException ("Invalid postcode (postcode digits not valid)");
		}
		
	}
	
	//setters and getters for all address attributes
	public void setStreetNo (String streetNo) {
		this.streetNo = streetNo;
	}
	
	public String getStreetNo () {
		return streetNo;
	}
	
	public void setStreetName (String streetName) {
		this.streetName = streetName;
	}
	
	public String getStreetName () {
		return streetName;
	}
	
	public void setSuburb (String suburb) {
		this.suburb = suburb;
	}
	
	public String getSuburb () {
		return this.suburb;
	}
	
	public void setPostCode (String postCode) {
		this.postCode = postCode;
	}
	
	public String getPostCode () {
		return this.postCode;
	}
	
	//method to display the address in the Customer toString and getDetails method
	public String displayAddress()
	{
		return(this.streetNo + " " + this.streetName + " " +  this.suburb + " " + this.postCode);
	}
	public String toRead()
	{
		return(this.streetNo + "\n" + this.streetName + "\n" +  this.suburb + "\n" + this.postCode);
	}
	public String toString()
	{
		return(this.streetNo + ":" + this.streetName + ":" +  this.suburb + ":" + this.postCode);
	}
	
}
