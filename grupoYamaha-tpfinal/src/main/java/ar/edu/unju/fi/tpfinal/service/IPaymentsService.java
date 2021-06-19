package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;


import ar.edu.unju.fi.tpfinal.model.Payments;

public interface IPaymentsService {

	public void guardarPayments(Payments payments);

	public void eliminarPayments(Long id);

	public List<Payments> obtenerPayments();

	public Optional<Payments> getPaymentsPorId(Long id);


}
