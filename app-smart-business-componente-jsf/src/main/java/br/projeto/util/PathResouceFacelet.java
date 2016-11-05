package br.projeto.util;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;


public class PathResouceFacelet {

	public static File obterDirectoriResource(){
		
		final Class<?> referenceClass = PathResouceFacelet.class;
		final URL url =
		    referenceClass.getProtectionDomain().getCodeSource().getLocation();

		try{
		    final File jarPath = new File(url.toURI().getPath());
		    System.out.println(jarPath); // this is the path you want 
		    
		    return jarPath;
		} catch(final URISyntaxException e){
		    // etc.
		}
		
		return null;
	}
	
}
