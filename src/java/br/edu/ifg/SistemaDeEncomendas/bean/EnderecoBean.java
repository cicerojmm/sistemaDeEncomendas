package br.edu.ifg.SistemaDeEncomendas.bean;

import br.edu.ifg.SistemaDeEncomendas.dao.EnderecoDAO;
import br.edu.ifg.SistemaDeEncomendas.entity.Endereco;
import javax.faces.application.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class EnderecoBean {
    private Endereco endereco = new Endereco();
    EnderecoDAO enderecoDAO = new EnderecoDAO();

    public void salvar() {
        enderecoDAO.salvar(endereco);
        endereco = new Endereco();
        mensagem("Salvar:","Operação realizada com Sucesso!",FacesMessage.SEVERITY_INFO);
    }
     
     
    public void mensagem(String titulo, String msg, FacesMessage.Severity tipo){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(tipo, titulo, msg);
        context.addMessage(null, mensagem);
    } 
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    } 
    
    public EnderecoDAO getEnderecoDAO() {
        return enderecoDAO;
    }

    public void setEnderecoDAO(EnderecoDAO enderecoDAO) {
        this.enderecoDAO = enderecoDAO;
    }

    
    private EntityManager getEntityManager () {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        EntityManager m = (EntityManager)request.getAttribute("EntityManage");

        return m;
    }
}