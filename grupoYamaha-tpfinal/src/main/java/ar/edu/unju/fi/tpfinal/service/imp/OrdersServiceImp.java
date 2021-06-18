package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Orders;
import ar.edu.unju.fi.tpfinal.repository.IOrdersRepository;
import ar.edu.unju.fi.tpfinal.service.IOrdersService;

@Service
public class OrdersServiceImp implements IOrdersService {

    @Autowired
    private IOrdersRepository ordersRepository;

    @Override
    public Orders guardarOrders(Orders orders) {
        return ordersRepository.save(orders);

    }

    @Override
    public List<Orders> obtenerOrders() {
        List<Orders> orders = (List<Orders>) ordersRepository.findAll();
        return orders;
    }

    @Override
    public Optional<Orders> obtenerOrdersPorId(Long id) {
        Optional<Orders> orders = ordersRepository.findById(id);
		return orders;
    }

    @Override
    public void eliminarOrders(Long id) {
        ordersRepository.deleteById(id);
        
    }
    
}
