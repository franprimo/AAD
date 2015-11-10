
import java.io.Serializable;

public class Libro implements Serializable {
	String titulo = null;
	String autor = null;
	int añoPublicacion = 0;
	String editor = null;
	int numPaginas = 0;
	
	public Libro(String tituloLibro, String nomAutor, int año, String editorial, int paginas){
		titulo = tituloLibro;
		autor = nomAutor;
		añoPublicacion = año;
		editor = editorial;
		numPaginas = paginas;
	}

	public Libro(){
		
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAñoPublicacion() {
		return añoPublicacion;
	}

	public void setAñoPublicacion(int añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public void imprimir(){
		System.out.println("Titulo: "+titulo+"\n"+"Autor: "+autor+"\n"+"Año de publicación: "+añoPublicacion+"\n"+"Editorial: "+editor+"\n"+"Numero de paginas: "+numPaginas);
	}
}
