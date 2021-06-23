package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.model.Payments;

public interface IPaymenService {
	
	public void guardarPayment(Payments payment) ;
	
	public List<Payments> obtenerPayments();
	

}
