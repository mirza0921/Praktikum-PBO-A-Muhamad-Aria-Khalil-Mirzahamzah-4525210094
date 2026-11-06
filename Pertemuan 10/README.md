LAPORAN PRAKTIKUM PEMROGRAMAN BERBASIS OBJEK
=============================================

Nama      : Muhamad Aria Khalil Mirzahamzah
NPM       : 4525210094
Kelas     : A
Mata Kuliah : Pemrograman Berbasis Objek (PBO)
Pertemuan : 10 - Exception Handling dan Refactoring
Tanggal   : [DD/MM/YYYY]





1. IMPLEMENTASI JAVA
--------------------

1.1. Folder exception

  File: PerpustakaanException.java
  TODO 1: Memilih Induk Exception

  Before : before/java/TODO1.png  (Kondisi awal / Belum ditentukan)
  After  : after/java/TODO1.png   (Kondisi akhir / Eksekusi berhasil)

  Penjelasan:
  PerpustakaanException diturunkan dari RuntimeException (unchecked).
  Kegagalan domain seperti buku tidak ditemukan atau batas peminjaman
  tercapai menandakan permintaan yang tidak sah, bukan keadaan luar yang
  wajar untuk ditangani di setiap pemanggil. Dengan unchecked, method
  pinjam() tidak perlu mendeklarasikan throws di setiap lapisan.
  Alasan ini juga dituliskan di skenario-uji.md.


  File: BukuTidakDitemukanException.java
  TODO 1-4: Atribut, Konstruktor, dan Getter

  Before : before/java/TODO2.png  (Kondisi awal / Belum lengkap)
  After  : after/java/TODO2.png   (Kondisi akhir / Eksekusi berhasil)

  Penjelasan:
  Exception ini menyimpan isbn sebagai atribut private final. Pesan dikirim
  ke super(...) sehingga getMessage() tetap bisa dibaca, sedangkan
  getIsbn() memungkinkan pemanggil mengambil data penyebab tanpa mengurai
  teks. Data inilah yang nantinya dipakai pada respons HTTP 404.


  File: AnggotaTidakDitemukanException.java
  TODO: Mengikuti Pola BukuTidakDitemukanException

  Before : before/java/TODO3.png  (Kondisi awal / Belum lengkap)
  After  : after/java/TODO3.png   (Kondisi akhir / Eksekusi berhasil)

  Penjelasan:
  Exception ini membawa idAnggota dengan pola yang sama seperti
  BukuTidakDitemukanException. Pemanggil dapat mengetahui anggota mana
  yang bermasalah melalui getIdAnggota().


  File: BukuSedangDipinjamException.java
  TODO: Membawa Dua Data (isbn dan judul)

  Before : before/java/TODO4.png  (Kondisi awal / Belum lengkap)
  After  : after/java/TODO4.png   (Kondisi akhir / Eksekusi berhasil)

  Penjelasan:
  Judul disertakan agar pesan untuk pengguna lebih bermakna, sedangkan
  ISBN disertakan agar sistem tetap dapat mengolahnya. Kedua data diakses
  lewat getJudul() dan getIsbn().


  File: BatasPinjamTerlampauiException.java
  TODO: Membawa idAnggota dan batas

  Before : before/java/TODO5.png  (Kondisi awal / Belum lengkap)
  After  : after/java/TODO5.png   (Kondisi akhir / Eksekusi berhasil)

  Penjelasan:
  Batas maksimum disimpan di dalam exception. Dengan demikian, pemanggil
  dapat menyusun pesan tanpa perlu mengetahui aturan BATAS_PINJAM secara
  langsung.

  Kode lengkap: kode/java/KodeException.png


1.2. Folder service: Refactoring pinjam()

  File: LibraryServiceKotor.java dan LibraryService.java
  TODO: Refactor Nested If menjadi Guard Clause

  Before : before/java/Refactor.png  (Kode bersarang empat tingkat)
  After  : after/java/Refactor.png   (Guard clause dengan exception)

  Penjelasan:
  Pada versi awal, logika utama berada di dalam empat tingkat kondisi, dan
  setiap kegagalan hanya menghasilkan false tanpa alasan. Pada versi
  refaktor, setiap pemeriksaan ditulis sebagai guard clause yang berdiri
  sendiri dan melempar exception spesifik sesuai penyebabnya. Logika utama
  berada di baris paling akhir tanpa menjorok. Menambahkan satu aturan baru
  cukup dengan menambahkan satu blok if di tempat yang sesuai.


1.3. File: PerpustakaanService.java
  TODO: Menangkap Exception dengan Pattern Matching

  Before : before/java/PerpustakaanService.png  (Kondisi awal / Galat logika)
  After  : after/java/PerpustakaanService.png   (Kondisi akhir / Eksekusi berhasil)

  Penjelasan:
  Blok catch (PerpustakaanException e) menangkap seluruh kegagalan domain
  sekaligus. Di dalamnya, instanceof dengan pattern matching (Java 16+)
  memilih data yang akan ditampilkan sesuai jenis exception. Blok
  catch (Exception e) terpisah menangani kesalahan lain, sehingga kesalahan
  pemrograman tidak ikut tertelan oleh penanganan domain.


1.4. File: Main.java
  TODO: Menu dan Ekspor Laporan

  Before : before/java/Main.png  (Kondisi awal / Belum lengkap)
  After  : after/java/Main.png   (Kondisi akhir / Eksekusi berhasil)

  Penjelasan:
  Menu utama menggunakan switch dengan nilai String. Metode eksporLaporan()
  menulis berkas laporan_buku.txt dengan try-with-resources, sehingga
  PrintWriter ditutup otomatis walaupun terjadi error. Status buku
  ditentukan dari sisa stok: "Tersedia" jika lebih dari 0.

  Kode lengkap : kode/java/P10_KodeMain.png
  Output       : output/java/P10_OutputJava.png


2. IMPLEMENTASI PHP
-------------------

2.1. Folder Exception

  File: PerpustakaanException.php

  Penjelasan:
  Kelas induk ini diturunkan dari RuntimeException. PHP tidak memiliki
  checked exception, sehingga seluruh exception setara dengan unchecked di
  Java. Karena itu anotasi @throws pada PHPDoc menjadi penting, sebab
  pembaca kode tidak dibantu oleh kompilator.

  File: BukuTidakDitemukanException.php, AnggotaTidakDitemukanException.php,
        BukuSedangDipinjamException.php, BatasPinjamTerlampauiException.php
  TODO 1-5: Constructor Property Promotion

  Before : before/php/TODO1.png  (Kondisi awal / Belum lengkap)
  After  : after/php/TODO1.png   (Kondisi akhir / Eksekusi berhasil)

  Penjelasan:
  Setiap exception menggunakan constructor property promotion dengan
  properti readonly, sehingga data penyebab tersimpan langsung tanpa
  penulisan ulang di badan konstruktor. Kelas dideklarasikan final karena
  tidak perlu diturunkan lagi. Pola ini sejalan dengan versi Java.

  Kode lengkap: kode/php/KodeException.png


2.2. File: LibraryService.php dan LibraryServiceKotor.php
  TODO: Refactor pinjam() menjadi Guard Clause

  Before : before/php/Refactor.png  (Kode bersarang)
  After  : after/php/Refactor.png   (Guard clause dengan throw)

  Penjelasan:
  Struktur refaktor sama dengan versi Java. Perbedaannya, versi PHP memakai
  array_key_exists() untuk memeriksa keberadaan kunci, dan method pinjam()
  bertipe void karena keberhasilan ditandai oleh tidak adanya exception.
  Konstanta BATAS_PINJAM bertipe int menggunakan typed class constant
  (PHP 8.3).


2.3. File: main.php

  Penjelasan:
  main.php menjalankan skenario uji berupa daftar percobaan peminjaman.
  Setiap percobaan dibungkus try, dan catch (PerpustakaanException $e)
  menampilkan pesan kegagalan. Fungsi createReport() membuka berkas dengan
  fopen(), menulis laporan, lalu menutup berkas di blok finally.

  Kode program : kode/php/P10_KodeMain.png
  Output       : output/php/P10_OutputPHP.png


3. KESIMPULAN
-------------

Pertemuan 10 membahas penanganan exception dan refactoring. Dengan membuat
hierarki exception domain, kegagalan peminjaman dapat ditangani melalui satu
induk dan setiap penyebab memiliki tipe tersendiri yang membawa datanya.
Pemanggil tidak lagi perlu menebak alasan dari nilai false.

Refactoring dari nested if menjadi guard clause membuat alur logika lebih
mudah dibaca, dan aturan baru dapat ditambahkan dengan lebih aman. Perbedaan
utama Java dan PHP terlihat pada tipe exception: Java memakai unchecked
exception dengan RuntimeException, sedangkan PHP tidak memiliki checked
exception sehingga dokumentasi @throws sangat penting.


