#language: pt
#encoding: utf-8
Funcionalidade: Teste

  @CALCULAR
  Esquema do Cenario: Deve <OPERACAO>
    Dado parametrizar <X> e <Y>
    Quando realizar a requisicao de "<OPERACAO>"
    Entao validar status code 200
    E validar <Z>

	Exemplos:
		| X    | Y   | Z    | OPERACAO    |
		| 2,0  | 3,0 | 5,0  | somar       |
		| 5,0  | 3,0 | 2,0  | subtrair    |
		| 5,0  | 3,0 | 15,0 | multiplicar |
		| 10,0 | 2,0 | 5,0  | dividir     |
    