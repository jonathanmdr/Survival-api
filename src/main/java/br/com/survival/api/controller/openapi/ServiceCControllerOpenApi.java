package br.com.survival.api.controller.openapi;

import br.com.survival.api.controller.exceptionhandler.ApiError;
import br.com.survival.api.dto.EventsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Eventos")
public interface ServiceCControllerOpenApi {
	
	@ApiOperation("Busca uma pessoa e os eventos registrados para o mesmo por CPF")
	@ApiResponses({		
		@ApiResponse(code = 404, message = "Pessoa não encontrada", response = ApiError.class)
	})
	public EventsDTO findLastConsultationByCpf(@ApiParam(value = "Identificador da pessoa registrado no Cadastro de Pessoas Físicas (CPF)", example = "00000000191", required = true) String cpf);

}
