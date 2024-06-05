package sesionPersonas.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import sesionPersonas.example.demo.Model.Reseña;

public interface ReseñaRepository extends MongoRepository<Reseña, Integer> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
