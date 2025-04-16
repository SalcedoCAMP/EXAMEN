package org.cibertec.persistencia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.cibertec.clases.Atencion_veterinaria;
import org.cibertec.clases.Tipo_servicio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class ServicioJpaController implements  Serializable{

    private EntityManagerFactory emf;


    public ServicioJpaController() {
        this.emf =  Persistence.createEntityManagerFactory("JpaPersistence");
    }

    public EntityManagerFactory getEm() {
        return emf;
    }

    public void setEm(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return  emf.createEntityManager();
    }


    public void create(Atencion_veterinaria atencion_veterinaria) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(atencion_veterinaria);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    public void create02(Tipo_servicio tipo_servicio) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(tipo_servicio);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void delete(int id) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Atencion_veterinaria atencion_veterinaria = em.find(Atencion_veterinaria.class, id);
            if (atencion_veterinaria != null) {
                em.remove(atencion_veterinaria);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void update(Atencion_veterinaria atencion_veterinaria) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(atencion_veterinaria);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (em != null) {
                em.clear();
            }
        }
    }

    public Atencion_veterinaria findById(int id) {
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(Atencion_veterinaria.class, id);
        } finally {
            em.close();
        }
    }

    public List<Atencion_veterinaria> ServicioJpaController(int num_atencion){
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Atencion_veterinaria> query = em.createQuery(
                    "SELECT e FROM Atencion_veterinaria e WHERE e.num_atencion = :num_atencion",
                    Atencion_veterinaria.class
            );
            query.setParameter("num_atencion", num_atencion);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Atencion_veterinaria> buscarAtenciones(Date fechaInicio, Date fechaFin) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Atencion_veterinaria> query = em.createQuery(
                    "SELECT a FROM Atencion_veterinaria a JOIN FETCH a.tipo_servicio " +
                            "WHERE a.fecha BETWEEN :inicio AND :fin ORDER BY a.fecha ASC",
                    Atencion_veterinaria.class
            );
            query.setParameter("inicio", fechaInicio);
            query.setParameter("fin", fechaFin);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
