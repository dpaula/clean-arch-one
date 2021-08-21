package com.dpaula.escola.aplicacao.aluno.matricular;

import com.dpaula.escola.dominio.PublicadorEventos;
import com.dpaula.escola.dominio.aluno.Aluno;
import com.dpaula.escola.dominio.aluno.AlunoMatriculado;
import com.dpaula.escola.dominio.aluno.AlunoRepository;

/**
 * @author Fernando de Lima on 11/08/21
 */
public class MatricularAluno {

    private final AlunoRepository repository;
    private final PublicadorEventos publicadorEventos;

    public MatricularAluno(final AlunoRepository repository, final PublicadorEventos publicadorEventos) {
        this.repository = repository;
        this.publicadorEventos = publicadorEventos;
    }

    public void executa(final MatricularAlunoDTO alunoDTO) {
        final Aluno novo = alunoDTO.criarAluno();
        repository.matricular(novo);

        publicadorEventos.publicar(new AlunoMatriculado(novo.getCpf()));
    }
}
