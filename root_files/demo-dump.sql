-- MySQL dump 10.13  Distrib 5.7.30, for osx10.12 (x86_64)
--
-- Host: 151.177.147.211    Database: demo
-- ------------------------------------------------------
-- Server version	5.7.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('dab06b40-9d5f-454d-86d4-2d9ab6bbf4ea','c592df4a86933b92addc9842402ddf198c638ea9be58916ee6e3734e1e3152f8','User','BasicUser'),('c5afbd9e-1010-4995-a489-7f419e1d8bd1','93915a0a4bf8f634cb1856494dd4304472ad46b9827f541f76b6761c49cc55b0','Admin','Admin'),('675c6dc3-ad44-4a31-9842-9db4fdbd3667','17b33d80470fb3fff29eb048d6bcce03ba14e305c4851baf39ac3d37a183c419','User','BosseBil');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attribute`
--

DROP TABLE IF EXISTS `attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attribute_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attribute`
--

LOCK TABLES `attribute` WRITE;
/*!40000 ALTER TABLE `attribute` DISABLE KEYS */;
INSERT INTO `attribute` VALUES (1,'Color'),(2,'Size'),(3,'Condition'),(0,'None');
/*!40000 ALTER TABLE `attribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attribute_option`
--

DROP TABLE IF EXISTS `attribute_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attribute_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attribute_option_name` varchar(255) DEFAULT NULL,
  `attribute` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKau3wlkygar2s0fn4s9cku3e1k` (`attribute`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attribute_option`
--

LOCK TABLES `attribute_option` WRITE;
/*!40000 ALTER TABLE `attribute_option` DISABLE KEYS */;
INSERT INTO `attribute_option` VALUES (1,'Red',1),(2,'Green',1),(3,'White',1),(4,'Black',1),(5,'Blue',1),(6,'Pink',1),(7,'Yellow',1),(8,'New',3),(9,'Used, good condition',3),(10,'Used, ok condition',3),(11,'Used, bad condition',3),(12,'XS',2),(13,'S',2),(14,'M',2),(15,'L',2),(16,'XL',2),(17,'XXL',2),(18,'Purple',1),(0,'None',0);
/*!40000 ALTER TABLE `attribute_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(32) DEFAULT NULL,
  `brand_logo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'Roblox','roblox.png'),(2,'Marvel','marvel.png'),(3,'DC Comics','dccomics.png'),(4,'PlayStation','playstation.png'),(5,'Stranger Things','strangerthing.png'),(6,'Star Trek','startrek.png'),(7,'Star Wars','starwars.png'),(8,'Pokémon','pokemon.png'),(9,'Xbox','xbox.png'),(10,'Fortnite','fortnite.png'),(11,'Game of Thrones','gameofthrones.png');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(32) DEFAULT NULL,
  `parent_category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Toys',0),(2,'Clothing & Accessories',0),(3,'Reading',0),(4,'Cards & Games',0),(5,'Home & Stationary',0),(6,'Action Figures',1),(7,'Dolls',1),(8,'Blind Bags & Boxes',1),(9,'Kids Clothes',2),(10,'Mens Clothes',2),(11,'Ladies Clothes',2),(12,'Bags',2),(13,'Accessories',2),(14,'Books',3),(15,'Comics',3),(16,'Graphic Novels',3),(17,'Board Games',4),(18,'Trading Cards',4),(19,'Role Play Games',4),(20,'Home & Lifestyle',5),(21,'Stationary & Office',5),(22,'Video games',4);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(50) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `postal` varchar(10) DEFAULT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn9x2k8svpxj3r328iy1rpur83` (`account_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Test Street 1','New York','thegeeksqueek@gmail.com','Basic','User','1-800-555-123456','100 90','dab06b40-9d5f-454d-86d4-2d9ab6bbf4ea'),(3,'verkstadsvägen 1','porsche','bildoktorn@fixar.com','Bosse','Bildoktorn','0731121122','911 11','675c6dc3-ad44-4a31-9842-9db4fdbd3667'),(4,'Unke','Unke','admin@unke.se','Admin','Kalle','123456789','123 45','c5afbd9e-1010-4995-a489-7f419e1d8bd1');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frontpage_banner`
--

DROP TABLE IF EXISTS `frontpage_banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `frontpage_banner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `banner_title` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `target_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frontpage_banner`
--

LOCK TABLES `frontpage_banner` WRITE;
/*!40000 ALTER TABLE `frontpage_banner` DISABLE KEYS */;
/*!40000 ALTER TABLE `frontpage_banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frontpage_slide`
--

DROP TABLE IF EXISTS `frontpage_slide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `frontpage_slide` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) DEFAULT NULL,
  `slide_content` varchar(255) DEFAULT NULL,
  `slide_order` int(11) DEFAULT NULL,
  `slide_title` varchar(255) DEFAULT NULL,
  `target_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frontpage_slide`
--

LOCK TABLES `frontpage_slide` WRITE;
/*!40000 ALTER TABLE `frontpage_slide` DISABLE KEYS */;
/*!40000 ALTER TABLE `frontpage_slide` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hashtag`
--

DROP TABLE IF EXISTS `hashtag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hashtag` (
  `hashtag` varchar(100) NOT NULL,
  PRIMARY KEY (`hashtag`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hashtag`
--

LOCK TABLES `hashtag` WRITE;
/*!40000 ALTER TABLE `hashtag` DISABLE KEYS */;
/*!40000 ALTER TABLE `hashtag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (10);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `full_desc` longtext,
  `product_name` varchar(32) NOT NULL,
  `product_price` double DEFAULT NULL,
  `short_desc` varchar(128) DEFAULT NULL,
  `catid` bigint(20) NOT NULL,
  `is_featured` tinyint(1) DEFAULT '0',
  `has_image` tinyint(1) DEFAULT '0',
  `brand_id` bigint(20) DEFAULT NULL,
  `vat_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs6cydsualtsrprvlf2bb3lcam` (`brand_id`),
  KEY `FKq6hhjex8p6noh29xumcr247oc` (`catid`),
  KEY `FKj7prsct7jf0yweq69tdnxqgnw` (`vat_id`)
) ENGINE=MyISAM AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'(W) Kelly Sue DeConnick (A/CA) Robson Rocha, Daniel Henriques','Aquaman No.40',2.99,'Aquaman Comics',15,0,0,3,1),(2,'(W) Kelly Sue DeConnick (A/CA) Robson Rocha, Daniel Henriques','Aquaman No.41',2.99,'Aquaman Comics',15,1,1,3,1),(3,'(W) Kelly Sue DeConnick (A/CA) Robson Rocha, Daniel Henriques','Aquaman No.42',2.99,'Aquaman Comics',15,0,0,3,1),(4,'(W) Kelly Sue DeConnick (A/CA) Robson Rocha, Daniel Henriques','Aquaman No.43',2.99,'Aquaman Comics',15,1,1,3,1),(5,'(W) Kelly Sue DeConnick (A/CA) Robson Rocha, Daniel Henriques','Aquaman No.44',2.99,'Aquaman Comics',15,0,0,3,1),(6,'(W) Kelly Sue DeConnick (A/CA) Robson Rocha, Daniel Henriques','Aquaman No.45',2.99,'Aquaman Comics',15,0,1,3,1),(7,'(W) Kelly Sue DeConnick (A/CA) Robson Rocha, Daniel Henriques','Aquaman No.46',2.99,'Aquaman Comics',15,1,1,3,1),(12,'Pokemon Pika Pop T-shirt','Pokemon T-shirt',24.99,'Pokemon T-shirt',10,1,1,8,1),(20,'Star Wars T-shirt with Yoda motive','Yoda t-shirt',25.99,'Star Wars t-shirt',10,0,1,7,1),(33,'Star Wars T-shirt with Darth Vader motive','Darth Vader t-shirt',24.99,'Star Wars t-shirt',10,0,1,7,1),(40,'Dominus Dudes is a 4 pieces set of popular Roblox action figures.','Dominus Dudes',24.99,'Set with 4 Roblox figures',8,0,1,1,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_rating`
--

DROP TABLE IF EXISTS `product_rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_rating` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rating` int(11) DEFAULT NULL,
  `ratingmessage` longtext,
  `account_id` varchar(255) DEFAULT NULL,
  `products_id` bigint(20) DEFAULT NULL,
  `rating_message` longtext,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4pwi5t39aa0p08cqfsp5yh8qi` (`products_id`),
  KEY `FKihfmkgwbxme220v7olcraxkjm` (`account_id`),
  KEY `FKt3mecsgki7hdg8srke4baeidk` (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_rating`
--

LOCK TABLES `product_rating` WRITE;
/*!40000 ALTER TABLE `product_rating` DISABLE KEYS */;
INSERT INTO `product_rating` VALUES (3,5,'Great quality and awesome motive','dab06b40-9d5f-454d-86d4-2d9ab6bbf4ea',33,NULL,33);
/*!40000 ALTER TABLE `product_rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sku`
--

DROP TABLE IF EXISTS `sku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `price_diff` double DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `stock` int(11) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `attribute_option_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_j5vwm8w70olis07rsnjeeyvka` (`sku`),
  KEY `FKixafovqfh0bn0kakqk45wfi4i` (`attribute_option_id`),
  KEY `FKovd96qvc9da3k94gf0j822p3o` (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sku`
--

LOCK TABLES `sku` WRITE;
/*!40000 ALTER TABLE `sku` DISABLE KEYS */;
INSERT INTO `sku` VALUES (1,NULL,'111-111-40',1,1,0),(2,NULL,'111-111-41',1,2,0),(3,NULL,'111-111-42',1,3,0),(4,NULL,'111-111-43',1,4,0),(5,NULL,'111-111-44',1,5,0),(6,NULL,'111-111-45',1,6,0),(7,NULL,'111-111-46',1,7,0),(8,NULL,'111-111-47-1',10,12,13),(9,NULL,'111-111-47-2',10,12,14),(10,NULL,'111-111-47-3',10,12,15),(24,NULL,'111-111-48-1',10,20,15),(25,NULL,'111-111-48-2',10,20,16),(26,NULL,'111-111-48-3',10,20,17),(43,NULL,'111-111-50',10,33,0),(49,NULL,'222-222-42',5,40,8),(54,NULL,'222-222-43',2,40,9);
/*!40000 ALTER TABLE `sku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vat`
--

DROP TABLE IF EXISTS `vat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `vat_name` varchar(32) DEFAULT NULL,
  `vat_value` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vat`
--

LOCK TABLES `vat` WRITE;
/*!40000 ALTER TABLE `vat` DISABLE KEYS */;
INSERT INTO `vat` VALUES (1,'Standard rate UK',20),(2,'Reduced rate UK',5),(3,'Zero rate UK',0);
/*!40000 ALTER TABLE `vat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-11 20:29:52
