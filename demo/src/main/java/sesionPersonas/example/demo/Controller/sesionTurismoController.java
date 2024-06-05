package sesionPersonas.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sesionPersonas.example.demo.Model.Reseña;
import sesionPersonas.example.demo.Model.Usuarios;
import sesionPersonas.example.demo.Service.sesionTurismoService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class sesionTurismoController {

    private final sesionTurismoService turismoService;

    public sesionTurismoController(sesionTurismoService turismoService) {
        this.turismoService = turismoService;
    }

    @GetMapping("/usuarios")
    public List<Usuarios> obtenerTodosLosUsuarios() {
        return turismoService.obtenerTodosLosUsuarios();
    }

    @PostMapping("/login")
    public Usuarios login(@RequestBody Usuarios usuario) {
        System.out.println("Nombre de usuario recibido: " + usuario.getNombre());
        System.out.println("Nombre de usuario recibido: " + usuario.getContraseña());
        return turismoService.login(usuario);
    }

    // Nuevo endpoint para crear un usuario
    @PostMapping("/crearUsuario")
    public Usuarios crearUsuario(@RequestBody Usuarios usuario) {
        return turismoService.crearUsuario(usuario);
    }

    @PostMapping("/crearResena")
    public ResponseEntity<Reseña> crearResena(@RequestBody Reseña resena) {
        Reseña nuevaResena = turismoService.crearResena(resena);
        return ResponseEntity.ok().body(nuevaResena);
    }

    // Endpoint para obtener todas las reseñas
    @GetMapping("/reseñas")
    public List<Reseña> obtenerTodasLasReseñas() {
        return turismoService.obtenerTodasLasReseñas();
    }
}
