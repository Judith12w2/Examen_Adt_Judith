import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class Book implements Serializable {

    @JsonProperty("titulo")  // Mapear a Titulo
    private String title;

    @JsonProperty("autor")  // Mapear a Autor
    private String author;

    @JsonProperty("anio")   // Mapear a Anio
    private int year;

    // Constructor para inicializar "tittle", "author" y "year"
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Constructor vacío (Por si las moscas)
    public Book() {}

    // Metodo toString para imprimir los libros
    @Override
    public String toString() {

        return "Book{title='" + title + "', author='" + author + "', year=" + year + "}";
    }

    // Getters
    public String getTitle() {

        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {

        return year;
    }
}

