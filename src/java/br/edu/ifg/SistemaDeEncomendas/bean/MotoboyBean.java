package br.edu.ifg.SistemaDeEncomendas.bean;

import br.edu.ifg.SistemaDeEncomendas.dao.MotoboyDAO;
import br.edu.ifg.SistemaDeEncomendas.entity.Motoboy;
import javax.faces.application.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class MotoboyBean {
    private Motoboy motoboy = new Motoboy();
    private MotoboyDAO motoboyDAO = new MotoboyDAO();
    
     public void salvar() {
         motoboyDAO.salvar(motoboy);
         motoboy = new Motoboy();
    }
     
     
    public void mensagem(String titulo, String msg, FacesMessage.Severity tipo){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(tipo, titulo, msg);
        context.addMessage(null, mensagem);
    }
}

