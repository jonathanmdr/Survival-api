# Survival-api
API de gestão de crédito.

A API tem como objetivo disponibilizar os dados armazenados em tempo real à seus consumidores com segurança e assertividade

## Travis CI
[![Build Status](https://travis-ci.org/jonathanmdr/Survival-api.svg?branch=master)](https://travis-ci.org/jonathanmdr/Survival-api)

## Tecnologias utilizadas
[![node](https://img.shields.io/badge/OpenJDK-12-lightgray.svg)](https://www.java.com/pt_BR/download/)
[![node](https://img.shields.io/badge/Maven-3.5.4-steelblue.svg)](https://maven.apache.org/download.cgi)
[![node](https://img.shields.io/badge/Lombok_1.18.8-indianRed.svg)](https://projectlombok.org/)
[![node](https://img.shields.io/badge/PostgreSQL_42.2.6-blue.svg)](https://www.postgresql.org/download/)
[![node](https://img.shields.io/badge/Springboot-2.1.7.RELEASE-springgreen.svg)](https://spring.io/)
[![node](https://img.shields.io/badge/Modelmapper-2.3.0-orange.svg)](http://modelmapper.org/)
[![node](https://img.shields.io/badge/Swagger-2.9.2-lime.svg)](https://swagger.io/)
[![node](https://img.shields.io/badge/OAuth2-2.2.5.RELEASE-black.svg)](https://oauth.net/2/)
[![node](https://img.shields.io/badge/JWT-1.0.9.RELEASE-purple.svg)](https://jwt.io/)
[![node](https://img.shields.io/badge/Flyway-5.2.4-gray.svg)](https://flywaydb.org/)


# Arquitetura cloud 
Para disponibilizar a API em cloud pensando em alta disponibilidade, escalabilidade e segurança optei pela AWS, tendo como base o tráfego de dados sensíveis entre a API e seus consumidores.

 - VPC: Virtual Private Cloud
 - RDS: Relational Database Service
 - EC2: Elastic Compute Cloud

A arquitetura é composta de uma VPC juntamente com uma sub-rede privada e uma sub-rede pública, onde na sub-rede privada temos a nossa base de dados RDS e na sub-rede pública temos os serviços da nossa API em um EC2.
A nossa base de dados e a nossa API estão dentro do mesmo grupo de segurança, o que nos garante que a comunicação entre ambas ocorra de isolada e limitada ao grupo que as mesmas pertencem.

### Cenário da arquitetura
[![node](https://github.com/jonathanmdr/Survival-api/blob/master/images/arquitetura_cloud.png)](https://github.com/jonathanmdr/Survival-api/blob/master/images)