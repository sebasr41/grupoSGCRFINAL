package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Offices;

public interface IOfficesService {

	public void guardarOffices(Offices offices);

	public void eliminarOffices(Long id);

	public List<Offices> obtenerOffices();

	public Optional<Offices> getOfficesPorId(Long id);
	

}
