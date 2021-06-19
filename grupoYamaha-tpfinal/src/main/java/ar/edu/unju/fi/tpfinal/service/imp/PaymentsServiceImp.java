package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Payments;
import ar.edu.unju.fi.tpfinal.repository.IPaymentsRepository;
import ar.edu.unju.fi.tpfinal.service.IPaymentsService;

@Service
public class PaymentsServiceImp implements IPaymentsService{

	@Autowired
	private IPaymentsRepository paymentsRepository;

	@Override
	public Payments guardarPayments(Payments payments) {
		// TODO Auto-generated method stub
		return paymentsRepository.save(payments);
	}

	@Override
	public List<Payments> obtenerPayments() {
		// TODO Auto-generated method stub
		List<Payments> payments = (List<Payments>) paymentsRepository.findAll();
		return payments;
	}

	@Override
	public Optional<Payments> obtenerPaymentsPorId(String id) {
		// TODO Auto-generated method stub
		Optional<Payments> payments = paymentsRepository.findById(id);
		return payments;
	}

	@Override
	public void eliminarPayments(String id) {
		// TODO Auto-generated method stub
		paymentsRepository.deleteById(id);
	}

		}
