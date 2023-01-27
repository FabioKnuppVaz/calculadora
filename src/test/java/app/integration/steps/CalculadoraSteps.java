package app.integration.steps;

import org.junit.Assert;
import org.springframework.boot.web.server.LocalServerPort;

import app.dtos.InputDto;
import app.dtos.OutputDto;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CalculadoraSteps {

	InputDto inputDto;
	RequestSpecification requestSpecification;
	Response response;
	
    @LocalServerPort
	int port;
	
	@Before
	public void setUp() {
		RestAssured.port = port;
		requestSpecification = RestAssured
								.given()
									.contentType(ContentType.JSON);
	}
	
    @Dado("parametrizar {double} e {double}")
    public void parametrizarXY(Double x, Double y) {
    	InputDto inputDto = new InputDto();
		inputDto.setX(x);
		inputDto.setY(y);
		
		requestSpecification
			.body(inputDto);
    }
    
	@Quando("realizar a requisicao de {string}")
	public void response(String operacao) {
		response = requestSpecification
					.when()
						.basePath("/" + operacao)
						.log()
						.all()
						.post();
	}

	@Entao("validar status code {int}")
	public void validarStatusCode(Integer statusCode) {
		response
			.then()
				.statusCode(statusCode);
	}
	
	@E("validar {double}")
	public void validar(Double z) {
		OutputDto outputDto = response
								.then()
									.extract()
									.body()
									.as(OutputDto.class);
		
		Assert.assertEquals(z, outputDto.getZ(), 0.001);
	}

}
