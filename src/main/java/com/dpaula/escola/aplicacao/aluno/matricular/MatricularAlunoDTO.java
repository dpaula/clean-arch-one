package com.dpaula.escola.aplicacao.aluno.matricular;

import com.dpaula.escola.dominio.aluno.Aluno;
import com.dpaula.escola.dominio.aluno.CPF;
import com.dpaula.escola.dominio.aluno.Email;

/**
 * @author Fernando de Lima on 11/08/21
 */
public class MatricularAlunoDTO {

    private String nomeAluno;
    private String cpfAluno;
    private String emailAluno;

    public MatricularAlunoDTO(String nomeAluno, String cpfAluno, String emailAluno) {
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.emailAluno = emailAluno;
    }

    public Aluno criarAluno() {
        return new Aluno(new CPF(cpfAluno), nomeAluno, new Email(emailAluno));
    }
}
