/* 
 * This is the package class that contains the package constructor as well as the corresponding rules for it
 * 
 * @author Zara Noor (s3804936)
 * @version 1.0
 * @since 2019-10-11
 */

package MiBay;

import java.time.LocalDate;
import MiBay.Customer;

//creation of the package class
public class Package {
	
	//declaration of the package attributes
	protected Customer customer;
	//(ensuring at least one product)
	protected Product [] prodArray = new Product [1];
	protected LocalDate localDate;

	//creation of package constructor
	public 	Package (Customer customer, Product product) {
		
		//initialising the attributes
		this.customer=customer;
		this.prodArray[0]=product;
	}

   //method for adding products into the product array
   public boolean addProduct(Product product) {
	   Product tempProduct[] = new Product[prodArray.length+1];
    	for (int i = 0; i < prodArray.length; i++) {
    		tempProduct[i]=prodArray[i];	
    	}  
    	tempProduct[prodArray.length]=product;
    	prodArray = tempProduct;
    	return true;                                             
    }
   
   //method for removing products from the product array
   public boolean removeProduct (Product product) {
	   Product prodRemove[] = new Product [prodArray.length-1];
	   prodArray[prodArray.length - 1] = product;
	   for (int i = 0; i < prodRemove.length; i++) {
		   prodRemove [i] = prodArray [i];
	   }
	   prodArray = prodRemove;
	   return true;
   }
    
    //method for printing all products from the product array for getDetails method
    public String printProduct () {
    	String print = "";
    	for (int i = 0; i < prodArray.length; i++) {
    		if(prodArray[i]!=null)
    		{
    		   print += prodArray[i].getDetails();
    	    }
    	}	
    	return print;
    }	
    
    //method for printing all products from the product array for toString method
    public String printStringProduct () {
    	String print = "";
    	for (int i = 0; i <prodArray.length; i++) {
    		if (prodArray[i] != null) {
    			print += prodArray[i].toString() + ":";
    		}
    	}
    	return print;
    }
    //set method for adding delivery date (miBay application)
    public void addDate(LocalDate localDate)
    {
    	this.localDate = localDate;
    	//return this.localDate;
    }
    
    //get method for adding delivery date (miBay application)
    public LocalDate returnDate()
    {
    	return this.localDate;
    }
    
    //implementing the getDetails method for package
    public String getDetails() {
    	return ("Customer details-\n" + customer.getDetails() + "\nProduct details-" + printProduct()+"\nDate: "+this.localDate);
    }
	
    //implementing the toString method for package
    public String toString () {
    	return (customer.toString() + ":" + printStringProduct ());
    }
}