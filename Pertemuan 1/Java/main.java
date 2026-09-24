public class main {
    public static void main(String[] args) {
        LaptopAsus laptop = new LaptopAsus(" ROG Strix G16", "ASUS-2024-001", 16);

        System.out.println("=== Info Awal ===");
        laptop.getInfo();

        System.out.println("/n=== Operasi Sah : Nyalakan lalu pakai Baterai ===");
        laptop.nyalakan();
        laptop.pakaiBaterai(30);
        laptop.getInfo();

        System.out.println("/n=== OPerasi tidak Sah 1: Cas melebihi 100 ===");
        laptop.cashBaterai(200);
        laptop.getInfo(); // tetap maksimal 100

        System.out.println("/n=== Operasi tidak Sah 2: Nyalakan saat Baterai Habis ===");
        
        laptop.pakaiBaterai(100); // baterai jadi 0, otomatis mati
        laptop.nyalakan();
        laptop.getInfo();
    }
}