-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: curriculum_design
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` char(12) NOT NULL,
  `name` char(11) NOT NULL,
  `gender` char(4) NOT NULL,
  `age` tinyint NOT NULL,
  `phone` char(12) NOT NULL,
  `topicId` char(11) DEFAULT NULL,
  `password` char(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('1910001902','张三','男',18,'11111111111','1910011902','123456'),('1910014224','张三','男',21,'15591738313',NULL,'1'),('1910031902','李四','女',12,'15829966469','1910011902','1'),('1910041902','王五','男',21,'11111111111',NULL,'1'),('1910061902','赵柳','男',12,'15829966469',NULL,'1'),('1910071902','利器','男',1,'11111111111',NULL,'1');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` char(12) NOT NULL,
  `name` char(11) NOT NULL,
  `gender` char(4) NOT NULL,
  `age` tinyint NOT NULL,
  `phone` char(12) NOT NULL,
  `password` char(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('1910011902','孔繁帮','女',18,'15829966469','1'),('1910021902','李白','男',21,'11111111111','1');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic` (
  `id` char(12) NOT NULL,
  `name` char(11) NOT NULL,
  `teacherId` char(12) NOT NULL,
  `isChoose` tinyint DEFAULT NULL,
  `isSubmit` tinyint DEFAULT '0',
  `grade` char(8) NOT NULL,
  `score` double DEFAULT NULL,
  `numberOne` char(13) DEFAULT NULL,
  `numberTwo` char(13) DEFAULT NULL,
  `numberThree` char(13) DEFAULT NULL,
  `resFile` char(255) DEFAULT NULL,
  `submitFile` char(255) DEFAULT NULL,
  `introduction` char(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES ('1910011902','学生管理系统','1910021902',1,1,'计科1902',NULL,'1910031902','1910001902','','1910011902helpAPI.zip','1910011902submitFile.zip','无'),('1910021902','宿舍管理系统','1910021902',NULL,0,'计科1902',NULL,NULL,NULL,NULL,'1910021902helpAPI.zip',NULL,'无');
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-20 23:13:35
