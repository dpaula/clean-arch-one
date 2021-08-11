package com.dpaula.escola;

import com.dpaula.escola.aplicacao.aluno.matricular.MatricularAluno;
import com.dpaula.escola.aplicacao.aluno.matricular.MatricularAlunoDTO;
import com.dpaula.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

/**
 * @author Fernando de Lima on 11/08/21
 */
public class MatricularAlunoPorLinhaDeComando {

    public static void main(String[] args) {

        var nome = "Fernando de Paula";
        var cpf = "043.180.459-19";
        var email = "fernando.paula@gmail.com";

        final MatricularAluno matricularAluno = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
        matricularAluno.executa(new MatricularAlunoDTO(nome, cpf, email));
    }
}
