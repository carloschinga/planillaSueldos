/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestor.dao;

import com.gestor.planillasueldos.exceptions.NonexistentEntityException;
import com.gestor.dto.Trabajador;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 51933
 */
public class TrabajadorJpaController implements Serializable {

    public TrabajadorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public TrabajadorJpaController() {
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_PlanillaSueldos_war_1.0-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Trabajador trabajador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(trabajador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Trabajador trabajador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            trabajador = em.merge(trabajador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = trabajador.getCodiTrab();
                if (findTrabajador(id) == null) {
                    throw new NonexistentEntityException("The trabajador with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Trabajador trabajador;
            try {
                trabajador = em.getReference(Trabajador.class, id);
                trabajador.getCodiTrab();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The trabajador with id " + id + " no longer exists.", enfe);
            }
            em.remove(trabajador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Trabajador> findTrabajadorEntities() {
        return findTrabajadorEntities(true, -1, -1);
    }

    public List<Trabajador> findTrabajadorEntities(int maxResults, int firstResult) {
        return findTrabajadorEntities(false, maxResults, firstResult);
    }

    private List<Trabajador> findTrabajadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Trabajador.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Trabajador findTrabajador(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Trabajador.class, id);
        } finally {
            em.close();
        }
    }

    public int getTrabajadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Trabajador> rt = cq.from(Trabajador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
