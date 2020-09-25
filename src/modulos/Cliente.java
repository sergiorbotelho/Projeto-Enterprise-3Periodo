package modulos;

public class Cliente {

	private String nome, rua, bairro, cidade, estado, cpf, cep, numero, saldo;

	public Cliente() {
		nome = null;
		rua = null;
		bairro = null;
		cidade = null;
		estado = null;
		cpf = null;
		cep = null;
		numero = null;
		saldo = null;
		
	}
	
	public Cliente(String nome, String rua, String bairro, String cidade, String estado, String cpf, String cep, String numero, String saldo) {
		this.nome = nome;
		this.rua = rua;
		this.bairro = bairro; 
		this.cidade = cidade;
		this.estado = estado;
		this.cpf = cpf;
		this.cep = cep;
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public String getnome() {
		return nome;


	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public void setNome(String nome) {
		this.nome = nome;

	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
