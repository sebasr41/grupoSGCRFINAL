package ar.edu.unju.fi.tpfinal.service.imp;
/**
 * 
 * @author RCGS
 */
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.repository.IPaymentRepository;
import ar.edu.unju.fi.tpfinal.service.IPaymenService;
/**
*
*/
@Service
public class PaymentsServiceImp implements IPaymenService{

	@Autowired
	private IPaymentRepository paymentsRepository;
	
	/**
	 *
	 */
	@Override
	public void guardarPayment(Payment payment) {
		// TODO Auto-generated method stub
		paymentsRepository.save(payment);
	}

	/**
	 *
	 */
	@Override
	public List<Payment> obtenerPayments() {
		List<Payment> payments = (List<Payment>) paymentsRepository.findAll();
		return payments;
	}

}
