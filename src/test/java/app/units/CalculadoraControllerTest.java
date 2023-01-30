package app.units;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import app.controllers.CalculadoraController;
import app.dtos.InputDto;
import app.dtos.OutputDto;
import app.model.CalculadoraModel;
import app.services.CalculadoraServices;

@RunWith(MockitoJUnitRunner.class)
public class CalculadoraControllerTest {
	
	@Mock
	OutputDto outputDto;
	
	@Mock
	List<CalculadoraModel> calculadoras;
	
	@Spy
	InputDto inputDto;
	
	@Mock
	CalculadoraServices calculadoraServices;
	
	@InjectMocks
	CalculadoraController calculadoraController;
	
	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void deveSomar() {
		Mockito.when(calculadoraServices.somar(inputDto)).thenReturn(outputDto);

		ResponseEntity<OutputDto> response = calculadoraController.somar(inputDto);
		
		Assert.assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test
	public void deveSubtrair() {	
		Mockito.when(calculadoraServices.subtrair(inputDto)).thenReturn(outputDto);

		ResponseEntity<OutputDto> response = calculadoraController.subtrair(inputDto);
		
		Assert.assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test
	public void deveMultiplicar() {		
		Mockito.when(calculadoraServices.multiplicar(inputDto)).thenReturn(outputDto);

		ResponseEntity<OutputDto> response = calculadoraController.multiplicar(inputDto);
		
		Assert.assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test
	public void deveDividir() {		
		Mockito.when(calculadoraServices.dividir(inputDto)).thenReturn(outputDto);

		ResponseEntity<OutputDto> response = calculadoraController.dividir(inputDto);
		
		Assert.assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	public void deveVerificarMemoria() {
		Mockito.when(calculadoraServices.memoria()).thenReturn(calculadoras);

		ResponseEntity<List<CalculadoraModel>> response = calculadoraController.memoria();
		
		Assert.assertEquals(200, response.getStatusCodeValue());
	}
	
}
