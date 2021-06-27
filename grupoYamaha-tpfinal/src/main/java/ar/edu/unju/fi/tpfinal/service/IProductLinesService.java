package ar.edu.unju.fi.tpfinal.service;
/**
 * 
 * @author RCGS
 */
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.ProductLine;


public interface IProductLinesService {
	
	public void guardarProductLines(ProductLine productLine);

	public void eliminarProductLines(String id);

	public List<ProductLine> obtenerProductLines();

	public Optional<ProductLine> getProductolinesPorId(String id);

}
