//RAFAEL ERVEY CABRERA PENNA - CICLO 4 REFUERZO 2 (SPRING 3 Y 4)

package co.edu.unab.api.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.api.models.ClienteModel;
import co.edu.unab.api.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    //Obtener Listado de Clientes
    public ArrayList<ClienteModel> obtenerClientes(){
        return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }

    //Registrar / Actualizar Cliente
    public ClienteModel guardarCliente(ClienteModel cliente){
        cliente.setNombre(cliente.getNombre()); //).toLowerCase()); //Opcional, convertir la cadena a minúscula para facilitar buscar por nombre , esto normalmente se hace desde el frontend 
        return clienteRepository.save(cliente);
    }
    //Eliminar Cliente
    public boolean eliminarCliente(String id){

        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return true;
        }else{
            return false;
        }      
                             
    }   
    //Buscar por Id   
    public Optional<ClienteModel> obtenerClientePorId(String id){
        
        return clienteRepository.findById(id);
    }  

    //Buscar por Nombre
    public ArrayList<ClienteModel> obtenerClientesPorNombre(String nombre){

        return clienteRepository.findByNombre(nombre);
    }

    //Buscar por Telefono
    public ArrayList<ClienteModel> obtenerClientesPorTelefono(String telefono){

        return clienteRepository.findByTelefono(telefono);
    }
    
    // Buscar por Ciudad y Departamento    
    public ArrayList<ClienteModel> clientesPorCiudad(String ciudad, String departamento){

        return clienteRepository.clientexCiudad(ciudad, departamento);
    }

    //Buscar Por Mayores Puntos
    public ArrayList<ClienteModel> clientesMayorOIgualPuntos(Long puntos){
        return clienteRepository.findByPuntosGreaterThanEqual(puntos);

    }
    //Buscar Por Menores Puntos
    public ArrayList<ClienteModel> clientesMenorOIgualPuntos(Long puntos){
        return clienteRepository.clientesPorMenorPuntos(puntos);

    }

    //Buscar Por Nombre y Apellido
    public ArrayList<ClienteModel> clientePorNombreYApellidos(String nombre, String apellido){
        return clienteRepository.clientexnombreyapellido(nombre, apellido);
    
    }

    //Buscar Por Solo Departamento
    public ArrayList<ClienteModel> clientePorDepartamento(String departamento){
        return clienteRepository.clientexDepartamento(departamento);
    }

    //Buscar Por Telefono
    public ArrayList<ClienteModel> clientePorTelefono(String telefono){
        return clienteRepository.clientexTelefono(telefono);

    }

    //Buscar y Listar por el número de puntos
    public ArrayList<ClienteModel> obtenerClientesPorPuntos(Long puntos){

        return clienteRepository.findByPuntos(puntos);
    }


   
}