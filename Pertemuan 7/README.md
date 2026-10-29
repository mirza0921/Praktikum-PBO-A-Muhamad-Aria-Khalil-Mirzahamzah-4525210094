# LAPORAN PRAKTIKUM PEMROGRAMAN BERBASIS OBJEK

| Informasi Praktikan | Keterangan |
| :--- | :--- |
| **Nama** | Muhamad Aria Khalil Mirzahamzah |
| **NPM** | 4525210094 |
| **Kelas** | A |
| **Mata Kuliah** | Pemrograman Berbasis Objek (PBO) |
| **Pertemuan** | 7 - Komposisi dan Agregasi |
| **Tanggal** | [ 17/10/2026 ] |

---

## 1. Implementasi Java

### 1.1. File: `model/Buku.java`

**TODO 1: Validasi jumlah eksemplar pada constructor**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO1 Buku.java](ImgBeforeJava/SSTODO1.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO1 Buku.java](ImgAfterJava/SSTODO1.png)

**Penjelasan:**
> Constructor menolak jumlah eksemplar negatif dengan melempar `IllegalArgumentException`. Pemeriksaan dilakukan sebelum field diisi, sehingga objek `Buku` tidak pernah berada dalam kondisi yang tidak valid.

**TODO 2: Method `tambahBab(int nomor, String judulBab)`**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO2 Buku.java](ImgBeforeJava/SSTODO2.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO2 Buku.java](ImgAfterJava/SSTODO2.png)

**Penjelasan:**
> Method menerima nomor dan judul, bukan objek `Bab`. Objek `Bab` dibuat di dalam `Buku` sehingga tidak ada cara lain untuk membuatnya dari luar. Inilah yang membuat relasi ini komposisi.

**TODO 3: Method `getBab()` mengembalikan salinan tak-berubah**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO3 Buku.java](ImgBeforeJava/SSTODO3.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO3 Buku.java](ImgAfterJava/SSTODO3.png)

**Penjelasan:**
> Sebelum diperbaiki, `getBab()` mengembalikan list internal sehingga `clear()` dari luar berhasil menghapus isi buku. Setelah memakai `List.copyOf(bab)`, pemanggilan `clear()` melempar `UnsupportedOperationException`, dan komposisi tetap terjaga.

**TODO 4: Method `kurangiStok()`**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO4 Buku.java](ImgBeforeJava/SSTODO4.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO4 Buku.java](ImgAfterJava/SSTODO4.png)

**Penjelasan:**
> Method mengurangi stok satu, dan melempar `IllegalStateException` jika stok sudah nol.

**Kode Lengkap:**
![Kode Buku.java](ImgKodeJava/SSKodeBuku.png)

### 1.2. File: `model/Jurusan.java`

**TODO 1: Method `daftarkan(Mahasiswa m)`**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO1 Jurusan.java](ImgBeforeJava/SSTODO5.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO1 Jurusan.java](ImgAfterJava/SSTODO5.png)

**Penjelasan:**
> Objek `Mahasiswa` datang dari luar, itulah tanda agregasi. Method menolak `null` dengan `Objects.requireNonNull` dan tidak menambahkan mahasiswa yang sudah terdaftar.

**TODO 2: Method `keluarkan(Mahasiswa m)`**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO2 Jurusan.java](ImgBeforeJava/SSTODO6.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO2 Jurusan.java](ImgAfterJava/SSTODO6.png)

**Penjelasan:**
> Method hanya melepas referensi dari daftar. Objek `Mahasiswa` tetap hidup di luar jurusan, sesuai sifat agregasi.

**TODO 3: Method `getMahasiswa()` mengembalikan salinan tak-berubah**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO3 Jurusan.java](ImgBeforeJava/SSTODO7.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO3 Jurusan.java](ImgAfterJava/SSTODO7.png)

**Penjelasan:**
> Sama seperti `Buku.getBab()`, method ini mengembalikan `List.copyOf(mahasiswa)` agar daftar internal tidak bisa diubah dari luar.

**Kode Lengkap:**
![Kode Jurusan.java](ImgKodeJava/SSKodeJurusan.png)

### 1.3. File: `service/PerpustakaanService.java`

**TODO 1: Keputusan agregasi atau komposisi**

* **Before** *(Kondisi awal / Belum ada penyimpanan koleksi)*:
![SS Before TODO1 PerpustakaanService.java](ImgBeforeJava/SSTODO8.png)

* **After** *(Kondisi akhir / Keputusan agregasi diwujudkan)*:
![SS After TODO1 PerpustakaanService.java](ImgAfterJava/SSTODO8.png)

**Penjelasan:**
> Keputusan: **agregasi**. Buku dibuat di luar layanan lalu diserahkan lewat `tambahKoleksi()`. Layanan hanya menyimpan referensinya sehingga buku tetap ada meski layanan tidak dipakai lagi.

**TODO 2: Method `tambahKoleksi(Buku buku)`**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO2 PerpustakaanService.java](ImgBeforeJava/SSTODO9.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO2 PerpustakaanService.java](ImgAfterJava/SSTODO9.png)

**Penjelasan:**
> Method menolak `null` dan nomor induk yang sudah terdaftar, lalu menambahkan buku ke daftar koleksi.

**TODO 3: Method `cariKoleksi(String nomorInduk)`**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO3 PerpustakaanService.java](ImgBeforeJava/SSTODO10.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO3 PerpustakaanService.java](ImgAfterJava/SSTODO10.png)

**Penjelasan:**
> Method menelusuri koleksi dan mengembalikan buku yang nomor induknya cocok, atau `null` jika tidak ditemukan.

**TODO 4: Method `pinjam(nomorAnggota, nomorInduk)`**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO4 PerpustakaanService.java](ImgBeforeJava/SSTODO11.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO4 PerpustakaanService.java](ImgAfterJava/SSTODO11.png)

**Penjelasan:**
> Aturan sementara: buku harus ada dan masih tersedia, lalu stoknya dikurangi. Validasi anggota dan batas pinjam akan ditambahkan pada sesi 10.

**TODO 5: Method `kembalikan(nomorAnggota, nomorInduk)`**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO5 PerpustakaanService.java](ImgBeforeJava/SSTODO12.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO5 PerpustakaanService.java](ImgAfterJava/SSTODO12.png)

**Penjelasan:**
> Method mencari buku lalu menambah stoknya kembali.

**Kode Lengkap:**
![Kode PerpustakaanService.java](ImgKodeJava/SSKodePerpustakaanService.png)

### 1.4. File: `Main.java`

* Tidak ada TODO. Program mendemonstrasikan komposisi (`Buku` dan `Bab`) dan agregasi (`Jurusan` dan `Mahasiswa`).

**Output Program:**
![Output Java](SSoutputJava.png)

**Penjelasan:**
> Percobaan mengosongkan koleksi bab dari luar ditolak, yang membuktikan `getBab()` sudah mengembalikan salinan tak-berubah. Setelah Budi dikeluarkan dari jurusan, objek `Budi` tetap ada, yang membuktikan agregasi.

---

## 2. Implementasi PHP

### 2.1. File: `relasi.php`

**TODO 1: Constructor `readonly` pada `Bab`**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO1 relasi.php](ImgBeforephp/SSTODO1.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO1 relasi.php](ImgAfterphp/SSTODO1.png)

**Penjelasan:**
> Properti `$nomor` dan `$judul` dibuat `readonly` agar tidak bisa diubah setelah objek dibuat. PHP tidak punya nested class, sehingga pembatasan bahwa `Bab` hanya dibuat dari `Buku` dijaga lewat konvensi.

**TODO 2: Validasi jumlah eksemplar pada `Buku`**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO2 relasi.php](ImgBeforephp/SSTODO2.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO2 relasi.php](ImgAfterphp/SSTODO2.png)

**Penjelasan:**
> Constructor melempar `InvalidArgumentException` jika jumlah eksemplar negatif.

**TODO 3: Method `tambahBab(int $nomor, string $judulBab)`**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO3 relasi.php](ImgBeforephp/SSTODO3.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO3 relasi.php](ImgAfterphp/SSTODO3.png)

**Penjelasan:**
> Method membuat `Bab` baru dari nomor dan judul, sama seperti versi Java.

**TODO 4: Method `kurangiStok()`**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO4 relasi.php](ImgBeforephp/SSTODO4.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO4 relasi.php](ImgAfterphp/SSTODO4.png)

**Penjelasan:**
> Method melempar `RuntimeException` jika stok sudah nol.

**TODO 5: Method `daftarkan(Mahasiswa $m)`**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO5 relasi.php](ImgBeforephp/SSTODO5.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO5 relasi.php](ImgAfterphp/SSTODO5.png)

**Penjelasan:**
> Perbandingan `in_array(..., true)` membandingkan identitas objek, sehingga mahasiswa yang sama tidak masuk dua kali.

**TODO 6: Method `keluarkan(Mahasiswa $m)`**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO6 relasi.php](ImgBeforephp/SSTODO6.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO6 relasi.php](ImgAfterphp/SSTODO6.png)

**Penjelasan:**
> Mahasiswa dibuang dari array dengan `array_filter`, lalu indeksnya dirapikan dengan `array_values`. Objeknya tetap hidup di luar jurusan.

**Kode Lengkap:**
![Kode relasi.php](ImgKodephp/SSKodeRelasi.png)

### 2.2. File: `main.php`

* Tidak ada TODO. Program mencetak hasil komposisi dan agregasi dengan cara yang sama seperti `Main.java`.

**Output Program:**
![Output PHP](SSoutputphp.png)

---

## 3. Class Diagram (PlantUML)

File: `perpustakaan-kerangka.puml`

**TODO 1: Tiga turunan `Koleksi`**

* **Before** *(Kondisi awal / Belum ada turunan)*:
![SS Before TODO1 puml](ImgBeforeUML/SSTODO1.png)

* **After** *(Kondisi akhir / Turunan ditambahkan)*:
![SS After TODO1 puml](ImgAfterUML/SSTODO1.png)
![SS After TODO1 puml](ImgAfterUML/SSTODO1(1).png)


**Penjelasan:**
> `Buku`, `Majalah`, dan `Skripsi` diturunkan dari `Koleksi`. Masa pinjam Buku 14 hari, Majalah 7 hari, dan Skripsi hanya baca di tempat sehingga tidak boleh dipinjam.

**TODO 2: Kelas `Anggota` dan `Peminjaman`**

* **Before** *(Kondisi awal / Kelas belum ada)*:
![SS Before TODO2 puml](ImgBeforeUML/SSTODO2.png)

* **After** *(Kondisi akhir / Kelas ditambahkan)*:
![SS After TODO2 puml](ImgAfterUML/SSTODO2.png)

**Penjelasan:**
> Ditambahkan kelas `Anggota` dengan atribut nomor anggota, nama, dan jenis. Kelas `Peminjaman` dengan atribut tanggal pinjam, jatuh tempo, dan tanggal kembali.

**TODO 3: Enum `StatusKoleksi` dan `JenisKeanggotaan`**

* **Before** *(Kondisi awal / Enum belum ada)*:
![SS Before TODO3 puml](ImgBeforeUML/SSTODO3.png)

* **After** *(Kondisi akhir / Enum ditambahkan)*:
![SS After TODO3 puml](ImgAfterUML/SSTODO3.png)

**Penjelasan:**
> `StatusKoleksi` berisi `TERSEDIA`, `DIPINJAM`, dan `HABIS`. `JenisKeanggotaan` berisi `MAHASISWA`, `DOSEN`, dan `UMUM`.

**TODO 4: Derajat keterikatan dan multiplicity**

* **Before** *(Kondisi awal / Relasi belum diisi)*:
![SS Before TODO4 puml](ImgBeforeUML/SSTODO4.png)

* **After** *(Kondisi akhir / Relasi lengkap dengan multiplicity)*:
![SS After TODO4 puml](ImgAfterUML/SSTODO4.png)

**Penjelasan:**
> `Buku "1" *-- "0..*" Bab` adalah komposisi, karena bab tidak punya arti tanpa buku. `Anggota "1" *-- "0..*" Peminjaman` adalah komposisi, karena riwayat pinjam dimiliki anggota. `Peminjaman "0..*" --> "1" Koleksi` adalah asosiasi, karena koleksi tidak memiliki peminjaman.

**TODO 5: Relasi `Koleksi <|-- Bab` yang salah**

* **Before** *(Kondisi awal / Relasi salah)*:
![SS Before TODO5 puml](ImgBeforeUML/SSTODO5.png)

* **After** *(Kondisi akhir / Relasi diperbaiki)*:
![SS After TODO5 puml](ImgAfterUML/SSTODO5.png)

**Penjelasan:**
> `Bab` bukan turunan `Koleksi`, melainkan bagian dari `Buku`. Relasi generalisasi tersebut dihapus.

**TODO 6: Relasi `PerpustakaanService`**

* **Before** *(Kondisi awal / Relasi belum ada)*:
![SS Before TODO6 puml](ImgBeforeUML/SSTODO6.png)

* **After** *(Kondisi akhir / Relasi ditambahkan)*:
![SS After TODO6 puml](ImgAfterUML/SSTODO6.png)

**Penjelasan:**
> `PerpustakaanService` memakai agregasi terhadap `Koleksi` dan `Anggota`, karena layanan hanya menyimpan referensi. Layanan juga memiliki dependensi ke `Peminjaman` karena membuatnya saat `pinjam()` dipanggil.

---

## 4. Kesimpulan

> Komposisi dipakai ketika bagian tidak punya arti tanpa induknya, seperti `Bab` pada `Buku`, dan bagian dibuat di dalam induk. Agregasi dipakai ketika bagian datang dari luar dan tetap hidup walau induknya dihapus, seperti `Mahasiswa` pada `Jurusan` dan `Koleksi` pada `PerpustakaanService`.
>
> Perbedaan utama Java dan PHP ada pada cara membatasi pembuatan objek bagian. Java bisa memakai nested class dengan constructor privat, sedangkan PHP hanya bisa mengandalkan konvensi.

