# Keputusan Desain — Pertemuan 6

## 1. Mengapa Java hanya membolehkan mewarisi SATU class, tetapi banyak interface?
Karena **masalah berlian (diamond problem)**. Jika kelas boleh mewarisi dua class, dan keduanya punya
method/field dengan nama sama yang sudah berisi kode, kompiler tidak tahu versi mana yang dipakai.
Interface hanya mendeklarasikan *kontrak* (apa yang bisa dilakukan), sehingga tidak ada state maupun
kode yang berbenturan: kelas implementor sendiri yang menulis isinya. Maka satu class boleh memenuhi
banyak kontrak (`Mobil implements Movable, Fuelable`) tanpa ambigu. (Default method yang bentrok pun
dipaksa diselesaikan eksplisit oleh implementor.)

## 2. Penolakan saat KOMPILASI: pesan error `isiPenuh(sepeda)` (Java)
```
Main.java:37: error: incompatible types: Sepeda cannot be converted to Fuelable
        isiPenuh(sepeda);
                 ^
```
(PHP: `TypeError: isiPenuh(): Argument #1 ($kendaraan) must be of type Fuelable, Sepeda given`,
muncul saat program dijalankan.)

**Mengapa menguntungkan?** Kesalahan ditemukan sebelum program dijalankan, bukan saat pengguna sudah
memakainya. Sepeda tidak punya tangki, jadi mengisinya bahan bakar adalah kesalahan desain yang
langsung terdeteksi. Ini bukti Interface Segregation Principle: karena `Fuelable` dipisah dari
`Movable`, tipe sistem sendiri yang mencegah kombinasi yang tidak masuk akal.

## 3. Interface vs abstract class
- **Abstract class** (`Kendaraan`): kode yang benar-benar sama (merek, tahun, `umur()`); menyatakan "benda ini ADALAH".
- **Interface** (`Movable`, `Fuelable`): kemampuan yang bisa dimiliki kelas apa pun; menyatakan "benda ini BISA".

## 4. Enum vs konstanta int
Enum membatasi nilai hanya yang terdaftar (angka 99 tidak bisa lolos) dan boleh punya method
(`biayaPengisian`, `ramahLingkungan`). Menambah `LISTRIK` cukup di satu tempat.

## 5. Trait (PHP)
`Loggable` dipakai `Mobil` dan `Pesanan` yang tidak sekerabat: penggunaan ulang **horizontal**.
Java tidak punya trait; padanan terdekatnya default method pada interface (tanpa state).
