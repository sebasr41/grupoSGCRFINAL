package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;


import ar.edu.unju.fi.tpfinal.model.Payments;


public interface IPaymentsService {

	public void guardarPayments(Payments payments);

	public List<Payments> obtenerPayments();

	public Optional<Payments> obtenerPaymentsPorId(String id);
	
	public void eliminarPayments(String id);

}
