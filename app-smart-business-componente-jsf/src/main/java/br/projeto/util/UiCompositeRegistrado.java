package br.projeto.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import br.com.projeto.arquivo.util.FileUtil;
import br.projeto.bean.ComponenteBean;

public class UiCompositeRegistrado {

	private static final String DIRETORIO_FACELETS = "tags";
	private static final String EXTENSAO_XHTML = ".xhtml";

	private static List<StringBuilder> buscarComponentesSB() {

		List<StringBuilder> resultado = new ArrayList<StringBuilder>();
		List<ComponenteBean> componentes = buscarComponentes();
		for (ComponenteBean c : componentes) {
			StringBuilder sb = FileUtil.read(c.getStream());
			resultado.add(sb);
		}
		return resultado;
	}

	public static List<ComponenteBean> buscarComponentes() {

		Path p = FileUtil.buscarDiretorio(Paths.get(PathResouceFacelet.obterDirectoriResource().toURI()),
				DIRETORIO_FACELETS);
		System.out.println("Caminho absoluto:" + p.toString());
		List<File> arquivos = new ArrayList<File>();
		List<ComponenteBean> componentes = new ArrayList<ComponenteBean>();
		FileUtil.buscarTodosArquivosDiretorio(p, arquivos, EXTENSAO_XHTML);
		for (File file : arquivos) {
			System.out.println("Arquivos encontrados: " + file.getName());

			ComponenteBean componente = new ComponenteBean(file);
			componentes.add(componente);
		}
		return componentes;
	}

	private static List<File> buscarComponentes(String nomeDiretorio, String extensaoArquivo) {

		Path p = FileUtil.buscarDiretorio(Paths.get(PathResouceFacelet.obterDirectoriResource().toURI()),
				nomeDiretorio);
		System.out.println("Caminho absoluto:" + p.toString());
		List<File> listaArquivos = new ArrayList<File>();
		FileUtil.buscarTodosArquivosDiretorio(p, listaArquivos, extensaoArquivo);
		for (File file : listaArquivos) {
			System.out.println("Arquvios encontrados: " + file.getName());
		}
		return listaArquivos;
	}
}
