package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Products;

public interface IProductsService{
    
    public void guardarProducts(Products products);
    
    public List<Products> obtenerProducts();
    
	public void eliminarProducts(Long id);

	public Optional<Products> obtenerProductsPorId(Long id);

    public Object buscarProducts(String productLinesName);
}
