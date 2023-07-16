public class Lemari {
    private int ukuran;
    private Rak[] rak;

    public Lemari(int ukuran){
        this.ukuran = ukuran;
        rak = new Rak[ukuran];
    }

    public void addRak(Rak rak, int index){
        this.rak[index] = rak;
    }

    // TODO : Implementasi method print
    public void print(){
        for (int i = 0 ; i < this.ukuran; i++){
            System.out.println(this.rak[i].getKategoriRak());
            System.out.println("==================");
            this.rak[i].printRak();
            System.out.println("==================");
            System.out.println();
        }
    }

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

    // TODO : Implementasi method getRak
    public Rak getRak(int i) {
        return this.rak[i];
    }
}
