<?php
declare(strict_types=1);

abstract class BangunDatar
{
    public function __construct(private readonly string $nama) {}

    abstract public function luas(): float;
    abstract public function keliling(): float;

    public function getNama(): string { return $this->nama; }

    public function __toString(): string
    {
        return sprintf('%-12s luas=%10.2f  keliling=%10.2f',
            $this->nama, $this->luas(), $this->keliling());
    }
}

class Lingkaran extends BangunDatar
{
    public function __construct(private readonly float $jariJari)
    {
        parent::__construct('Lingkaran');
        // TODO 1: tolak jari-jari <= 0.   [SELESAI]
        if ($jariJari <= 0) {
            throw new InvalidArgumentException("Jari-jari harus > 0, diterima: $jariJari");
        }
    }

    // TODO 2: lengkapi. Gunakan M_PI, bukan 3.14.   [SELESAI]
    public function luas(): float     { return M_PI * $this->jariJari ** 2; }
    public function keliling(): float { return 2 * M_PI * $this->jariJari; }

    public function getJariJari(): float { return $this->jariJari; }
}

class Persegi extends BangunDatar
{
    public function __construct(private readonly float $sisi)
    {
        parent::__construct('Persegi');
        // TODO 1: tolak sisi <= 0.   [SELESAI]
        if ($sisi <= 0) {
            throw new InvalidArgumentException("Sisi harus > 0, diterima: $sisi");
        }
    }

    // TODO 2: lengkapi.   [SELESAI]
    public function luas(): float     { return $this->sisi ** 2; }
    public function keliling(): float { return 4 * $this->sisi; }
}

// TODO Langkah 2: buat kelas Segitiga (tiga sisi, rumus Heron).
//                 Tolak konstruksi bila ketiga sisi tidak membentuk segitiga.   [SELESAI]
class Segitiga extends BangunDatar
{
    public function __construct(
        private readonly float $a,
        private readonly float $b,
        private readonly float $c,
    ) {
        parent::__construct('Segitiga');
        if ($a <= 0 || $b <= 0 || $c <= 0) {
            throw new InvalidArgumentException('Semua sisi harus > 0');
        }
        if ($a + $b <= $c || $a + $c <= $b || $b + $c <= $a) {
            throw new InvalidArgumentException("Sisi $a, $b, $c tidak membentuk segitiga");
        }
    }

    /** Rumus Heron. */
    public function luas(): float
    {
        $s = $this->keliling() / 2;
        return sqrt($s * ($s - $this->a) * ($s - $this->b) * ($s - $this->c));
    }

    public function keliling(): float { return $this->a + $this->b + $this->c; }
}

// TODO Langkah 4: buat kelas Trapesium.   [SELESAI]
class Trapesium extends BangunDatar
{
    public function __construct(
        private readonly float $sejajarA,
        private readonly float $sejajarB,
        private readonly float $tinggi,
        private readonly float $kakiC,
        private readonly float $kakiD,
    ) {
        parent::__construct('Trapesium');
        if ($sejajarA <= 0 || $sejajarB <= 0 || $tinggi <= 0 || $kakiC <= 0 || $kakiD <= 0) {
            throw new InvalidArgumentException('Semua ukuran harus > 0');
        }
        if ($kakiC < $tinggi || $kakiD < $tinggi) {
            throw new InvalidArgumentException('Kaki tidak boleh lebih pendek dari tinggi');
        }
    }

    public function luas(): float     { return ($this->sejajarA + $this->sejajarB) / 2 * $this->tinggi; }
    public function keliling(): float { return $this->sejajarA + $this->sejajarB + $this->kakiC + $this->kakiD; }
}