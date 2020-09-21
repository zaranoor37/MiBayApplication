/** 
 * This is the customer class that contains the customer constructor along with the business rules.
 * 
 * @author Zara Noor (s3804936)
 * @version 1.0
 * @since 2019-10-11
 */

package MiBay;

//creation of the customer class
public class Customer {
	
	//declaration of the attributes
	private String firstName;
	private String lastName;
	private Address address;
	private Address addressAlt;
	
	//creation of the customer constructor
	public Customer ( String firstName, String lastName, Address address) {
		
		//initialising the attributes 
		this.firstName = firstName;
		this.lastName = lastName;
		this.address=address;

		//throwing customer exceptions for any invalid inputs of the customer attributes
		if (this.firstName == null || this.firstName.isEmpty()) {
			throw new CustomerException ("Invalid first name");
		}
		
		if (this.lastName == null || this.lastName.isEmpty()) {
			throw new CustomerException ("Invalid last name");
		}
		
	}
	//constructor overriding for customers that wish to add a second alternative address
	public Customer (String firstName, String lastName, Address address, Address addressAlt) {
		
		//initialising the attributes
		this.firstName = firstName;
		this.lastName = lastName;
		this.address=address;
		this.addressAlt=addressAlt;

		if (this.addressAlt != null) {
			this.addressAlt = addressAlt;
		}
		
	}
	
	//setters and getters for customer attributes
	public void setfirstName (String firstName) {
		this.firstName = firstName;
	}
	
	public String getfirstName () {
		return firstName;
	}
	
	public void setlastName (String lastName) {
		this.lastName = lastName;
	}
	
	public String getlastName () {
		return lastName;
	}
	
	public void setAdress (Address address) {
		this.address = address;
	}
	
	public Address getAddress () {
		return address;
	}
	
	public void setAddressAlt (Address addressAlt) {
		this.address = addressAlt;
	}
	
	public Address getAddressAlt () {
		return addressAlt;
	}
	
	//implementing the getDetails method for customer
	public String getDetails () {
		if (addressAlt != null) {
			return ("Name:" + getfirstName() + " " + this.lastName + "\nAddress:" +  this.address.displayAddress() +
					"\nAlternative address: " + this.addressAlt.displayAddress());
		}else {
			return ("Name:" + this.firstName + " " + this.lastName + "\nAddress:" +  this.address.displayAddress());
		}
	}
	
	//implementing the toString method for customer
	public String toRead () {
		if (addressAlt != null) {
			return ("Customers:\n"+this.firstName + "\n" + this.lastName +"\n" + address.toRead() + "\n" + addressAlt.toRead());
		} else {
			return ("Customers:\n"+this.firstName + "\n" + this.lastName +"\n" + address.toRead()+"\nN/A");
		}
	}
	
	public String toString () {
		if (addressAlt != null) {
			return (this.firstName + ":" + this.lastName +":" + address.toString() + ":" + addressAlt.toString());
		} else {
			return (this.firstName + ":" + this.lastName +":" + address.toString());
		}
	}
}
