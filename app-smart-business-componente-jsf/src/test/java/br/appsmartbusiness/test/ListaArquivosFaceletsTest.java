package br.appsmartbusiness.test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.projeto.arquivo.util.FileUtil;
import br.projeto.util.ComponentesRegistrados;
import br.projeto.util.PathResouceFacelet;
import junit.framework.TestCase;

public class ListaArquivosFaceletsTest extends TestCase {

	@Ignore
	public void testListarTodosArquivosFacelets() {
		Path p = FileUtil.buscarDiretorio(Paths.get(PathResouceFacelet.obterDirectoriResource().toURI()), "app-smart-business-componente-jsf");
		System.out.println("Caminho absoluto:" + p.toString());
		List<File> listaArquivos = new ArrayList<File>();
		FileUtil.buscarTodosArquivosDiretorio(p, listaArquivos,".xhtml");
		for (File file : listaArquivos) {
			System.out.println("Arquvios encontrados: " + file.getName() );
		}
	}
	
	@Test
	public void testeLerArquivoFacelets(){
		
		
	}
}
