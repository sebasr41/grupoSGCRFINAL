package ar.edu.unju.fi.tpfinal.service.imp;
/**
 * 
 * @author RCGS
 */
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.repository.IProductRepository;
import ar.edu.unju.fi.tpfinal.service.IProductsService;
/**
 *
 */
@Service
public class ProductsServiceImp implements IProductsService{

    @Autowired
    private IProductRepository productsRepository;
    /**
     * 
     */
    @Override
    public void guardarProducts(Product products) {
        
        productsRepository.save(products);
    }
    
    /**
     * 
     */
    @Override
    public List<Product> obtenerProducts() {
        List<Product> products = (List<Product>) productsRepository.findAll();
		return products;
    }
    /**
     * 
     */
    @Override
    public void eliminarProducts(String id) {
        
        productsRepository.deleteById(id);
    }
    
    /**
     * 
     */
    @Override
    public Optional<Product> obtenerProductsPorId(String id) {
        Optional<Product> products = productsRepository.findById(id);
		return products;
    }
    /**
     * 
     */
	@Override
	public Object buscarProducts(String productsName,String id, double price) {
	
				//System.out.println("nombre " + productsName+ "id categoria "+id+ " precio "+ price );
		
		 List<Product> products = new ArrayList<Product>();
				
		        if(!productsName.isEmpty() && !id.isEmpty() && price >=0) {
					products = productsRepository.findByProductNameAndProductLinesProductLinesNameAndBuyPriceGreaterThanEqual(productsName, id, price);
				}else {
					if(!productsName.isEmpty()  && price >=0) {
						products = productsRepository.findByProductNameAndBuyPriceGreaterThanEqual(productsName,price);
					}
			        if(!id.isEmpty()  && price >=0) {
						products = productsRepository.findByProductLinesProductLinesNameAndBuyPriceGreaterThanEqual(id, price);
					}else if(productsName.isEmpty()&& id.isEmpty() && price >=0) {
						products= productsRepository.findByBuyPriceGreaterThanEqual(price);
					}
				}
		        
			return products;
		   }
		
		
	

  
	   
}
