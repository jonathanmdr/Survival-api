package br.com.survival.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "historico_busca")
public class SearchHistory {
	
	@Id
	@GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "codigo")
	private UUID code;
	
	@ManyToOne
	@JoinColumn(name = "cpf")
	private Person person;
		
	@UpdateTimestamp
	@Column(name = "data_consulta")
	private OffsetDateTime consultationDate;
	
	@Column(name = "nome_usuario")
	private String userName;

}
