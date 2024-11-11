package model.application;

import java.util.ArrayList;
import java.util.Scanner;

import model.entities.Carta;
import model.entities.GeradorArquivo;
import model.entities.MaquinaEscrever;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Vamos te ajudar a escrever uma carta e gerar um arquivo .txt para diversos fins.");
		System.out.println("Você só vai precisar se preocupar com o conteúdo principal da carta.");
		System.out.println("A formatação padrão, nós faremos para você!");
		System.out.println();
		System.out.println("LEMBRETE:");
		System.out.println("Você só deve se preocupar em escrever o CONTEÚDO PRINCIPAL da carta.");
		System.out.println();
		System.out.println("Vamos começar preenchendo os dados básicos da carta: ");
		System.out.print("Remetente: ");
		String remetente = sc.nextLine();
		System.out.print("Local de onde você está escrevendo: ");
		String local = sc.nextLine();
		System.out.print("Data em que você está escrevendo (dd/mm/yyyy): ");
		String dataEscrita = sc.next();
		sc.nextLine();
		System.out.print("Destinatário da carta: ");
		String destinatario = sc.nextLine();
		System.out.print("Destino (local para onde a carta será mandada): ");
		String destino = sc.nextLine();

		Carta carta1 = new Carta(remetente, local, dataEscrita, destinatario, destino);
		System.out.println();

		System.out.println("Bom, agora vamos lá:");
		MaquinaEscrever maq = new MaquinaEscrever(carta1);
		maq.escreverPrincipal();
		ArrayList<String> cartaFeita = maq.gerarFormatoPadrao(MaquinaEscrever.getCarta().getVocabulario());
		GeradorArquivo ga = new GeradorArquivo(maq);
		System.out.println();
		System.out.println("Agora, vamos gerar o arquivo.");
		// System.out.println("Preencha o local do seu PC onde o arquivo ficará
		// armazenado. Não coloque o nome do arquivo.");
		// String localArquivo = sc.next();
		String localArquivo = "local aqui";
		// System.out.print("Agora, preencha o nome do arquivo. Não coloque a extensão:
		// ");
		// String nomeArquivo = sc.next();
		String nomeArquivo = "geradoAutomaticamenteJavaNovo";
		ga.gerarArquivo(cartaFeita, localArquivo, nomeArquivo);
		sc.close();
		// String cartaFeita = maq.gerarFormatoPadrao(maq.getCarta().getVocabulario());
		// GeradorArquivo ga = new GeradorArquivo(maq);
		// ga.gerarArquivo(cartaFeita);

	}

}
