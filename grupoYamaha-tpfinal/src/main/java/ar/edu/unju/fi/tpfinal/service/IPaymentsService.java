package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;


import ar.edu.unju.fi.tpfinal.model.Payments;
import ar.edu.unju.fi.tpfinal.model.PaymentsId;

public interface IPaymentsService {

	public void guardarPayments(Payments payments);

	public void eliminarPayments(PaymentsId id);

	public List<Payments> obtenerPayments();

	public Optional<Payments> getPaymentsPorId(PaymentsId id);


}
