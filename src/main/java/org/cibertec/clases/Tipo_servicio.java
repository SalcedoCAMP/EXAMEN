package org.cibertec.clases;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "tipo_servicios")
public class Tipo_servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cod_tipo_servicio;

    @Column(length = 90, nullable = false)
    private String nom_tipo_servicio;

    @Column
    private Double precio;

    @OneToMany(mappedBy = "tipo_servicio")
    private List<Atencion_veterinaria> atencionVeterinarias = new ArrayList<>();

    public Tipo_servicio() {

    }
    public String getNom_tipo_servicio() {
        return nom_tipo_servicio;
    }

    public void setNom_tipo_servicio(String nom_tipo_servicio) {
        this.nom_tipo_servicio = nom_tipo_servicio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCod_tipo_servicio() {
        return cod_tipo_servicio;
    }

    public void setCod_tipo_servicio(int cod_tipo_servicio) {
        this.cod_tipo_servicio = cod_tipo_servicio;
    }


}


