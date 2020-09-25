package Programa;

import java.util.Scanner;

import codigo.Files;
import financeiro.Boleto;
import financeiro.CartaoCredito;
import financeiro.Conta;
import modulos.PainelConfig;

public class Interativo {
	int a;
	char x;
	String cpf;
	String cod;

	Scanner sc = new Scanner(System.in);
	PainelConfig Painel = new PainelConfig();
	Files files = new Files();
	Conta saldo = new Conta();
	Conta depositoCartao = new CartaoCredito();
	Conta depositoBoleto = new Boleto();

	public void enterpriseMenu() {
		boolean loopPrincipal = true;
		while (loopPrincipal) {
			Painel.enterprise();
			a = sc.nextInt();
			if (a == 1) {
				homeMenu();
			} else if (a == 2) {
				funcMenu();
			} else if (a == 3) {
				prodMenu();
			} else if (a == 4) {
				System.exit(0);
			} else {

				System.out.println("Caractere Inválido");
				System.out.println("Digite qualquer tecla para voltar...");

			}

		}
	}

	private void homeMenu() {
		boolean loophome = true;
		while (loophome) {
			Painel.home();
			a = sc.nextInt();
			if (a == 1) {
				areaAcesso();
			} else if (a == 2) {
				listProd();
			} else if (a == 3) {
				enterpriseMenu();
			}

		}
	}

	private void funcMenu() {

		do {

			Painel.funcionario();
			System.out.println();
			System.out.print("Deseja cadastrar outro funcionario? (s)/(n): ");
			x = sc.next().charAt(0);
			while (x != 's' && x != 'n') {
				System.out.print("Digite (s)/(n): ");
				x = sc.next().charAt(0);

			}
		} while (x == 's');
	}

	private void prodMenu() {

		do {

			Painel.cadPro();
			System.out.print("Deseja cadastrar outro podruto? (s)/(n) ");
			x = sc.next().charAt(0);
			while (x != 's' && x != 'n') {
				System.out.print("Digite (s)/(n): ");
				x = sc.next().charAt(0);

			}
		} while (x == 's');
	}

	private void loginCliente() {

		Painel.login();
		cpf = sc.next();
		boolean existe = Files.leConteudoArquivo(cpf);
		if (existe) {
			contaCliente();
		} else {
			do {
				System.out.print("CPF inexistente, deseja cadastrar novo cliente? (s) / (n): ");
				x = sc.next().charAt(0);
				if (x == 's') {
					cadCliente();
				} else if (x == 'n') {
					areaAcesso();
				} else {
					while (x != 's' && x != 'n') {
						System.out.print("Digite (s)/(n): ");
						x = sc.next().charAt(0);
					}
				}
			} while (x == 's');
		}
	}

	private void listProd() {
		files.relatorioProd();
		System.out.print("Digite (1) para voltar: ");
		a = sc.nextInt();
	}

	private void areaAcesso() {
		Painel.acesso();
		a = sc.nextInt();
		if (a == 1) {
			loginCliente();
		} else if (a == 2) {
			cadCliente();
		} else if (a == 3) {
			homeMenu();
		}
	}

	private void cadCliente() {
		do {
			Painel.cadastro();
			System.out.print("Deseja cadastrar outro cliente? (s)/(n) ");
			x = sc.next().charAt(0);
			if (x == 'n') {
				do {
					System.out.print("Deseja fazer login? (s)/ (n)");
					x = sc.next().charAt(0);
					if (x == 's') {
						loginCliente();
					} else if (x == 'n') {
						areaAcesso();
					}
					while (x != 's' && x != 'n') {
						System.out.print("Digite (s)/(n): ");
						x = sc.next().charAt(0);
					}
				} while (x == 's');

				while (x != 's' && x != 'n') {
					System.out.print("Digite (s)/(n): ");
					x = sc.next().charAt(0);
				}

			}
		} while (x == 's');
	}

	private void contaCliente() {
		Painel.contaCliente();
		a = sc.nextInt();
		if (a == 1) {
			loginAcesso();
		} else if (a == 2) {
			listaPedido();
		} else if (a == 3) {
			gerarPedido();
		} else if (a == 4) {
			carteiraVirtual();
		} else if (a == 5) {
			areaAcesso();
		}
	}

	private void loginAcesso() {
		files.relatorioCli(cpf);
		System.out.println("Digite (1) para voltar");
		a = sc.nextInt();
		contaCliente();

	}

	private void listaPedido() {
		files.relatorioCompra();
		System.out.println("Digite (1) para voltar");
		a = sc.nextInt();
		contaCliente();
	}

	private void gerarPedido() {
		Painel.gerarPedido();
		a = sc.nextInt();
		float s = 0;
		float preco = 0;
		if (a == 1) {
			System.out.println("Digite o codigo do produto: ");
			cod = sc.next();
			files.compra(cod);
			System.out.println("Digite (1) para confirmar (2) para cancelar");
			a = sc.nextInt();
			if (a == 1) {
				saldo.setSaldo(files.relatorioSaldo(cpf, s));
				preco = files.preco(cod, preco);
				if (saldo.getSaldo() < preco) {
					System.out.println("Saldo insuficiente.");
					System.out.print("Digite (1) para voltar: ");
					a = sc.nextInt();
					contaCliente();
				}else {
					saldo.setSaldo(files.relatorioSaldo(cpf, s));
					preco = files.preco(cod, preco);
					s = saldo.getSaldo() - preco;
					files.debitar(cpf, preco, s);
					Painel.notaFiscal(cod);
					System.out.println("Compra realizada com sucesso.");
					System.out.print("Digite (1) para voltar: ");
					a = sc.nextInt();
					contaCliente();
					
				}
			} else if (a == 2) {
				contaCliente();
				;
			}
		} else if (a == 2) {
			contaCliente();
			;
		}
	}

	/*private void pagamento() {
		Painel.pagamento();
		a = sc.nextInt();
		if (a == 1) {
			Painel.notaFiscal(cod);
		} else if (a == 2) {
			Painel.notaFiscal(cod);
		}

	}*/

	private void carteiraVirtual() {
		Painel.carteiraVirtual();
		a = sc.nextInt();
		float valor = 0;
		float s = 0;
		if (a == 1) {
			saldo.setSaldo(files.relatorioSaldo(cpf, s));
			for (int i = 0; i < 30; ++i)
				System.out.println();
			System.out.println("|||||||||||||||||||||||||||||||||");
			System.out.println("             SALDO                ");
			System.out.println("|||||||||||||||||||||||||||||||||");
			System.out.printf("Seu saldo é: %.2f\n", saldo.getSaldo());
			System.out.print("Digite 1 para voltar: ");
			a = sc.nextInt();
			contaCliente();

		} else if (a == 2) {
			Painel.deposito();
			a = sc.nextInt();
			if (a == 1) {
				System.out.println("Pagamento no boleto você receberá um bonus de 20% do valor.");
				System.out.print("Digite o valor desejado: ");
				valor = sc.nextFloat();
				valor = depositoBoleto.addDinheiro(valor);
				saldo.setSaldo(files.deposito(cpf, valor, s));
				System.out.println("Deposito realizado com sucesso! ");
				saldo.setSaldo(files.relatorioSaldo(cpf, s));
				System.out.printf("Seu saldo é: %.2f", saldo.getSaldo());
				System.out.print("Digite (1) para voltar: ");
				a = sc.nextInt();
				contaCliente();
			} else if (a == 2) {
				System.out.println("Pagamento no cartão você terá juros de 10% do valor.");
				System.out.print("Digite o valor desejado: ");
				valor = sc.nextFloat();
				valor = depositoCartao.addDinheiro(valor);
				saldo.setSaldo(files.deposito(cpf, valor, s));
				System.out.println("Deposito realizado com sucesso! ");
				saldo.setSaldo(files.relatorioSaldo(cpf, s));
				System.out.printf("Seu saldo é: %.2f\n", saldo.getSaldo());
				System.out.print("Digite (1) para voltar: ");
				a = sc.nextInt();
				contaCliente();
			}

		} else if (a == 3) {
			contaCliente();
		}
	}

}
