<?php
declare(strict_types=1);

/**
 * Langkah 6 — latihan mandiri.
 *
 * Buat hierarki Notifikasi dengan tiga turunan: Email, SMS, WhatsApp.
 * Lalu lengkapi kirimSemua() TANPA satu pun pemeriksaan tipe.
 */

// TODO 1: buat kelas abstrak Notifikasi dengan:
//         - properti readonly $tujuan
//         - method abstract kirim(string $pesan): void
//         - method saluran(): string yang menyebut nama salurannya
abstract class Notifikasi
{
    public function __construct(public readonly string $tujuan) {}

    abstract public function kirim(string $pesan): void;

    public function saluran(): string
    {
        return static::class;
    }
}

// TODO 2: buat tiga turunan: Email, SMS, WhatsApp.
//         Masing-masing mencetak format pesan yang berbeda.
class Email extends Notifikasi
{
    public function kirim(string $pesan): void
    {
        echo "[{$this->saluran()}] Kepada: {$this->tujuan}", PHP_EOL,
            " Subjek: Pemberitahuan ", PHP_EOL,
            "Isi    : $pesan", PHP_EOL;
    }
}

class SMS extends Notifikasi
{
    public function kirim(string $pesan): void
    {
        echo "[{$this->saluran()}] ke {$this->tujuan}: ", substr($pesan, 0, 160), PHP_EOL;
    }
}

class WhatsApp extends Notifikasi
{
    public function kirim(string $pesan): void
    {
        echo "[{$this->saluran()}] ke {$this->tujuan}:", PHP_EOL,
            " *Pemberitahuan*", PHP_EOL,
            " $pesan", PHP_EOL;
    }
}

/**
 * TODO 3: kirim pesan ke seluruh notifikasi dalam daftar.
 *
 * ATURAN: tidak boleh ada instanceof, tidak boleh ada match/switch
 *         atas jenis notifikasi.
 *
 * @param Notifikasi[] $daftar
 */
function kirimSemua(array $daftar, string $pesan): void
{
    foreach ($daftar as $n) {
        $n->kirim($pesan);
    }
}

kirimSemua([
    new Email('ani@univpancasila.ac.id'),
    new SMS('081234567890'),
    new WhatsApp('081234567890'),
], 'Buku yang Anda pesan sudah tersedia.');