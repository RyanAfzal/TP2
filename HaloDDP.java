import java.util.Scanner;

public class HaloDDP {
    public static void main(String[] args) {
        int BASE_PRICE = 5000; 
        Scanner input = new Scanner(System.in);

        System.out.print("Selamat datang Haloddp. Berapa ukuran lemari obat hari ini? (max row 5) \n");
    
        // TODO : Implementasi validasi input ukuran lemari
        String ukuran = input.next();
        String [] barisKolom = ukuran.split("[xX]");
        System.out.println("Rak obat hari ini berukuran " + ukuran);

        int baris = Integer.parseInt(barisKolom[0]);
        int kolom = Integer.parseInt(barisKolom[1]);

        // TODO : Buat objek lemari dengan ukuran yang sudah ditentukan
        Lemari lemari = new Lemari(baris);


        System.out.println("Silahkan tentukan kategori obat untuk setiap rak");
        // TODO : Implementasi input kategori rak
        for (int i = 0 ; i < baris ; i ++){
            System.out.print("Rak ke-"+(i+1)+": ");
            Rak rak = new Rak(kolom,input.next());
            lemari.addRak(rak, i);
            System.out.println("Rak ke-"+(i+1)+" adalah rak obat "+ rak.getKategoriRak());
            Obat obat = new Obat("Kosong", 0, rak.getKategoriRak());
            for (int j = 0 ; j < kolom ; j++){
                rak.tambahObat(obat, j);
            }
        }

        System.out.println("Rak obat hari ini: ");

        while (true) {
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. Tambah obat");
            System.out.println("2. Lihat obat");
            System.out.println("3. Beli obat");
            System.out.println("99. Keluar");
            System.out.print("Pilih menu: ");
            String menu = input.nextLine();

            if (menu.equals("1")) {
                // TODO : Implementasi input obat
            } else if (menu.equals("2")) {
                // TODO : Implementasi print obat
            } else if (menu.equals("3")) {
                // TODO : Implementasi beli obat
            } else if (menu.equals("99")){
                // TODO : Implementasi keluar
                break;
            } else {
                System.out.println("Menu tidak tersedia");
            }
        }

        input.close();
        System.out.println("Terima kasih telah menggunakan Haloddp!");
    }
}
