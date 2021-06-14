package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Products;

public interface IProductsRepository extends CrudRepository<Products,Long> {

    List<Products> findByProductNameAndBuyPriceGreaterThanEqual(String productLinesName, double price);

    List<Products> findByBuyPriceGreaterThanEqual(double price);
    
}
