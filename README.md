# Tugas Pemrograman 3 - HaloDDP
CSGE601021 Dasar-Dasar Pemrograman 2 @ Fakultas Ilmu Komputer Universitas Indonesia,
Semester Pendek – 2022/2023

## Dokumen Soal
Dokumen soal dapat diakses melalui [link ini](https://docs.google.com/document/d/1OD_QE2gXS5XrUaqRq00KPYf2-Ure2KTbAzpJLi0zUcY).

## Panduan Memulai (Jika Membuat Repository Baru)
1. Buat repository baru pada Gitlab atau Github kalian.
2. Pada direktori lokal anda, lakukan ***clone*** repository yang telah anda buat dengan perintah:
    ```bash
    git clone <url_repository_anda>
    ```
3. Tambahkan ***remote*** baru bernama **`upstream`** untuk mendapatkan code dari repository DDP2 dengan perintah:
    ```bash
    git remote add upstream https://gitlab.com/DDP2-CSUI/sp-ddp2-2023/tp3-sp-ddp2.git
    ```
    > Note: Sekarang, pada git anda terdapat 2 source remote, yakni: **`origin`**, repository milik anda yang telah dibuat pada langkah 1 (saat melakukan ***clone***, origin akan otomatis ter-*set* ke url tersebut) dan **`upstream`**, repository DDP2 tempat soal dan template Tugas Pemrograman 3 berada.
4. Lakukan ***pull*** dari remote **`upstream`** dengan perintah 
    ```bash
    git pull upstream main
    ```
5. Jangan lupa tambahkan `asdos kamu` dengan cara:
    - Jika kamu menggunakan [Gitlab](https://stackoverflow.com/questions/31908222/how-to-give-user-level-access-to-private-gitlab-repository)
        > Catatan: Tambahkan `asdos kamu` dengan izin akses ***Maintainer***
    - Jika kamu menggunakan [Github](https://docs.github.com/en/account-and-profile/setting-up-and-managing-your-personal-account-on-github/managing-access-to-your-personal-repositories/inviting-collaborators-to-a-personal-repository)

## Panduan Memulai (Jika Menggunakan Repository Lama)
1. Tambahkan ***remote*** baru bernama **`upstream`** untuk mendapatkan code dari repository DDP2 dengan perintah:
    ```bash
    git remote add upstream https://gitlab.com/DDP2-CSUI/sp-ddp2-2023/tp3-sp-ddp2.git
    ```
    Jika sebelumnya anda telah menambahkan **`upstream`**, Anda dapat mengganti url **`upstream`** ke DDP2 dengan perintah:
    ```bash
    git remote set-url upstream https://gitlab.com/DDP2-CSUI/sp-ddp2-2023/tp3-sp-ddp2.git
    ```
    > Note: Sekarang, pada git anda terdapat 2 source remote, yakni: **`origin`**, repository milik anda dan **`upstream`**, repository DDP2 tempat soal dan template Tugas Pemrograman 3 berada.
2. Buat direktori baru pada folder TP anda kemudian pindahkan terminal ke ***path*** tersebut.
3. Lakukan ***pull*** dari remote **`upstream`** dengan perintah 
    ```bash
    git pull upstream main
    ```

## Deskripsi
Tugas ini merupakan pembuatan sistem untuk apotek bernama HaloDDP menggunakan bahasa pemrograman Java. Sistem ini memungkinkan apoteker untuk melakukan input data obat, kalkulasi harga secara otomatis, dan update stok secara real-time. Sistem juga menyediakan fitur tambah obat, lihat obat, beli obat, dan riwayat transaksi.

Pembuatan Lemari: Apoteker dapat membuat lemari dengan ukuran tertentu. Lemari tersebut memiliki rak-rak yang ditentukan oleh apoteker.

Pembuatan Rak: Setelah membuat lemari, apoteker dapat membuat rak-rak pada lemari sesuai dengan kategori obat yang diinginkan.

Tambah Obat: Apoteker dapat menambahkan obat baru ke dalam rak. Obat akan ditempatkan pada posisi yang diinginkan, dan stok obat juga ditentukan.

Lihat Obat: Apoteker dapat melihat daftar obat yang telah diletakkan pada rak-rak lemari. Daftar obat akan mencantumkan nama obat dan stok obat.

Beli Obat: Fitur ini digunakan apoteker untuk melakukan pembelian obat. Apoteker dapat memasukkan nama obat dan jumlah yang ingin dibeli. Jika stok obat mencukupi, maka transaksi berhasil dilakukan. 

Keluar: Fitur ini mengakhiri program dan mencetak riwayat transaksi hari ini. Jika tidak ada transaksi, akan dicetak pesan motivasi.

## Menyelesaikan konflik

Jika terjadi *merge conflict*, silakan selesaikan konflik yang ada dan
lanjutkan proses *merging*. Kamu bisa mencari [panduan](https://githowto.com/resolving_conflicts) atau meminta bantuan asdos jika mengalami kesulitan.
