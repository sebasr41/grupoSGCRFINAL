package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.OrderDetails;
import ar.edu.unju.fi.tpfinal.model.OrderDetailsId;
import ar.edu.unju.fi.tpfinal.repository.IOrderDetailsRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailsService;


@Service
public class OrderDetailsServiceImp implements IOrderDetailsService {


    @Autowired
    OrderDetailsId orderDetailsId;  

    @Autowired
    private IOrderDetailsRepository orderDetailsRepository;

	@Override
	public OrderDetails guardarOrderDetails(OrderDetails orderDetails) {
		// TODO Auto-generated method stub
		return orderDetailsRepository.save(orderDetails);
	}

	@Override
	public List<OrderDetails> obtenerOrderDetails() {
		// TODO Auto-generated method stub
	    List<OrderDetails> orderDetails = (List<OrderDetails>) orderDetailsRepository.findAll();
	    return orderDetails;

	}

	@Override
	public Optional<OrderDetails> obtenerOrderDetailsPorId(OrderDetailsId id) {
		// TODO Auto-generated method stub
	    Optional<OrderDetails> ordersDetails = orderDetailsRepository.findById(id);
		return ordersDetails;

	}

	@Override
	public void eliminarOrderDetails(OrderDetailsId OrderDetailsId) {
		// TODO Auto-generated method stub
	    orderDetailsRepository.deleteById(orderDetailsId);		
	}


}
