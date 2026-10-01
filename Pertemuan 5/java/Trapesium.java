public class Trapesium extends BangunDatar {
    private final double sejajarA, sejajarB, tinggi, kakiC, kakiD;
    /**
     * @param sejajarA sisi sejajar pertama
     * @param sejajarB sisi sejajar kedua
     * @param tinggi tinggi trapesium 
     * @param kakiC kaki(sisi miring) pertama
     * @param kakiD kaki(sisi miring) kedua
     */
    public Trapesium(double sejajarA, double sejajarB, double tinggi, double kakiC, double kakiD) {
        super("Trapesium");
        if (sejajarA <= 0 || sejajarB <= 0 || tinggi <= 0 || kakiC <= 0 || kakiD <= 0) {
            throw new IllegalArgumentException("Semua ukuran harus > 0");
        }
        if (kakiC < tinggi || kakiD < tinggi) {
            throw new IllegalArgumentException("kaki tidak boleh lebih pendek dari tinggi");
        }
        this.sejajarA = sejajarA;
        this.sejajarB = sejajarB;
        this.tinggi = tinggi;
        this.kakiC = kakiC;
        this.kakiD = kakiD;
    }
    @Override public double luas() {
        return (sejajarA + sejajarB) / 2 * tinggi;
    }
    @Override public double keliling() {
        return sejajarA + sejajarB + kakiC + kakiD;
    }
}