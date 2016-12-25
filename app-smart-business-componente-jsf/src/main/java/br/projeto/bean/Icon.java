package br.projeto.bean;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum Icon {

	BOTAO_SALVAR("fa fa-save"), BOTAO_LIMPAR("fa fa-eraser"), CALENDARIO("fa fa-calendar"), CHAVE(
			"fa fa-key"), CHECK_BOX("fa fa-check-square-o"), COMPONENTE("fa fa-cubes"), EMAIL(
					"fa fa-envelope-o"), IMAGEM("fa fa-photo"), JORNAL("fa fa-newspaper-o"), LISTA(
							"fa fa-list-ul"), MENU("fa fa-navicon"), TABELA("fa fa-table"), TECLADO(
									"fa fa-keyboard-o"), TELEFONE_CLASSICO("fa fa-phone"), TELEFONE_FAX(
											"fa fa-fax"), TELEFONE_NORMAL("fa fa-tty"), TEXTO(
													"fa fa-font"), TEXTO_NORMAL("fa fa-edit"), SENHA(
															"fa fa-lock"), UPLOAD_ARQUIVO_TEXTO("fa fa-file-text-o");

	private String value;
	private static Map<String, Icon> mapaRelecaoComponenteIcon = new HashMap<String, Icon>();
	static {
		mapaRelecaoComponenteIcon.put("botao.xhtml", Icon.BOTAO_SALVAR);
		mapaRelecaoComponenteIcon.put("input-text.xhtml", Icon.TEXTO_NORMAL);

	}

	private Icon(String valor) {

		this.value = valor;
	}

	public String getValue() {
		return value;
	}

	public static Icon get(String nomeComponente) {

		if (nomeComponente != null) {

			Icon iconRegistrado = mapaRelecaoComponenteIcon.get(nomeComponente);
			if (iconRegistrado != null) {
				return iconRegistrado;
			}

			Set<Icon> icons = EnumSet.allOf(Icon.class);
			for (Icon icon : icons) {

				if (icon.getValue().equals(nomeComponente)) {
					return icon;
				}
			}

		}

		return Icon.COMPONENTE;
	}
}
