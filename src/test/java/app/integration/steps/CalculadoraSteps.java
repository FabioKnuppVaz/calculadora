package app.integration.steps;

import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;

import app.dtos.InputDto;
import app.dtos.OutputDto;
import app.model.CalculadoraModel;
import app.repositories.CalculadoraRepository;
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

	@Autowired
	CalculadoraRepository calculadoraRepository;
	
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
	
	@E("validar o valor de retorno {double}")
	public void validar(Double z) {
		OutputDto outputDto = response
								.then()
									.extract()
									.body()
									.as(OutputDto.class);
		
		Assert.assertEquals(z, outputDto.getZ(), 0.001);
	}
	
	@E("validar a memoria {int} {double} {double} {double} {string}")
	public void validarAMemoria(Integer id, Double x, Double y, Double z, String operacao) {
		List<CalculadoraModel> calculadorasModel = calculadoraRepository.findAll();
		
		CalculadoraModel model = calculadorasModel
			.stream()
				.filter(calcladoraModel -> calcladoraModel.getId() == id)
				.findFirst()
				.get();
		
		Assert.assertEquals(x, model.getX(), 0.001);
		Assert.assertEquals(y, model.getY(), 0.001);
		Assert.assertEquals(z, model.getZ(), 0.001);
		Assert.assertEquals(operacao, model.getOperacao());
	}

}
