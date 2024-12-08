package sa.booking.reserveStates;

import sa.booking.Reserve;

public class ReserveWaiting implements IReserveState {

	private Reserve			reserve;

	public ReserveWaiting(Reserve reserve) {
		// TODO Auto-generated constructor stub
		this.reserve = reserve;
	}

	@Override
	public void update() {
		// Copie el comportamiento que tiene update de ReserveBooked y lo aplique aca
		this.getReserve().setState(new ReserveBooked(this.getReserve()));
		

	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		this.getReserve().getBooking().removeWaiting(this.getReserve());
	}

	@Override
	public boolean isCancelled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reserve getReserve() {
		// TODO Auto-generated method stub
		return this.reserve;
	}

}
