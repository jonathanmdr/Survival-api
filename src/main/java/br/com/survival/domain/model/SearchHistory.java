package br.com.survival.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "historico_busca")
public class SearchHistory {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "codigo")
	private String code;
	
	@ManyToOne
	@JoinColumn(name = "cpf")
	private Person person;
	
	@Column(name = "data_consulta")
	private OffsetDateTime consultationDate;
	
	@Column(name = "nome_usuario")
	private String userName;

}
