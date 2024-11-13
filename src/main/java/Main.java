import java.io.File;

public class Main {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();

        // Intentar cargar libros desde el archivo JSON al inicio
        String jsonFilePath = "books.json";
        File jsonFile = new File(jsonFilePath);

        if (jsonFile.exists()) {
            System.out.println("Cargando libros desde " + jsonFilePath + "...");
            bookManager.loadBooksFromJsonFile(jsonFilePath);
        } else {
            System.out.println("No se encontró " + jsonFilePath + ". Iniciando con una lista vacía.");
        }

        // Mostrar los libros cargados (asumiendo un método toString en Book para visualización)
        System.out.println("Libros cargados:");
        for (Book book : bookManager.getBooks()) { // Asegúrate de tener un método getBooks() en BookManager
            System.out.println(book);
        }

        // Añadir dos libros más del mismo autor
        bookManager.addBook(new Book("Dune Messiah", "Frank Herbert", 1969));
        bookManager.addBook(new Book("Children of Dune", "Frank Herbert", 1976));

        // Guardar el informe de un autor con más de dos libros en un archivo de texto
        bookManager.printReportFromAuthor("Frank Herbert");

        // Guardar los libros actualizados en el archivo JSON
        bookManager.saveBooksToJsonFile(jsonFilePath);

        // Guardar los libros en un archivo binario
        String binaryFilePath = "books.bin";
        bookManager.saveBooksToBinaryFile(binaryFilePath);

        // Cargar los libros desde el archivo binario para comprobar la funcionalidad
        System.out.println("Cargando libros desde el archivo binario...");
        bookManager.loadBooksFromBinaryFile(binaryFilePath);

        // Mostrar los libros cargados desde el archivo binario
        System.out.println("Libros cargados desde el archivo binario:");
        for (Book book : bookManager.getBooks()) {
            System.out.println(book);
        }
    }
}