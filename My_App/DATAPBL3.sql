-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pbl3
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `abclient`
--

DROP TABLE IF EXISTS `abclient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abclient` (
  `ClientID` int NOT NULL AUTO_INCREMENT,
  `ClientUseName` varchar(255) DEFAULT NULL,
  `ClientPassword` varchar(255) DEFAULT NULL,
  `ClientFullName` varchar(255) DEFAULT NULL,
  `ClientPhoneNumber` varchar(255) DEFAULT NULL,
  `ClientEmailAdress` varchar(255) DEFAULT NULL,
  `ClientAdress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ClientID`),
  UNIQUE KEY `ClientUseName` (`ClientUseName`),
  UNIQUE KEY `ClientPhoneNumber` (`ClientPhoneNumber`),
  UNIQUE KEY `ClientEmailAdress` (`ClientEmailAdress`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abclient`
--

LOCK TABLES `abclient` WRITE;
/*!40000 ALTER TABLE `abclient` DISABLE KEYS */;
INSERT INTO `abclient` VALUES (1,'hoanganh','123456','Hoàng Anh','0987654321','hoanganh@gmail.com','Hà Nội');
/*!40000 ALTER TABLE `abclient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `abversion`
--

DROP TABLE IF EXISTS `abversion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abversion` (
  `VersionID` int NOT NULL AUTO_INCREMENT,
  `BrandID` int DEFAULT NULL,
  `VersionName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`VersionID`),
  KEY `BrandID` (`BrandID`),
  CONSTRAINT `abversion_ibfk_1` FOREIGN KEY (`BrandID`) REFERENCES `brand` (`BrandID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abversion`
--

LOCK TABLES `abversion` WRITE;
/*!40000 ALTER TABLE `abversion` DISABLE KEYS */;
INSERT INTO `abversion` VALUES (1,1,'Macbook Pro M1 2021');
/*!40000 ALTER TABLE `abversion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `BrandID` int NOT NULL AUTO_INCREMENT,
  `BrandName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`BrandID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'Apple');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `color` (
  `ColorID` int NOT NULL AUTO_INCREMENT,
  `ColorName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ColorID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES (1,'Silver');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `configuration`
--

DROP TABLE IF EXISTS `configuration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `configuration` (
  `ConfigurationID` int NOT NULL AUTO_INCREMENT,
  `HardDrive` enum('SSD','HDD') DEFAULT NULL,
  `GBMemoryID` int DEFAULT NULL,
  `Inchs` double DEFAULT NULL,
  PRIMARY KEY (`ConfigurationID`),
  KEY `GBMemoryID` (`GBMemoryID`),
  CONSTRAINT `configuration_ibfk_1` FOREIGN KEY (`GBMemoryID`) REFERENCES `gbmemory` (`GBMemoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuration`
--

LOCK TABLES `configuration` WRITE;
/*!40000 ALTER TABLE `configuration` DISABLE KEYS */;
INSERT INTO `configuration` VALUES (1,'SSD',1,15.6);
/*!40000 ALTER TABLE `configuration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descripted`
--

DROP TABLE IF EXISTS `descripted`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `descripted` (
  `DescriptionID` int NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(255) DEFAULT NULL,
  `Price` int DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `WarrantyPeriod` int DEFAULT NULL,
  `Descripted` text,
  `ProductItemID` int DEFAULT NULL,
  PRIMARY KEY (`DescriptionID`),
  KEY `ProductItemID` (`ProductItemID`),
  CONSTRAINT `descripted_ibfk_1` FOREIGN KEY (`ProductItemID`) REFERENCES `productitem` (`ProductItemID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descripted`
--

LOCK TABLES `descripted` WRITE;
/*!40000 ALTER TABLE `descripted` DISABLE KEYS */;
INSERT INTO `descripted` VALUES (1,'Macbook Pro M1',25000000,'Hà Nội',12,'Máy còn mới 98%, pin tốt',1);
/*!40000 ALTER TABLE `descripted` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `FeedBackID` int NOT NULL AUTO_INCREMENT,
  `ClientID` int DEFAULT NULL,
  `Rate` int DEFAULT NULL,
  `ClientComment` text,
  PRIMARY KEY (`FeedBackID`),
  KEY `ClientID` (`ClientID`),
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`ClientID`) REFERENCES `abclient` (`ClientID`),
  CONSTRAINT `feedback_chk_1` CHECK ((`Rate` between 1 and 5))
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,1,5,'Dịch vụ tốt, giao dịch nhanh chóng');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gbmemory`
--

DROP TABLE IF EXISTS `gbmemory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gbmemory` (
  `GBMemoryID` int NOT NULL AUTO_INCREMENT,
  `Ram` int DEFAULT NULL,
  `Rom` int DEFAULT NULL,
  `InternalMemory` int DEFAULT NULL,
  PRIMARY KEY (`GBMemoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gbmemory`
--

LOCK TABLES `gbmemory` WRITE;
/*!40000 ALTER TABLE `gbmemory` DISABLE KEYS */;
INSERT INTO `gbmemory` VALUES (1,8,128,128);
/*!40000 ALTER TABLE `gbmemory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productcategory`
--

DROP TABLE IF EXISTS `productcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productcategory` (
  `CategoryID` int NOT NULL AUTO_INCREMENT,
  `ProductCategoryName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CategoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productcategory`
--

LOCK TABLES `productcategory` WRITE;
/*!40000 ALTER TABLE `productcategory` DISABLE KEYS */;
INSERT INTO `productcategory` VALUES (1,'Laptop');
/*!40000 ALTER TABLE `productcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productcategoryclient`
--

DROP TABLE IF EXISTS `productcategoryclient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productcategoryclient` (
  `CategoryID` int NOT NULL,
  `ClientID` int NOT NULL,
  PRIMARY KEY (`CategoryID`,`ClientID`),
  KEY `ClientID` (`ClientID`),
  CONSTRAINT `productcategoryclient_ibfk_1` FOREIGN KEY (`CategoryID`) REFERENCES `productcategory` (`CategoryID`),
  CONSTRAINT `productcategoryclient_ibfk_2` FOREIGN KEY (`ClientID`) REFERENCES `abclient` (`ClientID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productcategoryclient`
--

LOCK TABLES `productcategoryclient` WRITE;
/*!40000 ALTER TABLE `productcategoryclient` DISABLE KEYS */;
INSERT INTO `productcategoryclient` VALUES (1,1);
/*!40000 ALTER TABLE `productcategoryclient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productitem`
--

DROP TABLE IF EXISTS `productitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productitem` (
  `ProductItemID` int NOT NULL AUTO_INCREMENT,
  `ColorID` int DEFAULT NULL,
  `ConfigurationID` int DEFAULT NULL,
  `BrandID` int DEFAULT NULL,
  `TariffiPackageID` int DEFAULT NULL,
  `SellCategoryID` int DEFAULT NULL,
  `ProductRole` enum('Seller','Buyer') DEFAULT NULL,
  PRIMARY KEY (`ProductItemID`),
  KEY `ColorID` (`ColorID`),
  KEY `ConfigurationID` (`ConfigurationID`),
  KEY `BrandID` (`BrandID`),
  KEY `TariffiPackageID` (`TariffiPackageID`),
  KEY `SellCategoryID` (`SellCategoryID`),
  CONSTRAINT `productitem_ibfk_1` FOREIGN KEY (`ColorID`) REFERENCES `color` (`ColorID`),
  CONSTRAINT `productitem_ibfk_2` FOREIGN KEY (`ConfigurationID`) REFERENCES `configuration` (`ConfigurationID`),
  CONSTRAINT `productitem_ibfk_3` FOREIGN KEY (`BrandID`) REFERENCES `brand` (`BrandID`),
  CONSTRAINT `productitem_ibfk_4` FOREIGN KEY (`TariffiPackageID`) REFERENCES `tariffipackage` (`TariffiPackageID`),
  CONSTRAINT `productitem_ibfk_5` FOREIGN KEY (`SellCategoryID`) REFERENCES `sellcategory` (`SellCategoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productitem`
--

LOCK TABLES `productitem` WRITE;
/*!40000 ALTER TABLE `productitem` DISABLE KEYS */;
INSERT INTO `productitem` VALUES (1,1,1,1,1,1,'Seller');
/*!40000 ALTER TABLE `productitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productitemcategory`
--

DROP TABLE IF EXISTS `productitemcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productitemcategory` (
  `CategoryID` int NOT NULL,
  `ProductItemID` int NOT NULL,
  PRIMARY KEY (`CategoryID`,`ProductItemID`),
  KEY `ProductItemID` (`ProductItemID`),
  CONSTRAINT `productitemcategory_ibfk_1` FOREIGN KEY (`CategoryID`) REFERENCES `productcategory` (`CategoryID`),
  CONSTRAINT `productitemcategory_ibfk_2` FOREIGN KEY (`ProductItemID`) REFERENCES `productitem` (`ProductItemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productitemcategory`
--

LOCK TABLES `productitemcategory` WRITE;
/*!40000 ALTER TABLE `productitemcategory` DISABLE KEYS */;
INSERT INTO `productitemcategory` VALUES (1,1);
/*!40000 ALTER TABLE `productitemcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sellcategory`
--

DROP TABLE IF EXISTS `sellcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sellcategory` (
  `SellCategoryID` int NOT NULL AUTO_INCREMENT,
  `ClientID` int DEFAULT NULL,
  PRIMARY KEY (`SellCategoryID`),
  KEY `ClientID` (`ClientID`),
  CONSTRAINT `sellcategory_ibfk_1` FOREIGN KEY (`ClientID`) REFERENCES `abclient` (`ClientID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sellcategory`
--

LOCK TABLES `sellcategory` WRITE;
/*!40000 ALTER TABLE `sellcategory` DISABLE KEYS */;
INSERT INTO `sellcategory` VALUES (1,1);
/*!40000 ALTER TABLE `sellcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tariffipackage`
--

DROP TABLE IF EXISTS `tariffipackage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tariffipackage` (
  `TariffiPackageID` int NOT NULL AUTO_INCREMENT,
  `PackageName` varchar(255) DEFAULT NULL,
  `Price` int DEFAULT NULL,
  PRIMARY KEY (`TariffiPackageID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tariffipackage`
--

LOCK TABLES `tariffipackage` WRITE;
/*!40000 ALTER TABLE `tariffipackage` DISABLE KEYS */;
INSERT INTO `tariffipackage` VALUES (1,'Gói đẩy tin 3 ngày',30000);
/*!40000 ALTER TABLE `tariffipackage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactionlist`
--

DROP TABLE IF EXISTS `transactionlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactionlist` (
  `TransactionID` int NOT NULL AUTO_INCREMENT,
  `ClientID` int DEFAULT NULL,
  `TransactionDay` datetime DEFAULT CURRENT_TIMESTAMP,
  `TransactionType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`TransactionID`),
  KEY `ClientID` (`ClientID`),
  CONSTRAINT `transactionlist_ibfk_1` FOREIGN KEY (`ClientID`) REFERENCES `abclient` (`ClientID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactionlist`
--

LOCK TABLES `transactionlist` WRITE;
/*!40000 ALTER TABLE `transactionlist` DISABLE KEYS */;
INSERT INTO `transactionlist` VALUES (1,1,'2025-04-15 20:30:41','Mua gói đẩy tin');
/*!40000 ALTER TABLE `transactionlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactionpackage`
--

DROP TABLE IF EXISTS `transactionpackage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactionpackage` (
  `TransactionID` int NOT NULL,
  `TariffiPackageID` int NOT NULL,
  PRIMARY KEY (`TransactionID`,`TariffiPackageID`),
  KEY `TariffiPackageID` (`TariffiPackageID`),
  CONSTRAINT `transactionpackage_ibfk_1` FOREIGN KEY (`TransactionID`) REFERENCES `transactionlist` (`TransactionID`),
  CONSTRAINT `transactionpackage_ibfk_2` FOREIGN KEY (`TariffiPackageID`) REFERENCES `tariffipackage` (`TariffiPackageID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactionpackage`
--

LOCK TABLES `transactionpackage` WRITE;
/*!40000 ALTER TABLE `transactionpackage` DISABLE KEYS */;
INSERT INTO `transactionpackage` VALUES (1,1);
/*!40000 ALTER TABLE `transactionpackage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlistcategory`
--

DROP TABLE IF EXISTS `wishlistcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlistcategory` (
  `WishListID` int NOT NULL AUTO_INCREMENT,
  `ClientID` int DEFAULT NULL,
  PRIMARY KEY (`WishListID`),
  KEY `ClientID` (`ClientID`),
  CONSTRAINT `wishlistcategory_ibfk_1` FOREIGN KEY (`ClientID`) REFERENCES `abclient` (`ClientID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlistcategory`
--

LOCK TABLES `wishlistcategory` WRITE;
/*!40000 ALTER TABLE `wishlistcategory` DISABLE KEYS */;
INSERT INTO `wishlistcategory` VALUES (1,1);
/*!40000 ALTER TABLE `wishlistcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlistproduct`
--

DROP TABLE IF EXISTS `wishlistproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlistproduct` (
  `WishListID` int NOT NULL,
  `ProductItemID` int NOT NULL,
  PRIMARY KEY (`WishListID`,`ProductItemID`),
  KEY `ProductItemID` (`ProductItemID`),
  CONSTRAINT `wishlistproduct_ibfk_1` FOREIGN KEY (`WishListID`) REFERENCES `wishlistcategory` (`WishListID`),
  CONSTRAINT `wishlistproduct_ibfk_2` FOREIGN KEY (`ProductItemID`) REFERENCES `productitem` (`ProductItemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlistproduct`
--

LOCK TABLES `wishlistproduct` WRITE;
/*!40000 ALTER TABLE `wishlistproduct` DISABLE KEYS */;
INSERT INTO `wishlistproduct` VALUES (1,1);
/*!40000 ALTER TABLE `wishlistproduct` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-15 20:35:16
