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
    private int ultimoIdReseña = 0; // Variable para mantener el último identificador utilizado

    public sesionTurismoService(CuentasRepository cuentasRepository, ReseñaRepository reseñaRepository) {
        this.cuentasRepository = cuentasRepository;
        this.reseñaRepository = reseñaRepository;
    }

    public List<Usuarios> obtenerTodosLosUsuarios() {
        return cuentasRepository.findAll();
    }

    public Usuarios login(Usuarios usuario) {
        // Asegúrate de que el usuario recibido tenga los datos correctos
        LOGGER.info("Nombre de usuario recibido en el servicio: " + usuario.getNombre());
        Usuarios usuarioEncontrado = cuentasRepository.findByNombre(usuario.getNombre());
        if (usuarioEncontrado == null) {
            throw new ResourceNotFoundException("Usuario no encontrado");
        } else if (usuarioEncontrado.getContraseña().equals(usuario.getContraseña())) {
            return usuarioEncontrado;
        } else {
            throw new RuntimeException("Contraseña incorrecta");
        }
    }

    // Nuevo método para crear un usuario
    public Usuarios crearUsuario(Usuarios usuario) {
        // Asignar rol 2 automáticamente
        usuario.setRol(2);
        return cuentasRepository.save(usuario);
    }

    // Método para obtener todas las reseñas
    public List<Reseña> obtenerTodasLasReseñas() {
        return reseñaRepository.findAll();
    }

    public Reseña crearResena(Reseña resena) {
        LOGGER.info("Creando reseña: " + resena.toString());
        
        // Asignamos el siguiente identificador disponible
        resena.setId(++ultimoIdReseña);
        
        try {
            Reseña nuevaReseña = reseñaRepository.save(resena);
            LOGGER.info("Reseña creada con éxito: " + nuevaReseña.toString());
            return nuevaReseña;
        } catch (Exception e) {
            LOGGER.error("Error al crear la reseña: " + e.getMessage());
            throw e;
        }
    }
}
