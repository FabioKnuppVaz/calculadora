#language: pt
#encoding: utf-8
Funcionalidade: Teste

  @CALCULAR
  Esquema do Cenario: Deve <OPERACAO>
    Dado parametrizar <X> e <Y>
    Quando realizar a requisicao de "<OPERACAO>"
    Entao validar status code 200
    E validar o valor de retorno <Z>
    E validar a memoria <ID> <X> <Y> <Z> "<OPERACAO>"

	Exemplos:
		| ID | X    | Y   | Z    | OPERACAO    |
		| 1  | 2,0  | 3,0 | 5,0  | somar       |
	 	| 2  | 5,0  | 3,0 | 2,0  | subtrair    |
		| 3  | 5,0  | 3,0 | 15,0 | multiplicar |
		| 4  | 10,0 | 2,0 | 5,0  | dividir     |
		
    