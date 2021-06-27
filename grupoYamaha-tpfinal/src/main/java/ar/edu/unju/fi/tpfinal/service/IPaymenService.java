package ar.edu.unju.fi.tpfinal.service;
/**
 * 
 * @author RCGS
 */
import java.util.List;

import ar.edu.unju.fi.tpfinal.model.Payment;

public interface IPaymenService {
	
	public void guardarPayment(Payment payment) ;
	
	public List<Payment> obtenerPayments();
	

}
