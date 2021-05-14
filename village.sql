-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 06, 2021 at 04:12 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `village`
--
CREATE DATABASE IF NOT EXISTS `village` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `village`;

-- --------------------------------------------------------

--
-- Table structure for table `archetype`
--

DROP TABLE IF EXISTS `archetype`;
CREATE TABLE IF NOT EXISTS `archetype` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `archetype`
--

INSERT INTO `archetype` (`id`, `nom`) VALUES
(1, 'Magicien'),
(2, 'Guerrier'),
(3, 'Barde'),
(4, 'Chasseur'),
(5, 'Sorcier'),
(6, 'Pirate');

-- --------------------------------------------------------

--
-- Table structure for table `catalogue`
--

DROP TABLE IF EXISTS `catalogue`;
CREATE TABLE IF NOT EXISTS `catalogue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_marchand` int(11) NOT NULL,
  `id_item` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_item` (`id_item`),
  KEY `id_marchand` (`id_marchand`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `catalogue`
--

INSERT INTO `catalogue` (`id`, `id_marchand`, `id_item`) VALUES
(1, 1, 6),
(2, 1, 7),
(3, 1, 8),
(4, 1, 2),
(5, 2, 1),
(6, 2, 17),
(7, 2, 16),
(8, 2, 9);

-- --------------------------------------------------------

--
-- Table structure for table `inventaire`
--

DROP TABLE IF EXISTS `inventaire`;
CREATE TABLE IF NOT EXISTS `inventaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_joueur` int(11) NOT NULL,
  `id_item` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_item` (`id_item`),
  KEY `id_joueur` (`id_joueur`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventaire`
--

INSERT INTO `inventaire` (`id`, `id_joueur`, `id_item`) VALUES
(3, 0, 5),
(4, 0, 11),
(5, 0, 19),
(6, 0, 23),
(7, 0, 24),
(8, 0, 10),
(9, 0, 12),
(10, 0, 20),
(11, 0, 15);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  `valeur` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`id`, `nom`, `description`, `valeur`) VALUES
(1, 'Chaussures', 'elles puent', 5),
(2, 'Baton magique', 'Il y a un caillou bleu dessus', 50),
(3, 'Cape d\'invisibilite', 'Elle permet de se rendre invisible', 100),
(4, 'Epee longue', 'Acier trempe rouille pas vite', 20),
(5, 'Chapeau de paille', 'Inutile mais swag pour Jordan', 1),
(6, 'Armure de cuir', 'Legere, ideale pour les freles magiciens', 10),
(7, 'Armure de metal', 'Lourde, ideale pour les grosses brutes suicidaires', 20),
(8, 'Cotte de mailles', 'Du metal porte pour pas mourir', 15),
(9, 'Bottes de sept lieues', 'Des godasses qui ont la classe', 30),
(10, 'Havresac', 'objet inutile du jeu, stockage infini', 100),
(11, 'Sabre Laser', 'artefact perdu des temps anciens', 75),
(12, 'Bouclier de bois', 'Craint le feu', 10),
(13, 'Bouclier de metal', 'Craint le feu tres chaud', 20),
(15, 'Dagues d\'argent', 'Ce ne sont pas des shurikens', 15),
(16, 'Marteau', 'A rendre au forgeron qui l\'a perdu', 0),
(17, 'Potion de soin', 'pour soigner les blessures non-lethales', 10),
(18, 'Fiole d\'alchimie', 'concoction obscure et odorante', 7),
(19, 'Herbes de provence', 'pour cuisiner de bons petits plats', 3),
(20, 'Kamoulox', 'pour gagner un argument', 13),
(21, 'Pistole à poudre', 'Et paf ca fait pan', 43),
(22, 'Arbalete', 'Plus puissante mais plus lente qu\'un arc', 36),
(23, 'Arc', 'Plus rapide mais plus faible qu\'une arbalete', 20),
(24, 'Fleches', 'Vendues par 12', 12);

-- --------------------------------------------------------

--
-- Table structure for table `joueur`
--

DROP TABLE IF EXISTS `joueur`;
CREATE TABLE IF NOT EXISTS `joueur` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `solde` int(11) NOT NULL,
  `job` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `joueur`
--

INSERT INTO `joueur` (`id`, `nom`, `solde`, `job`) VALUES
(0, 'Moi', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `marchand`
--

DROP TABLE IF EXISTS `marchand`;
CREATE TABLE IF NOT EXISTS `marchand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `solde` int(11) NOT NULL,
  `nom_magasin` varchar(50) NOT NULL,
  `affinite` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marchand`
--

INSERT INTO `marchand` (`id`, `nom`, `solde`, `nom_magasin`, `affinite`) VALUES
(1, 'Halvar le Forgeron', 100, 'Les Forges Infernalles', 50),
(2, 'Thorvald le Voyageur', 50, 'Boutique de Souvenirs du Monde', 50);

-- --------------------------------------------------------

--
-- Table structure for table `objectifs`
--

DROP TABLE IF EXISTS `objectifs`;
CREATE TABLE IF NOT EXISTS `objectifs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_archetype` int(11) NOT NULL,
  `id_item` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_archetype` (`id_archetype`),
  KEY `id_item` (`id_item`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `objectifs`
--

INSERT INTO `objectifs` (`id`, `id_archetype`, `id_item`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 6),
(4, 1, 17),
(5, 2, 7),
(6, 2, 4),
(7, 4, 3),
(8, 4, 15),
(9, 5, 18),
(10, 5, 10),
(11, 3, 9),
(12, 3, 5),
(13, 6, 5),
(14, 6, 11);

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE IF NOT EXISTS `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `libelle`) VALUES
(1, 'Que pensez-vous de notre village, Aventurier?'),
(2, 'Qu\'allez-vous faire ensuite?'),
(3, 'Avez-vous vu la fille du Chef du village?'),
(4, 'Où vas-tu comme ça l\'étranger?!'),
(5, 'Quel est ton plus grand désir aventurier?'),
(6, 'As-tu déjà connu la peur étranger?'),
(7, 'Holà qui va là?!'),
(8, 'Les dieux m\'ont parlé cette nuit! Le sais-tu?');

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
CREATE TABLE IF NOT EXISTS `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_marchand` int(11) NOT NULL,
  `id_question` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_marchand` (`id_marchand`),
  KEY `id_question` (`id_question`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`id`, `id_marchand`, `id_question`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 7),
(5, 2, 4),
(6, 2, 5),
(7, 2, 6),
(8, 2, 8);

-- --------------------------------------------------------

--
-- Table structure for table `reponse`
--

DROP TABLE IF EXISTS `reponse`;
CREATE TABLE IF NOT EXISTS `reponse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(100) NOT NULL,
  `valid` enum('0','1') NOT NULL COMMENT 'True or False',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reponse`
--

INSERT INTO `reponse` (`id`, `libelle`, `valid`) VALUES
(1, 'Charmant et rustisque comme je les aime', '0'),
(2, 'Petit mais convivial', '0'),
(3, 'Il sent un peu le souffre quand même', '1'),
(4, 'J\'irais exterminer les créatures démoniaques qui habitent ces terres!', '0'),
(5, 'J\'irais relever le défi du Labyrynthe d\'Elroe!', '0'),
(6, 'Je rentre à ma maison', '1'),
(7, 'Non, je n\'ai pas eu cet honneur', '1'),
(8, 'Oui, elle est belle et souriante', '0'),
(9, 'Elle m\'avait l\'air manipulatrice dérière son sourire hypocryte', '0'),
(10, 'Inspecteur Gadget! Go-go-gadgeto mawashi-geri dans les valseuses!', '1'),
(11, 'Je vais chez ta mère!', '1'),
(12, 'Je vais chez notre Père!', '0'),
(13, 'Je vais ceuillir des tulipes bleues, c\'est la saison parait-il', '0'),
(14, 'Oui, en ce moment meme je parle à quelque chose d\'effrayant', '0'),
(15, 'Non, jamais je n\'ai tremblé face au danger!', '0'),
(16, 'Bien sur! Et je peux même te l\'enseigner si tu insistes!', '1'),
(17, 'Fonder une famille et vivre paisiblement', '0'),
(18, 'Découvrir la vérité de ce monde', '1'),
(19, 'Combattre les injustices de la société', '0'),
(20, 'C\'est moi abruti', '0'),
(21, 'Juste un simple aventurier à la recherche d\'équipement de noob pour partir faire les quêtes niveau 1', '0'),
(22, 'Intéressant, fascinant, époustouflant! Non, c\'était surtout des stupéfiants!', '0'),
(23, 'Et qu\'on-t\'il bien pu dire à un pauvre bougre dans ton genre?', '1'),
(24, 'Tu mens pauvre fou!', '0');

-- --------------------------------------------------------

--
-- Table structure for table `reponses`
--

DROP TABLE IF EXISTS `reponses`;
CREATE TABLE IF NOT EXISTS `reponses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_question` int(11) NOT NULL,
  `id_reponse` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_question` (`id_question`),
  KEY `id_reponse` (`id_reponse`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reponses`
--

INSERT INTO `reponses` (`id`, `id_question`, `id_reponse`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 2, 4),
(5, 2, 5),
(6, 2, 6),
(7, 3, 7),
(8, 3, 8),
(9, 3, 9),
(10, 4, 11),
(11, 4, 12),
(12, 4, 13),
(13, 5, 17),
(14, 5, 18),
(15, 5, 19),
(16, 6, 14),
(17, 6, 15),
(18, 6, 16),
(19, 7, 10),
(20, 7, 20),
(21, 8, 22),
(22, 8, 23),
(23, 8, 24),
(24, 7, 21);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `catalogue`
--
ALTER TABLE `catalogue`
  ADD CONSTRAINT `catalogue_ibfk_1` FOREIGN KEY (`id_item`) REFERENCES `item` (`id`),
  ADD CONSTRAINT `catalogue_ibfk_2` FOREIGN KEY (`id_marchand`) REFERENCES `marchand` (`id`);

--
-- Constraints for table `inventaire`
--
ALTER TABLE `inventaire`
  ADD CONSTRAINT `inventaire_ibfk_1` FOREIGN KEY (`id_item`) REFERENCES `item` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `inventaire_ibfk_2` FOREIGN KEY (`id_joueur`) REFERENCES `joueur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `objectifs`
--
ALTER TABLE `objectifs`
  ADD CONSTRAINT `objectifs_ibfk_1` FOREIGN KEY (`id_archetype`) REFERENCES `archetype` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `objectifs_ibfk_2` FOREIGN KEY (`id_item`) REFERENCES `item` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `questions`
--
ALTER TABLE `questions`
  ADD CONSTRAINT `questions_ibfk_1` FOREIGN KEY (`id_marchand`) REFERENCES `marchand` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `questions_ibfk_2` FOREIGN KEY (`id_question`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `reponses`
--
ALTER TABLE `reponses`
  ADD CONSTRAINT `reponses_ibfk_1` FOREIGN KEY (`id_question`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reponses_ibfk_2` FOREIGN KEY (`id_reponse`) REFERENCES `reponse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
