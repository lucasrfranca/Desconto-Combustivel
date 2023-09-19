package br.com.controle;

public class Calculo {
	
	private double litros, total;
	
	public double getLitros() {
		return litros;
	}

	public void setLitros(double litros) {
		this.litros = litros;
	}

	public double descontoAlcool() {
		
		if (litros <= 20 ) {
			
			total = 5.72*litros;
			
		}
		
		else {
			
			total = 5.60*litros;
			
		}
		
		return total;
		
	}
	
	public double descontoGas() {
		
		if (litros <= 20) {
			
			total = 6.04*litros;
			
		}
		
		else {
			
			total = 5.92*litros;
			
		}
		
		return total;
	}
}
