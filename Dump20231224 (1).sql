-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: toiec365
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authority` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_g6g6arw2xba1pirbuf4ig44jq` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (2,'ROLE_ADMIN'),(1,'ROLE_USER');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_part`
--

DROP TABLE IF EXISTS `exam_part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam_part` (
  `exam_id` bigint NOT NULL,
  `part_id` bigint NOT NULL,
  KEY `FK29ijln51ol23pkhwo4ukif2wn` (`part_id`),
  KEY `FKb0weqgsjaxm9e8ul9u8aql941` (`exam_id`),
  CONSTRAINT `FK29ijln51ol23pkhwo4ukif2wn` FOREIGN KEY (`part_id`) REFERENCES `parts` (`id`),
  CONSTRAINT `FKb0weqgsjaxm9e8ul9u8aql941` FOREIGN KEY (`exam_id`) REFERENCES `exams` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_part`
--

LOCK TABLES `exam_part` WRITE;
/*!40000 ALTER TABLE `exam_part` DISABLE KEYS */;
INSERT INTO `exam_part` VALUES (2,2),(2,3),(2,4),(2,5),(2,15),(2,16),(2,17),(42,37),(42,3),(42,4),(42,5),(42,15),(42,16),(42,17);
/*!40000 ALTER TABLE `exam_part` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exams`
--

DROP TABLE IF EXISTS `exams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exams` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `exam_name` varchar(255) DEFAULT NULL,
  `total_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exams`
--

LOCK TABLES `exams` WRITE;
/*!40000 ALTER TABLE `exams` DISABLE KEYS */;
INSERT INTO `exams` VALUES (2,'ETS 2022 - Test 1','2021-04-20 02:00:00'),(42,'ETS 2022 - Test 2','2021-04-23 02:00:00');
/*!40000 ALTER TABLE `exams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_question`
--

DROP TABLE IF EXISTS `group_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `audio` varchar(255) DEFAULT NULL,
  `group_question_desc` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `group_question_img` varchar(255) DEFAULT NULL,
  `paragraph` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `title` varchar(255) DEFAULT NULL,
  `part_id` bigint NOT NULL,
  `transcript` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKajjkw2xbr81emufhhx6ectk4g` (`part_id`),
  CONSTRAINT `FKajjkw2xbr81emufhhx6ectk4g` FOREIGN KEY (`part_id`) REFERENCES `parts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_question`
--

LOCK TABLES `group_question` WRITE;
/*!40000 ALTER TABLE `group_question` DISABLE KEYS */;
INSERT INTO `group_question` VALUES (1,'ets_2020_01_part1.mp3','<p>Please refrain from replaying the audio, you can only listen one time when in real exam.</p>','','','Mark your answer on your answer sheet 1 - 3:',2,NULL),(4,'ets_2020_01_part2.mp3','<p>Please refrain from replaying the audio, you can only listen one time when in real exam.</p>','','','Mark your answer on your answer sheet 4 - 15:',3,NULL),(5,'ets_2020_01_part3-17-19.mp3','<p>Please refrain from replaying the audio, you can only listen one time when in real exam.</p>','','','Question 16 - 18 refer to following conversation:',4,NULL),(6,'ets_2020_01_part4-36-38.mp3','<p>Please refrain from replaying the audio, you can only listen one time when in real exam.</p>','','','Question 36 - 38 refer to following conversation:',5,NULL),(9,'ets_2020_01_part3-19-21.mp3','<p>Please refrain from replaying the audio, you can only listen one time when in real exam.</p>','','','Question 19 - 21 refer to following conversation:',4,NULL),(10,'ets_2020_01_part3-22-24.mp3','<p>Please refrain from replaying the audio, you can only listen one time when in real exam.</p>','','','Question 22 - 24 refer to following conversation:',4,NULL),(11,'ets_2020_01_part3-25-28.mp3','<p>Please refrain from replaying the audio, you can only listen one time when in real exam.</p>','','','Question 25 - 27 refer to following conversation:',4,NULL),(12,'ets_2020_01_part3-28-30.mp3','<p>Please refrain from replaying the audio, you can only listen one time when in real exam.</p>','','','Question 28 - 30 refer to following conversation:',4,NULL),(13,'ets_2020_01_part3-31-33.mp3','<p>Please refrain from replaying the audio, you can only listen one time when in real exam.</p>','','','Question 31 - 33 refer to following conversation:',4,NULL),(14,'ets_2020_01_part3-34-35.mp3','<p>Please refrain from replaying the audio, you can only listen one time when in real exam.</p>','','','Question 34 - 35 refer to following conversation:',4,NULL),(15,'ets_2020_01_part4-39-41.mp3','<p>Please refrain from replaying the audio, you can only listen one time when in real exam.</p>','','','Question 39 - 41 refer to following conversation:',5,NULL),(16,'ets_2020_01_part4-42-44.mp3','<p>Please refrain from replaying the audio, you can only listen one time when in real exam.</p>','','','Question 42 - 44 refer to following conversation:',5,NULL),(17,'ets_2020_01_part4-45-47.mp3','<p>Please refrain from replaying the audio, you can only listen one time when in real exam.</p>','','','Question 45 - 47 refer to following conversation:',5,NULL),(18,'ets_2020_01_part4-48-50.mp3','<p>ease refrain from replaying the audio, you can only listen one time when in real exam.</p>','','','Question 48 - 50 refer to following conversation:',5,NULL),(19,'','','','','Mark your answer on your answer sheet 51 - 80:',15,NULL),(20,'','','','<p>Pro Unis is now hiring for positions in our production, human resources, and accounting departments. As one of the region’s largest employers, Pro Unis __(1).....__ workforces with uniforms for over 70 years. Since our founding, Pro Unis has been committed to employee retention and _(2)....._.','Question 81- 83 refer to following paragraph:',16,NULL),(21,'','','','<p>WS Dental is pleased to announce that our practice is _(1)....._. Our second office is now open at 242 Union Street in Lambton, offering greater _(2)....._ for patients living on the north side of the city. Our original clinic will continue to operate at 12 Finn Place. Dr.</p>','Question 84 - 86 refer to following paragraph:',16,NULL),(22,'','','','<p><strong>EMPLOYMENT CENTER</strong></p><figure class=\"table\"><table><tbody><tr><td>Home</td><td><strong>Find a Job</strong></td><td>Apply</td></tr></tbody></table></figure><p><strong>Management Assistant, Property Development Division</strong></p><p>Fuhr Realty Ltd. has a need for a full-time management assistant to provide customer service, data entry, and general administrative support associated with our Property Development Division. The individual will respond to requests for information from the public, research and track permits, and assist with maintaining department records. The position requires a minimum of a bachelor’s degree and two years of related office experience. Strong computer literacy and excellent written and spoken communication skills are a must.</p><p><strong>Applications will be accepted through March 30.</strong></p>','Question 87 - 92 refer to following paragraph:',17,NULL),(23,'','','','<figure class=\"table\"><table><tbody><tr><td>http://www.cmb.com</td></tr><tr><td><h4>Crescent Moon Bistro</h4><p>Located along the eastern shore of Canawap Bay, the Crescent Moon Bistro is a unique venue for birthday parties, weddings, corporate gatherings, and a host of other social events. Our chefs work with you to craft a perfect menu, while our coordinators will see to it that your event is superbly organized. Rental pricing is based on the date, type of event, and number of attendees.</p><p>You are welcome to tour our facility on October 10 from 11:00 AM. to 2:00 PM. Meet with our coordinators and culinary staff, and sample items from our creative menu. Admission is free, but registration is required. We are offering 25% off on any booking made during this open house on October 10.</p></td></tr></tbody></table></figure><p>&nbsp;</p>','Question 93 - 98 refer to following paragraph:',17,NULL),(24,'','','','<p>To: (Customer List)</p><p>From: Info@rapidrailways.com</p><p>Date: February 1</p><p>Subject: News</p><p>Rapid Railways would like to reward its loyal customers with a special discount on travel during the month of April. Purchase an adult round-trip ticket over $60 and receive 50 percent off a second adult fare for a companion. Use code RAIL when booking online.</p><p>This promotion is not valid for Rapid Railways Express trains. Customers cannot exchange previously purchased tickets to obtain the offer. Tickets must be purchased by March 1.</p>','Question 99 - 100 refer to following paragraph:',17,NULL),(27,'ets_2020_02_part1.mp3','<p>Please refrain from replaying the audio, you can only listen one time when in real exam.</p>','','','02 - Mark your answer on your answer sheet 1- 3 : ',37,NULL),(28,'ets_2021_03_part1.mp3','<p>Please refrain from replaying the audio, you can only listen one time when in real exam.</p>','','','03 - Mark your answer on your answer sheet 1 - 3:',38,NULL),(29,'ets_2021_04_part1.mp3','<p>Please refrain from replaying the audio, you can only listen one time when in real exam.</p>','','','04 - Mark your answer on your answer sheet 1 - 3:',39,NULL),(30,'','<p>13333</p>','','','1233',40,NULL);
/*!40000 ALTER TABLE `group_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (41);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history_exam`
--

DROP TABLE IF EXISTS `history_exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history_exam` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `listening_score` decimal(19,2) DEFAULT NULL,
  `reading_score` decimal(19,2) DEFAULT NULL,
  `time_of_exam` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `exam_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK91xof8n9j6borg26rfxpro0mk` (`user_id`),
  KEY `FKnvphgkjitnr8mw5wg5bbve01g` (`exam_id`),
  CONSTRAINT `FK91xof8n9j6borg26rfxpro0mk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKnvphgkjitnr8mw5wg5bbve01g` FOREIGN KEY (`exam_id`) REFERENCES `exams` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_exam`
--

LOCK TABLES `history_exam` WRITE;
/*!40000 ALTER TABLE `history_exam` DISABLE KEYS */;
INSERT INTO `history_exam` VALUES (1,0.00,0.00,1,21,2),(2,0.00,0.00,2,21,2),(3,0.00,0.00,3,21,2),(4,0.00,0.00,1,18,2),(5,0.00,0.00,2,18,2),(6,0.00,0.00,3,18,2),(7,0.00,0.00,4,21,2);
/*!40000 ALTER TABLE `history_exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parts`
--

DROP TABLE IF EXISTS `parts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parts` (
  `id` bigint NOT NULL,
  `number_part` varchar(255) DEFAULT NULL,
  `part_desc` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `part_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parts`
--

LOCK TABLES `parts` WRITE;
/*!40000 ALTER TABLE `parts` DISABLE KEYS */;
INSERT INTO `parts` VALUES (2,'1','<p><strong>Directions: </strong>For each question, you will see a picture and you will hear four short statements. The statements will be spoken just one time. They will not be printed in your test book so you must listen carefully to understand what the speaker says. When you hear the four statements, look at the picture and choose the statement that best describes what you see in the picture. Choose the best answer A, B, C or D</p>','Part I: Picture Description'),(3,'2','<p><strong>Directions: </strong>In this part of the test, you will hear a question or statement spoken in English, followed by three responses, also spoken in English. The question or statement and the responses will be spoken just one time. They will not be printed in your test book, so you must listen carefully. You are to choose the best response to each question or statement. Now listen to a sample question.</p>','Part II: Question - Response'),(4,'3','<p><strong>Directions: </strong>You will hear some conversations between two people. You will be asked to answer three questions about what the speakers say in each conversation. Select the best response to each question and mark the letter (A), (B), (C) or (D) on your answer sheet. The conversations will not be printed in your test book and will be spoken only one time.</p>','Part III: Short Conversations'),(5,'4','<p><strong>Directions: </strong>You will hear some talks given by a single speaker. You will be asked to answer three questions about what the speaker says in each talk. Select the best response to each question and mark the letter (A), (B), (C) or (D) on your answer sheet. The talks will not be printed in your test book and will be spoken only one time.</p>','Part IV: Short Talks'),(15,'5','<p><strong>Directions: </strong>A word or pharse is missing in each of the sentences below. Four answer choices are given below each sentence. Select the best answer to complete the sentence. Then mark the letter (A), (B), (C) or (D) on your answer sheet.</p>','Part V: Incomplete Sentences'),(16,'6','<p><strong>Directions: </strong>Read the texts that follow. A word or pharse is missing in some of the sentences. Four answer choices are given below each of the sentences. Select the best answer to complete the text. Then mark the letter (A), (B), (C) or (D) on your answer sheet.</p>','Part VI: Incomplete Sentences'),(17,'7','<p><strong>Directions: </strong>In this part you will read a selection of texts, such as magezine and newspaper articles, letters, and advertisements. Each text is followed by several questions. Select the best answer for each question and mark the letter (A), (B), (C) or (D) on your answer sheet.</p>','Part VII: Reading Comprehension'),(37,'1.1','<p><strong>Directions: </strong>For each question, you will see a picture and you will hear four short statements. The statements will be spoken just one time. They will not be printed in your test book so you must listen carefully to understand what the speaker says. When you hear the four statements, look at the picture and choose the statement that best describes what you see in the picture. Choose the best answer A, B, C or D</p>','Part I: Picture Description'),(38,'1.2','<p><strong>Directions: </strong>For each question, you will see a picture and you will hear four short statements. The statements will be spoken just one time. They will not be printed in your test book so you must listen carefully to understand what the speaker says. When you hear the four statements, look at the picture and choose the statement that best describes what you see in the picture. Choose the best answer A, B, C or D</p>','Part I: Picture Description'),(39,'1.3','<p><strong>Directions: </strong>For each question, you will see a picture and you will hear four short statements. The statements will be spoken just one time. They will not be printed in your test book so you must listen carefully to understand what the speaker says. When you hear the four statements, look at the picture and choose the statement that best describes what you see in the picture. Choose the best answer A, B, C or D</p>','Part I: Picture Description'),(40,'1.4','<p>abc</p>','Part I: Picture Description');
/*!40000 ALTER TABLE `parts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `correct_answer` varchar(255) DEFAULT NULL,
  `option1` varchar(255) DEFAULT NULL,
  `option2` varchar(255) DEFAULT NULL,
  `option3` varchar(255) DEFAULT NULL,
  `option4` varchar(255) DEFAULT NULL,
  `question_content` varchar(255) DEFAULT NULL,
  `question_img` varchar(255) DEFAULT NULL,
  `question_number` bigint NOT NULL,
  `group_question_id` int DEFAULT NULL,
  `detailed_answer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmbjgv6xqox1wgxxt9tm2bjern` (`group_question_id`),
  CONSTRAINT `FKmbjgv6xqox1wgxxt9tm2bjern` FOREIGN KEY (`group_question_id`) REFERENCES `group_question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'B','A woman is painting a house.','A woman is watering a plant. ','A woman is fixing a door.','A woman is sweeping a walkway.','Select the answer','ets_2020_01_part1_1.jpg',1,1,'A'),(3,'C','They\'re folding some papers.','They\'re putting a picture in a frame.','They\'re studying a drawing. ','They\'re closing a window.','Select the answer','ets_2020_01_part1_2.jpg',2,1,'B'),(4,'D','The man is turning on a light.','The man is giving the woman a book.','The woman is posting signs on a wall.','The woman is typing on a keyboard. ','Select the answer','ets_2020_01_part1_3.jpg',3,1,NULL),(5,'A','Min-Su would like to. ','Our phone number has changed.',' A well-run organization.','','Who wants to organize the patient files?','',4,4,NULL),(6,'C','Yes, my new laptop.','utside of office 101.','Because she left early. ','','Why didn\'t Miranda shut down the computers yesterday?','',5,4,NULL),(7,'B','bout five dollars.','The pie sounds delicious. ','I just put it on.','','Would you like the pie or the pudding for dessert?','',6,4,NULL),(8,'C','At a hardware store','At a clothing shop','At a bakery  ','At a pharmacy','Where is the conversation most likely taking place?','',16,5,NULL),(9,'B','By advertising online','By offering a new product ','y providing free delivery ','By discounting some items','How do the speakers hope to increase sales?','',17,5,NULL),(10,'D','Contact a vendor','Talk to a colleague','File some invoices ','Get some more supplies ','What will the man do next?','',18,5,NULL),(11,'B','A retirement party',' holiday parade ','A business workshop ','A company picnic','According to the speaker, what will take place on Saturday?','',36,6,NULL),(12,'C','At a bank','At an amusement park','At a restaurant','At a police station','Where do the listeners work?','',37,6,NULL),(13,'B','Wear warm clothing','se public transportation ','Pack a lunch ','Bring identification','What does the speaker suggest that the listeners do?','',38,6,NULL),(14,'C','He used to live there.','A newspaper article.','Yes, I read it this morning. ','','Didn\'t you read Mr. Kim\'s memo?','',7,4,NULL),(16,'B','Platform nineteen.','Sure—here it is. ','A window seat.','','Excuse me, may I check your train ticket, please?','',8,4,NULL),(17,'A','The green one. ','Some mint tea, please.','All of the shirts have been folded.','','Which folder should I place this document in?','',9,4,NULL),(18,'A','Near the entrance. ','A new set of luggage.','The annual pharmacist convention.','','Where can I pick up my name tag for the conference?','',10,4,NULL),(19,'A','I actually teach math. ','We left early.','She was trained for a month.','','Why did you decide to become a history teacher?','',11,4,NULL),(20,'A','Yes, we\'ll do that today. ','At the farmer\'s market.','Thirty reservations.','','Doesn\'t the restaurant menu need to be updated for summer?','',12,4,NULL),(21,'A','I can\'t decide on a color. ','No, we didn\'t buy tickets.','The room next to the elevator.','','When are you going to paint your office?','',13,4,NULL),(22,'B','It went well.','Right, it\'s on Monday. ','Only a laptop.','','Isn\'t our presentation next week?','',14,4,NULL),(23,'B','No, to the left.','Yes, it\'s nearly ready. ','That\'s a fun movie.','','You\'re working on programming the Web site, right?','',15,4,NULL),(24,'D','At an appliance manufacturer','At a construction firm','At a grocery store','At an apartment complex','Where do the speakers most likely work?','',19,9,NULL),(25,'A','A budget','A contract','A job posting ','An instruction manual','What does the woman say she will review?','',20,9,NULL),(26,'B','Schedule an interview','Arrange a discount ','Make a delivery ','Print some brochures','What does the man hope to do this afternoon?','',21,9,NULL),(27,'B','A flight attendant','A sales representative ','An event organizer ','A repair technician','Who most likely is the man?','',22,10,NULL),(29,'D','Read some client information','Prepare a contract','Make a dinner reservation ','Check some equipment ','What does the woman say the man should do before a meeting?','',23,10,NULL),(30,'D','Read some client information','Prepare a contract','Make a dinner reservation ','Check some equipment ','What does the woman say the man should do before a meeting?','',24,10,NULL),(31,'A','At a clothing shop ','At a photography studio','At a travel agency ','At a furniture store','Where do the speakers work?','',25,11,NULL),(32,'D','To request assistance','To correct an error','To express disagreement ','To make a guess ',' Why does the man say, \\\"Coffee shops need a lot of tables and chairs\\\"?','',26,11,NULL),(33,'C','Process an online order','Call the building\'s property manager','Meet some new neighbors  ','Fix a broken piece of equipment','What will the woman do next?','',27,11,NULL),(34,'A','He used the wrong entrance. ','He is late for an appointment.','He forgot to bring identification. ','He lost an order number.','Why does the man apologize?','',28,12,'A'),(35,'C','Delivery driver','Electrician','Journalist  ','Security guard','What is the man’s job?','',29,12,NULL),(36,'B','To a conference room','To a security desk ','To a construction site ','To a loading dock','Where does the woman direct the man to go?','',30,12,NULL),(37,'B','At an advertising agency',' At an electronics shop ','At a furniture store ','At an assembly plant','Where do the speakers most likely work?','',31,13,'A'),(38,'C','To ask for help','To refuse a request','To express agreement  ','To show concern','Why does the woman say, \\\"We\'ve already sold out\\\"?','',32,13,NULL),(39,'A','It has good online reviews. ','It has a lifetime warranty.','It is being advertised by celebrities. ','It is being sold at a low price.','According to the woman, why is a product popular?','',33,13,NULL),(40,'B','To return a defective item','To purchase a gift ','To publicize a festival ','To apply for a position','Why are the men at the store?','',34,14,NULL),(41,'A','Hiking ','Swimming','Skiing ','Cycling','What hobby is mentioned?','',35,14,NULL),(42,'B','A travel agent','An author ','A librarian ','A news reporter','Who most likely is Rita Perez?','',39,15,NULL),(43,'C','She won a contest.','She received a promotion.',' She has become successful.  ','She will travel abroad.','Why is the speaker happy for Rita Perez?','',40,15,NULL),(44,'A','Silence their phones ','Take their seats','Ask questions ','Make a purchase','What does the speaker request that the listeners do?','',41,15,NULL),(45,'D','Laboratory technicians','Doctors','Telecommunication specialists ','Software designers ','Who most likely are the listeners?','',42,16,NULL),(46,'A','A product is effective. ','A deadline was extended.','Some tasks have been reassigned. ','Some staff members are not being careful.','What does the speaker imply when she says, they spent fifteen minutes less than usual completing reports each shift?','',43,16,NULL),(47,'B','Tour a facility','Review some charts ','Enjoy some refreshments ','Watch a product demonstration','What will the listeners do next?','',44,16,NULL),(48,'D','At a health food store','At a dentist\'s office','At a fitness center ','At a pharmacy ','Where does the speaker work?','',45,17,'A'),(49,'B','To ask the listener to work an additional shift','To encourage the listener to come at a different time ','To complain about a decision ','To refuse a request for time off','Why does the speaker say, \\\"we will be short staffed from four to five due to employee training\\\"?','',46,17,NULL),(50,'A','Bring identification ','Pay an overdue bill','Register online ','Submit a time sheet','What does the speaker remind the listener to do?','',47,17,NULL),(51,'B','A city official','A company president ','An office supervisor ','A university professor','According to the speaker, who is Min-Ah Choi?','',48,18,'A'),(52,'C','Project management','Computer skills','Financial planning  ','Product marketing','What is the focus of the seminar?','',49,18,NULL),(53,'A','Sign in online ','Pick up a handout','Ask questions ','Form small groups','What does the speaker ask the listeners to do?','',50,18,NULL),(54,'A','locations ','locate','located','location','Sunwirth Sneakers has several ....._ in the greater metropolitan area.','',51,19,NULL),(55,'B','buying','paying ','going','eating','Cimber CPAs offers clients the convenience of ..... their invoices online and by mail.','',52,19,NULL),(56,'D',' reliable','to rely','more reliable','eliably ','The new software at Patel Industries has been working ..... since it was installed last year.','',53,19,NULL),(57,'D','along','toward','over','throughout ','Best practices in customer service are outlined ..... the training handbook.','',54,19,'A'),(58,'C','simple','simpler','simply ','simplicity','The Scratch software will help us migrate our client records .....','',55,19,NULL),(59,'B','herself','her ','she','hers','The comedian said that ..... sense of humor was inherited from a grandparent.','',56,19,NULL),(60,'A','from ','beside','along','after','Starting this August, Gavelton Bike Tours will be leading group cycling trips ..... Paris to Berlin.','',57,19,'A'),(61,'A','reach ','talk','reason','put',' We hope to ..... an agreement with Mason Cooper, Inc., within the next week.','',58,19,NULL),(62,'C','if','to','of','as','Factory-floor managers must submit an inspection report at the end ..... their shift.','',59,19,NULL),(63,'C','Sometimes','Later','Formerly ','Frequently','..... a retail store, Seedum International will now sell merchandise only through its Web site.','',60,19,NULL),(64,'D','or','and','with','nor ','Remarkably, neither Ms. Chen ..... Mr. Gillespie had been notified that the board meeting was canceled.','',61,19,NULL),(65,'D','rigid','most rigidly','rigidly','more rigid ','The new microwave soup containers are ..... than the previous ones.','',62,19,NULL),(66,'C','regular','general',' proud ','favorite','The Banly Tourism Society is ..... to present the first issue of its publication, The Banly Quarterly.','',63,19,NULL),(67,'B','evaluate','evaluation ','evaluator','evaluative','Konixer Printers is conducting a thorough ..... of current requests for equipment upgrades.','',64,19,NULL),(68,'A','espite ','Across','Besides','Inside','..... the addition of 300 spaces, the ferry terminal’s parking area is still full by 9:00 A.M. every day.','',65,19,NULL),(69,'C','collaboration','collaborative','collaboratively ','collaborate','Justlox, Inc., is planning to ..... redesign Model 543Q with its partners in Britain to ensure a better product.','',66,19,'A'),(70,'A','assortment ','excitement','account','industry','Each box of Lane Permanent Markers contains an ..... of surprising colors.','',67,19,NULL),(71,'D','safe','close','clean','prompt ','We were pleased by the ..... and courteous reply we received from Astella Airlines concerning the change in itinerary.','',68,19,NULL),(72,'B','grow','growth ',' grew','grown','The rising employment rate is one factor contributing to ..... in the housing construction trade.','',69,19,'A'),(73,'B','specify','specified ','specifying','specification','The color of the new chairs was not ..... on the invoice','',70,19,NULL),(74,'A','minimum ','temporary','bottom','durable','Two hours is the ..... amount of time needed to complete the assignment.','',71,19,NULL),(75,'D','stabilized','stability','stabilizing','stabilize ','A successful digital marketing campaign has helped Fossler Electronics ..... its profit margins.','',72,19,NULL),(76,'B','supervisors','supervisory ','supervise','supervises','Applicants for the position of data manager are expected to have a minimum of three years’ ..... experience.','',73,19,NULL),(77,'D','record','recording','being recorded','was recorded ','The mayor’s speech at Monday’s business breakfast ..... and will be broadcast later this week.','',74,19,NULL),(78,'D','soon','suddenly','well','repeatedly ','The researchers ..... tested different formulas until the desired results were achieved.','',75,19,NULL),(79,'D','commit','associate','reserve','finance ','oan specialists at Newton Bank can help your company ..... equipment purchases.','',76,19,NULL),(80,'B','After all','Because of ','For this reason','As long as','..... our partnership with Shox Gym, we are able to provide employees with a free membership to the fitness center.','',77,19,NULL),(81,'A','anyone ','anywhere','anyway','anyhow','Mr. Tran asked the department whether ..... could work overtime on Friday.','',78,19,'A'),(82,'C','deadline','availability','profitability ','emphasis','Canyonland Corporation will research the potential ..... of expanding its overseas market to East Africa.','',79,19,'A'),(83,'C','who','what','which ','whose','Chef Lind’s cookbook, ..... will be available next week, contains only dessert recipes.','',80,19,NULL),(84,'D','outfitted','will outfit ','is outfitting','has been outfitting ','__(0)__','',81,20,'A'),(85,'D','advanced','an advance ','they advance','advancement ','__(1)__','',82,20,NULL),(86,'C','issues','events ','openings ','investments','__(2)__','',83,20,'A'),(87,'B','training','expanding  ','calling','moving','__(0)__','',84,21,'A'),(88,'D','collection','production ','performance','convenience ','__(1)__','',85,21,'A'),(89,'C','exception','exceptions ','exceptional ','exceptionally','__(2)__','',86,21,'A'),(90,'C','The location of Fuhr Realty Ltd.','A starting date for the position','A description of job responsibilities ','A description of job responsibilities','What is included in the job posting?','',87,22,'A'),(91,'D','A degree in accounting','A professional certification','Experience as a manager','Experience as a manager ','What qualification is necessary for the position?','',88,22,'A'),(92,'C','The location of Fuhr Realty Ltd.',' A starting date for the position','A description of job responsibilities ','A description of job responsibilities','What is included in the job posting?','',89,22,'A'),(93,'D','A degree in accounting','A professional certification','Experience as a manager','Experience as a manager ','What qualification is necessary for the position?','',90,22,'A'),(94,'C','The location of Fuhr Realty Ltd.','A starting date for the position','A description of job responsibilities ','A description of job responsibilities','What is included in the job posting?','',91,22,'A'),(95,'D','A degree in accounting','A professional certification','Experience as a manager','Experience as a manager ','What qualification is necessary for the position?','',92,22,'A'),(96,'C','A vacation rental','A new hotel','An event space ','An event space','What is being advertised?','',93,23,'A'),(97,'A','A discounted reservation rate ','A special concert','A famous recipe book','A famous recipe book','What will be offered on October 10 ?','',94,23,'A'),(98,'C','A vacation rental','A new hotel','An event space ','An event space','What is being advertised?','',95,23,NULL),(99,'A','A discounted reservation rate ','A special concert','A famous recipe book','A famous recipe book','What will be offered on October 10 ?','',96,23,'A'),(100,'C','A vacation rental','A new hotel','An event space ','An event space','What is being advertised?','',97,23,'A'),(101,'A','A discounted reservation rate ','A special concert','A famous recipe book','A famous recipe book','What will be offered on October 10 ?','',98,23,'A'),(102,'C','To publicize an updated service','To attract first-time customers','To increase the sale of April tickets','To promote Rapid Railways Express','What is the purpose of the e—mail?','',99,24,'A'),(103,'D','It includes children.','It requires that tickets be purchased over the phone.','It applies only to tickets already purchased.',' It applies only to tickets already purchased. ','What is true about the special discount?','',100,24,'A'),(108,'C','She’s closing a door.','She’s washing some plates.','She’s preparing some food ','She’s sweeping a floor.','Select the answer','ets_2020_02_part1_1.jpg',1,27,'A'),(109,'B','They’re taking off their jackets.','They’re walking outside. ','They’re going into a building.','They’re packing some luggage.','Select the answer','ets_2020_02_part1_2.jpg',2,27,'A'),(110,'D','They’re shaking hands across a counter.','They’re putting stamps on envelopes.','A man is organizing documents in a folder.','A woman is writing on a piece of paper. ','Select the answer','ets_2020_02_part1_3.jpg',3,27,'A'),(111,'A','He’s tying his shoe. ','He’s cutting the grass.','He’s reading a magazine.','He’s walking around a fountain.','Select the answer','ets_2021_03_part1_1.jpg',1,28,'A'),(112,'D','They’re installing a railing.','They’re sweeping the steps.','They’re looking out a window.','They’re going down some stairs. ','Select the answer','ets_2021_03_part1_2.jpg',2,28,'A'),(113,'C','She’s paying at a counter.','She has stacked books on shelves.','She has opened a refrigerator. ','She’s eating a meal in a restaurant.','Select the answer','ets_2021_03_part1_3.jpg',3,28,'A'),(114,'A','He’s carrying some packages. ','He’s putting on a hat.','He’s pushing a cart.','He’s washing some windows.','Select the answer','ets_2021_04_part1_1.jpg',1,29,'A'),(115,'C','She’s hanging up a sign.','She’s painting a wall.','She’s using some office equipment. ','She’s emptying a recycling bin','Select the answer','ets_2021_04_part1_2.jpg',2,29,'A'),(116,'C','A customer is placing a tray in a sink.','A customer is handing money to a cashier.','A cashier is holding an item. ','A cashier is stacking some cups.','Select the answer','ets_2021_04_part1_3.jpg',3,29,'A'),(121,'B','1','2','3','4','1','',1,30,'A'),(122,'A','1','2','3','4','1','',1,30,'A'),(123,'A','1','2','3','4','1','cau1.jpg',1,30,'A'),(124,'B','woman is giving birth','woman is giving birth','woman is giving birth','woman is giving birth','gggg','cau2.png',1,30,'A'),(125,'A','A','B','C','D','test','',1,27,'A'),(126,'A','A','B','C','D','ĐÂY LÀ CÂU TEST','',5,28,'ĐÂY LÀ ĐÁP ÁN CHI TIẾT'),(127,'A','A','B','C','D','ĐÂY LÀ CÂU HỎI TEST','',3,28,'ĐÁP ÁN CHI TIẾT Ở ĐÂY C');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_authority`
--

DROP TABLE IF EXISTS `user_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_authority` (
  `user_id` int NOT NULL,
  `authority_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`authority_id`),
  KEY `FKgvxjs381k6f48d5d2yi11uh89` (`authority_id`),
  CONSTRAINT `FKgvxjs381k6f48d5d2yi11uh89` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`),
  CONSTRAINT `FKhi46vu7680y1hwvmnnuh4cybx` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_authority`
--

LOCK TABLES `user_authority` WRITE;
/*!40000 ALTER TABLE `user_authority` DISABLE KEYS */;
INSERT INTO `user_authority` VALUES (14,1),(16,1),(17,1),(18,1),(21,1),(22,1),(19,2);
/*!40000 ALTER TABLE `user_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (14,'trongha@gmail.com','halt','$2a$10$LCpDNM9hLOfxuLe6EiGtjODiFJ5gYfPhP6ixtXx.t3XGlnSuR2aVm'),(16,'tienan@gmail.com','annt','$2a$10$LCpDNM9hLOfxuLe6EiGtjODiFJ5gYfPhP6ixtXx.t3XGlnSuR2aVm'),(17,'dangcuong@gmail.com','cuongdq','$2a$10$LCpDNM9hLOfxuLe6EiGtjODiFJ5gYfPhP6ixtXx.t3XGlnSuR2aVm'),(18,'giangbee.jb@gmail.com','giangtd','$2a$10$LCpDNM9hLOfxuLe6EiGtjODiFJ5gYfPhP6ixtXx.t3XGlnSuR2aVm'),(19,'admin@gmail.com','admin','$2a$10$x1M7jpdErjMvzrSNVZTtj.seYYcKpvROUSrV4O5NM32BGZNrkST5m'),(21,'solax0909@gmail.com','Kiều Sơn','$2a$10$LCpDNM9hLOfxuLe6EiGtjODiFJ5gYfPhP6ixtXx.t3XGlnSuR2aVm'),(22,'hung@gmail.com','hungvo2','$2a$10$LtqUZTZU6rkTJJPGTBuHSe15nj8TOqbksom7AEGOiB241plDV3HWu');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-24 19:41:08
