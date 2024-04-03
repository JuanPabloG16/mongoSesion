package sesionPersonas.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import sesionPersonas.example.demo.Exception.ResourceNotFoundException;
import sesionPersonas.example.demo.Model.Usuarios;
import sesionPersonas.example.demo.Repository.CuentasRepository;

@Service
public class sesionTurismoService {

    private final CuentasRepository cuentasRepository;

    public sesionTurismoService(CuentasRepository cuentasRepository) {
        this.cuentasRepository = cuentasRepository;
    }

    public List<Usuarios> obtenerTodosLosUsuarios() {
        return cuentasRepository.findAll();
    }

    public Usuarios login(Usuarios usuario) {
        Usuarios usuarioEncontrado = cuentasRepository.findByNombre(usuario.getNombre());
        if (usuarioEncontrado == null) {
            throw new ResourceNotFoundException("Usuario no encontrado");
        } else if (usuarioEncontrado.getContrasena().equals(usuario.getContrasena())) {
            return usuarioEncontrado;
        } else {
            throw new RuntimeException("Contraseña incorrecta");
        }
    }
}
