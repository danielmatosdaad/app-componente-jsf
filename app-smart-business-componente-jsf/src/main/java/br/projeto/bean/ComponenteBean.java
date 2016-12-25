package br.projeto.bean;

import java.io.File;

public class ComponenteBean {

	private String nome;
	private File stream;
	private Icon icon;

	public ComponenteBean() {
	}

	public ComponenteBean(String nome, File stream, Icon icon) {
		super();
		this.nome = nome;
		this.stream = stream;
		this.icon = icon;
	}

	public ComponenteBean(File stream) {
		super();
		this.nome = stream.getName();
		this.stream = stream;
		this.icon = Icon.get(stream.getName());
	}

	public File getStream() {
		return stream;
	}

	public void setStream(File stream) {
		this.stream = stream;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
