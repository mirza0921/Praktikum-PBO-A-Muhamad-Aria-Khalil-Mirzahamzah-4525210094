package service;

import model.Buku;

import java.util.ArrayList;
import java.util.List;

/**
 * Kerangka lapisan layanan.
 * Pada sesi 7 cukup struktur dan tanda tangan method; isinya boleh minimal.
 * Lapisan ini akan diperdalam pada sesi 10 (exception) dan 12 (SOLID).
 *
 * TODO: sesuaikan seluruh isi berkas ini dengan class diagram Anda sendiri.
 *       Kelas dan method di sini hanya contoh awal.
 */
public class PerpustakaanService {

    // TODO 1: tentukan bagaimana layanan ini menyimpan koleksi dan anggota.
    //         Agregasi atau komposisi? Tuliskan alasannya di analisis.md,
    //         lalu wujudkan keputusan itu di sini.
    //
    // Keputusan: AGREGASI. Buku dibuat di luar lalu diserahkan lewat tambahKoleksi.
    // Layanan hanya menyimpan referensinya, sehingga buku tetap ada
    // meski layanan tidak lagi dipakai.
    private final List<Buku> koleksi = new ArrayList<>();

    public void tambahKoleksi(Buku buku) {
        // TODO 2
        if (buku == null) {
            throw new IllegalArgumentException("Buku tidak boleh null");
        }
        if (cariKoleksi(buku.getNomorInduk()) != null) {
            throw new IllegalArgumentException("Nomor induk sudah terdaftar: " +
             buku.getNomorInduk());
        }
        koleksi.add(buku);
    }

    public Buku cariKoleksi(String nomorInduk) {
        // TODO 3
        for (Buku b : koleksi) {
            if (b.getNomorInduk().equals(nomorInduk)) {
                return b;
            }
        }
        return null;
    }

    public void pinjam(String nomorAnggota, String nomorInduk) {
        // TODO 4: terapkan aturan bisnis dari deskripsi-kebutuhan.md.
        //         Aturan lengkapnya akan disempurnakan pada sesi 10.
        // Aturan sementara: buku harus ada dan masih tersedia.
        // Validasi anggota dan batas pinjam menyusul pada sesi 10.
        Buku buku = cariKoleksi(nomorInduk);
        if (buku == null) {
            throw new IllegalArgumentException("Buku tidak ditemukan: " + nomorInduk);
        }
        if (!buku.tersedia()) {
            throw new IllegalStateException("Buku tidak tersedia: " + buku.getJudul());
        }
        buku.kurangiStok();
    }

    public void kembalikan(String nomorAnggota, String nomorInduk) {
        // TODO 5
        Buku buku = cariKoleksi(nomorInduk);
        if (buku == null) {
            throw new IllegalArgumentException("Buku tidak ditemukan: " + nomorInduk);
        }
        buku.tambahStok();
    }
}