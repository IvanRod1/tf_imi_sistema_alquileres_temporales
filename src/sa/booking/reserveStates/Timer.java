package sa.booking.reserveStates;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sa.subscriptions.INotifyTimerSubscriber;

public class Timer implements INotifyTimer {

	private HashMap<LocalDate, Set<INotifyTimerSubscriber>> rsubscribers;
	private long miliseconds;
	
	public Timer(long miliseconds) {
		this.rsubscribers = new HashMap<LocalDate, Set<INotifyTimerSubscriber>>();
		this.miliseconds = miliseconds;
		this.tick(); 
	}

	private void tick() {
		// TODO Auto-generated method stub
		LocalDate currDate = LocalDate.now(); 
		for(int i=0; i <2;i++) {  //2 ticks maximo
			this.notify(currDate);
			
			try {Thread.sleep(this.miliseconds);}
			catch (InterruptedException e) { 	
				//Thread.currentThread().interrupt();
				e.printStackTrace();}
			
			currDate = LocalDate.now();
		
		}
	}

	@Override
	public void register(INotifyTimerSubscriber subscriber, LocalDate date) {
		// TODO Auto-generated method stub
		if (this.rsubscribers.containsKey(date)) {
			this.rsubscribers.get(date).add(subscriber);
		} else {
			HashSet<INotifyTimerSubscriber> rs = new HashSet<INotifyTimerSubscriber>();
			rs.add(subscriber);
			this.rsubscribers.put(date, rs);
		}		
	}

	@Override
	public void unregister(INotifyTimerSubscriber subscriber, LocalDate date) {
		// TODO Auto-generated method stub
//		this.rsubscribers.stream().dropWhile(bs -> bs.getBooking().equals(booking) &&
//												   bs.getReserve().equals(reserve) && 
//												   bs.getDate().equals(date)          );
		if (this.rsubscribers.containsKey(date)) {
			this.rsubscribers.get(date).remove(subscriber);
		}
	}

	@Override
	public void notify(LocalDate date) {
		// TODO Auto-generated method stub
//		this.rsubscribers.stream().filter(bs -> date.equals(bs.getDate()))
//								  .forEach(bs -> bs.getBooking().update(bs.getReserve(), date));
//		this.rsubscribers.get(date).stream().filter(r -> date.equals(r.getCheckIn()) || date.equals(r.getCheckOut()))
//											.forEach(r -> r.getBooking().update(r, date));
		if(rsubscribers.containsKey(date)) {
			for(INotifyTimerSubscriber reserveState: rsubscribers.get(date)) { //recorro la lista de estados que se anotaron para ser avisados
				reserveState.update();
			}
		}
	}

	public List<INotifyTimerSubscriber> getSubscribers() {
	
		//return this.rsubscribers.keySet().stream(). // FIXME: tomar los sets de cada key
		//return this.rsubscribers.values().stream().collect(Collectors.toList());
		
		
		//eturn rsubscribers.values().toArray();  PODRIAMOS USAR .VALUES PARA OBTENER TODOS LOS VALORES DEL MAP
		List<INotifyTimerSubscriber> subscribers = new ArrayList<INotifyTimerSubscriber>();
		for(LocalDate dateKey : rsubscribers.keySet()) { //Recorro una lista de keys del MAP
			subscribers.addAll(rsubscribers.get(dateKey)); // Agrego a la lista de susbscribers el valor de la key del for
		}
		
		return subscribers;

	}
}
