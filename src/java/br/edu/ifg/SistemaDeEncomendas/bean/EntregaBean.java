package br.edu.ifg.SistemaDeEncomendas.bean;

import br.edu.ifg.SistemaDeEncomendas.dao.EntregaDAO;
import br.edu.ifg.SistemaDeEncomendas.entity.Encomenda;
import br.edu.ifg.SistemaDeEncomendas.entity.Endereco;
import br.edu.ifg.SistemaDeEncomendas.entity.Entrega;
import br.edu.ifg.SistemaDeEncomendas.entity.Usuario;
import javax.faces.application.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class EntregaBean {
    private Endereco endDestino = new Endereco();
    private Endereco endOrigem = new Endereco();
    private Encomenda encomenda = new Encomenda();
    private Entrega entrega = new Entrega();
    private EntregaDAO entregaDAO = new EntregaDAO();
    private Usuario usuario = new Usuario();

    public Endereco getEndDestino() {
        return endDestino;
    }

    public void setEndDestino(Endereco endDestino) {
        this.endDestino = endDestino;
    }

    public Endereco getEndOrigem() {
        return endOrigem;
    }

    public void setEndOrigem(Endereco endOrigem) {
        this.endOrigem = endOrigem;
    }

    public Encomenda getEncomenda() {
        return encomenda;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public EntregaDAO getEntregaDAO() {
        return entregaDAO;
    }

    public void setEntregaDAO(EntregaDAO entregaDAO) {
        this.entregaDAO = entregaDAO;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
     public void salvar() {
         entregaDAO.salvar(entrega);
         entrega = new Entrega();
    }
    
    public void inserirEntrega() {
	entregaDAO.inserirEntrega(usuario.getNome(), encomenda, endOrigem, endDestino, "1754954222");
        
        entrega = new Entrega();
        encomenda = new Encomenda();
        endOrigem = new Endereco();
        endDestino = new Endereco();
        usuario = new Usuario();
        
        mensagem("Salvar:","Operação realizada com Sucesso!",FacesMessage.SEVERITY_INFO);
    }
     
     
    public void mensagem(String titulo, String msg, FacesMessage.Severity tipo){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(tipo, titulo, msg);
        context.addMessage(null, mensagem);
    }
}
