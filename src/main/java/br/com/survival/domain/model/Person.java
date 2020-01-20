package br.com.survival.domain.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
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
	private String cpf;
	
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "codigo")
	private UUID code;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "data_nascimento")
	private OffsetDateTime dateOfBirth;
	
	@Column(name = "endereco")
	private String address;
	
	@OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
	private List<Debit> debits = new ArrayList<>();
	
	@UpdateTimestamp
	@Column(name = "data_atualizacao")
	private OffsetDateTime updatedDate;
	
	@Transient
	private int age;
	
	public int getAge() {		
		return OffsetDateTime.now().getYear() - getDateOfBirth().getYear();
	}

}
