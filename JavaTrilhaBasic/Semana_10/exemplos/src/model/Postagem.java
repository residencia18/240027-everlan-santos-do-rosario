package model;

public class Postagem {
	private int id;
	private String texto;
	private Usuario autor;
	
	public Postagem(int id, String texto, Usuario autor) {
		setId(id);
		setTexto(texto);
		setAutor(autor);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	
	
}
