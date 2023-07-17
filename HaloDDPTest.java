import static org.junit.Assert.*;
import org.junit.Test;

public class HaloDDPTest {

    @Test
    public void testBeliObat() {
        Lemari lemari = new Lemari(1);
        Rak rak = new Rak(3, "Paracetamol");
        Obat obat = new Obat("Panadol", 30, "Paracetamol");

        lemari.addRak(rak, 0);

        // Test case 1: jika obat tidak ditemukan atau null
        boolean result1 = lemari.beliObat(null, 5);
        assertEquals(false ,result1);

        // Test case 2: Jika membeli obat lebih banyak dari stok yang tersedia
        boolean result2 = lemari.beliObat(obat, 45);
        assertEquals(false , result2);

        // Test case 3: Obat ada dan stok nya lebih atau dari sama dengan dari yang akan dibeli
        boolean result3 = lemari.beliObat(obat, 20);
        assertEquals(true , result3);
    }

    @Test
    public void testSearchObat() {
        Lemari lemari = new Lemari(2);
        Rak rak1 = new Rak(3, "Paracetamol");
        lemari.addRak(rak1, 0);
        Rak rak2 = new Rak(3, "Antacid");
        lemari.addRak(rak2, 1);
        Obat obat1 = new Obat("Panadol", 30, "Paracetamol");
        rak1.tambahObat(obat1, 2);
        Obat obat2 = new Obat("Promaag", 30, "Antacid");
        rak2.tambahObat(obat2, 0);

        // Test case 1: Jika obat ditemukan atau tersedia
        Obat result1 = lemari.searchObat("Panadol");
        assertEquals(obat1, result1);

        // Test case 2: Jika obat tidak tersedia
        Obat result2 = lemari.searchObat("Ibuprofen");
        assertNull(result2);
    }
}



