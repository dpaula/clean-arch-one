package com.dpaula.escola.dominio.aluno;

import com.dpaula.escola.dominio.Evento;
import com.dpaula.escola.dominio.Ouvinte;

import java.time.format.DateTimeFormatter;

/**
 * @author Fernando de Lima on 20/08/21
 */
public class AlunoMatriculadoLog extends Ouvinte {

    @Override public void reageAoEvento(final Evento evento) {

        final AlunoMatriculado alunoMatriculadoEvento = (AlunoMatriculado) evento;

        final var dataMomento = alunoMatriculadoEvento.getMomento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        final var log = String.format("Aluno com CPF %s matriculado em %s", alunoMatriculadoEvento.getCpfAluno(),
            dataMomento);

        System.out.println(log);
    }

    @Override protected boolean deveProcessar(final Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}
