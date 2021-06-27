package ar.edu.unju.fi.tpfinal.service.imp;
/**
 * 
 * @author RCGS
 */
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.repository.IProductLineRepository;
import ar.edu.unju.fi.tpfinal.service.IProductLinesService;

@Service
public class ProductLinesServiceImp implements IProductLinesService {

	@Autowired
	private IProductLineRepository productLinesRepository;
	/**
	 *
	 */
	@Override
	public void guardarProductLines(ProductLine productLines) {

		productLinesRepository.save(productLines);
		
	}
	/**
	 *
	 */
	@Override
	public void eliminarProductLines(String id) {
		productLinesRepository.deleteById(id);		
	}
	/**
	 *
	 */
	@Override
	public List<ProductLine> obtenerProductLines() {
		List<ProductLine> productLines= (List<ProductLine>) productLinesRepository.findAll();
		return productLines;
	}

	/**
	 *
	 */
	@Override
	public Optional <ProductLine> getProductolinesPorId(String id) {
		Optional<ProductLine> productLines = productLinesRepository.findById(id);
		return productLines;
	}


}


