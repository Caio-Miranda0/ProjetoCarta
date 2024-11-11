package model.entities;

import java.util.ArrayList;

public class Carta {

	private String remetente;
	private String local;
	private String dataEscrita;
	private String destinatario;
	private String destino;

	private ArrayList<String> vocabulario = new ArrayList<>();

	public ArrayList<String> getVocabulario() {
		return vocabulario;
	}

	public String getRemetente() {
		return remetente;
	}

	public String getLocal() {
		return local;
	}

	public String getDataEscrita() {
		return dataEscrita;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public String getDestino() {
		return destino;
	}

	public Carta(String remetente, String local, String dataEscrita, String destinatario, String destino) {
		this.remetente = remetente;
		this.local = local;
		this.dataEscrita = dataEscrita;
		this.destinatario = destinatario;
		this.destino = destino;
	}

	public Carta() {
	}

	public void detalhes() {
		StringBuilder sb = new StringBuilder();
		sb.append("Remetente: " + remetente);
		sb.append(" Local onde mora: " + local);
		sb.append(" Data em que escreveu: " + dataEscrita);
		sb.append(" Destinatário da carta: " + destinatario);
		sb.append(" Carta enviado para o endereço: " + destino);
		System.out.println(sb.toString());
	}

}
