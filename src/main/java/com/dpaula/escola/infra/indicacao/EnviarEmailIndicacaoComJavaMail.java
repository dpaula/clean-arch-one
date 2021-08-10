package com.dpaula.escola.infra.indicacao;

import com.dpaula.escola.dominio.aluno.Aluno;
import com.dpaula.escola.dominio.indicacao.EnviarEmailIndicacao;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

	@Override
	public void enviarPara(Aluno indicado) {
		// logica de envio de email com a lib Java Mail
	}
}
