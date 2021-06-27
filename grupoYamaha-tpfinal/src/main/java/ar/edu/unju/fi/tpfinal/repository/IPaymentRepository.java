package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.model.PaymentId;

/**
 *Es una interfaz que se extiende a los metodos de crudrepository utilizandolos 
 *para la entidad Payment que tiene una clave a PaymentId
 */  
public interface IPaymentRepository extends CrudRepository<Payment, PaymentId>{

}
