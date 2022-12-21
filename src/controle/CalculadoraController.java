package controle;

import enums.EnumOperacao;

public class CalculadoraController {
	private Double total;
	
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
			total *= valor;
		}else if(operacao.equals(EnumOperacao.DIVISAO)) {
			total /= valor;
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
