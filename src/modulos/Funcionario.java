package modulos;

public class Funcionario extends Cliente{
	
	
	private String registro;

	
	public Funcionario(String nome, String rua, String bairro, String cidade, String estado, String cpf, String cep,
			String numero, String saldo, String registro) {
		super(nome, rua, bairro, cidade, estado, cpf, cep, numero, saldo);
		this.registro = registro;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}
	



	
}
