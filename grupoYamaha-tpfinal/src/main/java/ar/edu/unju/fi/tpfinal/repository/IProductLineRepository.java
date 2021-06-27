
package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.ProductLine;


/**
 *Es una interfaz que se extiende a los metodos de crudrepository utilizandolos 
 *para la entidad ProductLine que tiene una clave primaria de tipo String
 */  
public interface IProductLineRepository extends CrudRepository<ProductLine, String>{



}

