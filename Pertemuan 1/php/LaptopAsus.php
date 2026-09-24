<?php
class LaptopAsus {
    private string $merk = "ASUS";
    private string $model;
    private string $nomorSeri;
    private int $kapasitasBaterai; // 0 - 100
    private bool $statusMenyala;
    private int $jumlahRAM;

    public function __construct(string $model, string $nomorSeri, int $jumlahRAM) {
        $this->model = $model;
        $this->nomorSeri = $nomorSeri;
        $this->jumlahRAM = $jumlahRAM;
        $this->kapasitasBaterai = 100;
        $this->statusMenyala = false;
    }

    // Invarian 1: kapasitas baterai selalu 0-100
    public function cashBaterai(int $jumlah): void {
        if ($jumlah < 0) {
            echo "Jumlah cas tidak valid.\n";
            return;
        }
        $this->kapasitasBaterai = min(100, $this->kapasitasBaterai + $jumlah);
    }

    public function pakaiBaterai(int $jumlah): void {
        if ($jumlah < 0) {
            echo "Jumlah pemakaian tidak valid.\n";
            return;
        }
        $this->kapasitasBaterai = max(0, $this->kapasitasBaterai - $jumlah);
        if ($this->kapasitasBaterai === 0) {
            $this->statusMenyala = false;
        }
    }

    // Invarian 2: tidak bisa menyala jika baterai 0
    public function nyalakan(): void {
        if ($this->kapasitasBaterai <= 0) {
            echo "Gagal menyalakan: baterai habis!\n";
            return;
        }
        $this->statusMenyala = true;
        echo $this->model . " berhasil dinyalakan.\n";
    }

    public function matikan(): void {
        $this->statusMenyala = false;
        echo $this->model . " dimatikan.\n";
    }

    public function getInfo(): void {
        echo "Merk        : {$this->merk}\n";
        echo "Model       : {$this->model}\n";
        echo "Nomor Seri  : {$this->nomorSeri}\n";
        echo "RAM         : {$this->jumlahRAM} GB\n";
        echo "Baterai     : {$this->kapasitasBaterai}%\n";
        echo "Status      : " . ($this->statusMenyala ? "Menyala" : "Mati") . "\n";
    }
}

// Program utama
$laptop = new LaptopAsus("ROG Strix G16", "ASUS-2024-001", 16);
$laptop->getInfo();

// Operasi sah
$laptop->nyalakan();
$laptop->pakaiBaterai(30);
$laptop->getInfo();

// Operasi tidak sah 1: cas melebihi 100
$laptop->cashBaterai(200);
$laptop->getInfo(); // tetap maksimal 100

// Operasi tidak sah 2: nyalakan saat baterai habis
$laptop->pakaiBaterai(100); // baterai jadi 0, otomatis mati
$laptop->nyalakan(); // harus ditolak
$laptop->getInfo();