package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.ProductLines;
import ar.edu.unju.fi.tpfinal.repository.IProductLinesRepository;
import ar.edu.unju.fi.tpfinal.service.IProductLinesService;

@Service
public class ProductLinesServiceImp implements IProductLinesService {

	@Autowired
	private IProductLinesRepository productLinesRepository;
	
	@Override
	public void guardarProductLines(ProductLines productLines) {
		
		productLinesRepository.save(productLines);
		
	}

	@Override
	public void eliminarProductLines(Long id) {
		productLinesRepository.deleteById(id);		
	}

	@Override
	public List<ProductLines> obtenerProductLines() {
		List<ProductLines> productLines= (List<ProductLines>) productLinesRepository.findAll();
		return productLines;
	}


	@Override
	public Optional<ar.edu.unju.fi.model.ProductLines> getProductolinesPorId(Long id) {
		Optional<ProductLines> productLines = productLinesRepository.findById(id);
		return productLines;
	}

}
