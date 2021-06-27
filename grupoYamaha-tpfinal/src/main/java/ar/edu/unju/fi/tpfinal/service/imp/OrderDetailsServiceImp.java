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
import ar.edu.unju.fi.tpfinal.repository.IOrderDetailsRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailsService;

/**
*
*/
@Service
public class OrderDetailsServiceImp implements IOrderDetailsService {


    @Autowired
    private IOrderDetailsRepository orderDetailsRepository;
    /**
    *
    */
    @Override
    public OrderDetail guardarOrderDetails(OrderDetail orderDetails) {
        
        return orderDetailsRepository.save(orderDetails);
    }
    /**
    *
    */
    @Override
    public List<OrderDetail> obtenerOrderDetails() {
        
        List<OrderDetail> orderDetails = (List<OrderDetail>) orderDetailsRepository.findAll();
        return orderDetails;
    }
    /**
    *
    */
    @Override
    public Optional<OrderDetail> obtenerOrderDetailsPorId(Long id) {

        Optional<OrderDetail> ordersDetails = orderDetailsRepository.findById(id);
		return ordersDetails;
    }
    /**
    *
    */
    @Override
    public void eliminarOrderDetails(Long id) {
    
        orderDetailsRepository.deleteById(id);
    }
    /**
    *
    */
	@Override
	public List<OrderDetail> obtenerOrderDetailsporProductCode(String productCode) {
		
		List<OrderDetail> orderdetails = orderDetailsRepository.findByIdProductCodeProductCode(productCode);
		
		return orderdetails;
	}
    
}