package org.cibertec.logica;

import org.cibertec.clases.Atencion_veterinaria;
import org.cibertec.clases.Tipo_servicio;
import org.cibertec.persistencia.ServicioJpaController;

import java.util.Date;
import java.util.List;

public class GestorJPA {

    ServicioJpaController servicioJpaController = new ServicioJpaController();


    public void crearAtencion(Atencion_veterinaria atencion_veterinaria){
        servicioJpaController.create(atencion_veterinaria);
    }

    public void updateAtencion(Atencion_veterinaria atencion_veterinaria){
        servicioJpaController.update(atencion_veterinaria);
    }

    public void deleteAtencion(int id ){
        servicioJpaController.delete(id);
    }


    public Atencion_veterinaria buscarAtencion(int id ){

        return servicioJpaController.findById(id);
    }

    public void crearTipo(Tipo_servicio tipo_servicio){
        servicioJpaController.create02(tipo_servicio);
    }

    public List<Atencion_veterinaria> obtenerReporteAtenciones(Date inicio, Date fin){
        return servicioJpaController.buscarAtenciones(inicio, fin);
    }

}
