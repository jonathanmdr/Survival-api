# Survival-api
API de gestão de crédito.

A API tem como objetivo disponibilizar os dados armazenados em tempo real à seus consumidores com segurança e assertividade.

## Travis CI

|Branch|Status
|--|--|
|master|[![Build Status](https://travis-ci.org/jonathanmdr/Survival-api.svg?branch=master)](https://travis-ci.org/jonathanmdr/Survival-api)

## Tecnologias utilizadas
[![node](https://img.shields.io/badge/OpenJDK-12.0.2-lightgray.svg)](https://www.java.com/pt_BR/download/)
[![node](https://img.shields.io/badge/Maven-3.5.4-steelblue.svg)](https://maven.apache.org/download.cgi)
[![node](https://img.shields.io/badge/Lombok-1.18.8-indianRed.svg)](https://projectlombok.org/)
[![node](https://img.shields.io/badge/PostgreSQL-42.2.6-blue.svg)](https://www.postgresql.org/download/)
[![node](https://img.shields.io/badge/Springboot-2.1.7.RELEASE-springgreen.svg)](https://spring.io/)
[![node](https://img.shields.io/badge/Modelmapper-2.3.0-orange.svg)](http://modelmapper.org/)
[![node](https://img.shields.io/badge/Swagger-2.9.2-lime.svg)](https://swagger.io/)
[![node](https://img.shields.io/badge/OAuth2-2.2.5.RELEASE-black.svg)](https://oauth.net/2/)
[![node](https://img.shields.io/badge/JWT-1.0.9.RELEASE-purple.svg)](https://jwt.io/)
[![node](https://img.shields.io/badge/Flyway-5.2.4-silver.svg)](https://flywaydb.org/)


## Arquitetura cloud 
Para disponibilizar a API em cloud pensando em alta disponibilidade, escalabilidade e segurança optei pela AWS, tendo como base o tráfego de dados sensíveis entre a API e seus consumidores.

 - VPC: Virtual Private Cloud
 - RDS: Relational Database Service
 - EC2: Elastic Compute Cloud

A arquitetura é composta de uma VPC juntamente com uma sub-rede privada e uma sub-rede pública, onde na sub-rede privada temos a nossa base de dados postgreSql em um RDS e na sub-rede pública temos os serviços da nossa API em um EC2.
A nossa base de dados e a nossa API estão dentro do mesmo grupo de segurança, o que nos garante que a comunicação entre ambas ocorra de forma isolada e limitada ao grupo que as mesmas pertencem.

## Cenário da arquitetura
[![node](https://github.com/jonathanmdr/Survival-api/blob/master/images/arquitetura_cloud.png)](https://github.com/jonathanmdr/Survival-api/blob/master/images)

## Serviços que a API dispõe
A API dispõe de 3 (três) serviços únicos (Débitos, Score e Eventos).

|Serviço|URL|Retorno|Documentação
|--|--|--|--|
|Débitos|http://localhost:8095/serviceA/{cpf}|Retorna os dados da pessoa referente ao CPF informado juntamente com uma listagem de débitos registrados para o mesmo.|http://localhost:8095/swagger-ui.html#/Débitos
|Score|http://localhost:8095/serviceB/{cpf}|Retorna os dados da pessoa referente ao CPF informado juntamente com uma listagem de bens e fontes de renda.|http://localhost:8095/swagger-ui.html#/Score
|Eventos|http://localhost:8095/serviceC/{cpf}|Retorna os dados referente aos eventos registrados para o CPF informado|http://localhost:8095/swagger-ui.html#/Eventos

A documentação possui toda a informação referente ao serviço, como por exemplo dados de entrada esperados e o objeto de retorno.

## Configuração do projeto
> Atenção: para executar a aplicação é necessário ter a base de dados postgreSql devidamente criada e configurada.

1. Criando a base de dados:
 - Caso a base de dados seja criada com nome diferente, servidor remoto ou o serviço esteja executando em uma porta diferente da padrão (5432), siga as instruções sobre o arquivo de propriedades.
```
CREATE DATABASE survivalapi
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
```

2. Entendendo o arquivo de propriedades de configuração do projeto (`application.properties`):
```
# SERVER

• Porta em que a aplicação estará executando
server.port=8095


# CONNECTION DATABASE

• URL de conexão com a base de dados jdbc:postgresql://{HOST}:{PORT_NUMBER}/{DATABASE_NAME}
spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/survivalapi

• Usuário de conexão com a base de dados (usuário padrão: postgres)
spring.datasource.username=postgres

• Senha de conexão com a base de dados (senha padrão: postgres)
spring.datasource.password=postgres


# SECURITY

• Perfis de configuração de segurança da API (oauth-security e basic-security)
spring.profiles.active=oauth-security
```

3. Entendendo os perfis de segurança da aplicação:
 - **oauth-security**: Autentica o usuário na aplicação e verifica suas permissões de acesso para cada recurso da API por meio de tokens (Controla nível de acesso).
 - **basic-security**: Autentica o usuário na aplicação (Não controla nível de acesso).
 
4. Utilizando o perfil `oauth-security`:
 - Veja como autenticar o usuário e fazer uma requisição. 
 [![node](https://github.com/jonathanmdr/Survival-api/blob/master/images/oauth.gif)](https://github.com/jonathanmdr/Survival-api/blob/master/images)
 
5. Utilizando o perfil `basic-security`:
 - Veja como autenticar o usuário e fazer uma requisição.
 [![node](https://github.com/jonathanmdr/Survival-api/blob/master/images/basic.gif)](https://github.com/jonathanmdr/Survival-api/blob/master/images)
 
6. Usuários e níveis de acesso aos recursos:

|Usuário|Senha|Permissões de acesso
|--|--|--|
|admin@survival.com|admin|ROLE_PESQUISAR_DEBITO, ROLE_PESQUISAR_SCORE e ROLE_PESQUISAR_EVENTO
|convidado@survival.com|convidado|ROLE_PESQUISAR_DEBITO e ROLE_PESQUISAR_SCORE

## Requisições prontas para utilizar em testes
[Postman - Survival API Documentation](https://documenter.getpostman.com/view/6429490/SWT5jgkj)

## Auditoria
Todos os serviços são auditados a cada requisição gerando um registro na base de dados com informações para análise.
