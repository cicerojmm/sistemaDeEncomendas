package br.edu.ifg.SistemaDeEncomendas.filters;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames={"FacesServlet"})
public class JPAFilter implements Filter{
    private EntityManagerFactory factory;

    @Override
    public void init(FilterConfig filterConfig)throws ServletException{
        this.factory = Persistence.createEntityManagerFactory("gravar");
    }

    @Override
    public void destroy(){
        this.factory.close();
    }

    @Override
    public void doFilter(ServletRequest request,ServletResponse response,
                    FilterChain chain)throws IOException,ServletException{
        //CHEGADA
        EntityManager manager = this.factory.createEntityManager();
        request.setAttribute("EntityManager", manager);
        manager.getTransaction().begin();
        
        //CHEGADA
        //FACESSERVLET
        chain.doFilter(request,response);
        //FACESSERVLET

        //SAÍDA
        try{
            manager.getTransaction().commit();
        }catch(Exception e){
            manager.getTransaction().rollback();
        }finally{
            manager.close();
        }
        //SAÍDA
    }
}
