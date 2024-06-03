package sesionPersonas.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sesionPersonas.example.demo.Model.Usuarios;
import sesionPersonas.example.demo.Service.sesionTurismoService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")  
public class sesionTurismoController {

    private final sesionTurismoService sesionTurismoService;

    public sesionTurismoController(sesionTurismoService sesionTurismoService) {
        this.sesionTurismoService = sesionTurismoService;
    }

    @GetMapping("/usuarios")
    public List<Usuarios> obtenerTodosLosUsuarios() {
        return sesionTurismoService.obtenerTodosLosUsuarios();
    }

    @PostMapping("/login")
    public Usuarios login(@RequestBody Usuarios usuario) {
        return sesionTurismoService.login(usuario);
    }

    // Nuevo endpoint para crear un usuario
    @PostMapping("/crearUsuario")
    public Usuarios crearUsuario(@RequestBody Usuarios usuario) {
        return sesionTurismoService.crearUsuario(usuario);
    }
}
