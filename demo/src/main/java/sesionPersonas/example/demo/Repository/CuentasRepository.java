package sesionPersonas.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import sesionPersonas.example.demo.Model.Usuarios;

public interface CuentasRepository extends MongoRepository<Usuarios, String> {
    Usuarios findByNombre(String nombre);
}
