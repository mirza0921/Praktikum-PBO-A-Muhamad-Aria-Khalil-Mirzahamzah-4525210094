public class LaptopAsus {
    private final String merk = "ASUS";
    private String model;
    private String nomorSeri;
    private int kapasitasBaterai; // 0 - 100
    private boolean statusMenyala;
    private int jumlahRAM;

    public LaptopAsus(String model, String nomorSeri, int jumlahRAM) {
        this.model = model;
        this.nomorSeri = nomorSeri;
        this.jumlahRAM = jumlahRAM;
        this.kapasitasBaterai = 100; // default penuh saat dibuat
        this.statusMenyala = false;
    }

    // Invarian 1: kapasitas baterai selalu 0-100
    public void cashBaterai(int jumlah) {
        if (jumlah < 0) {
            System.out.println("Jumlah cas tidak valid.");
            return;
        }
        kapasitasBaterai = Math.min(100, kapasitasBaterai + jumlah);
    }

    public void pakaiBaterai(int jumlah) {
        if (jumlah < 0) {
            System.out.println("Jumlah pemakaian tidak valid.");
            return;
        }
        kapasitasBaterai = Math.max(0, kapasitasBaterai - jumlah);
        if (kapasitasBaterai == 0) {
            statusMenyala = false; // otomatis mati jika baterai habis
        }
    }

    // Invarian 2: tidak bisa menyala jika baterai 0
    public void nyalakan() {
        if (kapasitasBaterai <= 0) {
            System.out.println("Gagal menyalakan: baterai habis!");
            return;
        }
        statusMenyala = true;
        System.out.println(model + " berhasil dinyalakan.");
    }

    public void matikan() {
        statusMenyala = false;
        System.out.println(model + " dimatikan.");
    }

    public void getInfo() {
        System.out.println("Merk        : " + merk);
        System.out.println("Model       : " + model);
        System.out.println("Nomor Seri  : " + nomorSeri);
        System.out.println("RAM         : " + jumlahRAM + " GB");
        System.out.println("Baterai     : " + kapasitasBaterai + "%");
        System.out.println("Status      : " + (statusMenyala ? "Menyala" : "Mati"));
    }

    public static void main(String[] args) {
        LaptopAsus laptop = new LaptopAsus("ROG Strix G16", "ASUS-2024-001", 16);
        laptop.getInfo();

        // Operasi sah
        laptop.nyalakan();
        laptop.pakaiBaterai(30);
        laptop.getInfo();

        // Operasi tidak sah 1: cas melebihi 100
        laptop.cashBaterai(200);
        laptop.getInfo(); // tetap maksimal 100

        // Operasi tidak sah 2: nyalakan saat baterai habis
        laptop.pakaiBaterai(100); // baterai jadi 0, otomatis mati
        laptop.nyalakan(); // harus ditolak
        laptop.getInfo();
    }
}