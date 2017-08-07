package br.com.gma.fileupload.webapi.viewmodel;

public class ObraViewModel {
	
	private long id;
	private String codigo;
	private String nome;
	
	public ObraViewModel()	{}

	public ObraViewModel(long id, String codigo, String nome) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
	
	
	
	

}
