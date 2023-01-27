package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dtos.InputDto;
import app.dtos.OutputDto;
import app.model.CalculadoraModel;
import app.services.CalculadoraServices;

@RestController
@RequestMapping
public class CalculadoraController {
	
	@Autowired
	CalculadoraServices calculadoraServices;
	
	@PostMapping("somar")
	public OutputDto somar(@RequestBody InputDto inputDto) {
		return calculadoraServices.somar(inputDto);
	}
	
	@PostMapping("subtrair")
	public OutputDto subtrair(@RequestBody InputDto inputDto) {
		return calculadoraServices.subtrair(inputDto);
	}
	
	@PostMapping("multiplicar")
	public OutputDto multiplicar(@RequestBody InputDto inputDto) {
		return calculadoraServices.multiplicar(inputDto);
	}
	
	@PostMapping("dividir")
	public OutputDto dividir(@RequestBody InputDto inputDto) {
		return calculadoraServices.dividir(inputDto);
	}
	
	@GetMapping("memoria")
	public List<CalculadoraModel> memoria() {
		return calculadoraServices.memoria();
	}
	
}
