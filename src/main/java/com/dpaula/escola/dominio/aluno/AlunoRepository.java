package com.dpaula.escola.dominio.aluno;

import java.util.List;

/**
 * @author Fernando de Lima on 10/08/21
 */
public interface AlunoRepository {

    void matricular(Aluno aluno);

    Aluno buscarPorCPF(CPF cpf);

    List<Aluno> listarTodosAlunosMatriculados();
}
