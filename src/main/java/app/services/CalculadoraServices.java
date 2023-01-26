package app.services;

import org.springframework.stereotype.Service;

import app.dtos.InputDto;
import app.dtos.OutputDto;

@Service
public class CalculadoraServices {
	
	public OutputDto somar(InputDto inputDto) {
		OutputDto outputDto = new OutputDto();
		outputDto.setZ(inputDto.getX() + inputDto.getY());
		return outputDto;
	}
	
	public OutputDto subtrair(InputDto inputDto) {
		OutputDto outputDto = new OutputDto();
		outputDto.setZ(inputDto.getX() - inputDto.getY());
		return outputDto;
	}
	
	public OutputDto multiplicar(InputDto inputDto) {
		OutputDto outputDto = new OutputDto();
		outputDto.setZ(inputDto.getX() * inputDto.getY());
		return outputDto;
	}
	
	public OutputDto dividir(InputDto inputDto) {
		OutputDto outputDto = new OutputDto();
		outputDto.setZ(inputDto.getX() / inputDto.getY());
		return outputDto;
	}
	
}
