package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.CalculadoraModel;

public interface  CalculadoraRepository extends JpaRepository<CalculadoraModel, Integer>{

}
