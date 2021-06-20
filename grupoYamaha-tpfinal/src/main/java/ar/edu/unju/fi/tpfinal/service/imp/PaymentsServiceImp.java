package ar.edu.unju.fi.tpfinal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Payments;
import ar.edu.unju.fi.tpfinal.repository.IPaymentRepository;
import ar.edu.unju.fi.tpfinal.service.IPaymenService;
@Service
public class PaymentsServiceImp implements IPaymenService{

	@Autowired
	private IPaymentRepository paymentsRepository;
	
	
	@Override
	public void guardarPayment(Payments payment) {
		// TODO Auto-generated method stub
		paymentsRepository.save(payment);
	}

}
