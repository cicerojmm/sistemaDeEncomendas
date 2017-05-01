package br.edu.ifg.SistemaDeEncomendas.teste;

import br.edu.ifg.SistemaDeEncomendas.dao.*;
import br.edu.ifg.SistemaDeEncomendas.entity.*;

public class TesteSistema {
    public static void main(String[] args) {
        EntregaDAO entDAO = new EntregaDAO();
        Endereco endOrg = new Endereco();
        Endereco endDes = new Endereco();
        Encomenda en = new Encomenda();
        
        endOrg.setLogradouro("Rua 12 A");
        endOrg.setNumero("12");
        endOrg.setComplemento("Perto da Praça");
        endOrg.setCidade("Goiânia");
        endOrg.setBairro("Setor Caraibas");
        endOrg.setEstado("Goiás");
        endOrg.setCep("7442500");
        
        endDes.setLogradouro("Rua 1");
        endDes.setNumero("12");
        endDes.setComplemento("Praça da Biblia");
        endDes.setCidade("Goiânia");
        endDes.setBairro("Setor Central");
        endDes.setEstado("Goiás");
        endDes.setCep("74740000");
        
        en.setDescricao("Documentos para o cartorio");
        en.setTamanho("PEQUENO");
        en.setPeso(100.0);
        
        entDAO.inserirEntrega("cicero.moura", en, endOrg, endDes, "1754954222");
    }
}
