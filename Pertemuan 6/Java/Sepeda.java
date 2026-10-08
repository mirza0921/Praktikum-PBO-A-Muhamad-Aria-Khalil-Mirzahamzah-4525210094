/**
 * TODO Langkah 4: Sepeda — extends Kendaraan implements Movable,
 *                 TETAPI BUKAN Fuelable.   [SELESAI]
 */
public class Sepeda extends Kendaraan implements Movable {

    public Sepeda(String merek, int tahun) {
        super(merek, tahun);
    }

    @Override public int jumlahRoda() { return 2; }

    @Override public void bergerak() {
        System.out.println("  " + merek + " dikayuh di jalur sepeda");
    }

    @Override public double kecepatanMaksimum() { return 25; }
}
