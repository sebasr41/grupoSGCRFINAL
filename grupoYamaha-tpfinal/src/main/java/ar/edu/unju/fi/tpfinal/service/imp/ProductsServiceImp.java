package ar.edu.unju.fi.tpfinal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.tpfinal.repository.IProductsRepository;
import ar.edu.unju.fi.tpfinal.service.IProductsService;
import ar.edu.unju.fi.tpfinal.service.List;
import ar.edu.unju.fi.tpfinal.service.Optional;
import ar.edu.unju.fi.tpfinal.service.Products;

public class ProductsServiceImp implements IProductsService{

    @Autowired
    private IProductsRepository productsRepository;

    @Override
    public void guardarProducts(Products products) {
        
        productsRepository.save(products);
    }

    @Override
    public List<Products> obtenerProducts() {
        List<Products> products = (List<Products>) productsRepository.findAll();
		return products;
    }

    @Override
    public void eliminarProducts(Long id) {
        
        productsRepository.deleteById(id);
    }

    @Override
    public Optional<Products> obtenerProductsPorId(Long id) {
        Optional<Products> products = productsRepository.findById(id);
		return products;
    }
    
}
