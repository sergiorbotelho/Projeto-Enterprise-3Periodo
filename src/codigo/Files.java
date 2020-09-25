package codigo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Files {

	public static boolean leConteudoArquivo(String cpf) {
		boolean existe = false;
		try {
			File file = new File("Cliente.txt");
			if (file.exists()) {
				FileReader reader = new FileReader(file);
				BufferedReader buffReader = new BufferedReader(reader);
				String linha = "";
				while (linha != null) {
					linha = buffReader.readLine();
					if (linha != null) {
						if (linha.contains(cpf)) {
							existe = true;
							break;
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
		return existe;
	}

	public void compra(String cod) {

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

	public void relatorioProd() {
		String[] req = new String[6];
		req[0] = ("Nome: ");
		req[1] = ("Descrição: ");
		req[2] = ("Codigo: ");
		req[3] = ("Altura: ");
		req[4] = ("Peso: ");
		req[5] = ("Preço: ");
		try {
			FileInputStream arquivo = new FileInputStream("Produto.txt");
			InputStreamReader input = new InputStreamReader(arquivo);
			BufferedReader br = new BufferedReader(input);

			String linha;

			do {
				linha = br.readLine();
				if (linha != null) {
					String[] palavras = linha.split("-");

					System.out.println("----------------------------");
					for (int i = 0; i < palavras.length; i++) {
						System.out.println(req[i] + palavras[i]);
					}
				}
			} while (linha != null);
			br.close();
		} catch (Exception e) {
			System.out.println("Erro ao ler o arquivo");
		}

	}

	public void relatorioCli(String cpf) {
		String[] req = new String[9];
		req[0] = ("Nome: ");
		req[1] = ("CPF: ");
		req[2] = ("Rua: ");
		req[3] = ("Número: ");
		req[4] = ("Bairro: ");
		req[5] = ("Cidade: ");
		req[6] = ("Estado: ");
		req[7] = ("CEP: ");

		try {
			File file = new File("Cliente.txt");
			if (file.exists()) {
				FileReader reader = new FileReader(file);
				BufferedReader buffReader = new BufferedReader(reader);
				String linha = "";
				while (linha != null) {
					linha = buffReader.readLine();
					if (linha != null) {
						if (linha.contains(cpf)) {
							String[] palavras = linha.split("-");
							System.out.println("----------------------------");
							for (int i = 0; i < palavras.length; i++) {
								if (i == 8) {
									break;
								}
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

	public void relatorioCompra() {
		String[] req = new String[6];
		req[0] = ("Nome: ");
		req[1] = ("Descrição: ");
		req[2] = ("Codigo: ");
		req[3] = ("Altura: ");
		req[4] = ("Peso: ");
		req[5] = ("Preço: ");
		try {
			FileInputStream arquivo = new FileInputStream("Compra.txt");
			InputStreamReader input = new InputStreamReader(arquivo);
			BufferedReader br = new BufferedReader(input);

			String linha;

			do {
				linha = br.readLine();
				if (linha != null) {
					String[] palavras = linha.split("-");

					System.out.println("----------------------------");
					for (int i = 0; i < palavras.length; i++) {
						System.out.println(req[i] + palavras[i]);
					}

				}
			} while (linha != null);
			br.close();
		} catch (Exception e) {
			System.out.println("Erro ao ler o arquivo");
		}

	}

	public float relatorioSaldo(String cpf, Float saldo) {

		try {
			File file = new File("Cliente.txt");
			if (file.exists()) {
				FileReader reader = new FileReader(file);
				BufferedReader buffReader = new BufferedReader(reader);
				String linha = "";
				while (linha != null) {
					linha = buffReader.readLine();
					if (linha != null) {
						if (linha.contains(cpf)) {
							String[] palavras = linha.split("-");

							for (int i = 0; i < palavras.length; i++) {
								if (i == 8) {
									String x = palavras[8];
									saldo = Float.parseFloat(x);

								}
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
		return saldo;
	}

	public float deposito(String cpf, float dep, float saldo) {

		File fil = new File("Cliente.txt");

		try {
			FileReader fr = new FileReader(fil);
			BufferedReader br = new BufferedReader(fr);

			String linha = br.readLine();
			ArrayList<String> salvar = new ArrayList();

			while (linha != null) {

				String[] vetcli = linha.split("-");
				if (vetcli[1].equals(cpf) == false) {

					salvar.add(linha);

				} else if (vetcli[1].equals(cpf) == true) {
					String x = vetcli[8];
					float par = Float.parseFloat(x);
					par += dep;
					x = String.valueOf(par);
					vetcli[8] = x;
					linha = vetcli[0] + "-" + vetcli[1] + "-" + vetcli[2] + "-" + vetcli[3] + "-" + vetcli[4] + "-"
							+ vetcli[5] + "-" + vetcli[6] + "-" + vetcli[7] + "-" + vetcli[8] + "-";
					salvar.add(linha);
				}
				linha = br.readLine();
			}
			br.close();
			fr.close();
			FileWriter fv2 = new FileWriter(fil, true);
			fv2.close();

			FileWriter fw = new FileWriter(fil);
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < salvar.size(); i++) {
				bw.write(salvar.get(i));
				bw.newLine();

			}
			bw.close();
		} catch (IOException ex) {

		}

		return saldo;

	}

	public float preco(String cod, float preco) {

		File fil = new File("Produto.txt");

		try {
			FileReader fr = new FileReader(fil);
			BufferedReader br = new BufferedReader(fr);

			String linha = br.readLine();
			ArrayList<String> salvar = new ArrayList();

			while (linha != null) {

				String[] vetcli = linha.split("-");
				if (vetcli[2].equals(cod) == false) {

					salvar.add(linha);

				} else if (vetcli[2].equals(cod) == true) {
					String x = vetcli[5];
					preco = Float.parseFloat(x);
					x = String.valueOf(preco);
					vetcli[5] = x;
					linha = vetcli[0] + "-" + vetcli[1] + "-" + vetcli[2] + "-" + vetcli[3] + "-" + vetcli[4] + "-"	+ vetcli[5] + "-";
					salvar.add(linha);
				}
				linha = br.readLine();
			}
			br.close();
			fr.close();
			FileWriter fv2 = new FileWriter(fil, true);
			fv2.close();

			FileWriter fw = new FileWriter(fil);
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < salvar.size(); i++) {
				bw.write(salvar.get(i));
				bw.newLine();

			}
			bw.close();
		} catch (IOException ex) {

		}

		return preco;

	}

	public float debitar(String cpf, float dep, float saldo) {

		File fil = new File("Cliente.txt");

		try {
			FileReader fr = new FileReader(fil);
			BufferedReader br = new BufferedReader(fr);

			String linha = br.readLine();
			ArrayList<String> salvar = new ArrayList();

			while (linha != null) {

				String[] vetcli = linha.split("-");
				if (vetcli[1].equals(cpf) == false) {

					salvar.add(linha);

				} else if (vetcli[1].equals(cpf) == true) {
					String x = vetcli[8];
					float par = Float.parseFloat(x);
					par -= dep;
					x = String.valueOf(par);
					vetcli[8] = x;
					linha = vetcli[0] + "-" + vetcli[1] + "-" + vetcli[2] + "-" + vetcli[3] + "-" + vetcli[4] + "-"
							+ vetcli[5] + "-" + vetcli[6] + "-" + vetcli[7] + "-" + vetcli[8] + "-";
					salvar.add(linha);
				}
				linha = br.readLine();
			}
			br.close();
			fr.close();
			FileWriter fv2 = new FileWriter(fil, true);
			fv2.close();

			FileWriter fw = new FileWriter(fil);
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < salvar.size(); i++) {
				bw.write(salvar.get(i));
				bw.newLine();

			}
			bw.close();
		} catch (IOException ex) {

		}

		return saldo;

	}
}