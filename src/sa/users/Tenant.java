package sa.users;

import sa.booking.BookedPeriod;
import sa.booking.Booking;

public class Tenant extends User {
	
	public Tenant(String fullName, int telephone, String mail) {
		
		super(fullName, telephone, mail);
	}

	@Override
	public void summary() {
		// TODO Auto-generated method stub
		/**
		 * 
		 * * hacer lo mismo que en property 
		 */
		System.out.println("Property Summary:");
	    System.out.println("Area: " + this.fullName);
	    System.out.println("Area: " + this.telephone);
	    System.out.println("Area: " + this.mail);
		
	}

	@Override
	public void reserveCancelled(Booking b, BookedPeriod bp) {
		// TODO Auto-generated method stub
		
	}

}
