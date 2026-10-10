public class Segitiga extends BangunDatar {
    private final double a, b, c;

    public Segitiga(double a, double b, double c) {
        super("Segitiga");
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Semua sisi harus > 0");
        }
        // Tolak bila ketiga sisi tidak membentuk segitiga (ketaksamaan segitiga)
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Sisi" + a + "," + b + "," + c + "Tidak Membentuk 
            segitiga");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }   
    //TODO lengkapi luas() dan keliling().
    @Override public double luas() {
        double s = keliling() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override public double keliling() {
        return a + b + c; } 
}