CREATE TABLE pessoa (
	id BIGSERIAL PRIMARY KEY,
    cpf VARCHAR(11) NOT NULL,
	nome VARCHAR(255),
	data_nascimento TIMESTAMP WITH TIME ZONE,
	endereco VARCHAR(255) NOT NULL,
	data_atualizacao TIMESTAMP WITH TIME ZONE
);


CREATE TABLE debito (
    id BIGSERIAL PRIMARY KEY,
	codigo UUID NOT NULL,
	pessoa_id BIGINT NOT NULL,
	razao_social_credor VARCHAR(255) NOT NULL,
	cnpj_credor VARCHAR(14) NOT NULL,
	contrato_credor VARCHAR(255) NOT NULL,
	data_vencimento_credor TIMESTAMP WITH TIME ZONE NOT NULL,
	tipo_registro_credor VARCHAR(10) NOT NULL,
	status VARCHAR(10) NOT NULL,
	valor_debito DECIMAL(16,2) NOT NULL,
	data_disponibilizacao TIMESTAMP WITH TIME ZONE NOT NULL,
	data_atualizacao TIMESTAMP WITH TIME ZONE,
	CONSTRAINT debito_pessoa_fk FOREIGN KEY(pessoa_id) REFERENCES pessoa(id)
);