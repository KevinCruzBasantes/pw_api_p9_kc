package uce.edu.ec.api.intrastructure;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.ec.api.application.VehiculoService;
import uce.edu.ec.api.application.representation.VehiuloRepresentation;

import java.util.List;

@ApplicationScoped
@Path("/vehiculos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VehiculoResorce {
    @Inject
    private VehiculoService vehiculoService;

    @GET
    public Response listarTodos() {
        List<VehiuloRepresentation> vehiculos = vehiculoService.listarTodos();
        return Response.ok(vehiculos).build();
    }

    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") Long id) {
        VehiuloRepresentation vehiculo = vehiculoService.obtenerPorId(id);
        if (vehiculo == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Vehículo no encontrado con ID: " + id)
                    .build();
        }
        return Response.ok(vehiculo).build();
    }

    @POST
    public Response crear(VehiuloRepresentation vehiculo) {
        if (vehiculo == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Datos del vehículo requeridos")
                    .build();
        }
        VehiuloRepresentation nuevoVehiculo = vehiculoService.crear(vehiculo);
        return Response.status(Response.Status.CREATED)
                .entity(nuevoVehiculo)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") Long id, VehiuloRepresentation vehiculo) {
        if (vehiculo == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Datos del vehículo requeridos")
                    .build();
        }
        VehiuloRepresentation vehiculoActualizado = vehiculoService.actualizar(id, vehiculo);
        if (vehiculoActualizado == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Vehículo no encontrado con ID: " + id)
                    .build();
        }
        return Response.ok(vehiculoActualizado).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Long id) {
        boolean eliminado = vehiculoService.eliminar(id);
        if (!eliminado) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Vehículo no encontrado con ID: " + id)
                    .build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
