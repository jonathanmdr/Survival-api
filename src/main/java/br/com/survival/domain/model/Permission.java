package br.com.survival.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "permissao")
public class Permission {
		
	@Id
	private Long id;
	
	@Column(name = "descricao")
	private String description;

}
