package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

public interface IOrderDetailsService {
    	
	public void guardarOrderDetails(OrderDetails orderDetails);
	
	public List<OrderDetails> obtenerOrderDetails();
	
	public Optional<OrderDetails> obtenerOrderDetailsPorId(Long id);
	
	public void eliminarOrderDetails(Long id);

    
}
