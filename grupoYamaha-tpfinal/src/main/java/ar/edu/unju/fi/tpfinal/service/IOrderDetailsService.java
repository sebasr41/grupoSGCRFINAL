package ar.edu.unju.fi.tpfinal.service;
/**
 * 
 * @author RCGS
 */
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;

public interface IOrderDetailsService {
    	
	public OrderDetail guardarOrderDetails(OrderDetail orderDetails);
	
	public List<OrderDetail> obtenerOrderDetails();
	
	public Optional<OrderDetail> obtenerOrderDetailsPorId(Long id);
	
	public void eliminarOrderDetails(Long id);
	
	public List<OrderDetail> obtenerOrderDetailsporProductCode(String productCode);

    
}