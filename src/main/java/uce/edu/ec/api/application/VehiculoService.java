package uce.edu.ec.api.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.api.application.representation.VehiuloRepresentation;
import uce.edu.ec.api.domain.Vehiculo;
import uce.edu.ec.api.interfaces.VehiculoRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class VehiculoService {
    @Inject
    private VehiculoRepository vehiculoRepository;

    private VehiuloRepresentation mapperToVR(Vehiculo vehiculo){
        VehiuloRepresentation vehRepre = new VehiuloRepresentation();
        vehRepre.id = vehiculo.id;
        vehRepre.marca = vehiculo.marca;
        vehRepre.chasis = vehiculo.chasis;
        vehRepre.fechamatricula = vehiculo.fechamatricula;
        vehRepre.fechafabricacion = vehiculo.fechafabricacion;
        return vehRepre;
    }

    private Vehiculo mapperToVehiculo(VehiuloRepresentation vehRepre){
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.marca = vehRepre.marca;
        vehiculo.chasis = vehRepre.chasis;
        vehiculo.fechamatricula = vehRepre.fechamatricula;
        vehiculo.fechafabricacion = vehRepre.fechafabricacion;
        return vehiculo;
    }

    public List<VehiuloRepresentation> listarTodos(){
        return vehiculoRepository.listAll()
                .stream()
                .map(this::mapperToVR)
                .collect(Collectors.toList());
    }

    public VehiuloRepresentation obtenerPorId(Long id){
        Vehiculo vehiculo = vehiculoRepository.findById(id);
        if(vehiculo == null){
            return null;
        }
        return mapperToVR(vehiculo);
    }

    @Transactional
    public VehiuloRepresentation crear(VehiuloRepresentation vehRepre){
        Vehiculo vehiculo = mapperToVehiculo(vehRepre);
        vehiculoRepository.persist(vehiculo);
        return mapperToVR(vehiculo);
    }

    @Transactional
    public VehiuloRepresentation actualizar(Long id, VehiuloRepresentation vehRepre){
        Vehiculo vehiculo = vehiculoRepository.findById(id);
        if(vehiculo == null){
            return null;
        }
        vehiculo.marca = vehRepre.marca;
        vehiculo.chasis = vehRepre.chasis;
        vehiculo.fechamatricula = vehRepre.fechamatricula;
        vehiculo.fechafabricacion = vehRepre.fechafabricacion;
        vehiculoRepository.persist(vehiculo);
        return mapperToVR(vehiculo);
    }

    @Transactional
    public boolean eliminar(Long id){
        Vehiculo vehiculo = vehiculoRepository.findById(id);
        if(vehiculo == null){
            return false;
        }
        vehiculoRepository.delete(vehiculo);
        return true;
    }
}
