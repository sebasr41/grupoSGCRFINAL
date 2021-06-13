package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.model.ProductLines;


public interface IProductLinesService {
	
	public void guardarProductLines(ProductLines productLine);

	public void eliminarProductLines(Long id);

	public List<ProductLines> obtenerProductLines();

	public Optional<ProductLines> getProductolinesPorId(Long id);

}
