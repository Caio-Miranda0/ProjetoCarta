package model.entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GeradorArquivo {

	private MaquinaEscrever maquina;

	public MaquinaEscrever getMaquina() {
		return maquina;
	}

	public GeradorArquivo(MaquinaEscrever maquina) {
		this.maquina = maquina;
	}

	public static String extensaoPadrao = ".txt";

	public void gerarArquivo(ArrayList<String> cartaFeita, String localArquivo, String nomeArquivo) {
		StringBuilder sb = new StringBuilder();
		sb.append(localArquivo);
		sb.append("\\" + nomeArquivo);
		sb.append(extensaoPadrao);
		localArquivo = sb.toString();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(localArquivo))) {

			double porcentagem = 0, controle = 1;

			for (int i = 0; i < cartaFeita.size(); i++) {
				if (i == 0) {
					System.out.println("Gerando o documento...");
				}
				bw.write(cartaFeita.get(i));
				bw.newLine();
				porcentagem = controle / cartaFeita.size() * 100;
				controle++;
				System.out.println("Progresso: " + porcentagem + "%");
			}
			System.out.println("Documento gerado com sucesso!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
