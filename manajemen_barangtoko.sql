-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 04 Jan 2025 pada 08.19
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `manajemen_barangtoko`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `akses`
--

CREATE TABLE `akses` (
  `id_akses` int(11) NOT NULL,
  `panelpengguna` tinyint(1) DEFAULT NULL,
  `daftaritem` tinyint(1) DEFAULT NULL,
  `suplier` tinyint(1) DEFAULT NULL,
  `pelanggan` tinyint(1) DEFAULT NULL,
  `sales` tinyint(1) DEFAULT NULL,
  `settingkas` tinyint(1) DEFAULT NULL,
  `panelpembelian` tinyint(1) DEFAULT NULL,
  `panelpenjualan` tinyint(1) DEFAULT NULL,
  `panellaporan` tinyint(1) DEFAULT NULL,
  `panelpemeliharaandata` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `akses`
--

INSERT INTO `akses` (`id_akses`, `panelpengguna`, `daftaritem`, `suplier`, `pelanggan`, `sales`, `settingkas`, `panelpembelian`, `panelpenjualan`, `panellaporan`, `panelpemeliharaandata`) VALUES
(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(2, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0),
(3, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `detailuser`
--

CREATE TABLE `detailuser` (
  `nomor_pegawai` varchar(15) NOT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `nomor_telpon` varchar(15) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `posisibekerja` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `detailuser`
--

INSERT INTO `detailuser` (`nomor_pegawai`, `nama`, `nomor_telpon`, `alamat`, `posisibekerja`) VALUES
('ADMIN01', 'David Jo', '087810331584', 'Komp.Banjar Indah Permai Jl.Kayu kuku no 88', 'Pemilik'),
('KASIR01', 'udin', '082638491234', 'jl. trikora', 'kasir'),
('SALES01', 'budi', '087912345678', 'jl. dharmapraja', 'sales');

-- --------------------------------------------------------

--
-- Struktur dari tabel `item`
--

CREATE TABLE `item` (
  `kodeItem` int(11) NOT NULL,
  `kodeBarcode` varchar(50) DEFAULT NULL,
  `namaItem` varchar(100) DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `jenis` varchar(50) DEFAULT NULL,
  `satuan` varchar(20) DEFAULT NULL,
  `hargapokok` decimal(10,2) DEFAULT NULL,
  `hargajual` decimal(10,2) DEFAULT NULL,
  `tipeitem` varchar(50) DEFAULT NULL,
  `keterangan` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `item`
--

INSERT INTO `item` (`kodeItem`, `kodeBarcode`, `namaItem`, `stok`, `jenis`, `satuan`, `hargapokok`, `hargajual`, `tipeitem`, `keterangan`) VALUES
(1001, 'qwertya23-22', 'indomie', 107, 'barang', 'pcs', 3800.00, 3800.00, 'mie instan', 'indomie goreng biasa dan jumbo'),
(1002, 'aafha-2937sb', 'mie sedap', 14, 'barang', 'pcs', 4000.00, 4000.00, 'mie instant', 'mie kuah'),
(1003, 'ab93-afeb7', 'chitato', 25, 'barang', 'pcs', 8000.00, 8000.00, 'snack', '-'),
(1004, 'fba-37ga', 'pepsodent', 30, 'barang', 'pcs', 12000.00, 12000.00, 'odol', 'rasa cool lime');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `idPelanggan` int(11) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `kota` varchar(50) DEFAULT NULL,
  `provinsi` varchar(50) DEFAULT NULL,
  `nomortelpon` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`idPelanggan`, `nama`, `alamat`, `kota`, `provinsi`, `nomortelpon`) VALUES
(1, 'Eko', 'banjarmasin jl ahmad yani km sekian', 'Banjarmasin', 'Kalimantan Selatan', '081234567890'),
(2, 'Eli', 'bjm jl veteran', 'Banjarmasin', 'Kalimantan Selatan', '080987654321'),
(3, 'Robert', 'handil bakti', 'Banjarmasin', 'Kalimantan Selatan', '081122334455');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengguna`
--

CREATE TABLE `pengguna` (
  `username` varchar(50) NOT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `nomor_pegawai` varchar(10) DEFAULT NULL,
  `detail_akses` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pengguna`
--

INSERT INTO `pengguna` (`username`, `pass`, `nomor_pegawai`, `detail_akses`) VALUES
('admin', 'administrator', 'ADMIN01', 1),
('creativeguy', 'rajinkerja', 'KASIR01', 2),
('sales', 'cuan', 'SALES01', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesananpembelian`
--

CREATE TABLE `pesananpembelian` (
  `idPesanan` int(11) NOT NULL,
  `kodeItem` int(11) DEFAULT NULL,
  `idSuplier` int(11) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `harga` decimal(10,2) DEFAULT NULL,
  `tanggalpesan` date DEFAULT NULL,
  `status_pemebelian` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pesananpembelian`
--

INSERT INTO `pesananpembelian` (`idPesanan`, `kodeItem`, `idSuplier`, `jumlah`, `harga`, `tanggalpesan`, `status_pemebelian`) VALUES
(1, 1001, 1, 13, 49400.00, '2023-12-25', 'Lunas'),
(2, 1002, 2, 2, 8000.00, '2023-12-27', 'Lunas'),
(3, 1003, 2, 5, 40000.00, '2023-12-27', 'Lunas'),
(4, 1001, 3, 2, 7600.00, '2023-12-28', 'Lunas'),
(5, 1004, 2, 7, 84000.00, '2023-12-28', 'Lunas'),
(6, 1001, 1, 20, 76000.00, '2023-12-28', 'Belum');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesananpenjualan`
--

CREATE TABLE `pesananpenjualan` (
  `idPesananPenjualan` int(11) NOT NULL,
  `idPelanggan` int(11) DEFAULT NULL,
  `kodeItem` int(11) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `harga` decimal(10,2) DEFAULT NULL,
  `tanggalPesan` date DEFAULT NULL,
  `status_pesanan` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pesananpenjualan`
--

INSERT INTO `pesananpenjualan` (`idPesananPenjualan`, `idPelanggan`, `kodeItem`, `jumlah`, `harga`, `tanggalPesan`, `status_pesanan`) VALUES
(1, 1, 1001, 25, 95000.00, '2023-12-25', 'Lunas'),
(2, 3, 1002, 3, 12000.00, '2023-12-26', 'Lunas'),
(3, 2, 1003, 12, 96000.00, '2023-12-28', 'Belum');

-- --------------------------------------------------------

--
-- Struktur dari tabel `sales`
--

CREATE TABLE `sales` (
  `idSales` int(11) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `nomortelpon` varchar(15) DEFAULT NULL,
  `gaji` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `suplier`
--

CREATE TABLE `suplier` (
  `idSuplier` int(11) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `kota` varchar(50) DEFAULT NULL,
  `provinsi` varchar(50) DEFAULT NULL,
  `nomortelpon` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `suplier`
--

INSERT INTO `suplier` (`idSuplier`, `nama`, `alamat`, `kota`, `provinsi`, `nomortelpon`) VALUES
(1, 'cv. iqromayu', 'lab ilkom 3 ulm', 'banjarbaru', 'kalimantan selatan', '081283411990'),
(2, 'cv. ekspedisi', 'jl dharmapraja', 'banjarmasin', 'kalimantan selatan', '081234566543'),
(3, 'indofood', 'jl ahmad yani km 8', 'banjarmasin', 'kalimantan selatan', '081234563731');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksipembelian`
--

CREATE TABLE `transaksipembelian` (
  `idTransaksi` int(11) NOT NULL,
  `idPesanan` int(11) DEFAULT NULL,
  `tanggaltransaksi` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksipembelian`
--

INSERT INTO `transaksipembelian` (`idTransaksi`, `idPesanan`, `tanggaltransaksi`) VALUES
(1, 1, '2023-12-25'),
(2, 2, '2023-12-27'),
(3, 4, '2023-12-28'),
(4, 3, '2023-12-28'),
(5, 5, '2023-12-28');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksipenjualan`
--

CREATE TABLE `transaksipenjualan` (
  `idTransaksiPenjualan` int(11) NOT NULL,
  `idPesananPenjualan` int(11) DEFAULT NULL,
  `tanggalTransaksi` date DEFAULT NULL,
  `totalBayar` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksipenjualan`
--

INSERT INTO `transaksipenjualan` (`idTransaksiPenjualan`, `idPesananPenjualan`, `tanggalTransaksi`, `totalBayar`) VALUES
(1, 1, '2023-12-26', 95000.00),
(2, 2, '2023-12-28', 12000.00);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `akses`
--
ALTER TABLE `akses`
  ADD PRIMARY KEY (`id_akses`);

--
-- Indeks untuk tabel `detailuser`
--
ALTER TABLE `detailuser`
  ADD PRIMARY KEY (`nomor_pegawai`);

--
-- Indeks untuk tabel `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`kodeItem`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`idPelanggan`);

--
-- Indeks untuk tabel `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`username`),
  ADD KEY `nomor_pegawai` (`nomor_pegawai`),
  ADD KEY `detail_akses` (`detail_akses`);

--
-- Indeks untuk tabel `pesananpembelian`
--
ALTER TABLE `pesananpembelian`
  ADD PRIMARY KEY (`idPesanan`),
  ADD KEY `kodeItem` (`kodeItem`),
  ADD KEY `idSuplier` (`idSuplier`);

--
-- Indeks untuk tabel `pesananpenjualan`
--
ALTER TABLE `pesananpenjualan`
  ADD PRIMARY KEY (`idPesananPenjualan`),
  ADD KEY `idPelanggan` (`idPelanggan`),
  ADD KEY `kodeItem` (`kodeItem`);

--
-- Indeks untuk tabel `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`idSales`);

--
-- Indeks untuk tabel `suplier`
--
ALTER TABLE `suplier`
  ADD PRIMARY KEY (`idSuplier`);

--
-- Indeks untuk tabel `transaksipembelian`
--
ALTER TABLE `transaksipembelian`
  ADD PRIMARY KEY (`idTransaksi`),
  ADD KEY `idPesanan` (`idPesanan`);

--
-- Indeks untuk tabel `transaksipenjualan`
--
ALTER TABLE `transaksipenjualan`
  ADD PRIMARY KEY (`idTransaksiPenjualan`),
  ADD KEY `idPesananPenjualan` (`idPesananPenjualan`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `akses`
--
ALTER TABLE `akses`
  MODIFY `id_akses` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `pengguna`
--
ALTER TABLE `pengguna`
  ADD CONSTRAINT `pengguna_ibfk_1` FOREIGN KEY (`nomor_pegawai`) REFERENCES `detailuser` (`nomor_pegawai`),
  ADD CONSTRAINT `pengguna_ibfk_2` FOREIGN KEY (`detail_akses`) REFERENCES `akses` (`id_akses`);

--
-- Ketidakleluasaan untuk tabel `pesananpembelian`
--
ALTER TABLE `pesananpembelian`
  ADD CONSTRAINT `pesananpembelian_ibfk_1` FOREIGN KEY (`kodeItem`) REFERENCES `item` (`kodeItem`),
  ADD CONSTRAINT `pesananpembelian_ibfk_2` FOREIGN KEY (`idSuplier`) REFERENCES `suplier` (`idSuplier`);

--
-- Ketidakleluasaan untuk tabel `pesananpenjualan`
--
ALTER TABLE `pesananpenjualan`
  ADD CONSTRAINT `pesananpenjualan_ibfk_1` FOREIGN KEY (`idPelanggan`) REFERENCES `pelanggan` (`idPelanggan`),
  ADD CONSTRAINT `pesananpenjualan_ibfk_2` FOREIGN KEY (`kodeItem`) REFERENCES `item` (`kodeItem`);

--
-- Ketidakleluasaan untuk tabel `transaksipembelian`
--
ALTER TABLE `transaksipembelian`
  ADD CONSTRAINT `transaksipembelian_ibfk_1` FOREIGN KEY (`idPesanan`) REFERENCES `pesananpembelian` (`idPesanan`);

--
-- Ketidakleluasaan untuk tabel `transaksipenjualan`
--
ALTER TABLE `transaksipenjualan`
  ADD CONSTRAINT `transaksipenjualan_ibfk_1` FOREIGN KEY (`idPesananPenjualan`) REFERENCES `pesananpenjualan` (`idPesananPenjualan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
