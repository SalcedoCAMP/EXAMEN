package org.cibertec;
import org.cibertec.logica.GestorJPA;
import org.cibertec.clases.Atencion_veterinaria;
import org.cibertec.clases.Tipo_servicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {


        /*CRUD:  INSERTAR*/

        GestorJPA gestor01 = new GestorJPA();
        Atencion_veterinaria atencion_veterinaria = new Atencion_veterinaria();
        Tipo_servicio tipo_servicio = new Tipo_servicio();


        tipo_servicio.setNom_tipo_servicio("Consulta Nro 1");
        tipo_servicio.setPrecio(195.50);
        gestor01.crearTipo(tipo_servicio);


        atencion_veterinaria.setFecha(new Date());
        atencion_veterinaria.setTipo_servicio(tipo_servicio);
        atencion_veterinaria.setNom_mascota("Manuel");
        atencion_veterinaria.setNom_propietario("Juan");
        gestor01.crearAtencion(atencion_veterinaria);


       /*
        UPDATE


        GestorJPA gestor = new GestorJPA();
        Atencion_veterinaria atencion_veterinaria = new Atencion_veterinaria();
        Tipo_servicio tipo_servicio = new Tipo_servicio();


        tipo_servicio.setNom_tipo_servicio("Consulta Nro 1");
        tipo_servicio.setPrecio(195.50);
        gestor.crearTipo(tipo_servicio);

        atencion_veterinaria.setNum_atencion(2);
        atencion_veterinaria.setFecha(new Date());
        atencion_veterinaria.setTipo_servicio(tipo_servicio);
        atencion_veterinaria.setNom_mascota("Manuel");
        atencion_veterinaria.setNom_propietario("Juan");
        gestor.updateAtencion(atencion_veterinaria);   */

        /*
        DELETE


        GestorJPA gestor = new GestorJPA();
        gestor.deleteAtencion(2);
        */

        /*
        CONSULTAR


        GestorJPA gestor = new GestorJPA();
        Atencion_veterinaria atencion_veterinaria = new Atencion_veterinaria();
        Tipo_servicio tipo_servicio = new Tipo_servicio();

        Atencion_veterinaria consulta ;
        consulta = gestor.buscarAtencion(52);
        System.out.println(consulta.getNom_propietario()); */


     /*
       /*PREGUNTA 3:
       GestorJPA gestor = new GestorJPA();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date inicio = sdf.parse("2023-01-01");
        Date fin = sdf.parse("2025-12-31");

        List<Atencion_veterinaria> reporte= gestor.obtenerReporteAtenciones(inicio,fin);
        System.out.println("REPORTE DE ATENCIONES VETERINARIAS:");
        System.out.println("-------------------:)-----------------------------");
        for (Atencion_veterinaria a : reporte) {
            System.out.println("Fecha: " + sdf.format(a.getFecha()));
            System.out.println("Mascota: " + a.getNom_mascota());
            System.out.println("Propietario: " + a.getNom_propietario());
            System.out.println("Servicio: " + a.getTipo_servicio().getNom_tipo_servicio());
            System.out.println("Precio: S/ " + a.getTipo_servicio().getPrecio());
            System.out.println("--------------------------------------------------");
        }

     */



    }
}