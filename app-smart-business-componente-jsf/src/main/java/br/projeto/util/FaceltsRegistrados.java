package br.projeto.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringBufferInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.collections.MapConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import br.com.projeto.arquivo.util.FileUtil;

public class FaceltsRegistrados {

	private static final String DIRETORIO_FACELETS = "tags";
	private static final String EXTENSAO_XHTML = ".xhtml";

	public static List<StringBuilder> buscarComponentesFaceletsSB() {

		List<StringBuilder> resultado = new ArrayList<StringBuilder>();
		List<File> files = buscarComponentesFacelets();
		for (File file : files) {
			StringBuilder sb = FileUtil.read(file);
			resultado.add(sb);
		}
		return resultado;
	}

	public static List<File> buscarComponentesFacelets() {

		Path p = FileUtil.buscarDiretorio(Paths.get(PathResouceFacelet.obterDirectoriResource().toURI()),
				DIRETORIO_FACELETS);
		System.out.println("Caminho absoluto:" + p.toString());
		List<File> listaArquivos = new ArrayList<File>();
		FileUtil.buscarTodosArquivosDiretorio(p, listaArquivos, EXTENSAO_XHTML);
		for (File file : listaArquivos) {
			System.out.println("Arquivos encontrados: " + file.getName());
		}
		return listaArquivos;
	}

	public static List<File> buscarComponentesFacelets(String nomeDiretorio, String extensaoArquivo) {

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
