package app.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import app.dtos.InputDto;
import app.dtos.OutputDto;
import app.services.CalculadoraServices;


@RunWith(MockitoJUnitRunner.class)
public class CalculadoraControllerTest {

	@Spy
	InputDto inputDto;
	
	@InjectMocks
	CalculadoraServices calculadoraServices;

	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void deveSomar() {
		inputDto.setX(0.1);
		inputDto.setY(0.2);

		OutputDto outputDto = calculadoraServices.somar(inputDto);
		Assert.assertEquals(0.3, outputDto.getZ(), 0.001);
	}
	
	@Test
	public void deveSubtrair() {
		inputDto.setX(0.1);
		inputDto.setY(0.2);

		OutputDto outputDto = calculadoraServices.subtrair(inputDto);
		Assert.assertEquals(-0.1, outputDto.getZ(), 0.001);
	}

	@Test
	public void deveMultiplicar() {
		inputDto.setX(0.1);
		inputDto.setY(0.2);

		OutputDto outputDto = calculadoraServices.multiplicar(inputDto);
		Assert.assertEquals(0.02, outputDto.getZ(), 0.001);
	}

	@Test
	public void deveDividir() {
		inputDto.setX(0.1);
		inputDto.setY(0.2);

		OutputDto outputDto = calculadoraServices.dividir(inputDto);
		Assert.assertEquals(0.5, outputDto.getZ(), 0.001);
	}
}
