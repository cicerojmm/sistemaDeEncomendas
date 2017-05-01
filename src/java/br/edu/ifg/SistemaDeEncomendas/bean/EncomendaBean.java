package br.edu.ifg.SistemaDeEncomendas.bean;

import br.edu.ifg.SistemaDeEncomendas.dao.EncomendaDAO;
import br.edu.ifg.SistemaDeEncomendas.entity.Encomenda;
import javax.faces.application.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class EncomendaBean {
    private Encomenda encomenda = new Encomenda();
    private EncomendaDAO encomendaDAO = new EncomendaDAO();
    
     public void salvar() {
         encomendaDAO.salvar(encomenda);
         encomenda = new Encomenda();
    }
     
     
    public void mensagem(String titulo, String msg, FacesMessage.Severity tipo){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(tipo, titulo, msg);
        context.addMessage(null, mensagem);
    }
}

