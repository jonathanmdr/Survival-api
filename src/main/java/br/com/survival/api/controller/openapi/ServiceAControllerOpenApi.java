package br.com.survival.api.controller.openapi;

import br.com.survival.api.controller.exceptionhandler.ApiError;
import br.com.survival.api.dto.PersonDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Débitos")
public interface ServiceAControllerOpenApi {
	
	@ApiOperation("Busca uma pessoa por CPF")
	@ApiResponses({		
		@ApiResponse(code = 404, message = "Pessoa não encontrada", response = ApiError.class)
	})
	public PersonDTO findPersonAndDebtsByCpf(@ApiParam(value = "Identificador da pessoa registrado no Cadastro de Pessoas Físicas (CPF)", example = "00000000191", required = true) String cpf);

}
