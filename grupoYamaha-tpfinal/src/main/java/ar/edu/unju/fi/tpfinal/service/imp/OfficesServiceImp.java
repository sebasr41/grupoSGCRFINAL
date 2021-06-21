package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Offices;
import ar.edu.unju.fi.tpfinal.repository.IOfficesRepository;
import ar.edu.unju.fi.tpfinal.service.IOfficesService;
@Service
public class OfficesServiceImp implements IOfficesService {
    @Autowired
    private IOfficesRepository officesRepository;
	@Override
	public Offices guardarOffices(Offices offices) {
		// TODO Auto-generated method stub
		return officesRepository.save(offices);
	}

	@Override
	public void eliminarOffices(Long id) {
		officesRepository.deleteById(id);		
		
	}

	@Override
	public List<Offices> obtenerOffices() {
		List<Offices> offices= (List<Offices>) officesRepository.findAll();
		return offices;
	}

	@Override
	public Optional<Offices> getOfficesPorId(Long id) {
		Optional<Offices> offices = officesRepository.findById(id);
		return offices;
	}
}
