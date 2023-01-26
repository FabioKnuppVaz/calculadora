package app.integration.steps;

import org.springframework.boot.web.server.LocalServerPort;

import app.dtos.InputDto;
import io.cucumber.java.pt.Dado;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CalculadoraSteps {

    @LocalServerPort
    int port;
	
	@Dado("realizar a requisicao de soma")
	public void realizarARequisicaoDeSoma() {
		RestAssured.port = port;
		
		InputDto inputDto = new InputDto();
		inputDto.setX(2.0);
		inputDto.setY(3.0);
		
		RestAssured
		.given()
			.basePath("/somar")
			.contentType(ContentType.JSON)
			.body(inputDto)
		.when()
			.log()
			.all()
			.post()
		.then()
			.statusCode(200);

	}

}
