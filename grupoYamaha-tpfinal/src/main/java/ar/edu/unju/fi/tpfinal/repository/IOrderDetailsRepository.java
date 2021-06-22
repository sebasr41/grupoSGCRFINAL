package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.OrderDetails;
import ar.edu.unju.fi.tpfinal.model.OrderDetailsId;

public interface IOrderDetailsRepository extends CrudRepository<OrderDetails, OrderDetailsId> {
    

}
