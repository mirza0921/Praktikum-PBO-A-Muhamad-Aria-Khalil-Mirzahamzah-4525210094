public class AntiPatternRefaktor {
    public static void main(String[] args) {
        BangunDatar[] daftar = {
            new Lingkaran(7),
            new Persegi(5),
            new Segitiga(3, 4, 5)
        };

        double total = 0;
        for (BangunDatar b : daftar) total += b.luas();
        System.out.printf("Total luas (cara polimorfik) : %.2f%n", total);
    }
}