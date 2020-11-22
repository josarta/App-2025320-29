/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;

import edu.app.entity.Usuario;
import edu.app.facade.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Usuario
 */
@Named(value = "administracionView")
@ViewScoped
public class AdministracionView implements Serializable {

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;

    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    @PostConstruct
    public void cargaInicial() {
        listaUsuarios.addAll(usuarioFacadeLocal.findAll());
    }

    public void remover(Usuario usuR){
        try {
            usuarioFacadeLocal.remove(usuR);
            listaUsuarios.remove(usuR);
        } catch (Exception e) {
            System.out.println("edu.app.controlador.AdministracionView.remover() " +e.getMessage() );
        }
    }
    
    /**
     * Creates a new instance of AdministracionView
     */
    public AdministracionView() {
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

}
