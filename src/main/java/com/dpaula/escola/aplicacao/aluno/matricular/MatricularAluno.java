package com.dpaula.escola.aplicacao.aluno.matricular;

import com.dpaula.escola.dominio.aluno.Aluno;
import com.dpaula.escola.dominio.aluno.AlunoRepository;

/**
 * @author Fernando de Lima on 11/08/21
 */
public class MatricularAluno {

    private final AlunoRepository repository;

    public MatricularAluno(AlunoRepository repository) {
        this.repository = repository;
    }

    public void executa(MatricularAlunoDTO alunoDTO) {
        Aluno novo = alunoDTO.criarAluno();
        repository.matricular(novo);
    }
}
