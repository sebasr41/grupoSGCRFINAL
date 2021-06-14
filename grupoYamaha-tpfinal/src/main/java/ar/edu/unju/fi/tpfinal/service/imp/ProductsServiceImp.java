package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.ProductLines;
import ar.edu.unju.fi.tpfinal.model.Products;
import ar.edu.unju.fi.tpfinal.repository.IProductsRepository;
import ar.edu.unju.fi.tpfinal.service.IProductsService;
@Service
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

    @Override
    public Object buscarProducts(String productLinesName) {
        List<Products> products = new ArrayList<Products>();
		if(!productLinesName.isEmpty()) {
			products = productsRepository.findByproductName(productLinesName);
		}
		return products;
    }
    
}
