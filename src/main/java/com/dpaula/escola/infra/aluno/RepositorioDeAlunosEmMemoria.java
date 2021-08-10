package com.dpaula.escola.infra.aluno;

import com.dpaula.escola.dominio.aluno.Aluno;
import com.dpaula.escola.dominio.aluno.AlunoNaoEncontrado;
import com.dpaula.escola.dominio.aluno.AlunoRepository;
import com.dpaula.escola.dominio.aluno.CPF;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosEmMemoria implements AlunoRepository {

	private List<Aluno> matriculados = new ArrayList<>();
	
	@Override
	public void matricular(Aluno aluno) {
		this.matriculados.add(aluno);
	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		return this.matriculados.stream()
				.filter(a -> a.getCpf().equals(cpf.getNumero()))
				.findFirst()
				.orElseThrow(() -> new AlunoNaoEncontrado(cpf));
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		return this.matriculados;
	}
}
