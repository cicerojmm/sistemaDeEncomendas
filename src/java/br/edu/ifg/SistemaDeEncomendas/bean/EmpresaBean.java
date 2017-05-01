package br.edu.ifg.SistemaDeEncomendas.bean;

import br.edu.ifg.SistemaDeEncomendas.dao.EmpresaDAO;
import br.edu.ifg.SistemaDeEncomendas.entity.Empresa;
import javax.faces.application.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class EmpresaBean {
    private Empresa empresa = new Empresa();
    private EmpresaDAO empresaDAO = new EmpresaDAO();
    
     public void salvar() {
         empresaDAO.salvar(empresa);
         empresa = new Empresa();
    }
     
     
    public void mensagem(String titulo, String msg, FacesMessage.Severity tipo){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(tipo, titulo, msg);
        context.addMessage(null, mensagem);
    }
}