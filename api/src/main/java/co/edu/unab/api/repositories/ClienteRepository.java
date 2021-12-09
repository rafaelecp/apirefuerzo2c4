//RAFAEL ERVEY CABRERA PENNA - CICLO 4 REFUERZO 2 (SPRING 3 Y 4)

package co.edu.unab.api.repositories;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unab.api.models.ClienteModel;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteModel , String> {
    
    //Buscar por Nombre
    ArrayList<ClienteModel> findByNombre(String nombre);

    ArrayList<ClienteModel> findByTelefono(String telefono);

    // Buscar por Ciudad y Departamento
    @Query(value= "{'address.ciudad':?0, 'address.departamento':?1}", fields ="{'nombre':1, 'apellido':1}")
    ArrayList<ClienteModel> clientexCiudad(String ciudad, String departamento);

    //Buscar Por Mayores Puntos
    ArrayList<ClienteModel> findByPuntosGreaterThanEqual(Long puntos);

    //Buscar Por Menores Puntos
    @Query("{'puntos':{$lte:?0}}")
    ArrayList<ClienteModel> clientesPorMenorPuntos(Long puntos);

    //Buscar Por Nombre y Apellido
    @Query("{'nombre':?0, 'apellido':?1}")
    ArrayList<ClienteModel> clientexnombreyapellido(String nombre, String apellido);

    //Buscar por Telefono
    @Query("{'telefono':?0}")
    ArrayList<ClienteModel> clientexTelefono(String telefono);

    //Buscar Por Solo Departamento
    @Query("{'address.departamento':?0}")
    ArrayList<ClienteModel> clientexDepartamento(String departamento);

    //Buscar y Listar por el número de puntos
    //ArrayList<ClienteModel> findByPuntos(Long puntos);
    @Query(value= "{'puntos':?0}", fields ="{'nombre':1, 'apellido':1, 'telefono':1}")
    ArrayList<ClienteModel> findByPuntos(Long puntos);
 
}

    