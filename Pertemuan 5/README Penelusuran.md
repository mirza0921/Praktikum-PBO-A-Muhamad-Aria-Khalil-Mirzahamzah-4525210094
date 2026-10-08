# Penelusuran

**toString() di induk memanggil luas() milik turunan, bagaimana mungkin?**
Karena *dynamic dispatch* (late binding). Metode 'luas()' dipilih saat program berjalan berdasarkan tipe objek sebenarnya (Lingkaran/Persegi/..), bukan tipe variabelnya. Induk hanya menetapkan kontrak abstrak; JVM/PHP mencari implementasi di kelas turunan

**AntiPattern (Langkah 5)**
1. Menambah satu bangun baru pada versi anti-pattern: minimal 3 tempat disunting (record baru, cabang else-if baru, tambahan di array). Pada versi polimorfik: 1 kelas baru + 1 baris di array; kode lama tidak disunting.
2. Jika lupa menambah cabang else-if, program melempar 'ILLegalArgumentException' saat runtime ( baru ketahuan ketika dijalankan). Pada versi polimorfik, kelas yang lupa mengisi 'luas()' gagal di compile time (kelas abstrak tidak bisa diinstansi).
3. Pengetahuan "cara menghitung luas lingkaran" seharusnya berada di kelas ' lingkaran sendiri'
