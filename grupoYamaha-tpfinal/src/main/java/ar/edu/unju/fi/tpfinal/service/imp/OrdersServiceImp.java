package ar.edu.unju.fi.tpfinal.service.imp;
/**
 * 
 * @author RCGS
 */
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.repository.IOrderRepository;
import ar.edu.unju.fi.tpfinal.service.IOrdersService;

/**
*
*/
@Service
public class OrdersServiceImp implements IOrdersService {

    @Autowired
    private IOrderRepository ordersRepository;
    /**
    *
    */
    @Override
    public Order guardarOrders(Order orders) {
        return ordersRepository.save(orders);

    }
    /**
    *
    */
    @Override
    public List<Order> obtenerOrders() {
        List<Order> orders = (List<Order>) ordersRepository.findAll();
        return orders;
    }
    /**
    *
    */
    @Override
    public Optional<Order> obtenerOrdersPorId(Long id) {
        Optional<Order> orders = ordersRepository.findById(id);
		return orders;
    }
    /**
    *
    */
    @Override
    public void eliminarOrders(Long id) {
        ordersRepository.deleteById(id);
        
    }
    /**
    *
    */
	@Override
	public List<Order> obtenerOrdersPorcustomerNumber(Long customerNumber) {
        List<Order> orders = ordersRepository.findByCustomersCustomerNumber(customerNumber);
		
		return orders;
	}
    
}
