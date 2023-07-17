// Class untuk objek rak
public class Rak {
    private int size;
    private String kategori;
    private Obat[] daftarObat;

    /**
     * Constructor untuk membuat objek rak yang berisi obat
     * @param size parameter ukuran rak (berisi berapa banyak obat)
     * @param kategori parameter yang menyatakan kategori obat yang disimpan rak
     */
    public Rak(int size, String kategori){
        this.kategori = kategori;
        this.daftarObat = new Obat[size];
        this.size = size;
    }

    /**
     * Method accessor untuk mendapatkan kategori rak
     * @return mengembalikan kategori dari rak
     */
    // TODO : Implementasi method getKategoriRak
    public String getKategoriRak() {
        return kategori;
    }

    /**
     * Method untuk menambahkan obat ke rak
     * @param obat parameter obat apa yang akan ditambahkan
     * @param index parameter posisi pada rak obat akan ditambahkan
     */
    // TODO : Implementasi method tambahObat
    public void tambahObat(Obat obat, int index) {
        this.daftarObat[index] = obat;
    }
    
    /**
     * Method untuk mencetak rak
     */
    // TODO : Implementasi method printRak
    public void printRak(){
        for (int i = 0 ; i < this.size ; i++){
            if (daftarObat[i].getStok() == 0){
                System.out.print("| " + "Kosong" + " ");
            }

            else{
                System.out.print("| " + daftarObat[i].getNama() + " (stok: " + daftarObat[i].getStok() + ")");
            }
        }
        System.out.println();
    }

    /**
     * Method accessor untuk mendapatkan daftar obat (rak yang berisi obat)
     * @return mengembalikan daftar obat
     */
    // TODO : Implementasi method getListObat
    public Obat[] getListObat() {
        return daftarObat;
    }
    
}
