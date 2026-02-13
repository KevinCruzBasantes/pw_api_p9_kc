package uce.edu.ec.api.domain;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name="vehiculos")
@SequenceGenerator(name="veh_seq", sequenceName = "vehiculo_secuencia", allocationSize = 1)
public class Vehiculo extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veh_seq")
    public Long id;
    @Column(length = 50, nullable = false)
    public String marca;
    @Column(length = 50, nullable = false)
    public String chasis;
    @Column(nullable = false)
    public LocalDate fechamatricula;
    @Column(nullable = false)
    public LocalDate fechafabricacion;


}
