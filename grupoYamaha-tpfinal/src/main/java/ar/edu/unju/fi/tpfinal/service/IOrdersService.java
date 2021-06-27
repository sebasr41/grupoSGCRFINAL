package ar.edu.unju.fi.tpfinal.service;
/**
 * 
 * @author RCGS
 */
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.model.Order;

public interface IOrdersService {

    public Order guardarOrders(Order orders);

	public List<Order> obtenerOrders();

    public Optional<Order> obtenerOrdersPorId(Long id);
	
	public void eliminarOrders(Long id);
	public List<Order> obtenerOrdersPorcustomerNumber(Long customerNumber);
}
