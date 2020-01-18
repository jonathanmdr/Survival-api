CREATE TABLE ativo (	
    codigo UUID PRIMARY KEY,
	cpf VARCHAR(11) NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	tipo VARCHAR(14) NOT NULL,
	valor DECIMAL(12,4) NOT NULL,
	data_atualizacao TIMESTAMP WITH TIME ZONE,	
	CONSTRAINT ativo_pessoa_fk FOREIGN KEY(cpf) REFERENCES pessoa(cpf)
);

CREATE TABLE renda (	
    codigo UUID PRIMARY KEY,
	cpf VARCHAR(11) NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	tipo VARCHAR(10) NOT NULL,
	valor DECIMAL(16,2) NOT NULL,
	data_atualizacao TIMESTAMP WITH TIME ZONE,	
	CONSTRAINT renda_pessoa_fk FOREIGN KEY(cpf) REFERENCES pessoa(cpf)
);