package br.com.survival.domain.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pessoa")
public class Person {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cpf;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "data_nascimento")
	private OffsetDateTime dateOfBirth;
	
	@Column(name = "endereco")
	private String address;
	
	@OneToMany(mappedBy = "person")
	private List<Debit> debits = new ArrayList<>();
	
	@UpdateTimestamp
	@Column(name = "data_atualizacao")
	private OffsetDateTime updatedDate;

}
