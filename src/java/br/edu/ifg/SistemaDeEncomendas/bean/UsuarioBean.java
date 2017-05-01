package br.edu.ifg.SistemaDeEncomendas.bean;

import br.edu.ifg.SistemaDeEncomendas.dao.UsuarioDAO;
import br.edu.ifg.SistemaDeEncomendas.entity.Usuario;
import javax.faces.application.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UsuarioBean {
    private Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    
     public void salvar() {
         usuarioDAO.salvar(usuario);
         usuario = new Usuario();
    }
     
     
    public void mensagem(String titulo, String msg, FacesMessage.Severity tipo){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(tipo, titulo, msg);
        context.addMessage(null, mensagem);
    }
}

