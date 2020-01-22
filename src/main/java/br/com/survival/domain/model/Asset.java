package br.com.survival.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"code"})
@Entity
@Table(name = "ativo")
public class Asset {
		
	@Id
	@GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "codigo")
	private UUID code;
	
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

}
