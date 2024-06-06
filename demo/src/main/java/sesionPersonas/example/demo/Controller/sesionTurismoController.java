package sesionPersonas.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sesionPersonas.example.demo.Model.Reseña;
import sesionPersonas.example.demo.Model.Usuarios;
import sesionPersonas.example.demo.Service.sesionTurismoService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class sesionTurismoController {

    @Autowired
    private sesionTurismoService turismoService;

    @GetMapping("/usuarios")
    public List<Usuarios> obtenerTodosLosUsuarios() {
        return turismoService.obtenerTodosLosUsuarios();
    }

    @PostMapping("/login")
    public Usuarios login(@RequestBody Usuarios usuario) {
        return turismoService.login(usuario);
    }

    @PostMapping("/crearUsuario")
    public Usuarios crearUsuario(@RequestBody Usuarios usuario) {
        return turismoService.crearUsuario(usuario);
    }

    @PostMapping("/crearResena")
    public ResponseEntity<Reseña> crearResena(@RequestBody Reseña resena) {
        Reseña nuevaResena = turismoService.crearResena(resena);
        return ResponseEntity.ok().body(nuevaResena);
    }

    @GetMapping("/reseñas")
    public List<Reseña> obtenerTodasLasReseñas() {
        return turismoService.obtenerTodasLasReseñas();
    }

    @PutMapping("/actualizarResena/{id}")
    public ResponseEntity<Reseña> actualizarResena(@PathVariable int id, @RequestBody Reseña resena) {
        Reseña resenaActualizada = turismoService.actualizarResena(id, resena);
        return ResponseEntity.ok().body(resenaActualizada);
    }
}
