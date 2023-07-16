public class Obat {
    private String kategori;
    private String nama;
    private int harga;
    private int stok;
    
    public Obat(String nama, int stok, String kategori){
        this.nama = nama;
        this.stok = stok;
        this.kategori = kategori;
    }

    // TODO : Implementasi method getter getKategori
    public String getKategori(){
        return kategori;
    }

    // TODO : Implementasi method getter getNama
    public String getNama(){
        return nama;
    }

    // TODO : Implementasi method getter getHarga
    public int getHarga(){
        return harga;
    }

    // TODO : Implementasi method getter getStok
    public int getStok(){
        return stok;
    }

    // TODO : Implementasi method setter setKategori
    public void setKategori(String newKategori){
        kategori = newKategori;
    }

    // TODO : Implementasi method setter setNama
    public void setStok(int newStok){
        stok =  newStok;
    }

    // TODO : Implementasi method setter setHarga
    public void setHarga(int newHarga){
        harga = newHarga;
    }

}
