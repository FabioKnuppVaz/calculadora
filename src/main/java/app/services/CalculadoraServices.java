package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dtos.InputDto;
import app.dtos.OutputDto;
import app.model.CalculadoraModel;
import app.repositories.CalculadoraRepository;

@Service
public class CalculadoraServices {
	
	@Autowired
	CalculadoraRepository calculadoraRepository;
	
	public OutputDto somar(InputDto inputDto) {
		OutputDto outputDto = new OutputDto();
		CalculadoraModel calculadoraModel = CalculadoraModel.builder()
															.x(inputDto.getX())
															.y(inputDto.getY())
															.z(inputDto.getX() + inputDto.getY())
															.operacao("soma")
															.build();

		calculadoraRepository.save(calculadoraModel);
		outputDto.setZ(calculadoraModel.getZ());
		
		return outputDto;
	}
	
	public OutputDto subtrair(InputDto inputDto) {
		OutputDto outputDto = new OutputDto();
		CalculadoraModel calculadoraModel = CalculadoraModel.builder()
															.x(inputDto.getX())
															.y(inputDto.getY())
															.z(inputDto.getX() - inputDto.getY())
															.operacao("subtracao")
															.build();

		calculadoraRepository.save(calculadoraModel);
		outputDto.setZ(calculadoraModel.getZ());
		
		return outputDto;
	}
	
	public OutputDto multiplicar(InputDto inputDto) {
		OutputDto outputDto = new OutputDto();
		CalculadoraModel calculadoraModel = CalculadoraModel.builder()
															.x(inputDto.getX())
															.y(inputDto.getY())
															.z(inputDto.getX() * inputDto.getY())
															.operacao("multiplicacao")
															.build();

		calculadoraRepository.save(calculadoraModel);
		outputDto.setZ(calculadoraModel.getZ());
		
		return outputDto;
	}
	
	public OutputDto dividir(InputDto inputDto) {
		OutputDto outputDto = new OutputDto();
		CalculadoraModel calculadoraModel = CalculadoraModel.builder()
															.x(inputDto.getX())
															.y(inputDto.getY())
															.z(inputDto.getX() / inputDto.getY())
															.operacao("divisao")
															.build();

		calculadoraRepository.save(calculadoraModel);
		outputDto.setZ(calculadoraModel.getZ());
		
		return outputDto;
	}

	public List<CalculadoraModel> memoria() {
		return calculadoraRepository.findAll();
	}
	
}
