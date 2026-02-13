package uce.edu.ec.api.interfaces;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import uce.edu.ec.api.domain.Vehiculo;

@ApplicationScoped
public class VehiculoRepository implements PanacheRepositoryBase<Vehiculo,Long>{

}
