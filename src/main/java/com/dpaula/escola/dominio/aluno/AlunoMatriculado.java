package com.dpaula.escola.dominio.aluno;

import com.dpaula.escola.dominio.Evento;

import java.time.LocalDateTime;

/**
 * @author Fernando de Lima on 20/08/21
 */
public class AlunoMatriculado implements Evento {

    private final CPF cpfAluno;
    private final LocalDateTime momento;

    public AlunoMatriculado(final CPF cpfAluno) {
        this.cpfAluno = cpfAluno;
        momento = LocalDateTime.now();
    }

    @Override public LocalDateTime momento() {
        return momento;
    }

    public CPF getCpfAluno() {
        return cpfAluno;
    }

    public LocalDateTime getMomento() {
        return momento;
    }
}
