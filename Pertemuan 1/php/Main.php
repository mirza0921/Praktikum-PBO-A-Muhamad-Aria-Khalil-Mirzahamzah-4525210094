<?php

require_once 'LaptopAsus.php';

$laptop = new LaptopAsus("ROG Strix G16", "ASUS 2024-001", 16);

echo "=== Info Awal ===/n";
$laptop->getinfo();

echo "/n=== Operasi tidak Sah: Nyalakan lalu pakai Baterai ===/n";
$laptop->nyalakan();

$laptop->pakaiBaterai(30);
$laptop->getinfo();

echo "/n=== Operasi tidak Sah 1: Cas melebihi 100 ===/n";
$laptop->cashBaterai(200);
$laptop->getinfo(); // tetap maksimal 100

echo "/n=== Operasi tidak Sah 2: Nyalakan saat Baterai Habis ===/n";
$laptop->pakaiBaterai(100); // baterai jadi0, otomatis mati
$laptop->nyalakan();
$laptop->getinfo();