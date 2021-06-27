package ar.edu.unju.fi.tpfinal.service;
/**
 * 
 * @author RCGS
 */
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Office;

public interface IOfficesService {

	public Office guardarOffices(Office offices);

	public void eliminarOffices(Long id);

	public List<Office> obtenerOffices();

	public Optional<Office> getOfficesPorId(Long id);
	

}