package br.com.survival.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"code"})
@Entity
@Table(name = "debito")
public class Debit {
		
	@Id
	@GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "codigo")
	private UUID code;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cpf")
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

}
