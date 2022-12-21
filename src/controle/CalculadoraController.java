package controle;

import enums.EnumOperacao;

public class CalculadoraController {
	private Double total;
	private Boolean zero = false;
	
	public CalculadoraController() {
		total= 0.0;
	}
	
	public Double realizarOperacao(EnumOperacao operacao, Double valor) {
		if(operacao.equals(EnumOperacao.SOMA)) {
			total += valor;
		}else if(operacao.equals(EnumOperacao.SUBTRACAO)) {
			if(total == 0.0) {
				total += valor;
			}else {
				total -= valor;
			}
			
		}else if(operacao.equals(EnumOperacao.MULTIPLICACAO)) {
			if(total == 0.0) {
				total += valor;
			}else {
				total *= valor;
			}
			
		}else if(operacao.equals(EnumOperacao.DIVISAO)) {
			if(total == 0.0 && zero == false) {
				if(valor == 0.0 && valor == 0) {
					total += valor;
					zero = true;
				}else {
					total += valor;
				}
				
			}else{
				if(zero == true) {
					total = 0.0;
					zero = false;
				}else {
					total /= valor;
					zero = false;
				}
			
				
			}
			
		}
		return total;
	}
	
	public Double getTotal() {
		return this.total;
	}
	
	
	public void zerar() {
		total=0.0;
	}
}
