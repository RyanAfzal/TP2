// Class untuk objek Lemari
public class Lemari {
    private int ukuran;
    private Rak[] rak;

    /**
     * Constructor untuk membuat objek lemari yang terdiri dari rak
     * @param ukuran parameter untuk ukuran dari lemari (berisi berapa banyak rak)
     */
    public Lemari(int ukuran){
        this.ukuran = ukuran;
        rak = new Rak[ukuran];
    }

    /**
     * method dari kelas lemari untuk menambahkan  rak
     * @param rak parameter rak kategori apa yang akan dimasukan ke lemari
     * @param index parameter yang menyatakan di posisi mana pada lemari rak akan ditambahkan
     */
    public void addRak(Rak rak, int index){
        this.rak[index] = rak;
    }

    /**
     * Method untuk mencetak lemari 
     */
    // TODO : Implementasi method print
    public void print(){
        for (int i = (this.ukuran-1) ; i >= 0 ; i--){
            System.out.println(this.rak[i].getKategoriRak());
            System.out.println("==================");
            this.rak[i].printRak();
            System.out.println("==================");
            System.out.println();
        }
    }

    /**
     * Method untuk memeriksa apakah user sudah membeli obat atau belum
     * @param obat  parameter obat apa yang dibeli
     * @param jumlah parameter berapa jumlah obat yang dibeli
     * @return akan mengembalikan true jika sudah membeli obat
     * dan akan mengembalikan false jika belum membeli obat
     */
    // TODO : Implementasi method beliObat
    public boolean beliObat(Obat obat, int jumlah) {
        if (obat == null){
            return false; 
        }

        else{
            if (obat.getStok()<jumlah){
                return false;
            }

            else{
                return true;
            }
        }
    }

    /**
     * Method untuk mencari obat pada lemari
     * @param namaObat parameter obat apa yang dicari 
     * @return akan mengembalikan obat jika obat tersedia di lemari
     * dan akan mengembalikan null jika obat tidak tersedia di lemari
     */
    // TODO : Implementasi method searchObat
    public Obat searchObat(String namaObat) {
        for (int i = 0 ; i < this.ukuran ; i++){
            Obat [] daftarObat = this.rak[i].getListObat();
            for (int j = 0; j < daftarObat.length ; j++) {
                Obat obat = daftarObat[j];
                if (obat.getNama().equalsIgnoreCase(namaObat)) {
                    return obat;
                }
            }
        }
        return null;
    }

    /**
     * Method accessor untuk mendapatkan rak pada posisi tertentu di lemari
     * @param i paramater posisi di mana rak yang akan didapatkan
     * @return mengembalikan rak pada posisi tertentu di lemari
     */
    // TODO : Implementasi method getRak
    public Rak getRak(int i) {
        return this.rak[i];
    }
}
