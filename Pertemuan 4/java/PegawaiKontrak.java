public class PegawaiKontrak extends Pegawai {

    private final int bulanKontrak;

    public PegawaiKontrak(String nip, String nama, double gajiPokok, int bulanKontrak) {
        super(nip, nama, gajiPokok);
        this.bulanKontrak = bulanKontrak;
    }

    // TODO 2: pegawai kontrak TIDAK mendapat tunjangan masa kerja.
    //         Apakah method hitungGaji() perlu di-override di sini?
    //         Jawab: TIDAK perlu. Versi warisan dari Pegawai sudah mengembalikan
    //         gaji pokok apa adanya, dan itulah yang berlaku untuk kontrak.
    //         Meng-override hanya untuk menyalin perilaku yang sama = duplikasi.

    @Override
    public String jenis() { return "KONTRAK"; }

    public int getBulanKontrak() { return bulanKontrak; }
}
