package com.dpaula.escola.aplicacao.aluno.matricular;

import com.dpaula.escola.dominio.aluno.Aluno;
import com.dpaula.escola.dominio.aluno.CPF;
import com.dpaula.escola.infra.aluno.RepositorioDeAlunosEmMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatricularAlunoTest {

    @Test
    void alunoDeveSerPersistido() {

        final RepositorioDeAlunosEmMemoria repositorioDeAlunosEmMemoria = new RepositorioDeAlunosEmMemoria();

        final MatricularAluno useCase = new MatricularAluno(repositorioDeAlunosEmMemoria);

        final var dados = new MatricularAlunoDTO("Fernando de Paula", "043.180.459-19",
            "fernando.paula@gmail.com");

        useCase.executa(dados);

        final var alunoEncontrado = repositorioDeAlunosEmMemoria.buscarPorCPF(new CPF(dados.getCpfAluno()));

        assertEquals(dados.getNomeAluno(), alunoEncontrado.getNome());
        assertEquals(dados.getCpfAluno(), alunoEncontrado.getCpf());
        assertEquals(dados.getEmailAluno(), alunoEncontrado.getEmail());
    }
}