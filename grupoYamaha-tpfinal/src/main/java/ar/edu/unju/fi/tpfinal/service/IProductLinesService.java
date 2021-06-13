package ar.edu.unju.fi.tpfinal.service;

import java.util.List;


public interface IProductLinesService {
	
	public void guardarProductLines(ProductLines productLine);

	public void eliminarProductLines(Long id);

	public List<ProductLines> obtenerProductLines();

}
