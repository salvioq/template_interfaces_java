package librofx;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Libro {
	private StringProperty titulo = 
		new SimpleStringProperty(this, "titulo", "Desconocido");
	private StringProperty autor = 
		new SimpleStringProperty(this, "autor", "Desconocido");
	private DoubleProperty precio = 
		new SimpleDoubleProperty(this, "precio", 0.0);
	private ReadOnlyStringWrapper ISBN = 
		new ReadOnlyStringWrapper(this, "ISBN", "Desconocido");
        private IntegerProperty id = new SimpleIntegerProperty();
        
        public ArrayList<Libro> almacenLibros = new ArrayList<Libro>();
        private static int idContador = 0;
        
        
	public Libro() {
	}

	public Libro(String titulo, String autor, double precio, String ISBN) {
		this.titulo.set(titulo);
		this.titulo.set(autor);
                this.precio.set(precio);
		this.ISBN.set(ISBN);
                this.id.set(idContador++);
	}

	public final String getTitulo() {
		return titulo.get();
	}

	public final void setTitulo(String titulo) {
		this.titulo.set(titulo);
	}

	public final StringProperty tituloProperty() {
		return titulo;
	}

	public final String getAutor() {
		return autor.get();
	}

	public final void setAutor(String autor) {
		this.autor.set(autor);
	}

	public final StringProperty autorProperty() {
		return autor;
	}

        public final double getPrecio() {
		return precio.get();
	}

	public final void setPrecio(double precio) {
		this.precio.set(precio);
	}

	public final DoubleProperty precioProperty() {
		return precio;
	}

	public final String getISBN() {
		return ISBN.get();
	}

	public final ReadOnlyStringProperty ISBNProperty() {
		return ISBN.getReadOnlyProperty();
	}


        // metodos utiles y/o sobrecargados
      	//
        public boolean save()
        {
            if(isValid())
            {
                   almacenLibros.add(this);
                   return true;
            }
            return false;
        }
        
        public ArrayList<Libro> getAlmacenLibros(){
            return almacenLibros;
        }
        
        //lista de errores
        private final ObjectProperty<ArrayList<String>> errorList = new SimpleObjectProperty<>(this, "errorList", new ArrayList<>());
 
        public ObjectProperty<ArrayList<String>> errorsProperty()
        {
            return errorList;
        }

        public boolean isValid()    {
            boolean isValid = true;

            if(titulo.get() != null && titulo.get().equals(""))
            {
                errorList.getValue().add("Titulo vacio!");
                isValid = false;
            }
            if(autor.get().equals(""))
            {
                errorList.getValue().add("Autor vacio!");
                isValid = false;
            }
            if(ISBN.get().equals(""))
            {
                errorList.getValue().add("ISBN vacio!");
                isValid = false;
            }
            return isValid;
        }

    	public int compareTo(Libro l) {
		// Assume that the first and last names are always not null
		int diff = this.getTitulo().compareTo(l.getTitulo());
		if (diff == 0) {
			diff = this.getAutor().compareTo(l.getAutor());
		}
		return diff;
	}
    
    
	@Override
	public String toString() {
             return "[ Id:    " + String.valueOf(id.get())+ 
                "\n[Titulo: " + getTitulo() + 
                "\n[Autor:  " + getAutor() + 
                "\n[Precio: " + Double.toString(getPrecio()) +
                "\n[ISBN:   " + getISBN() + "]";
	}

}
