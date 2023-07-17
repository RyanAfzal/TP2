// Class untuk objek obat
public class Obat {
    private String kategori;
    private String nama;
    private int harga;
    private int stok;
    
    /**
     * Constructor untuk membuat objek obat
     * @param nama parameter nama obat
     * @param stok parameter jumlah stok obat
     * @param kategori parameter kategori obat
     */
    public Obat(String nama, int stok, String kategori){
        this.nama = nama;
        this.stok = stok;
        this.kategori = kategori;
    }

    /**
     * Method accessor untuk mendapatkan kategori obat
     * @return mengembalikan kategori obat
     */
    // TODO : Implementasi method getter getKategori
    public String getKategori(){
        return kategori;
    }

    /**
     * Method accessor untuk mendapatkan nama obat
     * @return mengembalikan nama obat
     */
    // TODO : Implementasi method getter getNama
    public String getNama(){
        return nama;
    }

    /**
     * Method accessor untuk mendapatkan harga obat
     * @return mengembalikan harga obat
     */
    // TODO : Implementasi method getter getHarga
    public int getHarga(){
        return harga;
    }

    /**
     * Method acccessor untuk mendapatkan jumlah stok obat
     * @return mengembalikan jumlah stok obat
     */
    // TODO : Implementasi method getter getStok
    public int getStok(){
        return stok;
    }

    /**
     * Method mutator untuk set atau mengubah kategori obat
     * @param kategori parameter kategori untuk obat
     */
    // TODO : Implementasi method setter setKategori
    public void setKategori(String kategori){
        this.kategori = kategori;
    }

    /**
     * Method mutator untuk set atau mengubah nama obat
     * @param stok parameter jumlah stok obat
     */
    // TODO : Implementasi method setter setNama
    public void setStok(int stok){
        this.stok =  stok;
    }

    /**
     * Method mutator untuk set atau mengubah harga obat
     * @param harga parameter harga obat
     */
    // TODO : Implementasi method setter setHarga
    public void setHarga(int harga){
        this.harga = harga;
    }

}
