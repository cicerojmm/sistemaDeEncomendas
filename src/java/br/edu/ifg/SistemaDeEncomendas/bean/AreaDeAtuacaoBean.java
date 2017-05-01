package br.edu.ifg.SistemaDeEncomendas.bean;

import br.edu.ifg.SistemaDeEncomendas.dao.AreaDeAtuacaoDAO;
import br.edu.ifg.SistemaDeEncomendas.entity.AreaDeAtuacao;
import javax.faces.application.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class AreaDeAtuacaoBean {
    private AreaDeAtuacao area = new AreaDeAtuacao();
    private AreaDeAtuacaoDAO areaDAO = new AreaDeAtuacaoDAO();
    
     public void salvar() {
         areaDAO.salvar(area);
         area = new AreaDeAtuacao();
    }
     
     
    public void mensagem(String titulo, String msg, FacesMessage.Severity tipo){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(tipo, titulo, msg);
        context.addMessage(null, mensagem);
    }
}