/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.facade;

import edu.app.entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "App-2025320-29PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    
    public Usuario validarUsuario(String correoIn, String claveIn ){
        try {
            Query qt = em.createQuery("SELECT u FROM Usuario u WHERE u.clave = :claveIn AND u.correo = :correoIn");
            qt.setParameter("claveIn", claveIn);
            qt.setParameter("correoIn", correoIn);
            return  (Usuario) qt.getSingleResult();
        } catch (Exception e) {
            System.out.println("edu.app.facade.UsuarioFacade.validarUsuario() " +e.getMessage() );
            return new Usuario();
        }
    }
    
    
    
}
