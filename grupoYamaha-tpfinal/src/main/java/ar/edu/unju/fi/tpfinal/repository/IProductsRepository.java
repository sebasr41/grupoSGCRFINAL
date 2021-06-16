package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Products;

public interface IProductsRepository extends CrudRepository<Products,String> {

   // List<Products> findByProductNameAndProductLinesIdAndBuyPriceGreaterThanEqual(String productLinesName, Long id,double price);
	
    //List<Products> findByProductNameAndBuyPriceGreaterThanEqual(String id, double price);

    //List<Products> findByBuyPriceGreaterThanEqual(double price);
    
    //List<Products> findByProductLinesIdAndBuyPriceGreaterThanEqual(String id, double price);

}
