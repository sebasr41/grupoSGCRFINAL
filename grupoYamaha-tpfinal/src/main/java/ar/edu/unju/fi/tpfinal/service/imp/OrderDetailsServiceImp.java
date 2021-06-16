package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.OrderDetails;
import ar.edu.unju.fi.tpfinal.repository.IOrderDetailsRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailsService;


@Service
public class OrderDetailsServiceImp implements IOrderDetailsService {


    @Autowired
    private IOrderDetailsRepository orderDetailsRepository;

    @Override
    public OrderDetails guardarOrderDetails(OrderDetails orderDetails) {
        
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public List<OrderDetails> obtenerOrderDetails() {
        
        List<OrderDetails> orderDetails = (List<OrderDetails>) orderDetailsRepository.findAll();
        return orderDetails;
    }

    @Override
    public Optional<OrderDetails> obtenerOrderDetailsPorId(Long id) {

        Optional<OrderDetails> ordersDetails = orderDetailsRepository.findById(id);
		return ordersDetails;
    }

    @Override
    public void eliminarOrderDetails(Long id) {
    
        orderDetailsRepository.deleteById(id);
    }
    
}
