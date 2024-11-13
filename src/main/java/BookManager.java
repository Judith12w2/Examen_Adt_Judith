import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    // Agrega un libro a la lista (no persiste en archivo)
    public void addBook(Book book) {
        // TODO
    }

    public List<Book> getBooks() {
        // TODO
    }

    // Guardar el informe en un archivo de texto con el nombre del autor
    public void printReportFromAuthor(String author) {
        // La siguiente instrucción
        String fileName = author.replaceAll(" ", "_") + "_report.txt";
        // TODO
    }

    // Guarda los libros en formato json
    public void saveBooksToJsonFile(String filePath) {
        // TODO
    }

    // Carga los libros desde un archivo json
    public void loadBooksFromJsonFile(String filePath) {
        // TODO
    }

    // Método para guardar los libros en un archivo binario
    public void saveBooksToBinaryFile(String filePath) {
        // TODO
    }

    // Método para cargar los libros desde un archivo binario
    public void loadBooksFromBinaryFile(String filePath) {
        // TODO
    }
}
