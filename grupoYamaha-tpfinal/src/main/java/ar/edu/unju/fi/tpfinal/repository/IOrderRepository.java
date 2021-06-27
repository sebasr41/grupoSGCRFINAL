package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Order;


/**
 *Es una interfaz que se extiende a los metodos de crudrepository utilizandolos 
 *para la entidad  Order que tiene una clave primaria vlaores Long- Ademas de crear u metodo generico
 *de busqueda por numero de cliente (cusomerNumber)
 */  
public interface IOrderRepository extends CrudRepository< Order, Long> {

	List<Order> findByCustomersCustomerNumber(Long customerNumber);
    
}
