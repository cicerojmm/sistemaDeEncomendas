package br.edu.ifg.SistemaDeEncomendas.bean;

import br.edu.ifg.SistemaDeEncomendas.dao.MotoDAO;
import br.edu.ifg.SistemaDeEncomendas.entity.Moto;
import javax.faces.application.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class MotoBean {
    private Moto moto = new Moto();
    private MotoDAO motoDAO = new MotoDAO();
    
     public void salvar() {
         motoDAO.salvar(moto);
         moto = new Moto();
    }
     
     
    public void mensagem(String titulo, String msg, FacesMessage.Severity tipo){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(tipo, titulo, msg);
        context.addMessage(null, mensagem);
    }
}
