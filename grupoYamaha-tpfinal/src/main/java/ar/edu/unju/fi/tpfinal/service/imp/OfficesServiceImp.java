package ar.edu.unju.fi.tpfinal.service.imp;
/**
 * 
 * @author RCGS
 */
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.repository.IOfficeRepository;
import ar.edu.unju.fi.tpfinal.service.IOfficesService;
/**
*
*/
@Service
public class OfficesServiceImp implements IOfficesService {
    @Autowired
    private IOfficeRepository officesRepository;
	@Override
	public Office guardarOffices(Office offices) {
		// TODO Auto-generated method stub
		return officesRepository.save(offices);
	}
	/**
	 *
	 */
	@Override
	public void eliminarOffices(Long id) {
		officesRepository.deleteById(id);		
		
	}
	/**
	 *
	 */
	@Override
	public List<Office> obtenerOffices() {
		List<Office> offices= (List<Office>) officesRepository.findAll();
		return offices;
	}
	/**
	 *
	 */
	@Override
	public Optional<Office> getOfficesPorId(Long id) {
		Optional<Office> offices = officesRepository.findById(id);
		return offices;
	}
}
