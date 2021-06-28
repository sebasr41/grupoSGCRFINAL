package ar.edu.unju.fi.tpfinal.service;
/**
 * 
 * @author RCGS
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.tpfinal.model.Usuario;
import ar.edu.unju.fi.tpfinal.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
	//Permite inyertar una dependencia, en este caso la clase UsuarioRepository 
    @Autowired
    UsuarioRepository usuarioRepository;
    
    /**
     * 
     * @return
     */
    public List<Usuario> lista(){
        return usuarioRepository.findAll();
    }

    /**
     * 
     * @param id
     * @return
     */
    public Optional<Usuario> getById(int id){
        return usuarioRepository.findById(id);
    }
    /**
     * 
     * @param nombreUsuario
     * @return
     */
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    /**
     * metodo Void
     * guarda los elemntos de la interfaz usuarioRepository, que a su vez se comunica con la clase Usuario
     * @param usuario
     * 
     */
    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    /**
     * 
     * @param id
     * @return un elemtno de la clase usuarioRepository
     */
    public boolean existsById(int id){
        return usuarioRepository.existsById(id);
    }
    /**
     * 
     * @param nombreUsuario
     * @return un elemtno de la clase usuarioRepository
     */
    public boolean existsByNombreusuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    /**
     * 
     * @param nombreUsuario
     * @return
     */
    public List<Usuario> getByCustomerCustomerName(Long id){
        return usuarioRepository.findByCustomersCustomerNumber(id);
    }
}
