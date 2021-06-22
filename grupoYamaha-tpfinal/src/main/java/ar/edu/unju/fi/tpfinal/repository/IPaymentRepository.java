package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Payments;
import ar.edu.unju.fi.tpfinal.model.PaymentsId;

public interface IPaymentRepository extends CrudRepository<Payments, PaymentsId>{

	
}
