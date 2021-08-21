package com.dpaula.escola;

import com.dpaula.escola.aplicacao.aluno.matricular.MatricularAluno;
import com.dpaula.escola.aplicacao.aluno.matricular.MatricularAlunoDTO;
import com.dpaula.escola.dominio.PublicadorEventos;
import com.dpaula.escola.dominio.aluno.AlunoMatriculadoLog;
import com.dpaula.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

/**
 * @author Fernando de Lima on 11/08/21
 */
public class MatricularAlunoPorLinhaDeComando {

    public static void main(final String[] args) {

        final var nome = "Fernando de Paula";
        final var cpf = "043.180.459-19";
        final var email = "fernando.paula@gmail.com";

        final var publicador = new PublicadorEventos();
        publicador.addOuvinte(new AlunoMatriculadoLog());

        final MatricularAluno matricularAluno = new MatricularAluno(new RepositorioDeAlunosEmMemoria(),
            publicador);
        matricularAluno.executa(new MatricularAlunoDTO(nome, cpf, email));
    }
}
