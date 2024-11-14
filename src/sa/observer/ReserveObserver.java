package sa.observer;

import java.time.LocalDate;

import sa.booking.BookedPeriod;
import sa.booking.Booking;
import sa.observer.interfaces.INotifyObserver;

public class ReserveObserver implements INotifyObserver {

	@Override
	public void update(Booking booking) {
		
		System.out.println("Se alquilo la propiedad:");
		booking.getProperty().summary();
		
	}

	@Override
	public void update(Booking b, BookedPeriod bp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Booking b, LocalDate date) {
		// TODO Auto-generated method stub
		
	}

}
