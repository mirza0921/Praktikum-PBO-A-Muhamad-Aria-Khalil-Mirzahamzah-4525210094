# Tugas 1 — LaptopAsus

## Domain
Laptop ASUS

## Rancangan Class

**Nama Class:** `LaptopAsus`

**Field (atribut):**

| Field | Tipe | Keterangan |
|---|---|---|
| merk | String | tetap "ASUS" |
| model | String | mis. "ROG Strix G16" |
| nomorSeri | String | unik per unit |
| kapasitasBaterai | int | dalam persen (0–100) |
| statusMenyala | boolean | true/false |
| jumlahRAM | int | dalam GB |

**Method:**
- `nyalakan()` — mengubah statusMenyala jadi true, hanya jika baterai > 0
- `matikan()` — mengubah statusMenyala jadi false
- `cashBaterai(int jumlah)` — menambah kapasitasBaterai, tidak boleh melebihi 100
- `pakaiBaterai(int jumlah)` — mengurangi kapasitasBaterai saat laptop menyala
- `getInfo()` — menampilkan info laptop

## Invarian & Alasannya

1. **kapasitasBaterai selalu 0–100** — Nilai baterai tidak boleh negatif atau melebihi kapasitas maksimum, karena secara fisik tidak mungkin baterai terisi lebih dari 100% atau berkurang di bawah 0%.
2. **statusMenyala tidak boleh true jika kapasitasBaterai == 0** — Laptop tidak mungkin menyala tanpa daya baterai sama sekali, sehingga status menyala harus otomatis ditolak/dimatikan saat baterai habis.

Karena kedua field ini punya aturan yang harus dijaga, field tersebut **tidak diberi setter langsung**. Perubahan nilainya hanya bisa lewat method (`cashBaterai`, `pakaiBaterai`, `nyalakan`, `matikan`) yang sudah memvalidasi aturan di atas.