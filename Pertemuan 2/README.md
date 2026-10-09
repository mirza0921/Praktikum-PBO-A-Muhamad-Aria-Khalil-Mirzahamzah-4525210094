# LAPORAN PRAKTIKUM PEMROGRAMAN BERBASIS OBJEK

| Informasi Praktikan | Keterangan |
| :--- | :--- |
| **Nama** | Muhamad Aria Khalil Mirzahamzah |
| **NPM** | 4525210094 |
| **Kelas** | A |
| **Mata Kuliah** | Pemrograman Berbasis Objek (PBO) |
| **Pertemuan** | 2 - Kelas, Objek, dan Enkapsulasi |
| **Tanggal** | 10/09/2026 |

---

## 1. Implementasi Java

### 1.1. File: `Mahasiswa.java`

**TODO 1: Deklarasi Atribut**

* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![SS Before TODO1 Mahasiswa.java](ImgBeforeJava/SSTODO1.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO1 Mahasiswa.java](ImgAfterJava/SSTODO1.png)

**Penjelasan:**
> `nim` dan `nama` dideklarasikan `final` karena invariant pertama menyatakan bahwa NIM tidak boleh diubah setelah objek dibuat. Atribut nilai tidak `final` karena masih bisa diperbarui. Tidak ada setter untuk nilai, sehingga nilai tidak bisa diubah dari luar kelas.

**TODO 2: Validasi NIM**

* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![SS Before TODO2 Mahasiswa.java](ImgBeforeJava/SSTODO2.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO2 Mahasiswa.java](ImgAfterJava/SSTODO2.png)

**Penjelasan:**
> Pemeriksaan `null` harus dilakukan terlebih dahulu. Jika tidak, pemanggilan `nim.isBlank()` akan menyebabkan `NullPointerException`. Method `isBlank()` juga menolak string yang hanya berisi spasi.

**TODO 3: Validasi Rentang Nilai**

* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![SS Before TODO3 Mahasiswa.java](ImgBeforeJava/SSTODO3.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO3 Mahasiswa.java](ImgAfterJava/SSTODO3.png)

**Penjelasan:**
> Validasi dilakukan sebelum field diisi, sehingga objek yang tidak valid tidak pernah terbentuk. Ketiga komponen nilai memakai satu method pembantu agar pemeriksaannya tidak ditulis berulang.

**TODO 4: Method Pembantu `pastikanNilaiSah`**

* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![SS Before TODO4 Mahasiswa.java](ImgBeforeJava/SSTODO4.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO4 Mahasiswa.java](ImgAfterJava/SSTODO4.png)

**Penjelasan:**
> Method ini bersifat `static` karena tidak membaca status objek. Pesan kesalahan menyebutkan komponen yang tidak valid beserta nilai yang dimasukkan. Kode ini masih mengizinkan `NaN`, karena setiap perbandingan dengan `NaN` menghasilkan `false`. Perbaikannya adalah:


**TODO 5: Perhitungan Nilai Akhir**

* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![SS Before TODO5 Mahasiswa.java](ImgBeforeJava/SSTODO5.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO5 Mahasiswa.java](ImgAfterJava/SSTODO5.png)

**Penjelasan:**
> Rumusnya adalah 30% tugas, 30% UTS, dan 40% UAS. Bobot diambil dari konstanta sehingga angka 0.30 dan 0.40 tidak ditulis langsung di dalam method. Jika bobot berubah, cukup mengubah satu tempat.

**TODO 6: Huruf Mutu**

* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![SS Before TODO6 Mahasiswa.java](ImgBeforeJava/SSTODO6.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO6 Mahasiswa.java](ImgAfterJava/SSTODO6.png)

**Penjelasan:**
> Pengecekan dimulai dari batas tertinggi, sehingga setiap nilai hanya cocok dengan satu kondisi. Perlu diperhatikan bahwa `double` tidak presisi. Nilai yang seharusnya tepat 80 bisa terhitung 79.9999999 dan mendapat huruf "B". Solusinya adalah membulatkan nilai terlebih dahulu, misalnya dengan `Math.round(akhir * 100) / 100.0`.

**TODO 7: Getter**

* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![SS Before TODO7 Mahasiswa.java](ImgBeforeJava/SSTODO7.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO7 Mahasiswa.java](ImgAfterJava/SSTODO7.png)

**Penjelasan:**
> Tidak ada `setNim()` sesuai dengan invariant. Method `getNilaiAkhir()` tidak menyimpan hasil, melainkan menghitung ulang dari nilai komponen, sehingga hasilnya selalu sesuai dengan data yang ada.

### 1.2. File: `Main.java`

* Tidak ada TODO pada `Main.java`.

**Output Program:**
![Output Java](SSoutputJava.png)

**Penjelasan:**
> `Main.java` menguji apakah kelas `Mahasiswa` berjalan sesuai ketentuan. Bagian pertama membuat tiga objek mahasiswa dan mencetak datanya untuk menguji perhitungan nilai akhir dan huruf mutu. Bagian kedua mencoba memasukkan data tidak valid, yaitu nilai 150 dan NIM kosong, lalu memeriksa apakah keduanya ditolak dengan `IllegalArgumentException`. Hasil dibaca secara manual: "Ditolak" menunjukkan validasi berjalan dengan baik, sedangkan "MASALAH" menandakan adanya kesalahan.

---

## 2. Implementasi PHP

### 2.1. File: `Mahasiswa.php`

**TODO 1: Deklarasi Atribut (`readonly`)**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO1 Mahasiswa.php](ImgBeforephp/SSTODO1.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO1 Mahasiswa.php](ImgAfterphp/SSTODO1.png)

**Penjelasan:**
> `readonly` merupakan padanan `final` di Java. `nim` dan `nama` tidak dapat diubah setelah ditetapkan, sedangkan nilai dibiarkan tanpa `readonly`. Di PHP 8, *constructor property promotion* membuat atribut sekaligus, sehingga tidak perlu deklarasi dan penugasan terpisah.

**TODO 2: Validasi NIM**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO2 Mahasiswa.php](ImgBeforephp/SSTODO2.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO2 Mahasiswa.php](ImgAfterphp/SSTODO2.png)

**Penjelasan:**
> `trim()` menghapus spasi di awal dan akhir string, sehingga NIM yang hanya berisi spasi juga ditolak.

**TODO 3: Validasi Rentang Nilai**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO3 Mahasiswa.php](ImgBeforephp/SSTODO3.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO3 Mahasiswa.php](ImgAfterphp/SSTODO3.png)

**Penjelasan:**
> Pemanggilan dilakukan di dalam konstruktor, sebelum objek dianggap selesai dibuat. Method dipanggil dengan `self::` karena bersifat `static`.

**TODO 4: Method Pembantu `pastikanNilaiSah`**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO4 Mahasiswa.php](ImgBeforephp/SSTODO4.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO4 Mahasiswa.php](ImgAfterphp/SSTODO4.png)

**Penjelasan:**
> Pemeriksaan ini memiliki kekurangan yang sama dengan versi Java: `NaN` tidak terdeteksi karena setiap perbandingan dengan `NaN` menghasilkan `false`. Perbaikannya adalah:



**TODO 5: Perhitungan Nilai Akhir**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO5 Mahasiswa.php](ImgBeforephp/SSTODO5.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO5 Mahasiswa.php](ImgAfterphp/SSTODO5.png)

**Penjelasan:**
> Bobot diambil dari konstanta kelas (`self::`), bukan ditulis langsung sebagai angka. Hasilnya sama dengan versi Java.

**TODO 6: Huruf Mutu**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO6 Mahasiswa.php](ImgBeforephp/SSTODO6.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO6 Mahasiswa.php](ImgAfterphp/SSTODO6.png)

**Penjelasan:**
> `match (true)` mengevaluasi kondisi dari atas ke bawah dan mengembalikan hasil pertama yang cocok. Jika tidak ada yang cocok, nilai `default` digunakan. Struktur ini setara dengan rangkaian `if` berurutan di Java.

**TODO 7: Getter**

* **Before** *(Kondisi awal / Galat logika)*:
![SS Before TODO7 Mahasiswa.php](ImgBeforephp/SSTODO7.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![SS After TODO7 Mahasiswa.php](ImgAfterphp/SSTODO7.png)

**Penjelasan:**
> Tidak ada method setter untuk `nim`, sesuai dengan invariant. `getNilaiAkhir()` ditambahkan agar versi PHP sejalan dengan versi Java.

### 2.2. File: `Main.php`

* Tidak ada TODO pada `Main.php`.

**Output Program:**
![Output PHP](SSoutputphp.png)

**Penjelasan:**
> Program ini membuat tiga objek mahasiswa dan menampilkannya untuk menguji perhitungan nilai akhir dan huruf mutu. Setelah itu, program mencoba membuat mahasiswa dengan nilai 150 dan NIM kosong. Jika `Mahasiswa` menolak keduanya dengan `InvalidArgumentException`, akan muncul tulisan "Ditolak". Jika tidak, akan muncul tulisan "MASALAH".

---

## 3. Kesimpulan

> Materi ini membahas enkapsulasi pada kelas `Mahasiswa` dalam Java dan PHP, dengan tiga aturan yang harus dijaga: NIM tidak boleh kosong dan tidak boleh berubah, setiap nilai (tugas, UTS, UAS) harus berada di rentang 0 sampai 100, dan nilai akhir dihitung dengan bobot 30% tugas, 30% UTS, dan 40% UAS. Validasi dilakukan di konstruktor sehingga objek yang tidak valid tidak pernah terbentuk. Atribut yang tidak boleh berubah ditandai dengan `final` (Java) atau `readonly` (PHP), dan tidak disediakan setter untuk NIM.
>
> Tujuh TODO saling berhubungan untuk menerapkan aturan tersebut, mulai dari deklarasi atribut, validasi NIM dan rentang nilai, method pembantu, perhitungan nilai akhir, penentuan huruf mutu, hingga pembuatan getter. Program uji `Main.java` dan `Main.php` memverifikasi hasilnya dengan mencetak tiga mahasiswa untuk memastikan perhitungan dan huruf mutu sudah benar (Ani A, Budi D, Citra A), lalu mencoba membuat data yang salah, yaitu nilai 150 dan NIM kosong. Jika keduanya ditolak, hasilnya menampilkan "Ditolak". Jika ada yang lolos, hasilnya menampilkan "MASALAH".
>
> Perbaikan yang direkomendasikan meliputi validasi `NaN` dengan kondisi `!(nilai >= MIN && nilai <= MAX)`, pembulatan nilai `double` sebelum dibandingkan, penggantian nama file `Mahasiswa (2).java` agar dapat dikompilasi, dan penghapusan tipe pada konstanta PHP jika menggunakan versi di bawah 8.3.