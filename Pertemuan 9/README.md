# Praktikum PBO Sesi 9 — Package, Namespace, dan Build Tool

**Nama:** Muhamad Aria Khalil MIrzahamzah  
**NPM:** 4525210094  
**Mata Kuliah:** Praktikum Pemrograman Berorientasi Objek

## 1. Deskripsi Praktikum

Pada praktikum PBO sesi 9, saya mempelajari cara menggunakan package pada Java, namespace pada PHP, serta build tool Maven dan Composer. Materi ini membantu saya memahami bagaimana mengatur susunan file program agar lebih rapi dan memudahkan pengelolaan library atau dependensi yang digunakan dalam proyek.

## 2. Tujuan Praktikum

1. Mengetahui cara menggunakan package dalam Java.
2. Memahami fungsi namespace pada PHP.
3. Mempelajari penyusunan proyek Java dengan Maven.
4. Memahami cara mengelola library PHP menggunakan Composer.
5. Menerapkan autoload PSR-4 untuk memanggil kelas secara otomatis.
6. Mencoba penggunaan library Datafaker dan Carbon.
7. Mempraktikkan penggunaan Git dan GitHub untuk menyimpan hasil pekerjaan.

## 3. Struktur Folder Proyek

### A. Java dengan Maven

java/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/                        
│   │   │   └── id/ac/univpancasila/perpustakaan/
│   │   │       ├── App.java
│   │   │       ├── model/
│   │   │       │   ├── Buku.java
│   │   │       │   ├── Anggota.java
│   │   │       │   └── Peminjaman.java
│   │   │       ├── service/
│   │   │       │   └── PerpustakaanService.java
│   │   │       └── util/
│   │   │           └── Format.java
│   │   └── resources/                   
│   └── test/
│       └── java/                       
└── target/

### B. PHP dengan Composer

php/
├── composer.json
├── composer.lock          
├── main.php               
├── src/
│   ├── Model/
│   │   ├── Buku.php       
│   │   ├── Anggota.php
│   │   └── Peminjaman.php
│   ├── Service/
│   │   └── PerpustakaanService.php
│   └── Util/
│       └── Format.php
├── tests/                
└── vendor/ hp


## 4. Package pada Java

Package merupakan fitur Java yang digunakan untuk mengelompokkan kelas berdasarkan fungsi tertentu. Dengan package, file program dapat disusun lebih teratur dan lebih mudah ditemukan ketika dibutuhkan.

Dalam proyek perpustakaan, kelas yang berhubungan dengan data, seperti `Buku`, `Anggota`, dan `Peminjaman`, ditempatkan pada package `model`. Sementara itu, kelas yang mengatur proses atau layanan perpustakaan dimasukkan ke dalam package `service`.

Penggunaan package juga membantu menghindari kesamaan nama kelas yang dapat menimbulkan konflik dalam sebuah proyek.

## 5. Namespace pada PHP

Namespace pada PHP memiliki fungsi untuk mengelompokkan kelas agar susunan program menjadi lebih jelas. Penggunaannya juga membantu membedakan kelas yang memiliki nama sama tetapi berasal dari kelompok yang berbeda.

Pada proyek ini, namespace `Perpustakaan\Model` digunakan untuk kelas yang mengelola data, sedangkan namespace `Perpustakaan\Service` digunakan untuk kelas yang menangani proses layanan perpustakaan.

Dengan adanya namespace, pemanggilan kelas menjadi lebih terstruktur karena setiap kelas memiliki identitas sesuai dengan namespace yang telah ditentukan.

## 6. Maven pada Java

Maven adalah alat bantu yang digunakan untuk mengelola proyek Java. Maven dapat membantu proses kompilasi, mengatur library yang diperlukan, dan menjalankan program melalui perintah tertentu.

Konfigurasi Maven disimpan dalam file `pom.xml`. Melalui file tersebut, dependensi yang dibutuhkan proyek dapat ditentukan tanpa harus mengelolanya secara manual satu per satu.

Beberapa perintah yang digunakan dalam praktikum ini adalah `mvn clean compile` untuk membersihkan hasil build sebelumnya sekaligus melakukan kompilasi, `mvn exec:java` untuk menjalankan kelas utama sesuai konfigurasi, dan `mvn dependency:tree` untuk melihat daftar dependensi yang digunakan.

Hasil daftar dependensi juga dapat disimpan ke dalam file agar lebih mudah diperiksa kembali.

## 7. Composer pada PHP

Composer merupakan alat untuk mengelola dependensi pada PHP. Dengan Composer, proses pemasangan library dan pengaturan autoload kelas dapat dilakukan dengan lebih mudah.

Konfigurasi proyek disimpan dalam file `composer.json`. Pada praktikum ini, autoload PSR-4 digunakan untuk menghubungkan namespace `Perpustakaan` dengan folder `src/`.

Perintah `composer install` digunakan untuk memasang dependensi berdasarkan konfigurasi proyek. Jika terdapat perubahan pada struktur kelas atau konfigurasi autoload, perintah `composer dump-autoload` dapat digunakan untuk memperbarui daftar kelas yang dapat dimuat secara otomatis.

Setelah dependensi terpasang, program dapat dijalankan melalui file utama menggunakan perintah `php main.php`.

## 8. Penggunaan Datafaker dan Carbon

### A. Datafaker

Datafaker merupakan library Java yang dapat menghasilkan data buatan untuk kebutuhan pengujian program. Contohnya adalah membuat nama atau informasi fiktif sehingga program dapat dicoba tanpa harus memasukkan data secara manual satu per satu.

Dalam praktikum ini, Datafaker dipelajari sebagai salah satu dependensi eksternal yang dapat ditambahkan dan dikelola menggunakan Maven.

### B. Carbon

Carbon adalah library PHP yang membantu proses pengolahan tanggal dan waktu. Library ini menyediakan berbagai fungsi untuk mengambil tanggal saat ini, mengubah format tanggal, serta melakukan perhitungan waktu.

Pada contoh program, Carbon digunakan untuk mengambil tanggal peminjaman dan menentukan tanggal pengembalian tujuh hari setelahnya. Hasil tanggal kemudian ditampilkan dengan format hari, bulan, dan tahun.

Dengan menggunakan Carbon, perhitungan tanggal dapat dilakukan dengan lebih praktis dan kode menjadi lebih mudah dipahami.

## 9. Percobaan Package dan Namespace

Pada bagian ini, saya mempelajari hubungan antara package atau namespace dengan susunan folder tempat kelas disimpan. Setiap kelas perlu memiliki deklarasi yang sesuai agar dapat dikenali dan dipanggil dengan benar.

Jika terdapat ketidaksesuaian antara deklarasi package atau namespace dan struktur proyek, program dapat mengalami kesalahan ketika dijalankan atau ketika kelas dipanggil.

Untuk mengatasinya, deklarasi pada file program perlu diperiksa dan disesuaikan dengan struktur folder yang digunakan. Hasil percobaan, pesan kesalahan yang muncul, serta cara memperbaikinya dicatat dalam file `percobaan.md`.

## 10. Pengelolaan Proyek Menggunakan Git

Git digunakan untuk mencatat perubahan pada file program, sedangkan GitHub digunakan sebagai tempat penyimpanan repositori secara online. Keduanya membantu proses penyimpanan dan pengumpulan hasil praktikum.

Dalam prosesnya, perintah `git status` digunakan untuk memeriksa perubahan file. Selanjutnya, `git add .` digunakan untuk menyiapkan file yang akan disimpan, kemudian `git commit` digunakan untuk mencatat perubahan tersebut.

Setelah itu, perintah `git push origin main` digunakan untuk mengunggah commit ke repositori GitHub.

Folder hasil build seperti `target/` dan folder dependensi `vendor/` umumnya tidak perlu diunggah karena dapat dihasilkan kembali melalui proses build atau instalasi dependensi. Namun, file `composer.lock` tetap disimpan agar versi dependensi yang digunakan dapat dipertahankan.

## 11. Kesimpulan

Dari praktikum PBO sesi 9, saya memahami bahwa package pada Java dan namespace pada PHP digunakan untuk menyusun kelas berdasarkan fungsi masing-masing. Dengan pembagian tersebut, struktur program menjadi lebih rapi dan lebih mudah dikelola.

Saya juga mempelajari fungsi Maven dan Composer dalam mengatur dependensi serta membantu proses menjalankan proyek. Selain itu, penggunaan autoload PSR-4, Datafaker, dan Carbon memberikan pemahaman mengenai cara memanfaatkan library untuk mendukung pembuatan program.

Melalui praktikum ini, saya memperoleh pengetahuan dasar tentang penyusunan proyek Java dan PHP serta penggunaan Git dan GitHub untuk mengelola dan menyimpan hasil pekerjaan.
