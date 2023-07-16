import java.util.Scanner;

public class HaloDDP {
    public static void main(String[] args) {
        int BASE_PRICE = 5000; 
        Scanner input = new Scanner(System.in);
        int statusBeliObat = 0;
        String obatObatYgDibeli = "";
        String jumlahTiapObatYGDibeli = "";

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
        lemari.print();

        while (true) {
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. Tambah obat");
            System.out.println("2. Lihat obat");
            System.out.println("3. Beli obat");
            System.out.println("99. Keluar");
            System.out.print("Pilih menu: ");
            String menu = input.next();

            if (menu.equals("1")) {
                // TODO : Implementasi input obat
                System.out.print("Masukkan nama obat: ");
                String namaObat = input.next();
                System.out.print("Masukkan kategori obat: ");
                String kategori = input.next();
                boolean kategoriSesuai = false;
                for (int i = 0 ; i < baris; i++){
                    String kategoriPadaArray = lemari.getRak(i).getKategoriRak();
                    if (kategori.equalsIgnoreCase(kategoriPadaArray)){
                        kategoriSesuai = true;
                    }
                }

                if (kategoriSesuai == true){
                    System.out.println("Kategori obat valid");
                    System.out.print("Masukkan posisi obat: ");
                    // Untuk handle agar scanner tidak skip input.nextLine()
                    input.nextLine();
                    String posisi = input.nextLine();
                    String [] posisiSplit = posisi.split(",");

                    if (Integer.parseInt(posisiSplit[0])>baris || Integer.parseInt(posisiSplit[1]) > kolom){
                        System.out.println("Posisi tidak ada di lemari");
                        continue;
                    }

                    Rak rak = lemari.getRak(Integer.parseInt(posisiSplit[0])-1);
                    String namaObatDiDaftarObat = rak.getListObat()[Integer.parseInt(posisiSplit[1])-1].getNama();
                    
                    if (namaObatDiDaftarObat.equalsIgnoreCase("Kosong")){
                        System.out.print("Masukkan stok obat: ");
                        int stokObat = input.nextInt();
                        Obat obat = new Obat(namaObat,stokObat,kategori);
                        rak.tambahObat(obat, Integer.parseInt(posisiSplit[1])-1);
                        System.out.println("Obat berhasil ditambahkan");
                    }

                    else{
                        System.out.println("Rak sudah terisi obat");

                    }
                }

                else{
                    System.out.println("Kategori obat tidak valid");
                }


            } else if (menu.equals("2")) {
                // TODO : Implementasi print obat
                lemari.print();

            } else if (menu.equals("3")) {
                // TODO : Implementasi beli obat
                System.out.print("Obat apa yang ingin dibeli? ");
                String obatYgDibeli = input.next();
                System.out.print("Ingin beli berapa banyak? ");
                int jumlahYgDibeli = input.nextInt();

                if (lemari.beliObat(lemari.searchObat(obatYgDibeli), jumlahYgDibeli) == false){
                    if (lemari.searchObat(obatYgDibeli) == null){
                        System.out.println("Obat " + obatYgDibeli + " tidak tersedia");
                    }

                    else{
                        System.out.println("Stok obat " + obatYgDibeli + " kurang dari " + jumlahYgDibeli);
                    }
                }

                else{
                    System.out.println("Berhasil membeli obat");
                    statusBeliObat += 1;
                    int harga = BASE_PRICE;
                    obatObatYgDibeli += obatYgDibeli + " ";
                    jumlahTiapObatYGDibeli += String.valueOf(jumlahYgDibeli) + " ";
                    int sisaStok = lemari.searchObat(obatYgDibeli).getStok()-jumlahYgDibeli;
                    lemari.searchObat(obatYgDibeli).setStok(sisaStok);
                    for (int i = 0 ; i < baris ; i++){
                        Obat [] daftarObat = lemari.getRak(i).getListObat();
                        for (int j = 0; j < daftarObat.length ; j++) {
                            Obat obat = daftarObat[j];
                            if (obat.getNama().equals(obatYgDibeli)) {
                                harga += (i)*10000 + (j)*5000;
                                obat.setHarga(harga);
                            }    
                        }
                    }
                }

            } else if (menu.equals("99")){
                // TODO : Implementasi keluar
                if (statusBeliObat < 1){
                    System.out.println("Tetap semangat. Besok pasti akan jauh lebih baik!");
                }

                else{
                    String [] daftarObatYgDibeli = obatObatYgDibeli.split(" ");
                    String [] daftarJumlahTiapObatYgDibeli = jumlahTiapObatYGDibeli.split(" ");
                    System.out.println("Riwayat transaksi hari ini\n");
                    System.out.println("No. Nama - Jumlah - Total Harga");
                    for (int i = 0 ; i < daftarObatYgDibeli.length ; i++){
                        System.out.println((i+1) + " " + daftarObatYgDibeli[i] + " - " + daftarJumlahTiapObatYgDibeli[i] + " - " + lemari.searchObat(daftarObatYgDibeli[i]).getHarga() * Integer.parseInt(daftarJumlahTiapObatYgDibeli[i])); 
                    }
                }

                break;

            } else {
                System.out.println("Menu tidak tersedia");
            }
        }

        input.close();
        System.out.println("Terima kasih telah menggunakan Haloddp!");
    }
}
