package com.dpaula.escola.dominio.indicacao;

import com.dpaula.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {
	
	void enviarPara(Aluno indicado);
}
