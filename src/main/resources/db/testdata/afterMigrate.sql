-- TRUNCATE TABLE historico_busca CASCADE;
TRUNCATE TABLE renda CASCADE;
TRUNCATE TABLE ativo CASCADE;
TRUNCATE TABLE debito CASCADE;
TRUNCATE TABLE pessoa CASCADE;

INSERT INTO pessoa(codigo, cpf, nome, data_nascimento, endereco, data_atualizacao) VALUES(uuid_generate_v1(), '05761400073', 'João da Silva Sauro', '1987-07-15', 'Rua A 1 - Centro', now()),
																			 	 		 (uuid_generate_v1(), '36042646001', 'Maria Aparecida Pinto', '1994-03-02', 'Rua B 2 - Centro', now()),
																			 	 		 (uuid_generate_v1(), '66851482096', 'Sebastião Carvalho de Souza', '2000-12-31', 'Rua C 3 - Centro', now()),
																			 	 		 (uuid_generate_v1(), '69884362009', 'Tibúrcio Castilho Santigo', '1964-09-23', 'Rua D 4 - Centro', now()),
																			 	 		 (uuid_generate_v1(), '10519106091', 'Ladislau de Oliveira Neto', '1988-08-09', 'Rua F 5 - Centro', now());
																				 	 
INSERT INTO debito(codigo, cpf, razao_social_credor, cnpj_credor, contrato_credor, data_vencimento_credor, tipo_registro_credor, status, valor_debito, data_disponibilizacao, data_atualizacao)
VALUES (uuid_generate_v1(), '05761400073', 'Empresa aleatória SA', '55032488000120', 'AB1234', '2018-01-17', 'AVALISTA', 'ATIVO', 623.55, now(), now()),
	   (uuid_generate_v1(), '05761400073', 'Empresa aleatória SA', '55032488000120', 'AB12DF', '2019-02-10', 'TITULAR', 'ATIVO', 100.00, now(), now()),	   
	   (uuid_generate_v1(), '36042646001', 'Empresa aleatória SA', '55032488000120', 'JB1R34', '2020-01-05', 'AVALISTA', 'ATIVO', 1235.73, now(), now()),	   
	   (uuid_generate_v1(), '66851482096', 'Empresa aleatória SA', '55032488000120', 'KLB134', '2017-03-23', 'TITULAR', 'ATIVO', 89.90, now(), now()),
	   (uuid_generate_v1(), '69884362009', 'Empresa aleatória SA', '55032488000120', 'AB1N87', '2015-04-02', 'TITULAR', 'ATIVO', 785.33, now(), now()),
	   (uuid_generate_v1(), '69884362009', 'Empresa aleatória SA', '55032488000120', 'AB1T96', '2018-12-29', 'TITULAR', 'ATIVO', 52.64, now(), now()),	   
	   (uuid_generate_v1(), '10519106091', 'Empresa aleatória SA', '55032488000120', 'DG1230', '2019-06-14', 'AVALISTA', 'ATIVO', 123.45, now(), now());
	   
INSERT INTO ativo(codigo, cpf, descricao, tipo, valor, data_atualizacao) VALUES(uuid_generate_v1(), '05761400073', 'Casa 200 m2', 'IMOVEL', 360000.00, now()),
							  												   (uuid_generate_v1(), '05761400073', 'Poubança BB', 'POUPANCA', 10000.00, now()),
																			   (uuid_generate_v1(), '36042646001', 'Título Sicoob', 'TITULO_PRIVADO', 30000.00, now()),
																			   (uuid_generate_v1(), '66851482096', 'Título do tesouro', 'TITULO_PUBLICO', 200000.00, now()),
																		  	   (uuid_generate_v1(), '69884362009', 'Ações magalu', 'ACOES', 12000.00, now()),
																			   (uuid_generate_v1(), '69884362009', 'Apartamento', 'IMOVEL', 180000.00, now()),
																			   (uuid_generate_v1(), '10519106091', 'Poupança Bradesco', 'POUPANCA', 55000.00, now());

INSERT INTO renda(codigo, cpf, descricao, tipo, valor, data_atualizacao) VALUES(uuid_generate_v1(), '05761400073', 'Renda fixa', 'MENSAL', 5000.00, now()),
																		  	   (uuid_generate_v1(), '05761400073', 'Renda extra', 'QUINZENAL', 1000.00, now()),
																			   (uuid_generate_v1(), '36042646001', 'Renda diária', 'DIARIA', 100.00, now()),
																			   (uuid_generate_v1(), '66851482096', 'Renda anual', 'ANUAL', 100000.00, now()),
																			   (uuid_generate_v1(), '69884362009', 'Renda mensa', 'MENSAL', 1750.00, now()),
																			   (uuid_generate_v1(), '69884362009', 'Renda mensal', 'MENSAL', 12000.00, now()),
																			   (uuid_generate_v1(), '10519106091', 'Renda mensal', 'MENSAL', 5500.00, now());