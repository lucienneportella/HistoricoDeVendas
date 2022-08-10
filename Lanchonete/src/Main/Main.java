package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		File arquivo = new File("resumoDia.txt");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

		try {
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("Data: " + dtf.format(LocalDateTime.now()));
			bw.newLine();
			bw.close();
			fw.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		String produto = null;
		int opc = 1;
		int qnt = 0;
		double valor = 0;
		double total = 0;
		while (opc != 0) {

			opc = menu(sc);

			if (opc != 0) {
				System.out.println("Entre com a quantidade: ");
				qnt = sc.nextInt();
			}

			switch (opc) {
			case 1:
				produto = "Cachorro quente";
				valor = qnt * 4.00;
				break;

			case 2:
				produto = "X-Salada";
				valor = qnt * 4.50;
				break;
			case 3:
				produto = "X-Bacon";
				valor = qnt * 5.00;
				break;

			case 4:
				produto = "Torrada simples";
				valor = qnt * 2.00;
				break;

			case 5:
				produto = "Refrigerante";
				valor = qnt * 1.50;
				break;

			}
			if (opc != 0) {
				System.out.println("Produto vendido: " + produto);
				System.out.println("Valor R$" + valor + " unidade.");
				System.out.println();
				total += valor;
				try {
					if (!arquivo.exists()) {
						arquivo.createNewFile();
					}

					FileWriter fw1 = new FileWriter(arquivo, true);
					BufferedWriter bw1 = new BufferedWriter(fw1);

					bw1.write(produto + " : " + valor);
					bw1.newLine();
					bw1.write("Total R$: " + total);
					bw1.newLine();
					bw1.close();
					fw1.close();

					FileReader fr = new FileReader(arquivo);
					BufferedReader br = new BufferedReader(fr);

					while (br.ready()) {
						String linha = br.readLine();
						System.out.println(linha);
					}
					arquivo.delete();
					br.close();
					fr.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}

			System.out.println();

		}
		System.out.println("Sistema encerrado!");

	}

	protected static int menu(Scanner sc) {

		boolean codigoValido = false;
		int opc = 0;
		while (!codigoValido) {
			System.out.println("---CARD�PIO---");
			System.out.println("1. Cachorro quente R$: 4.00");
			System.out.println("2. X-Salada        R$: 4.50");
			System.out.println("3. X-Bacon         R$: 5.00");
			System.out.println("4. Torrada simples R$: 2.00");
			System.out.println("5. Refrigerante    R$: 1.50");
			System.out.println("0. para sair\n");
			System.out.println("Entre com o c�digo do produto: ");
			opc = sc.nextInt();

			if (opc > 0 && opc <= 5) {
				codigoValido = true;
			} else if (opc == 0) {
				codigoValido = true;
			} else {
				System.out.println("Produto n�o encontrado!");

			}

		}
		return opc;
	}

}


