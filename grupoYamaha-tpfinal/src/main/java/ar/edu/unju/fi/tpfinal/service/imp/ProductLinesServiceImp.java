package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp8.model.Compra;
import ar.edu.unju.fi.tpfinal.repository.IProductLinesRepository;
import ar.edu.unju.fi.tpfinal.service.IProductLinesService;
import ar.edu.unju.fi.tpfinal.service.ProductLines;

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

}
