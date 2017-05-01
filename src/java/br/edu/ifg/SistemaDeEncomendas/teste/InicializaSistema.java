package br.edu.ifg.SistemaDeEncomendas.teste;

import br.edu.ifg.SistemaDeEncomendas.dao.*;
import br.edu.ifg.SistemaDeEncomendas.entity.*;


public class InicializaSistema {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        Endereco endereco = new Endereco();
        Endereco endUser= new Endereco();
        Moto moto = new Moto();
        Motoboy motoboy =  new Motoboy();
        Moto moto1 = new Moto();
        Motoboy motoboy1 =  new Motoboy();
        AreaDeAtuacao area = new AreaDeAtuacao();
        Usuario usuario = new Usuario();
        
        EnderecoDAO endDAO = new EnderecoDAO();
        EmpresaDAO empDAO = new EmpresaDAO();
        MotoboyDAO mbDAO = new MotoboyDAO();
        MotoboyDAO mbDAO1 = new MotoboyDAO();
        MotoDAO mDAO = new MotoDAO();
        MotoDAO mDAO1 = new MotoDAO();
        AreaDeAtuacaoDAO areaDAO = new AreaDeAtuacaoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        endereco.setLogradouro("Rua 135 A");
        endereco.setNumero("11");
        endereco.setComplemento("Perto do Banco");
        endereco.setCidade("Goiânia");
        endereco.setBairro("Setor Marista");
        endereco.setEstado("Goiás");
        endereco.setCep("74747490");
        
        empresa.setCnpj("12548741000171");
        empresa.setEndereco(endereco);
        empresa.setRazaoSocial("EGPS");
        
        area.setNumero(1);
        area.setDescricao("Norte Sul");
        
        moto.setPlaca("AAA-1111");
        moto.setMarca("Honda");
        moto.setModelo("CG 150");
        moto.setAno(2015);
        
        moto1.setPlaca("AAA-222");
        moto1.setMarca("Honda");
        moto1.setModelo("CG 150");
        moto1.setAno(2016);
        
        motoboy.setCpf("1754954222");
        motoboy.setNome("João Batista");
        motoboy.setDataNasc("11/05/1993");
        motoboy.setSalario(300.0);
        motoboy.setSexo("M");
        motoboy.setEmpresa(empresa);
        motoboy.setMoto(moto);
        motoboy.setArea(area);
        
        motoboy1.setCpf("12121212121");
        motoboy1.setNome("João Manuel");
        motoboy1.setDataNasc("11/05/1980");
        motoboy1.setSalario(300.0);
        motoboy1.setSexo("M");
        motoboy1.setEmpresa(empresa);
        motoboy1.setMoto(moto1);
        motoboy1.setArea(area);
        
        endUser.setLogradouro("Rua 12 A");
        endUser.setNumero("12");
        endUser.setComplemento("Perto da Praça");
        endUser.setCidade("Goiânia");
        endUser.setBairro("Setor Caraibas");
        endUser.setEstado("Goiás");
        endUser.setCep("7442500");

        usuario.setDocumento("12121212");
        usuario.setLogin("cicero.moura");
        usuario.setNome("Cicero Moura");
        usuario.setSenha("123456");
        usuario.setTipoUsuario("PF");
           
        
        usuarioDAO.cadastrar(usuario, endUser);
        endDAO.salvar(endereco);
        empDAO.salvar(empresa);
        mDAO.salvar(moto);
        areaDAO.salvar(area);
        mbDAO.salvar(motoboy);
        mDAO1.salvar(moto1);
        mbDAO1.salvar(motoboy1);

    }
}
