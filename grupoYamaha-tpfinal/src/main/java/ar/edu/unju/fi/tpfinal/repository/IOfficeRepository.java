package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Office;


/**
 *Es una interfaz que se extiende a los metodos de crudrepository utilizandolos 
 *para la entidad  Office que tiene una clave primaria valores Long.
 *y que crea un metodo de busqueda de codigo de producucto(Office)
 */  
public interface IOfficeRepository extends CrudRepository< Office, Long> {

}
