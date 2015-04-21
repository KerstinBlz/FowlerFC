
import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();
    public Customer (String newname){
        name = newname;
    };
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    };
    public String getName (){
        return name;
    };
    public String statement() 
    {
    	double totalAmount = 0;
    	int frequentRenterPoints = 0;
    	Enumeration _rentals = rentals.elements();
    	String result = "Rental Record for " + getName() + "\n";
    	while (_rentals.hasMoreElements()) 
    	{	    	
	    	Rental each = (Rental) _rentals.nextElement();	
	    	frequentRenterPoints += each.getFrequentRenterPoints();
	    	
	    	//show figures for this rental
	    	result += "\t" + each.getMovie().getTitle()+ "\t" +
	    	String.valueOf(each.getCharge()) + "\n";
	    	totalAmount += each.getCharge();
    	}
    	//add footer lines
    	result += "Amount owed is " + String.valueOf(getTotalCharge()) +
    	"\n";
    	result += "You earned " +
    	String.valueOf(frequentRenterPoints) +
    	" frequent renter points";
    	return result;
    }
    
    private double getTotalCharge() {
    	double result = 0;
    	Enumeration _rentals = rentals.elements();
    	while (_rentals.hasMoreElements()) {
	    	Rental each = (Rental) _rentals.nextElement();
	    	result += each.getCharge();
    	}
    	return result;
    }

    private double amountFor(Rental aRental) {
    	return aRental.getCharge();
    }
    
  }
    