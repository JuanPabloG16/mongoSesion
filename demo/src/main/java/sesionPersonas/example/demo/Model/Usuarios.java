package sesionPersonas.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "users")
@Data
public class Usuarios {

    @Id
    private String id;

    private String nombre;
    private String contrasena;
    private Number rol;
}
