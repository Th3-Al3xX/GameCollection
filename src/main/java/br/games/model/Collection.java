package br.games.model;

public class Collection {
	
	private int id;
	private String nome;
	private String desenv;
	private String estilo;
	private String plataforma;
	
	public Collection() {
	}
	
	public Collection(int id, String nome, String desenv, String estilo, String plataforma) {
		super();
		this.id = id;
		this.nome = nome;
		this.desenv = desenv;
		this.estilo = estilo;
		this.plataforma = plataforma;
	}

	public Collection(String nome, String desenv, String estilo, String plataforma) {
		super();
		this.nome = nome;
		this.desenv = desenv;
		this.estilo = estilo;
		this.plataforma = plataforma;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDesenv() {
		return desenv;
	}

	public void setDesenv(String desenv) {
		this.desenv = desenv;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
}