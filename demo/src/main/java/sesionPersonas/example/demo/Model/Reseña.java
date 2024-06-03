package sesionPersonas.example.demo.Model;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "reseñas")
@Data
public class Reseña {

    private int id; // Cambiado el tipo de datos a int

    private int valor;
    private String comentario;
    private String usuarioID;
    private String datoID;
    private String estadoID;

    // Constructor, getters y setters
}
