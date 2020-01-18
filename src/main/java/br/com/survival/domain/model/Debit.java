package br.com.survival.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "debito")
public class Debit {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo")
	private String code;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Person person;
	
	@Column(name = "razao_social_credor")
	private String corporateName;
	
	@Column(name = "cnpj_credor")
	private String cnpj;
	
	@Column(name = "contrato_credor")
	private String contractNumber;
	
	@Column(name = "data_vencimento_credor")
	private OffsetDateTime dueDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_registro_credor")
	private RegistryType registryType;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "valor_debito")
	private BigDecimal debitAmount;
	
	@CreationTimestamp
	@Column(name = "data_disponibilizacao")
	private OffsetDateTime createdDate;
	
	@UpdateTimestamp
	@Column(name = "data_atualizacao")
	private OffsetDateTime updatedDate;
	
	@PrePersist
	private void generateCode() {
		this.setCode(UUID.randomUUID().toString());
	}

}
