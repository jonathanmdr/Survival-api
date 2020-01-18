CREATE TABLE historico_busca (    
	codigo UUID PRIMARY KEY,
	cpf VARCHAR(11) NOT NULL,
	data_consulta TIMESTAMP WITH TIME ZONE,
	nome_usuario VARCHAR(255) NOT NULL,	
    CONSTRAINT historico_busca_pessoa_fk FOREIGN KEY(cpf) REFERENCES pessoa(cpf)
);