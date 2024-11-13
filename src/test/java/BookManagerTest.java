import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class BookManagerTest {

    private BookManager bookManager;
    private final String jsonFilePath = "test_books.json";
    private final String binaryFilePath = "test_books.bin";

    @BeforeEach
    public void setUp() {
        bookManager = new BookManager();
        bookManager.addBook(new Book("Dune", "Frank Herbert", 1965));
        bookManager.addBook(new Book("Dune Messiah", "Frank Herbert", 1969));
    }

    @AfterEach
    public void tearDown() {
        // Limpieza de archivos de prueba
        new File(jsonFilePath).delete();
        new File(binaryFilePath).delete();
        new File("Frank_Herbert_report.txt").delete();
    }

    @Test
    public void testAddBook() {
        int initialSize = bookManager.getBooks().size();
        bookManager.addBook(new Book("Children of Dune", "Frank Herbert", 1976));
        assertEquals(initialSize + 1, bookManager.getBooks().size());
    }

    @Test
    public void testPrintReportFromAuthor() {
        // Genera el informe para "Frank Herbert" y verifica que el archivo existe
        bookManager.printReportFromAuthor("Frank Herbert");
        File reportFile = new File("Frank_Herbert_report.txt");
        assertTrue(reportFile.exists());

        // Verifica el contenido del informe
        try {
            String content = new String(java.nio.file.Files.readAllBytes(reportFile.toPath()));
            assertTrue(content.contains("Dune"));
            assertTrue(content.contains("Dune Messiah"));
        } catch (IOException e) {
            fail("Error al leer el archivo de informe");
        }
    }

    @Test
    public void testSaveBooksToJsonFile() {
        bookManager.saveBooksToJsonFile(jsonFilePath);
        File jsonFile = new File(jsonFilePath);
        assertTrue(jsonFile.exists());
    }

    @Test
    public void testLoadBooksFromJsonFile() {
        // Guarda en JSON y luego vuelve a cargar
        bookManager.saveBooksToJsonFile(jsonFilePath);
        BookManager loadedManager = new BookManager();
        loadedManager.loadBooksFromJsonFile(jsonFilePath);

        assertEquals(bookManager.getBooks().size(), loadedManager.getBooks().size());
        assertEquals(bookManager.getBooks().get(0).getTitle(), loadedManager.getBooks().get(0).getTitle());
    }

    @Test
    public void testSaveBooksToBinaryFile() {
        bookManager.saveBooksToBinaryFile(binaryFilePath);
        File binaryFile = new File(binaryFilePath);
        assertTrue(binaryFile.exists());
    }

    @Test
    public void testLoadBooksFromBinaryFile() {
        // Guarda en binario y luego vuelve a cargar
        bookManager.saveBooksToBinaryFile(binaryFilePath);
        BookManager loadedManager = new BookManager();
        loadedManager.loadBooksFromBinaryFile(binaryFilePath);

        assertEquals(bookManager.getBooks().size(), loadedManager.getBooks().size());
        assertEquals(bookManager.getBooks().get(0).getTitle(), loadedManager.getBooks().get(0).getTitle());
    }
}