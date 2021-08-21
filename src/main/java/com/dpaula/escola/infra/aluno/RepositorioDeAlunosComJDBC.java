package com.dpaula.escola.infra.aluno;

import com.dpaula.escola.dominio.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosComJDBC implements AlunoRepository {

	private final Connection connection;
	
	public RepositorioDeAlunosComJDBC(final Connection connection) {
		this.connection = connection;
	}

	@Override
	public void matricular(final Aluno aluno) {
		try {
			String sql = "INSERT INTO ALUNO VALUES(?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, aluno.getCpf().getNumero());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getEmail());
			ps.execute();

			sql = "INSERT INTO TELEFONE VALUES(?, ?)";
			ps = connection.prepareStatement(sql);
			for (final Telefone telefone : aluno.getTelefones()) {
				ps.setString(1, telefone.getDdd());
				ps.setString(2, telefone.getNumero());
				ps.execute();
			}
		} catch (final SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Aluno buscarPorCPF(final CPF cpf) {
		try {
			String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cpf.getNumero());

			ResultSet rs = ps.executeQuery();
			final boolean encontrou = rs.next();
			if (!encontrou) {
				throw new AlunoNaoEncontrado(cpf);
			}

			final String nome = rs.getString("nome");
			final Email email = new Email(rs.getString("email"));
			final Aluno encontrado = new Aluno(cpf, nome, email);
			
			final Long id = rs.getLong("id");
			sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				final String numero = rs.getString("numero");
				final String ddd = rs.getString("ddd");
				encontrado.adicionarTelefone(ddd, numero);
			}
			
			return encontrado;
		} catch (final SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		try {
			String sql = "SELECT id, cpf, nome, email FROM ALUNO";
			final PreparedStatement ps = connection.prepareStatement(sql);
			final ResultSet rs = ps.executeQuery();
			final List<Aluno> alunos = new ArrayList<>();
			while (rs.next()) {
				final CPF cpf = new CPF(rs.getString("cpf"));
				final String nome = rs.getString("nome");
				final Email email = new Email(rs.getString("email"));
				final Aluno aluno = new Aluno(cpf, nome, email);
				
				final Long id = rs.getLong("id");
				sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
				final PreparedStatement psTelefone = connection.prepareStatement(sql);
				psTelefone.setLong(1, id);
				final ResultSet rsTelefone = psTelefone.executeQuery();
				while (rsTelefone.next()) {
					final String numero = rsTelefone.getString("numero");
					final String ddd = rsTelefone.getString("ddd");
					aluno.adicionarTelefone(ddd, numero);
				}
			
				alunos.add(aluno);
			}
			
			return alunos;
		} catch (final SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
