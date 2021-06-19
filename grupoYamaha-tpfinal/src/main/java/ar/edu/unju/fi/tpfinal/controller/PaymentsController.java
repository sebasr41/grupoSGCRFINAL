package ar.edu.unju.fi.tpfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ar.edu.unju.fi.tpfinal.model.Payments;

public class PaymentsController {

	@Autowired
	private Payments payments;
	
	@GetMapping("/pago")
	public String getPaymentsPage(Model model){
		model.addAttribute(payments);
		return "nuevo-pago";
	}

}
