/* 
 * This is the product class that contains of the product constructor along with all the business rules for the products.
 * 
 * @author Zara Noor (s3804936)
 * @version 1.0
 * @since 2019-10-11
 */

package MiBay;

//creation of the product class
public class Product {
	
	//declaration of the attributes
	private String name;
	private double weight;
	private double cost;
	
	//creation of the product constructor
	public Product (String name, double weight, double cost) {
		
		//initialising the attributes 
		this.name=name;
		this.weight=weight;
		this.cost=cost;
		
		//throwing product exception when there is an invalid input for the product attributes
		if (this.name == null || this.name.isEmpty()) {
			throw new ProductException ("Invalid product name");
		}
		
		if (this.weight == 0) {
			throw new ProductException ("Invalid product weight");
		}
		
		if (this.cost < 1) {
			throw new ProductException ("Invalid product cost");
		}
	}
	
	//setters and getters for the product attributes
	public void setName (String name) {
		this.name = name; 
	}
	
	public String getName () {
		return name;
	}
	
	public void setWeight (double weight) {
		this.weight = weight;
	}
	
	public double getWeight () {
		return weight;
	}
	
	public void setCost (double cost) {
		this.cost = cost;
	}
	
	public double getCost () {
		return cost;
	}
	
	//implementing the getDetails method for the product class
	public String getDetails () {
		return ("\nName:" + this.name + "\nWeight:" + this.weight + "g" + "\nCost:" + "$" + this.cost);
	}
	
	//implementing the toString method for the product class
	public String toString () {
		return (this.name + ":" + this.weight + ":" + this.cost);
	}
	public String toRead () {
		return ("Product:\n"+this.name + "\n" + this.weight + "\n" + this.cost);
	}

}
