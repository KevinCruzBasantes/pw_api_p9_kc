package uce.edu.ec.api.application.representation;

import java.time.LocalDate;

public class VehiuloRepresentation {
    public Long id;
    public String marca;
    public String chasis;
    public LocalDate fechamatricula;
    public LocalDate fechafabricacion;
    public VehiuloRepresentation() {
    }
    public VehiuloRepresentation(Long id, String marca, String chasis, LocalDate fechamatricula,
            LocalDate fechafabricacion) {
        this.id = id;
        this.marca = marca;
        this.chasis = chasis;
        this.fechamatricula = fechamatricula;
        this.fechafabricacion = fechafabricacion;
    }
    
}
