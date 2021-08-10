package com.dpaula.escola.dominio.aluno;

/**
 * @author Fernando de Lima on 10/08/21
 */
public interface CifradorSenha {

    String cifrar(String senha);

    boolean validarSenhaCifrada(String senhaCifrada, String senha);
}
