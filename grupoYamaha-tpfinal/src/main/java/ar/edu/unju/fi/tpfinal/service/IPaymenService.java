package ar.edu.unju.fi.tpfinal.service;
/**
 * 
 * @author RCGS
 */
import java.util.List;

import ar.edu.unju.fi.tpfinal.model.Payment;
/**IPaymenService es una interfaz que permite minimizar el acomplamiento entre clases
* y tiene creado dentro de si los metodos Guardar, listar y obtener, los valores de Payment 
*/
public interface IPaymenService {
	/**
	 * Metodo guardar
	 * @param payment
	 */
	public void guardarPayment(Payment payment) ;
	/**
	 * Metodo Listar
	 * @return List<Payment>
	 */
	public List<Payment> obtenerPayments();
	

}
