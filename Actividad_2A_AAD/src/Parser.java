import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Parser {
	private Document dom = null;
	private ArrayList<Libro> libros = null;
	
	public Parser(){
		libros = new ArrayList<Libro>();
	}
	
	public void parseFicheroXml(String fichero){
		//Creamos un document builder factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			//Creamos un document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			//Parseamos un documento XML y obtenemos una representacion DOM
			dom = db.parse(fichero);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void parseDocument(){
		//Obtenemso el elemento raiz
		Element docEle = dom.getDocumentElement();
		
		//Obtenemos el nodelist de elementos
		NodeList nl = dom.getElementsByTagName("libro");
		if(nl != null && nl.getLength() > 0){
			for(int i = 0; i < nl.getLength(); i++){
				//Obtenemos un elemento de la lista libro
				Element el = (Element) nl.item(i);
				
				//Obtenemos un libro
				Libro lib = getLibro(el);
				
				//Lo añadimos al array
				libros.add(lib);
			}

		}
		
	}
	
	public Libro getLibro(Element libroEle){
		//Para cada elemento libro, obtenemos sus atributos
		String titulo = getTextValue(libroEle, "titulo");
		String autor = getTextValue(libroEle, "autor");
		int fPub = getIntValue(libroEle, "anoPublicacion");
		String editorial = getTextValue(libroEle, "editor");
		int numPag = getIntValue(libroEle, "numPag");
		
		//Creamos un nuevo libro con los elementos obtenidos de los nodos
		Libro nuevoLibro = new Libro(titulo, autor, fPub, editorial, numPag);
		
		return nuevoLibro;
	}
	
	private String getTextValue(Element element, String nombreEtiqueta){
		String texto = null;
		NodeList nl = element.getElementsByTagName(nombreEtiqueta);
		if(nl != null && nl.getLength() > 0){
			Element el = (Element) nl.item(0);
			texto = el.getFirstChild().getNodeValue();
		}
		return texto;
	}
	
	private int getIntValue(Element element, String nombreEtiqueta){
		return Integer.parseInt(getTextValue(element, nombreEtiqueta));
	}
	
	public void imprimir(){
		Iterator it = libros.iterator();
		while(it.hasNext()){
			Libro lib = (Libro) it.next();
			lib.imprimir();
		}
	}
}
