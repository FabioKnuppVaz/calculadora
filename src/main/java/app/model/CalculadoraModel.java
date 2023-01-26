package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class CalculadoraModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	Double x;
	Double y;
	Double z;
	String operacao;

}
