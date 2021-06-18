package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;



import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Products;

public interface IProductsRepository extends CrudRepository<Products,String> {

    List<Products> findByProductNameAndProductLinesProductLinesNameAndBuyPriceGreaterThanEqual(String productsName, String id,double price);
	
    List<Products> findByProductNameAndBuyPriceGreaterThanEqual(String id, double price);

    List<Products> findByBuyPriceGreaterThanEqual(double price);
    
    List<Products> findByProductLinesProductLinesNameAndBuyPriceGreaterThanEqual(String id, double price);

}
