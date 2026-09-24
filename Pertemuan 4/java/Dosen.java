/** Dosen: pegawai tetap + tunjangan fungsional (nominal tetap). */
public class Dosen extends PegawaiTetap {

    private final double tunjanganFungsional;

    public Dosen(String nip, String nama, double gajiPokok, int masaKerjaTahun,
                 double tunjanganFungsional) {
        super(nip, nama, gajiPokok, masaKerjaTahun);
        if (tunjanganFungsional < 0) {
            throw new IllegalArgumentException(
                "Tunjangan fungsional tidak boleh negatif: " + tunjanganFungsional);
        }
        this.tunjanganFungsional = tunjanganFungsional;
    }

    @Override
    public double hitungGaji() {
        return super.hitungGaji() + tunjanganFungsional;
    }

    @Override
    public String jenis() { return "DOSEN"; }
}
