package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

public interface IOrdersService {

    public void guardarOrders(Orders orders);

	public List<Orders> obtenerOrders();

    public Optional<Orders> obtenerOrdersPorId(Long id);
	
	public void eliminarOrders(Long id);
    
}
