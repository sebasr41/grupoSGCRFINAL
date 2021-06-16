package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.OrderDetails;

public interface IOrderDetailsService {
    	
	public OrderDetails guardarOrderDetails(OrderDetails orderDetails);
	
	public List<OrderDetails> obtenerOrderDetails();
	
	public Optional<OrderDetails> obtenerOrderDetailsPorId(Long id);
	
	public void eliminarOrderDetails(Long id);

    
}
