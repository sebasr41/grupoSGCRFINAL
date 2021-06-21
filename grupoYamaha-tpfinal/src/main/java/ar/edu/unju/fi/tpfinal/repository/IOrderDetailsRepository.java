package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.OrderDetails;

public interface IOrderDetailsRepository extends CrudRepository<OrderDetails, Long> {
	
	List<OrderDetails> findByIdProductCodeProductCode(String productCode);
    
}