package financeiro;

public class Conta {

	public String numConta;
	public float saldo;
	
	
	public Conta() {
		
	}

	public Conta(String numConta, float saldo) {
		this.numConta = numConta;
		this.saldo = saldo;
	}

	public String getNumConta() {
		return numConta;
	}

	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public float addDinheiro(float valor) {
		return valor;
	}
	
	public float debitar(float valor) {
		return valor;
	}
	

	
	
}
