package br.com.survival.api.dto;

import java.time.OffsetDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LastSearchDTO {
	
	private String code;
	private OffsetDateTime consultationDate;
	private EstablishmentDTO establishment;

}
