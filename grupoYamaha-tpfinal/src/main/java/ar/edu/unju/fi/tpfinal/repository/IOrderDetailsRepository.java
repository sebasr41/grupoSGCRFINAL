package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;


/**
 *Es una interfaz que se extiende a los metodos de crudrepository utilizandolos 
 *para la entidad  OrderDetail que tiene una clave primaria valores Long.
 *y que crea un metodo de busqueda de codigo de producucto(productCode)
 */  
public interface IOrderDetailsRepository extends CrudRepository<OrderDetail, Long> {
	
	List<OrderDetail> findByIdProductCodeProductCode(String productCode);
    
}