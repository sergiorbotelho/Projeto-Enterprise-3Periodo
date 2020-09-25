package modulos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

import codigo.Files;

public class PainelConfig implements Painel {

	Cliente cliente = new Cliente();
	Produto produto = new Produto();
	Funcionario func = new Funcionario(null, null, null, null, null, null, null, null, null, null);
	Scanner sc = new Scanner(System.in);

	Files file = new Files();

	@Override
	public void enterprise() {

		for (int i = 0; i < 30; ++i)
			System.out.println();
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("         LOJA ENTERPRISE        ");
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("                                 ");
		System.out.println(" _______________________________");
		System.out.println("|                               |");
		System.out.println("|(1) => Acesso a Loja           |");
		System.out.println("|(2) => Cadastro de Funcionários|");
		System.out.println("|(3) => Cadastro de Produto     |");
		System.out.println("|(4) => Sair                    |");
		System.out.println("|_______________________________|");
		System.out.printf("");
		System.out.print("Digite a opção desejada: ");

	}

	@Override
	public void home() {

		for (int i = 0; i < 30; ++i)
			System.out.println();
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("             HOME                ");
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("");
		System.out.println(" ________________________________");
		System.out.println("|(1) => Login do cliente         |");
		System.out.println("|(2) => Listar produtos          |");
		System.out.println("|(3) => Voltar ao menu anterior  |");
		System.out.println("|________________________________| ");
		System.out.println("");
		System.out.print("Digite a opção desejada: ");

	}

	@Override
	public void acesso() {

		for (int i = 0; i < 30; ++i)

			System.out.println();
		System.out.println("||||||||||||||||||||||||||||||||||||");
		System.out.println("          ÁREA DE ACESSO            ");
		System.out.println("||||||||||||||||||||||||||||||||||||");
		System.out.println("");
		System.out.println(" __________________________________");
		System.out.println("|                                  |");
		System.out.println("|(1) => Entrar na conta do cliente |");
		System.out.println("|(2) => Cadastra cliente           |");
		System.out.println("|(3) => Voltar home                |");
		System.out.println("|__________________________________|");
		System.out.println("");
		System.out.print("Digite a opção desejada: ");

	}

	@Override
	public void login() {

		for (int i = 0; i < 30; ++i)
			System.out.println();
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("               LOGIN             ");
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("");
		System.out.print("Digite seu Cpf:");

	}

	@Override
	public void cadastro() {

		for (int i = 0; i < 30; ++i)
			System.out.println();
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("       CADASTRO DE CLIENTE       ");
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("                                 ");
		System.out.print("Nome:");
		cliente.setNome(sc.nextLine());
		System.out.print("CPF:");
		cliente.setCpf(sc.nextLine());
		System.out.print("Rua:");
		cliente.setRua(sc.nextLine());
		System.out.print("Número:");
		cliente.setNumero(sc.nextLine());
		System.out.print("Bairro:");
		cliente.setBairro(sc.nextLine());
		System.out.print("Cidade:");
		cliente.setCidade(sc.nextLine());
		System.out.print("Estado:");
		cliente.setEstado(sc.nextLine());
		System.out.print("CEP:");
		cliente.setCep(sc.nextLine());
		cliente.setSaldo("0");
		String[] vetcli = new String[9];

		vetcli[0] = (cliente.getnome());
		vetcli[1] = (cliente.getCpf());
		vetcli[2] = (cliente.getRua());
		vetcli[3] = (cliente.getNumero());
		vetcli[4] = (cliente.getBairro());
		vetcli[5] = (cliente.getCidade());
		vetcli[6] = (cliente.getEstado());
		vetcli[7] = (cliente.getCep());
		vetcli[8] = (cliente.getSaldo());
		try {
			FileOutputStream arquivo = new FileOutputStream("Cliente.txt", true);
			PrintWriter pr = new PrintWriter(arquivo);

			for (int i = 0; i < 9; i++) {
				pr.print(vetcli[i] + "-");

			}
			pr.println();

			pr.close();
			arquivo.close();

		} catch (Exception e) {
			System.out.println("Erro ao escrever o arquivo");
		}

	}

	@Override
	public void cadPro() {

		for (int i = 0; i < 30; ++i)
			System.out.println();
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("       CADASTRO DE PRODUTO       ");
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("                                 ");
		System.out.println("Nome do produto:");
		produto.setNome(sc.nextLine());
		System.out.println("Descrição:");
		produto.setDescricao(sc.nextLine());
		System.out.println("Código:");
		produto.setCodigo(sc.nextLine());
		System.out.println("Altura:");
		produto.setAltura(sc.nextLine());
		System.out.println("Peso:");
		produto.setPeso(sc.nextLine());
		System.out.println("Preço:");
		produto.setPreco(sc.nextLine());
		String[] vetprod = new String[6];

		vetprod[0] = produto.getNome();
		vetprod[1] = produto.getDescricao();
		vetprod[2] = produto.getCodigo();
		vetprod[3] = produto.getAltura();
		vetprod[4] = produto.getPeso();
		vetprod[5] = produto.getPreco();

		try {
			FileOutputStream arquivo1 = new FileOutputStream("Produto.txt", true);
			PrintWriter pr1 = new PrintWriter(arquivo1);

			for (int i = 0; i < 6; i++) {
				pr1.print(vetprod[i] + "-");

			}
			pr1.println();

			pr1.close();
			arquivo1.close();

		} catch (Exception e) {
			System.out.println("Erro ao escrever o arquivo");
		}

	}

	@Override
	public void contaCliente() {

		for (int i = 0; i < 30; ++i)
			System.out.println();
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("         CONTA DO CLIENTE        ");
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("                                 ");
		System.out.println(" _______________________________");
		System.out.println("|                               |");
		System.out.println("|(1) => Perfil do cliente       |");
		System.out.println("|(2) => lista de pedidos        |");
		System.out.println("|(3) => Fazer pedidos           |");
		System.out.println("|(4) => Carteira Virtual        |");
		System.out.println("|(5) => Sair                    |");
		System.out.println("|_______________________________|");
		System.out.printf("");
		System.out.print("Digite a opção desejada: ");

	}
	
	@Override
	public void carteiraVirtual() {
		
		for (int i = 0; i < 30; ++i)
			System.out.println();
		System.out.println();
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("         CARTEIRA VIRTUAL        ");
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("                                 ");
		System.out.println("                                 ");
		System.out.println(" _________________________________");
		System.out.println("|(1) => Saldo                     |");
		System.out.println("|(2) => Fazer Deposito            |");
		System.out.println("|(3) => Voltar ao menu anterior   |");
		System.out.println("|_________________________________|");
		System.out.println("                                   ");
		System.out.print("Digite a opção desejada: ");
	}

	@Override
	public void gerarPedido() {

		for (int i = 0; i < 30; ++i)
			System.out.println();
		System.out.println("||||||||||||||||||||||||||||||||||");
		System.out.println("            GERAR PEDIDOS         ");
		System.out.println("||||||||||||||||||||||||||||||||||");
		System.out.println("");
		System.out.println(" _________________________________");
		System.out.println("|(1) => Digitar cógido do produto |");
		System.out.println("|(2) => Voltar ao menu anterior   |");
		System.out.println("|_________________________________|");
		System.out.println("");
		System.out.print("Digite a opção desejada: ");

	}

	@Override
	public void pagamento() {

		for (int i = 0; i < 30; ++i)
			System.out.println();
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("             PAGAMENTO           ");
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("");
		System.out.println(" ________________________________");
		System.out.println("|(1) => Boleto                   |");
		System.out.println("|(2) => Cartão                   |");
		System.out.println("|                                |");
		System.out.println("|________________________________| ");
		System.out.println("");
		System.out.print("Digite a forma de pagamento desejada: ");

	}

	@Override
	public void funcionario() {

		for (int i = 0; i < 30; ++i)
			System.out.println();
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("      	  FUNCIONÁRIOS	         ");
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("                                 ");
		System.out.print("Nome:");
		func.setNome(sc.nextLine());
		System.out.print("CPF:");
		func.setCpf(sc.nextLine());
		System.out.print("Rua:");
		func.setRua(sc.nextLine());
		System.out.print("Número:");
		func.setNumero(sc.nextLine());
		System.out.print("Bairro:");
		func.setBairro(sc.nextLine());
		System.out.print("Cidade:");
		func.setCidade(sc.nextLine());
		System.out.print("Estado:");
		func.setEstado(sc.nextLine());
		System.out.print("CEP:");
		func.setCep(sc.nextLine());
		
		System.out.print("Registro:");
		func.setRegistro(sc.next());
		System.out.print("Cadastro realizado com sucesso.");
		String[] vetfun = new String[9];

		vetfun[0] = func.getnome();
		vetfun[1] = func.getCpf();
		vetfun[2] = func.getRua();
		vetfun[3] = func.getNumero();
		vetfun[4] = func.getBairro();
		vetfun[5] = func.getCidade();
		vetfun[6] = func.getEstado();
		vetfun[7] = func.getCep();
		vetfun[8] = func.getRegistro();

		try {
			FileOutputStream arquivo = new FileOutputStream("Funcionario.txt", true);
			PrintWriter pr = new PrintWriter(arquivo);

			for (int i = 0; i < 9; i++) {
				pr.print(vetfun[i] + "-");

			}
			pr.println();

			pr.close();
			arquivo.close();

		} catch (Exception e) {
			System.out.println("Erro ao escrever o arquivo");
		}
	}

	@Override
	public void compraProd(String cod) {

		String[] req = new String[6];
		req[0] = ("Nome: ");
		req[1] = ("Descrição: ");
		req[2] = ("Codigo: ");
		req[3] = ("Altura: ");
		req[4] = ("Peso: ");
		req[5] = ("Preço: ");
		try {
			File file = new File("Produto.txt");
			if (file.exists()) {
				FileReader reader = new FileReader(file);
				BufferedReader buffReader = new BufferedReader(reader);
				String linha = "";
				while (linha != null) {
					linha = buffReader.readLine();
					if (linha != null) {
						if (linha.contains(cod)) {
							String[] palavras = linha.split("-");
							System.out.println("----------------------------");
							for (int i = 0; i < palavras.length; i++) {
								System.out.println(req[i] + palavras[i]);
							}
						}
					}
				}
				buffReader.close();
			} else {
				System.out.println("Arquivo " + file + " não encontrado ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void notaFiscal(String cod) {

		String[] req = new String[6];
		req[0] = ("Nome: ");
		req[1] = ("Descrição: ");
		req[2] = ("Codigo: ");
		req[3] = ("Altura: ");
		req[4] = ("Peso: ");
		req[5] = ("Preço: ");
		try {
			File file = new File("Produto.txt");
			if (file.exists()) {
				FileReader reader = new FileReader(file);
				BufferedReader buffReader = new BufferedReader(reader);
				String linha = "";
				while (linha != null) {
					linha = buffReader.readLine();
					if (linha != null) {
						if (linha.contains(cod)) {
							String[] palavras = linha.split("-");

							for (int i = 0; i < palavras.length; i++) {
								System.out.println(req[i] + palavras[i]);

							}
							FileOutputStream arquivo = new FileOutputStream("Compra.txt", true);
							PrintWriter pr = new PrintWriter(arquivo);

							for (int j = 0; j < 6; j++) {
								pr.print(palavras[j] + "-");
							}
							pr.println();
							pr.close();
						}
					}
				}
				buffReader.close();
			} else {
				System.out.println("Arquivo " + file + " não encontrado ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void deposito() {

		for (int i = 0; i < 30; ++i)
			System.out.println();
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("             DEPOSITO           ");
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("");
		System.out.println(" ________________________________");
		System.out.println("|(1) => Boleto                   |");
		System.out.println("|(2) => Cartão                   |");
		System.out.println("|                                |");
		System.out.println("|________________________________| ");
		System.out.println("");
		System.out.print("Digite a forma de pagamento desejada: ");


}
}