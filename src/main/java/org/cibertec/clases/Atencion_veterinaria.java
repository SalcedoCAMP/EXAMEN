package org.cibertec.clases;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "atencion_veterinarias")
public class Atencion_veterinaria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int num_atencion;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(length = 80, nullable = false)
    private String nom_mascota;

    @Column(length = 80, nullable = false)
    private String nom_propietario;

    @ManyToOne
    @JoinColumn(name = "cod_tipo_servicio")
    private Tipo_servicio tipo_servicio;
    
    public Atencion_veterinaria() {
        tipo_servicio = new Tipo_servicio();
    }

    public Atencion_veterinaria(int num_atencion, Tipo_servicio tipo_servicio, String nom_propietario, String nom_mascota, Date fecha) {
        this.num_atencion = num_atencion;
        this.tipo_servicio = tipo_servicio;
        this.nom_propietario = nom_propietario;
        this.nom_mascota = nom_mascota;
        this.fecha = fecha;
    }

    public int getNum_atencion() {
        return num_atencion;
    }

    public void setNum_atencion(int num_atencion) {
        this.num_atencion = num_atencion;
    }

    public Tipo_servicio getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(Tipo_servicio tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public String getNom_propietario() {
        return nom_propietario;
    }

    public void setNom_propietario(String nom_propietario) {
        this.nom_propietario = nom_propietario;
    }

    public String getNom_mascota() {
        return nom_mascota;
    }

    public void setNom_mascota(String nom_mascota) {
        this.nom_mascota = nom_mascota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
