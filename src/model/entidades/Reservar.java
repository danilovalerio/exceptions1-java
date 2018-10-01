package model.entidades;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservar {
	
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	
	public Reservar(Integer numeroQuarto, Date checkIn, Date checkOut) {
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public long duracaoHospedagem() {
		//retorna a diferença das datas em mmilisegundos
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void atualizarDatas(Date checkin, Date checkout) {
		this.checkIn = checkin;
		this.checkOut = checkout;
	}

	@Override
	public String toString() {
		return "\nReserva confirmada:\n Quarto: " + numeroQuarto + 
				", \n Check-In: " + checkIn + 
				", \n Check-Out: " + checkOut + 
				", \n Diárias: "+ duracaoHospedagem() +
				"\n--------------------------------------";
	}
	
	
	
	
	

}
