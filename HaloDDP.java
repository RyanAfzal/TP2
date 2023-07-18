import java.util.Scanner;

// Class untuk HaloDDP
public class HaloDDP {
    // Main program
    public static void main(String[] args) {
        int BASE_PRICE = 5000; 
        Scanner input = new Scanner(System.in);
        int statusBeliObat = 0; //untuk periksa apakah sudah beli obat atau belum
        String obatObatYgDibeli = ""; //untuk menyimpan data obat apa saja yang sudah dibeli
        String jumlahTiapObatYGDibeli = ""; //untuk menyimpan data berapa saja jumlah obat yang dibeli
        int jmlLoopRunStop = 0; //untuk periksa apakah program sudah pernah run dan stop program
        boolean runStopProgram = false; //untuk penanda berhenti nya loop run dan stop program
        String semuaKategoriAwal = ""; //untuk simpan semua data kategori saat awal memulai program
        int indexLoopMasukanKategoriAwal = 0; //untuk penanda sudah di rak ke berapa saat meminta kategori di awal program

        // loop sampai input ukuran lemari benar
        while (!runStopProgram){

        if (jmlLoopRunStop > 0){
            System.out.println("\n");
        }

        System.out.println("=============================RUN PROGRAM================================");
        System.out.print("Selamat datang Haloddp. Berapa ukuran lemari obat hari ini? (max row 5) \n");
    
        // TODO : Implementasi validasi input ukuran lemari
        String ukuran = input.nextLine();

        String [] barisKolom = ukuran.split("[xX]");
        
        try{
            Integer.parseInt(barisKolom[0]);
            Integer.parseInt(barisKolom[1]);
        }

        catch (Exception e){
            System.out.println("Format lemari tidak sesuai. Seharusnya <row>x<column>");
            System.out.println("=============================PROGRAM STOPPED============================");
            jmlLoopRunStop += 1;
            continue;
        }

        if (barisKolom.length>2){
            System.out.println("Format lemari tidak sesuai. Seharusnya <row>x<column>");
            System.out.println("=============================PROGRAM STOPPED============================");
            jmlLoopRunStop += 1;
            continue;
        }

        int baris = Integer.parseInt(barisKolom[0]);
        int kolom = Integer.parseInt(barisKolom[1]);

        if (baris < 1 || kolom < 1){
            System.out.println("Ukuran lemari tidak bisa < 1");
            System.out.println("=============================PROGRAM STOPPED============================");
            jmlLoopRunStop += 1;
            continue;
        }

        if (baris > 5){
            System.out.println("Ukuran baris tidak boleh lebih besar dari 5");
            System.out.println("=============================PROGRAM STOPPED============================");
            jmlLoopRunStop += 1;
            continue;
        }

        System.out.println("Rak obat hari ini berukuran " + ukuran);

        // TODO : Buat objek lemari dengan ukuran yang sudah ditentukan
        Lemari lemari = new Lemari(baris);

        System.out.println("Silahkan tentukan kategori obat untuk setiap rak");
        // TODO : Implementasi input kategori rak
        while (indexLoopMasukanKategoriAwal < baris){
            boolean kategoriSudahAda = false;
            String[] daftarSemuaKategoriAwal = semuaKategoriAwal.split(" ");
            System.out.print("Rak ke-"+(indexLoopMasukanKategoriAwal+1)+": ");
            String kategoriAwal = input.next();

            //untuk memeriksa apakah kategori sudah ada
            for (String category : daftarSemuaKategoriAwal){
                if (category.equalsIgnoreCase(kategoriAwal)){
                    kategoriSudahAda = true;
                }
            }

            //Jika belum
            if (kategoriSudahAda == false){
                semuaKategoriAwal += kategoriAwal + " ";
                Rak rak = new Rak(kolom,kategoriAwal);
                lemari.addRak(rak, indexLoopMasukanKategoriAwal);
                System.out.println("Rak ke-"+(indexLoopMasukanKategoriAwal+1)+" adalah rak obat "+ rak.getKategoriRak());
                Obat obat = new Obat("Kosong", 0, rak.getKategoriRak());
                for (int j = 0 ; j < kolom ; j++){
                    rak.tambahObat(obat, j);
                }
            }

            //Jika sudah ada (handle kategori tidak duplikat)
            else{
                System.out.println("Kategori rak tidak valid");
                continue;
            }
            indexLoopMasukanKategoriAwal += 1;
        }

        //mencetak lemari kondisi awal
        System.out.println("Rak obat hari ini: ");
        lemari.print();

        // layanan HaloDDP
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

                //periksa apakah kategori obat sesuai dengan kategori di rak
                for (int i = 0 ; i < baris; i++){
                    String kategoriPadaArray = lemari.getRak(i).getKategoriRak();
                    if (kategori.equalsIgnoreCase(kategoriPadaArray)){
                        kategoriSesuai = true;
                    }
                }

                //Jika sesuai
                if (kategoriSesuai == true){
                    System.out.println("Kategori obat valid");
                    System.out.print("Masukkan posisi obat: ");
                    // Untuk handle agar scanner tidak skip input.nextLine()
                    input.nextLine();
                    String posisi = input.nextLine();
                    String [] posisiSplit = posisi.split(",");

                    //Validasi input
                    try{
                        Integer.parseInt(posisiSplit[0]);
                        Integer.parseInt(posisiSplit[1]);
                    }

                    catch (Exception e){
                        System.out.println("Format tidak sesuai seharusnya <posisi1>,<posisi2>");
                        continue;
                    }

                    if (Integer.parseInt(posisiSplit[0])<1 || Integer.parseInt(posisiSplit[1])<1){
                        System.out.println("Posisi tidak bisa kurang dari 1");
                        continue;
                    }
                    
                    if (Integer.parseInt(posisiSplit[0])>baris || Integer.parseInt(posisiSplit[1]) > kolom){
                        System.out.println("Posisi tidak ada di lemari");
                        continue;
                    }

                    if (kategori.equalsIgnoreCase(lemari.getRak(Integer.parseInt(posisiSplit[0])-1).getKategoriRak()) == false){
                        System.out.println("Rak bukan untuk kategori obat " + kategori);
                        continue;
                    }

                    Rak rak = lemari.getRak(Integer.parseInt(posisiSplit[0])-1);
                    String namaObatDiDaftarObat = rak.getListObat()[Integer.parseInt(posisiSplit[1])-1].getNama();
                    
                    // Menambahkan obat jika rak masih kosong
                    if (namaObatDiDaftarObat.equalsIgnoreCase("Kosong")){
                        System.out.print("Masukkan stok obat: ");
                        int stokObat = input.nextInt();
                        Obat obat = new Obat(namaObat,stokObat,kategori);
                        rak.tambahObat(obat, Integer.parseInt(posisiSplit[1])-1);
                        System.out.println("Obat berhasil ditambahkan");
                    }

                    // Menambahkan obat jika rak sudah terisi
                    else{
                        System.out.println("Rak sudah terisi obat");

                    }
                }

                //Jika kategori obat tidak sesuai dengan kategori di rak
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

                //Jika tidak berhasil beli obat
                if (lemari.beliObat(lemari.searchObat(obatYgDibeli), jumlahYgDibeli) == false){
                    // Jika obat tidak tersedia
                    if (lemari.searchObat(obatYgDibeli) == null){
                        System.out.println("Obat " + obatYgDibeli + " tidak tersedia");
                    }

                    // Jika stok obat kurang
                    else{
                        System.out.println("Stok obat " + obatYgDibeli + " kurang dari " + jumlahYgDibeli);
                    }
                }

                // Jika berhasil membeli obat
                else{
                    System.out.println("Berhasil membeli obat");
                    statusBeliObat += 1;
                    int harga = BASE_PRICE;
                    obatObatYgDibeli += obatYgDibeli + " ";
                    jumlahTiapObatYGDibeli += String.valueOf(jumlahYgDibeli) + " ";

                    // Memperbarui stok obat
                    int sisaStok = lemari.searchObat(obatYgDibeli).getStok()-jumlahYgDibeli;
                    lemari.searchObat(obatYgDibeli).setStok(sisaStok);

                    // Menghitung harga obat
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

                //Jika tidak beli obat
                if (statusBeliObat < 1){
                    System.out.println("Tetap semangat. Besok pasti akan jauh lebih baik!");
                }

                // Jika beli obat
                else{
                    String [] daftarObatYgDibeli = obatObatYgDibeli.split(" ");
                    String [] daftarJumlahTiapObatYgDibeli = jumlahTiapObatYGDibeli.split(" ");
                    System.out.println("Riwayat transaksi hari ini\n");
                    System.out.println("No. Nama - Jumlah - Total Harga");
                    for (int i = 0 ; i < daftarObatYgDibeli.length ; i++){
                        System.out.println((i+1) + " " + daftarObatYgDibeli[i] + " - " + daftarJumlahTiapObatYgDibeli[i] + " - " + lemari.searchObat(daftarObatYgDibeli[i]).getHarga() * Integer.parseInt(daftarJumlahTiapObatYgDibeli[i])); 
                    }
                    System.out.println();
                }

                break;
            
                //Jika menu tidak tersedia
            } else {
                System.out.println("Menu tidak tersedia");
            }
        }

        input.close();
        runStopProgram = true; //Agar program berhenti
        System.out.println("Terima kasih telah menggunakan Haloddp!");
        }
    }
}
