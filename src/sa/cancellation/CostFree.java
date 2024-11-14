package sa.cancellation;

import java.time.LocalDate;

import sa.booking.BookedPeriod;
import sa.booking.Booking;

public class CostFree implements ICancellationPolicy{

 
	@Override
	public void activate(LocalDate cancellationDate, Booking booking, BookedPeriod periodCancelled) {
		/*
		 * Este metodo se encarga de verificar si en el momento de activacion de la cancelacion 		   
		 * fue 10 dias antes que el inicio del alquiler. En el caso de que sea asi, se notifica 
		 * por pantalla que no se paga nada. En el caso negativo, tendra que pagar el equivalente
		 * a dos dias de alquiler, se notificara por pantalla el valor
		 * 
		 * 
		 * */
		if(cancellationDate.isBefore(periodCancelled.getCheckIn().minusDays(10))) {
			System.out.println("No pagas nada");
		}else {
			System.out.println("Solo pagas el equivalente a dos dias de alquiler $:"+ booking.price(booking.getCheckIn()) * 2 );
		}
		
		
	}
	
	


}
