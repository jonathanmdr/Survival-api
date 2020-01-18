CREATE TABLE ativo (
	id BIGSERIAL PRIMARY KEY,
    codigo UUID NOT NULL,
	pessoa_id BIGINT NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	tipo VARCHAR(255) NOT NULL,
	valor DECIMAL(12,4) NOT NULL,
	data_atualizacao TIMESTAMP WITH TIME ZONE,
	CONSTRAINT ativo_codigo_uk UNIQUE(codigo),
	CONSTRAINT ativo_pessoa_fk FOREIGN KEY(pessoa_id) REFERENCES pessoa(id)
);

CREATE TABLE renda (
	id BIGSERIAL PRIMARY KEY,
    codigo UUID NOT NULL,
	pessoa_id BIGINT NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	tipo VARCHAR(10) NOT NULL,
	valor DECIMAL(16,2) NOT NULL,
	data_atualizacao TIMESTAMP WITH TIME ZONE,
	CONSTRAINT renda_codigo_uk UNIQUE(codigo),
	CONSTRAINT renda_pessoa_fk FOREIGN KEY(pessoa_id) REFERENCES pessoa(id)
);