package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Orders;

public interface IOrdersRepository extends CrudRepository< Orders, Long> {
    
}
