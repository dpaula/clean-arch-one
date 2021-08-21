package com.dpaula.escola.aplicacao.aluno.matricular;

import com.dpaula.escola.dominio.PublicadorEventos;
import com.dpaula.escola.dominio.aluno.AlunoMatriculadoLog;
import com.dpaula.escola.dominio.aluno.CPF;
import com.dpaula.escola.infra.aluno.RepositorioDeAlunosEmMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatricularAlunoTest {

    @Test
    void alunoDeveSerPersistido() {

        final RepositorioDeAlunosEmMemoria repositorioDeAlunosEmMemoria = new RepositorioDeAlunosEmMemoria();
        final var publicador = new PublicadorEventos();
        publicador.addOuvinte(new AlunoMatriculadoLog());

        final MatricularAluno useCase = new MatricularAluno(repositorioDeAlunosEmMemoria, publicador);

        final var dados = new MatricularAlunoDTO("Fernando de Paula", "043.180.459-19",
            "fernando.paula@gmail.com");

        useCase.executa(dados);

        final var alunoEncontrado = repositorioDeAlunosEmMemoria.buscarPorCPF(new CPF(dados.getCpfAluno()));

        assertEquals(dados.getNomeAluno(), alunoEncontrado.getNome());
        assertEquals(dados.getCpfAluno(), alunoEncontrado.getCpf());
        assertEquals(dados.getEmailAluno(), alunoEncontrado.getEmail());
    }
}