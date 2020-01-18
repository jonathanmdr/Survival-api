TRUNCATE TABLE renda CASCADE;
TRUNCATE TABLE ativo CASCADE;
TRUNCATE TABLE debito CASCADE;
TRUNCATE TABLE pessoa CASCADE;

INSERT INTO pessoa(id, cpf, nome, data_nascimento, endereco, data_atualizacao) VALUES(1, '05761400073', 'João da Silva Sauro', '1987-07-15', 'Rua A 1 - Centro', now()),
																				 	 (2, '36042646001', 'Maria Aparecida Pinto', '1994-03-02', 'Rua B 2 - Centro', now()),
																				 	 (3, '66851482096', 'Sebastião Carvalho de Souza', '2000-12-31', 'Rua C 3 - Centro', now()),
																				 	 (4, '69884362009', 'Tibúrcio Castilho Santigo', '1964-09-23', 'Rua D 4 - Centro', now()),
																				 	 (5, '10519106091', 'Ladislau de Oliveira Neto', '1988-08-09', 'Rua F 5 - Centro', now());
																				 	 
INSERT INTO debito(id, codigo, pessoa_id, razao_social_credor, cnpj_credor, contrato_credor, data_vencimento_credor, tipo_registro_credor, status, valor_debito, data_disponibilizacao, data_atualizacao)
VALUES (1, uuid_generate_v1(), 1, 'Empresa aleatória SA', '55032488000120', 'AB1234', '2018-01-17', 'AVALISTA', 'ATIVO', 623.55, now(), now()),
	   (2, uuid_generate_v1(), 1, 'Empresa aleatória SA', '55032488000120', 'AB12DF', '2019-02-10', 'TITULAR', 'ATIVO', 100.00, now(), now()),	   
	   (3, uuid_generate_v1(), 2, 'Empresa aleatória SA', '55032488000120', 'JB1R34', '2020-01-05', 'AVALISTA', 'ATIVO', 1235.73, now(), now()),	   
	   (4, uuid_generate_v1(), 3, 'Empresa aleatória SA', '55032488000120', 'KLB134', '2017-03-23', 'TITULAR', 'ATIVO', 89.90, now(), now()),
	   (5, uuid_generate_v1(), 4, 'Empresa aleatória SA', '55032488000120', 'AB1N87', '2015-04-02', 'TITULAR', 'ATIVO', 785.33, now(), now()),
	   (6, uuid_generate_v1(), 4, 'Empresa aleatória SA', '55032488000120', 'AB1T96', '2018-12-29', 'TITULAR', 'ATIVO', 52.64, now(), now()),	   
	   (7, uuid_generate_v1(), 5, 'Empresa aleatória SA', '55032488000120', 'DG1230', '2019-06-14', 'AVALISTA', 'ATIVO', 123.45, now(), now());																				 	 