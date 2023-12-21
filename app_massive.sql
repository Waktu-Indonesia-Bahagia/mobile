-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: dbkoperasi
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `jenis_produk`
--

DROP TABLE IF EXISTS `jenis_produk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jenis_produk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jenis_produk`
--

LOCK TABLES `jenis_produk` WRITE;
/*!40000 ALTER TABLE `jenis_produk` DISABLE KEYS */;
INSERT INTO `jenis_produk` VALUES (1,'elektronik'),(2,'furniture'),(3,'makanan'),(4,'minuman'),(5,'komputer');
/*!40000 ALTER TABLE `jenis_produk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kartu`
--

DROP TABLE IF EXISTS `kartu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kartu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode` varchar(6) DEFAULT NULL,
  `nama` varchar(45) DEFAULT NULL,
  `diskon` double DEFAULT NULL,
  `iuran` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `kode_UNIQUE` (`kode`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kartu`
--

LOCK TABLES `kartu` WRITE;
/*!40000 ALTER TABLE `kartu` DISABLE KEYS */;
INSERT INTO `kartu` VALUES (1,'GOLD','Gold Utama',0.05,100000),(2,'PLAT','Platinum Jaya',0.1,150000),(3,'SLV','Silver',0.025,7000),(4,'NO','Non Member',0,0);
/*!40000 ALTER TABLE `kartu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `massages`
--

DROP TABLE IF EXISTS `massages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `massages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `massage` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `massages`
--

LOCK TABLES `massages` WRITE;
/*!40000 ALTER TABLE `massages` DISABLE KEYS */;
INSERT INTO `massages` VALUES (1,'Test MySQL Event 01','2022-05-28 23:55:49'),(2,'Test MySQL Event 2','2022-05-29 00:00:02');
/*!40000 ALTER TABLE `massages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelanggan`
--

DROP TABLE IF EXISTS `pelanggan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pelanggan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode` varchar(10) DEFAULT NULL,
  `nama` varchar(45) DEFAULT NULL,
  `jk` char(1) DEFAULT NULL,
  `tmp_lahir` varchar(30) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `kartu_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_email_pelanggan` (`email`),
  KEY `fk_pelanggan_kartu1_idx` (`kartu_id`),
  KEY `idx_nama_pelanggan` (`nama`),
  KEY `idx_tgllahir_pelanggan` (`tgl_lahir`),
  CONSTRAINT `fk_pelanggan_kartu1` FOREIGN KEY (`kartu_id`) REFERENCES `kartu` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelanggan`
--

LOCK TABLES `pelanggan` WRITE;
/*!40000 ALTER TABLE `pelanggan` DISABLE KEYS */;
INSERT INTO `pelanggan` VALUES (1,'C001','Agung Hapsah','L','Solo','2010-01-01','sedayu@gmail.com',1),(2,'C002','Maria utagaluh','P','Yogyakarta','1950-01-01','wangi@gmail.com',2),(3,'C003','Sekar Mirah','P','Kediri','1983-02-20','mirah@yahoo.com',1),(4,'C004','Swandaru Geni','L','Kediri','1981-01-04','swandaru@yahoo.com',4),(5,'C005','Pradabashu','L','Pati','1985-04-02','prada85@gmail.com',2),(6,'C006','Gayatri Dwi','P','Jakarta','1987-11-28','gaya87@gmail.com',1),(7,'C007','Dewi Gyat','P','Jakarta','1988-12-01','giyat@gmail.com',1),(8,'C008','Andre Haru','L','Surabaya','1990-07-15','andre.haru@gmail.com',4),(9,'C009','Ahmad Hasan','L','Surabaya','1992-10-15','ahasan@gmail.com',4),(10,'C010','Cassanndra','P','Belfast','1990-11-20','casa90@gmail.com',1);
/*!40000 ALTER TABLE `pelanggan` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER before_pelanggan_update
BEFORE UPDATE ON pelanggan
FOR EACH ROW
INSERT INTO pelanggan_audit set action='update', kodepelanggan= old.kode, nama=old.nama, changedate=now() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `pelanggan_audit`
--

DROP TABLE IF EXISTS `pelanggan_audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pelanggan_audit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kodepelanggan` varchar(10) NOT NULL,
  `nama` varchar(45) NOT NULL,
  `changedate` datetime DEFAULT NULL,
  `action` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelanggan_audit`
--

LOCK TABLES `pelanggan_audit` WRITE;
/*!40000 ALTER TABLE `pelanggan_audit` DISABLE KEYS */;
INSERT INTO `pelanggan_audit` VALUES (1,'C001','Agung Sedayu','2022-05-28 23:10:57','update'),(2,'C002','Pandan Wangi','2022-05-28 23:12:28','update');
/*!40000 ALTER TABLE `pelanggan_audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pembayaran`
--

DROP TABLE IF EXISTS `pembayaran`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pembayaran` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nokuitansi` varchar(10) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `jumlah` double DEFAULT NULL,
  `ke` int(11) DEFAULT NULL,
  `pesanan_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nokuitansi_UNIQUE` (`nokuitansi`),
  KEY `fk_pembayaran_pesanan1_idx` (`pesanan_id`),
  CONSTRAINT `fk_pembayaran_pesanan1` FOREIGN KEY (`pesanan_id`) REFERENCES `pesanan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pembayaran`
--

LOCK TABLES `pembayaran` WRITE;
/*!40000 ALTER TABLE `pembayaran` DISABLE KEYS */;
/*!40000 ALTER TABLE `pembayaran` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pembelian`
--

DROP TABLE IF EXISTS `pembelian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pembelian` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal` varchar(45) DEFAULT NULL,
  `nomor` varchar(10) DEFAULT NULL,
  `produk_id` int(11) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `harga` double DEFAULT NULL,
  `vendor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nomor_UNIQUE` (`nomor`),
  KEY `produk_id` (`produk_id`),
  KEY `vendor_id` (`vendor_id`),
  CONSTRAINT `pembelian_ibfk_1` FOREIGN KEY (`produk_id`) REFERENCES `produk` (`id`),
  CONSTRAINT `pembelian_ibfk_2` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pembelian`
--

LOCK TABLES `pembelian` WRITE;
/*!40000 ALTER TABLE `pembelian` DISABLE KEYS */;
INSERT INTO `pembelian` VALUES (1,'2019-10-10','P001',1,2,3500000,1),(2,'2019-11-20','P002',2,5,5500000,2),(3,'2019-12-12','P003',2,5,5400000,1),(4,'2020-01-20','P004',7,200,1800,3),(5,'2020-01-20','P005',5,100,2300,3),(6,'2022-05-28','P006',3,5,3500000,5);
/*!40000 ALTER TABLE `pembelian` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger after_pembelian_insert
after insert on pembelian
for each row
update produk set stok=stok+new.jumlah
where id =new.produk_id */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `pesanan`
--

DROP TABLE IF EXISTS `pesanan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pesanan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal` date DEFAULT NULL,
  `total` double DEFAULT NULL,
  `pelanggan_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pesanan_customer_idx` (`pelanggan_id`),
  CONSTRAINT `fk_pesanan_customer` FOREIGN KEY (`pelanggan_id`) REFERENCES `pelanggan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pesanan`
--

LOCK TABLES `pesanan` WRITE;
/*!40000 ALTER TABLE `pesanan` DISABLE KEYS */;
INSERT INTO `pesanan` VALUES (1,'2015-11-04',9720000,1),(2,'2015-11-04',17500,3),(3,'2015-11-04',0,6),(4,'2015-11-04',0,7),(5,'2015-11-04',0,10),(6,'2015-11-04',0,2),(7,'2015-11-04',0,5),(8,'2015-11-04',0,4),(9,'2015-11-04',0,8),(10,'2015-11-04',67000000,9),(11,'2022-05-28',1200000,3);
/*!40000 ALTER TABLE `pesanan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pesanan_items`
--

DROP TABLE IF EXISTS `pesanan_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pesanan_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `produk_id` int(11) NOT NULL,
  `pesanan_id` int(11) NOT NULL,
  `qty` int(11) DEFAULT NULL,
  `harga` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pesanan_items_pesanan1_idx` (`pesanan_id`),
  KEY `fk_pesanan_items_produk1_idx` (`produk_id`),
  CONSTRAINT `fk_pesanan_items_pesanan1` FOREIGN KEY (`pesanan_id`) REFERENCES `pesanan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pesanan_items_produk1` FOREIGN KEY (`produk_id`) REFERENCES `produk` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2147483648 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pesanan_items`
--

LOCK TABLES `pesanan_items` WRITE;
/*!40000 ALTER TABLE `pesanan_items` DISABLE KEYS */;
INSERT INTO `pesanan_items` VALUES (1,1,1,1,5040000),(2,3,1,1,4680000),(3,5,2,5,3500),(6,5,3,10,3500),(7,1,3,1,5040000),(9,5,5,10,3500),(10,5,6,20,3500),(11,4,11,2,600000),(12,1,10,2,3500000),(14,10,10,5,12000000);
/*!40000 ALTER TABLE `pesanan_items` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger after_pesanan_items_insert
after insert on pesanan_items
for each row
begin
declare total_harga double;
set total_harga = new.harga * new.qty;
update pesanan set total = total + total_harga
where id = new.pesanan_id;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER trig_kurangi_stok 
AFTER INSERT ON pesanan_items
FOR EACH ROW
BEGIN
CALL kurangi_stok(NEW.produk_id, NEW.qty);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `produk`
--

DROP TABLE IF EXISTS `produk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode` varchar(10) DEFAULT NULL,
  `nama` varchar(45) DEFAULT NULL,
  `harga_beli` double DEFAULT NULL,
  `harga_jual` double DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `min_stok` int(11) DEFAULT NULL,
  `jenis_produk_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `kode_UNIQUE` (`kode`),
  KEY `fk_produk_jenis_produk1_idx` (`jenis_produk_id`),
  CONSTRAINT `fk_produk_jenis_produk1` FOREIGN KEY (`jenis_produk_id`) REFERENCES `jenis_produk` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produk`
--

LOCK TABLES `produk` WRITE;
/*!40000 ALTER TABLE `produk` DISABLE KEYS */;
INSERT INTO `produk` VALUES (1,'TV01','Televisi 21 inch',3500000,7257600,15,2,1),(2,'TV02','Televisi 40 inch',5500000,10713600,4,2,1),(3,'K001','Kulkas 2 pintu',3500000,6739200,11,2,1),(4,'M001','Meja Makan',500000,600000,4,3,2),(5,'TK01','Teh Kotak',3000,3500,6,10,4),(6,'PC01','PC Desktop HP',7000000,9600000,9,2,5),(7,'TB01','Teh Botol',2000,2500,33,10,4),(8,'AC01','Notebook Acer',8000000,10800000,7,2,5),(9,'LN01','Notebook Lenovo',9000000,12000000,9,2,5),(10,'L004','Laptop HP',12000000,13000000,5,5,5),(11,'LN03','Laptop Asus',10000000,12000000,45,30,5),(12,'MC01','Mesin Cuci',5000000,6000000,25,12,1),(13,'W001','Wafer Nabati',1500,2000,70,40,3);
/*!40000 ALTER TABLE `produk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomor` varchar(4) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `kota` varchar(30) DEFAULT NULL,
  `kontak` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nomor` (`nomor`),
  UNIQUE KEY `idx_data_vendor` (`nama`,`kota`,`kontak`),
  KEY `idx_namavendor` (`nama`(10))
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
INSERT INTO `vendor` VALUES (1,'V001','PT Guna Samudra','Surabaya','Ali Nurdin'),(2,'V002','PT Pondok C9','Depok','Putri Ramadhani'),(3,'V003','CV Jaya Raya Semesta','Jakarta','Dwi Rahayu'),(4,'V004','PT Lekulo X','Kebumen','Mbambang G'),(5,'V005','PT IT Prima','Jakarta','David W');
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-21 22:28:17
