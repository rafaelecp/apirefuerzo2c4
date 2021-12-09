//RAFAEL ERVEY CABRERA PENNA - CICLO 4 REFUERZO 2 (SPRING 3 Y 4)

package co.edu.unab.api.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.api.models.ClienteModel;
import co.edu.unab.api.services.ClienteService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    //Obtener Listado de Clientes
    @GetMapping()
    public ArrayList<ClienteModel> obtenerClientes(){
        return  clienteService.obtenerClientes();
    }

    //Registrar / Actualizar Cliente
    @PostMapping()
    public ClienteModel guardarCliente(@RequestBody ClienteModel cliente){
        return clienteService.guardarCliente(cliente);
    }
    
    //Eliminar Cliente
    @DeleteMapping(path = "/{id}")
    public String eliminarClientePorId(@PathVariable("id") String id){
        boolean resultadoEliminar=this.clienteService.eliminarCliente(id);
        if (resultadoEliminar){
            return "Se eliminó el usuario con id: "+id;
        }else{
            return "No se pudo eliminar el usuario con el id: "+id;
        }
    }
    //Buscar por Id
    @GetMapping(path = "/{id}")
    public Optional<ClienteModel> obtenerClientePorId(@PathVariable("id") String id){
        return this.clienteService.obtenerClientePorId(id);
    }

     //Buscar por Nombre
    @GetMapping(path = "nombre/{nombre}")
    public ArrayList<ClienteModel> clientesporNombre(@PathVariable("nombre") String nombre){
        return this.clienteService.obtenerClientesPorNombre(nombre);
    }

     //Buscar por Telefono
     @GetMapping(path = "tele/{telefono}")
     public ArrayList<ClienteModel> clientesportelefono(@PathVariable("telefono") String telefono){
         return this.clienteService.obtenerClientesPorTelefono(telefono);
     }

    // Buscar por Ciudad y Departamento
    @GetMapping(path = "ubicacion/{ciudad}/{departamento}")
    public ArrayList<ClienteModel> clientesporUbicacion(@PathVariable("ciudad") String ciudad,
    @PathVariable("departamento") String departamento){
        return this.clienteService.clientesPorCiudad(ciudad, departamento);
    }

    //Buscar Por Mayores Puntos
    @GetMapping(path = "puntos/{puntos}")
    public ArrayList<ClienteModel> clientesPorMayorPuntos(@PathVariable("puntos") Long puntos){
        return this.clienteService.clientesMayorOIgualPuntos(puntos);
    }
    //Buscar Por Menores Puntos
    @GetMapping(path = "puntosm/{puntos}")
    public ArrayList<ClienteModel> clientespormenorPuntos(@PathVariable("puntos") Long puntos){
        return this.clienteService.clientesMenorOIgualPuntos(puntos);
    }
  
    //Buscar Por Nombre y Apellido
    @GetMapping(path = "nombreyapellido/{nombre}/{apellido}")
    public ArrayList<ClienteModel> clientexnombreyapellido(@PathVariable("nombre") String nombre,
    @PathVariable("apellido") String apellido){
        return this.clienteService.clientePorNombreYApellidos(nombre, apellido);
    }

    //Buscar por Telefono 2
    @GetMapping(path = "telefono/{telefono}")
    public ArrayList<ClienteModel> clientePorNumeroTelefono(@PathVariable("telefono") String telefono){
        return this.clienteService.clientePorTelefono(telefono);
    }

    //Buscar Por Solo Departamento
    @GetMapping(path = "departamento/{departamento}")
    public ArrayList<ClienteModel> clientePorDPTO(@PathVariable("departamento") String departamento){
        return this.clienteService.clientePorDepartamento(departamento);
    }

    //Buscar y Listar por el número de puntos
    @GetMapping(path = "totalpuntos/{puntos}")
    public ArrayList<ClienteModel> clientesPorTotalPuntos(@PathVariable("puntos") Long puntos){
        return this.clienteService.obtenerClientesPorPuntos(puntos);
    }

}