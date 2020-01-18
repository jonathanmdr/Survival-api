package br.com.survival.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ativo")
public class Asset {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "codigo")
	private String code;
	
	@ManyToOne
	@JoinColumn(name = "cpf")
	private Person person;
	
	@Column(name = "descricao")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")	
	private AssetType assetType;
	
	@Column(name = "valor")
	private BigDecimal amount;
	
	@UpdateTimestamp
	@Column(name = "data_atualizacao")
	private OffsetDateTime updatedDate;
	
	@PrePersist
	private void generateCode() {
		this.setCode(UUID.randomUUID().toString());
	}

}
