package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Payments;

public interface IPaymentsRepository extends CrudRepository<Payments, String>{

}
