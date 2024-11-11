package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MaquinaEscrever {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:MM:ss");
	
	private static Date data = new Date();
	private static Carta carta;
	private static final String marcaDagua = "DOCUMENTO GERADO PELO PROGRAMA JAVA FEITO POR CAIO CHARLES EM " + sdf.format(data);
	public MaquinaEscrever(Carta carta) {
		MaquinaEscrever.carta = carta;
	}

	public static Carta getCarta() {
		return carta;
	}

	public void escreverPrincipal() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Para começar a escrever o conteúdo principal da carta, digite y: ");
		String controlador = sc.next();
		while (controlador.equalsIgnoreCase("y")) {
			System.out.println("Insira seu texto: ");
			sc.nextLine();
			String texto = sc.nextLine();
			MaquinaEscrever.carta.getVocabulario().add(texto);
			System.out.println("Continuar a escrever? y/n");
			controlador = sc.next();
		}
		sc.close();
	}

	public ArrayList<String> gerarFormatoPadrao(ArrayList<String> vocabulario) {

		ArrayList<String> cartaFeita = new ArrayList<>();
		cartaFeita.add(MaquinaEscrever.carta.getLocal() + ", " + MaquinaEscrever.carta.getDataEscrita());
		cartaFeita.add("\n\n");
		cartaFeita.add("Prezado(a) " + MaquinaEscrever.carta.getDestinatario() + ",");
		cartaFeita.add("\n\n");
		for (String texto : vocabulario) {
			cartaFeita.add(texto.indent(5) + "\n");
		}
		cartaFeita.add("\n");
		cartaFeita.add("Atenciosamente,");
		cartaFeita.add("\n\n" + MaquinaEscrever.carta.getRemetente() + ".");
		cartaFeita.add("\n\n" + marcaDagua);
		return cartaFeita;
	}

}
