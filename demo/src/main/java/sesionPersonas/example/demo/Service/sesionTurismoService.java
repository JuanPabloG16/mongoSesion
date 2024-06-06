package sesionPersonas.example.demo.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import sesionPersonas.example.demo.Exception.ResourceNotFoundException;
import sesionPersonas.example.demo.Model.Reseña;
import sesionPersonas.example.demo.Model.Usuarios;
import sesionPersonas.example.demo.Repository.CuentasRepository;
import sesionPersonas.example.demo.Repository.ReseñaRepository;

import java.util.List;

@Service
public class sesionTurismoService {

    private final CuentasRepository cuentasRepository;
    private final ReseñaRepository reseñaRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(sesionTurismoService.class);

    public sesionTurismoService(CuentasRepository cuentasRepository, ReseñaRepository reseñaRepository) {
        this.cuentasRepository = cuentasRepository;
        this.reseñaRepository = reseñaRepository;
    }

    public List<Usuarios> obtenerTodosLosUsuarios() {
        return cuentasRepository.findAll();
    }

    public Usuarios login(Usuarios usuario) {
        Usuarios usuarioEncontrado = cuentasRepository.findByNombre(usuario.getNombre());
        if (usuarioEncontrado == null) {
            throw new ResourceNotFoundException("Usuario no encontrado");
        } else if (usuarioEncontrado.getContraseña().equals(usuario.getContraseña())) {
            return usuarioEncontrado;
        } else {
            throw new RuntimeException("Contraseña incorrecta");
        }
    }

    public Usuarios crearUsuario(Usuarios usuario) {
        usuario.setRol(2);
        return cuentasRepository.save(usuario);
    }

    public List<Reseña> obtenerTodasLasReseñas() {
        return reseñaRepository.findAll();
    }

    public Reseña crearResena(Reseña resena) {
        LOGGER.info("Creando reseña: " + resena.toString());
        return reseñaRepository.save(resena);
    }

    public Reseña actualizarResena(int id, Reseña resenaDetalles) {
        Reseña resena = reseñaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reseña no encontrada para este id :: " + id));
        resena.setValor(resenaDetalles.getValor());
        resena.setComentario(resenaDetalles.getComentario());
        resena.setUsuarioID(resenaDetalles.getUsuarioID());
        resena.setDatoID(resenaDetalles.getDatoID());
        resena.setEstadoID(resenaDetalles.getEstadoID());
        final Reseña resenaActualizada = reseñaRepository.save(resena);
        return resenaActualizada;
    }
}
