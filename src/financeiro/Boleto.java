package financeiro;

public class Boleto extends Conta{

private Integer numBoleto;
	
	public Boleto() {
		super();
	}

	
	public Boleto(String numConta, float saldo, Integer numBoleto) {
		super(numConta, saldo);
		this.numBoleto = numBoleto;
	}



	public Integer getNumBoleto() {
		return numBoleto;
	}

	public void setNumBoleto(Integer numBoleto) {
		this.numBoleto = numBoleto;
	}
	
	@Override
	public float addDinheiro(float valor) {
		valor += valor*0.20;
		return valor;
	}
	
	
}
