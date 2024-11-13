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
import java.io.PrintWriter;


public class BookManager {
    private List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    // Agrega un libro a la lista (no persiste en archivo)
    public void addBook(Book book) {
        books.add(book);
    }

    // Devuelve la lista de libros
    public List<Book> getBooks() {
        return books;
    }

    // Guardar el informe en un archivo de texto con el nombre del autor
    public void printReportFromAuthor(String author) {
        // La siguiente instrucción
        String fileName = author.replaceAll(" ", "_") + "_report.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Book book : books) {
                if (book.getAuthor().equals(author)) {
                    writer.println(book);
                }
            }
            System.out.println("Informe guardado en " + fileName);
        } catch (IOException e) {
            System.err.println("Error al guardar el informe: " + e.getMessage());
        }
    }

    // Guarda los libros en formato json
    public void saveBooksToJsonFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filePath), books);
            System.out.println("Libros guardados en formato JSON en " + filePath);
        } catch (IOException e) {
            System.err.println("Error al guardar los libros en JSON: " + e.getMessage());
        }
    }

    // Carga los libros desde un archivo json
    public void loadBooksFromJsonFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Leer el archivo JSON y convertirlo a una lista de libros
            books = objectMapper.readValue(new File(filePath), new TypeReference<List<Book>>() {});
            System.out.println("Libros cargados:");
            for (Book book : books) {
                System.out.println(book);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los libros desde JSON: " + e.getMessage());
        }
    }


    // Método para guardar los libros en un archivo binario
    public void saveBooksToBinaryFile(String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(books);
            System.out.println("Libros guardados en formato binario en " + filePath);
        } catch (IOException e) {
            System.out.println("Error al guardar los libros en formato binario: " + e.getMessage());
        }
    }

    // Método para cargar los libros desde un archivo binario
    public void loadBooksFromBinaryFile(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            books = (List<Book>) in.readObject();
            System.out.println("Libros cargados desde el archivo binario.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los libros desde el archivo binario: " + e.getMessage());
        }
    }
}
