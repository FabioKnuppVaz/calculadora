package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<OutputDto> somar(@RequestBody InputDto inputDto) {
		OutputDto outputDto = calculadoraServices.somar(inputDto);
		return ResponseEntity.ok(outputDto);
	}
	
	@PostMapping("subtrair")
	public ResponseEntity<OutputDto> subtrair(@RequestBody InputDto inputDto) {
		OutputDto outputDto = calculadoraServices.subtrair(inputDto);
		return ResponseEntity.ok(outputDto);
	}
	
	@PostMapping("multiplicar")
	public ResponseEntity<OutputDto> multiplicar(@RequestBody InputDto inputDto) {
		OutputDto outputDto = calculadoraServices.multiplicar(inputDto);
		return ResponseEntity.ok(outputDto);
	}
	
	@PostMapping("dividir")
	public ResponseEntity<OutputDto> dividir(@RequestBody InputDto inputDto) {
		OutputDto outputDto = calculadoraServices.dividir(inputDto);
		return ResponseEntity.ok(outputDto);
	}
	
	@GetMapping("memoria")
	public ResponseEntity<List<CalculadoraModel>> memoria() {
		List<CalculadoraModel> outputDto = calculadoraServices.memoria();
		return ResponseEntity.ok(outputDto);
	}
	
}
