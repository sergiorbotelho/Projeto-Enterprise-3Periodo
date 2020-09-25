package financeiro;

public class CartaoCredito extends Conta{

	private double numCartao;
	
	public CartaoCredito() {
		super();
	}

	public CartaoCredito(String numConta, float saldo, double numCartao) {
		super(numConta, saldo);
		this.numCartao = numCartao;
	}

	public double getNumCartao() {
		return numCartao;
	}

	public void setNumCartao(double numCartao) {
		this.numCartao = numCartao;
	}
	
	@Override
	public float addDinheiro(float valor) {
		valor -= valor*0.10;
		return valor;
	}
	
	
}
