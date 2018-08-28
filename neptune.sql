-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Ven 22 Juin 2018 à 14:00
-- Version du serveur :  5.7.22-0ubuntu0.16.04.1
-- Version de PHP :  7.0.30-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `neptune`
--
USE `neptune`;
-- --------------------------------------------------------

--
-- Structure de la table `chambres`
--

CREATE TABLE `chambres` (
  `numero` int(11) NOT NULL,
  `capacite` int(11) NOT NULL,
  `exposition` varchar(20) DEFAULT NULL,
  `douche` int(11) NOT NULL DEFAULT '0',
  `etage` int(11) NOT NULL,
  `tarif_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `chambres`
--

INSERT INTO `chambres` (`numero`, `capacite`, `exposition`, `douche`, `etage`, `tarif_id`) VALUES
(1, 2, 'port', 0, 1, 2),
(2, 4, 'rempart', 0, 1, 5),
(3, 2, 'port', 0, 1, 2),
(4, 2, 'rempart', 1, 1, 1),
(5, 2, 'port', 0, 2, 3),
(6, 3, 'rempart', 0, 2, 4),
(7, 3, 'port', 0, 2, 4),
(8, 2, 'rempart', 1, 2, 3),
(9, 2, 'port', 0, 3, 1),
(10, 2, 'rempart', 0, 3, 2),
(11, 2, 'port', 0, 3, 2),
(12, 4, 'port', 1, 3, 5);

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE `clients` (
  `id` int(11) NOT NULL,
  `civilite` varchar(20) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(70) NOT NULL,
  `adresse` varchar(200) DEFAULT NULL,
  `codePostal` varchar(10) DEFAULT NULL,
  `ville` varchar(200) DEFAULT NULL,
  `pays_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `clients`
--

INSERT INTO `clients` (`id`, `civilite`, `nom`, `prenom`, `adresse`, `codePostal`, `ville`, `pays_id`) VALUES
(1, 'Mademoiselle', 'DUMAS', 'Sandrine', '5 allée des Tilleuls', '75010', 'PARIS', 1),
(2, 'Monsieur', 'MORIN', 'Karl', 'North avenue 44', 'TW9 3', 'KEW', 2),
(3, 'Madame', 'MORIN', 'Joélle', '34 rue Saint Denis', '67000', 'STRASBOURG', 1),
(4, 'Mademoiselle', 'GAGNERON', 'Aurélie', '4 rue Laénnec', '01200', 'MONTANGES', 1),
(5, 'Madame', 'DULLAC', 'Martine', '4 allée André Malraux', '14100', 'LISIEUX', 1),
(6, 'Madame', 'DUPRE', 'Stéphanie', '87 rue Ernest Renan', '35480', 'GUIPRY', 1),
(7, 'Monsieur', 'BRIGAND', 'Maurice', '2 rue Louis Blériot', '35360', 'MONTAUBAN DE BRETAGNE', 1),
(8, 'Monsieur', 'VAN ELIT', 'Gérard', '27 rue Ambroise', '1000', 'BRUXELLES', 3),
(9, 'Monsieur', 'DESROSIERS', 'Antoine', '2 allée Antoinette', '53200', 'AZE', 1),
(10, 'Mademoiselle', 'DULLAC', 'Martine', '17 avenue Albert Camus', '35200', 'MARSEILLE', 1),
(11, 'Monsieur', 'LELONG', 'Magloire', '11 rue Paul Bert', '1000', 'BRUXELLES', 3),
(12, 'Monsieur', 'MALPAS', 'Julien', '16 rue Gambetta', '29000', 'BREST', 1),
(13, 'Monsieur', 'BRIGAND', 'Maurice', '46 rue Emile Zola', '30000', 'NIMES', 1),
(14, 'Madame', 'DESBOIS', 'Delphine', '8 Square des Ormeaux', '36000', 'CHATEAUROUX', 1),
(15, 'Mademoiselle', 'DUMARC', 'Sandrine', '31 rue André Desilles', '33000', 'BORDEAUX', 1),
(16, 'Monsieur', 'TAILLARD', 'Julien', 'La Chesnaie', '5570', 'WANCENNES', 3),
(17, 'Madame', 'LEGOFF', 'Franéoise', '11 rue des Peupliers', '29000', 'BREST', 1),
(18, 'Monsieur', 'BOURGE', 'Nicolas', 'Le Chéne Tord', '92340', 'BOURG LA REINE', 1),
(19, 'Madame', 'FRALIN', 'Emmanuelle', '4 rue Rabelais', '78650', 'BEYNES', 1),
(20, 'Mademoiselle', 'GARCIA', 'Mary', 'New road east 22', 'PO2 7', 'PORTSMOUTH', 2),
(21, 'Monsieur', 'FOULON', 'Yann', '7 Allée de Bréquigny', '72000', 'LE MANS', 1),
(22, 'Monsieur', 'FOURET', 'Samuel', '45 rue de lIse', '22000', 'SAINT BRIEUC', 1),
(23, 'Mademoiselle', 'GARRET', 'Guénola', '8 Square de Londres', '53000', 'LAVAL', 1),
(24, 'Madame', 'JAMOTEAU', 'Fabienne', '2 rue Saint Michel', '44000', 'NANTES', 1),
(25, 'Monsieur', 'ROUSSEAU', 'Damien', '1 Square du Douro', '02400', 'NOGENTEL', 1),
(26, 'Monsieur', 'AUBIER', 'Barnab', 'Les Ruelles', '35235', 'THORIGNE FOUILLARD', 1),
(27, 'Monsieur', 'HILARY', 'Lionel', '18 rue des Camélias', '54300', 'LUNEVILLE', 1),
(28, 'Madame', 'COIGNE', 'Katell', '11 rue de la Mare', '01100', 'APREMONT', 1),
(29, 'Monsieur', 'LINIZAN', 'Gérald', '19 rue Mozart', '35830', 'BETTON', 1),
(30, 'Monsieur', 'AUDUREAU', 'Manuel', '34 rue de Verdun', '34000', 'MONTPELLIER', 1),
(31, 'Monsieur', 'HERFROY', 'Sylvain', '2 rue Launay', '12200', 'SAVIGNAC', 1),
(32, 'Monsieur', 'COUPPE', 'Maxime', '42 rue César', '06000', 'NICE', 1),
(33, 'Monsieur', 'COULAIN', 'John', 'Porstmouth Street 23', 'SW1X', 'LONDON', 2),
(34, 'Madame', 'LEDUC', 'Christine', 'Villa des Résédas', '75003', 'PARIS', 1),
(35, 'Monsieur', 'MOREAU', 'Ludovic', '11 rue du Hétre', '35480', 'GUIPRY', 1),
(36, 'Mademoiselle', 'RACAPE', 'Sylvie', '8 Square du Douro', '02100', 'GRICOURT', 1),
(37, 'Monsieur', 'MALOUIN', 'Herv', '33 allée du Lac Onéga', '35200', 'MARSEILLE', 1),
(38, 'Madame', 'QUERE', 'Maryvonne', '28 rue de vern', '02000', 'URCEL', 1),
(39, 'Monsieur', 'ROULIER', 'Jean Paul', '6 avenue du Canada', '35200', 'RENNES', 1),
(40, 'Mademoiselle', 'SEVEZAN', 'Michelle', 'Albert road north 6', 'S0145', 'SOUTHAMPTON', 2),
(41, 'Monsieur', 'LESTER', 'Ted', 'Beechin wood lane 6', 'TN158', 'PLATT', 2),
(42, 'Madame', 'MONTEREL', 'Sonia', 'Castle Road 3', 'SW1B', 'LONDON', 2),
(43, 'Monsieur', 'GICQUEL', 'Bruno', '64 rue Albert Camus', '25230', 'DASLE', 1),
(44, 'Mademoiselle', 'COUPPEY', 'Corinne', 'Roding lane north 54', 'IG88', 'LONDON', 2),
(45, 'Madame', 'CADOREL', 'Louise', '23 route de Lorient', '03500', 'MONTORD', 1),
(46, 'Monsieur', 'VIGNER', 'Jean Luc', '43 rue Etienne Pinault', '13000', 'MARSEILLE', 1),
(47, 'Madame', 'COUSTOM', 'Colleen', 'Dapholdils Street 4', 'BD1', 'MARSH', 2),
(48, 'Mademoiselle', 'LEBLE', 'Séverine', '65 rue des Foss', '75012', 'PARIS', 1),
(49, 'Monsieur', 'LEGOFF', 'Pierre', 'Gand Platze 4', '8000', 'ZURICH', 4),
(50, 'Monsieur', 'LESCOUARN', 'Claude', '22 allée de Varsovie', '35200', 'RENNES', 1),
(51, 'Monsieur', 'AUDUREAU', 'Gildas', 'Les Ruelles', '04500', 'RIEZ', 1),
(52, 'Monsieur', 'BOURGE', 'Manuel', '34 rue de Verdun', '92500', 'RUEIL MALMAISON', 1),
(53, 'Monsieur', 'BRIGAND', 'Nicolas', 'Le Chéne Tord', '1000', 'LAUSANNE', 4),
(54, 'Monsieur', 'BRIGAND', 'Maurice', '2 rue Louis Blériot', '59000', 'LILLE', 1),
(55, 'Monsieur', 'CADOREL', 'Maurice', 'Emilian Strasse 67', '8000', 'ZURICH', 4),
(56, 'Monsieur', 'COIGNE', 'Ludovic', '23 route de Lorient', '35700', 'RENNES', 1),
(57, 'Monsieur', 'COULARON', 'Killian', '11 rue de la Mare', '35250', 'ST MEDARD/ILLE', 1),
(58, 'Monsieur', 'MARTIN', 'Peter', 'Upper new road 56', 'SO303', 'SOUTHAMPTON', 2),
(59, 'Monsieur', 'COUPPEY', 'Maxime', '42 rue César', '01000', 'BOURG EN BRESSE', 1),
(60, 'Monsieur', 'COUSSOT', 'Corentin', 'New george street 1', 'PL11', 'PLYMOUTH', 2),
(61, 'Monsieur', 'DAUMAS', 'Colin', '4 allée du Dauphin', '35000', 'RENNES', 1),
(62, 'Monsieur', 'DESBOIS', 'Stéphane', '5 allée des Tilleuls', '75005', 'PARIS', 1),
(63, 'Monsieur', 'DESROSIERS', 'Didier', '8 Square des Ormeaux', '91100', 'CORBEIL ESSONNES', 1),
(64, 'Monsieur', 'DULLAC', 'Antoine', '2 allée Antoinette', '35520', 'GUICHEN', 1),
(65, 'Monsieur', 'DULLAC', 'Martin', '4 allée André Malraux', '35150', 'CORPS NUDS', 1),
(66, 'Monsieur', 'DUMARC', 'Martin', '17 avenue Albert Camus', '37220', 'TROGUES', 1),
(67, 'Monsieur', 'DUMAS', 'Stéphane', '31 rue André Desilles', '35000', 'RENNES', 1),
(68, 'Monsieur', 'LOUMAS', 'Geoffroy', '5 allée des Tilleuls', '75001', 'PARIS', 1),
(69, 'Monsieur', 'DESPRE', 'Stéphane', '87 rue Ernest Renan', '14400', 'CUSSY', 1),
(70, 'Monsieur', 'COULON', 'Yann', '7 Allée de Bréquigny', '92400', 'COURBEVOIE', 1),
(71, 'Monsieur', 'LOURET', 'Samuel', '45 rue de lIse', '14000', 'CAEN', 1),
(72, 'Monsieur', 'GRALIN', 'Emmanuel', '4 rue Rabelais', '35250', 'ST MEDARD/ILLE', 1),
(73, 'Monsieur', 'SAGER', 'Aurélien', '4 rue Laénnec', '37150', 'CHENONCEAUX', 1),
(74, 'Monsieur', 'GRANDOLE', 'Paul', 'North down crescent 9', 'PL22', 'PLYMOUTH', 2),
(75, 'Monsieur', 'BARRET', 'Gweltaz', '8 Square de Londres', '33000', 'BORDEAUX', 1),
(76, 'Monsieur', 'PIGEON', 'Bruno', '64 rue Albert Camus', '35230', 'CREVIN', 1),
(77, 'Monsieur', 'GEFFROY', 'Laurent', '2 rue Launay', '35850', 'GEVEZE', 1),
(78, 'Monsieur', 'JULIEN', 'Lionel', '18 rue des Camélias', '43000', 'POLIGNAC', 1),
(79, 'Monsieur', 'FRAME', 'Charly', 'Pine view 10', 'TN158', 'PLATT', 2),
(80, 'Monsieur', 'LEGORGE', 'Sébastien', '65 rue des Foss', '35850', 'GEVEZE', 1),
(81, 'Monsieur', 'DURAND', 'Christian', 'Villa des Résédas', '35830', 'PARIS', 1),
(82, 'Monsieur', 'FERNIER', 'Thierry', '23 rue Barthou', '8957', 'MESSINES', 3),
(83, 'Monsieur', 'DEGOUIS', 'Franéois', '11 rue des Peupliers', '75001', 'PARIS', 1),
(84, 'Monsieur', 'SERFE', 'Pierre', '11 lot des Peupliers', '1000', 'LAUSANNE', 4),
(85, 'Monsieur', 'DULONG', 'Magloire', '11 rue Paul Bert', '27000', 'EVREUX', 1),
(86, 'Monsieur', 'MESCOUARN', 'Claude', '22 allée de Varsovie', '27100', 'VAL DE REUIL', 1),
(87, 'Monsieur', 'INIZAN', 'Gérald', '19 rue Mozart', '75001', 'PARIS', 1),
(88, 'Monsieur', 'FALOUIN', 'Herv', '33 allée du Lac Onéga', '27200', 'VERNON', 1),
(89, 'Monsieur', 'MOBAL', 'Jude', 'Row lane 23', 'PL52', 'PLYMOUTH', 2),
(90, 'Monsieur', 'MONTHUREL', 'Simon', '3 Quai Chateaubriand', '67500', 'HAGUENAU', 1),
(91, 'Monsieur', 'POREL', 'Ludovic', '11 rue du Hétre', '14250', 'BROUAY', 1),
(92, 'Monsieur', 'NOUE', 'Herv', '44 rue Saint Denis', '27300', 'BERNAY', 1),
(93, 'Monsieur', 'CHARLES', 'Julien', '44 rue Saint Denis', '35000', 'RENNES', 1),
(94, 'Monsieur', 'BERDIER', 'Marc', '28 rue de vern', '35000', 'RENNES', 1),
(95, 'Monsieur', 'BADELOIS', 'Sylvain', '8 Square du Douro', '35200', 'RENNES', 1),
(96, 'Monsieur', 'ROULLER', 'Jean Paul', '6 avenue du Canada', '35200', 'RENNES', 1),
(97, 'Monsieur', 'MONTVOL', 'Damien', '1 Square du Douro', '35200', 'RENNES', 1),
(98, 'Monsieur', 'VERSER', 'Martin', 'Clare hill 8', 'KT109', 'LONDON', 2),
(99, 'Monsieur', 'MAILLARD', 'Julien', 'La Chesnaie', '33150', 'CENON', 1),
(100, 'Monsieur', 'BANELIER', 'Gérard', '27 rue Ambroise', '6978', 'GANDRIA', 4),
(101, 'Monsieur', 'BIHAN', 'Martin', 'Eastend avenue 43', 'OX2', 'TUSMORE', 2),
(102, 'Monsieur', 'AUDUREAU', 'Barnab', 'Les Ruelles', '35235', 'THORIGNE FOUILLARD', 1),
(103, 'Monsieur', 'BOURGE', 'Manuel', '34 rue de Verdun', '72150', 'COURDEMANCHE', 1),
(104, 'Monsieur', 'BRIGAND', 'Nicolas', 'Les Mélézes', '1875', 'MORGINS', 4),
(105, 'Monsieur', 'BRIGAND', 'Maurice', '2 rue Louis Blériot', '35360', 'MONTAUBAN DE BRETAGNE', 1),
(106, 'Monsieur', 'CADOREL', 'Maurice', '46 rue Emile Zola', '35170', 'BRUZ', 1),
(107, 'Monsieur', 'COIGNE', 'Louis', '23 route de Lorient', '78250', 'MEULAN', 1),
(108, 'Monsieur', 'COULARON', 'Killian', '11 rue de la Mare', '54000', 'NANCY', 1),
(109, 'Monsieur', 'COUPPLE', 'John', 'Sunnyside road north 23', 'N99', 'LONDON', 2),
(110, 'Monsieur', 'COUPPEY', 'Maxime', '42 rue César', '92300', 'LEVALLOIS PERRET', 1),
(111, 'Monsieur', 'BOURN', 'Peter', 'Lichfield drive 5', 'LE84', 'BLABY', 2),
(112, 'Monsieur', 'DAUMAS', 'Pol', '4 allée du Dauphin', '29100', 'DOUARNENEZ', 1),
(113, 'Monsieur', 'DESBOIS', 'Stéphane', '5 allée des Tilleuls', '1200', 'GENEVE', 4),
(114, 'Monsieur', 'DESROSIERS', 'Donatien', '8 Square des Ormeaux', '44150', 'ANCENIS', 1),
(115, 'Monsieur', 'DULLAC', 'Antoine', '2 allée Antoinette', '66150', 'ARLES SUR TECH', 1),
(116, 'Monsieur', 'DULLAC', 'Karim', '4 allée André Malraux', '14200', 'HEROUVILLE SAINT CLAIR', 1),
(117, 'Monsieur', 'DUMARC', 'Martin', '17 avenue Albert Camus', '92200', 'NEUILLY SUR SEINE', 1),
(118, 'Monsieur', 'DUMMORE', 'Sam', 'Albert road north 7', 'SO303', 'SOUTHAMPTON', 2),
(119, 'Monsieur', 'LOUMAS', 'Erwann', '5 allée des Tilleuls', '75001', 'PARIS', 1),
(120, 'Monsieur', 'DESPRE', 'Stéphane', '87 rue Ernest Renan', '22100', 'LANVALLAY', 1),
(121, 'Monsieur', 'COULON', 'Yann', '7 Allée de Bréquigny', '78350', 'JOUY EN JOSAS', 1),
(122, 'Monsieur', 'LOURET', 'Samuel', '45 rue de lIse', '35150', 'CORPS NUDS', 1),
(123, 'Monsieur', 'GRALIN', 'Emmanuel', '4 rue Rabelais', '72150', 'BRIVES', 1),
(124, 'Monsieur', 'SAGER', 'Aurélien', '4 rue Laénnec', '85100', 'LES SABLES DOLONNE', 1),
(125, 'Monsieur', 'GRADOLE', 'Aston', 'Little town square 22', 'BD1', 'MARSH', 2),
(126, 'Monsieur', 'BARRET', 'Gurvan', '8 Square de Londres', '26000', 'VALENCE', 1),
(127, 'Monsieur', 'PIGEON', 'Bruno', '64 rue Albert Camus', '35510', 'CHATEAUGIRON', 1),
(128, 'Monsieur', 'GEFFROY', 'Lillian', '2 rue Launay', '11000', 'CARCASSONNE', 1),
(129, 'Monsieur', 'JULIEN', 'Lionel', '18 rue des Camélias', '63000', 'CLERMONT FERRAND', 1),
(130, 'Monsieur', 'FOSTER', 'Michael', 'Tudor Court north 2', 'NW10', 'LONDON', 2),
(131, 'Monsieur', 'LEGORGE', 'Steven', '65 rue des Foss', '35400', 'PARAME', 1),
(132, 'Monsieur', 'DURAND', 'Christian', 'Villa des Résédas', '35830', 'BETTON', 1),
(133, 'Monsieur', 'FERNER', 'Tod', 'North avenue 4', 'PO29', 'PORTSMOUTH', 2),
(134, 'Monsieur', 'DEGOUIS', 'Franéois', '11 rue des Peupliers', '75001', 'PARIS', 1),
(135, 'Monsieur', 'SCIONS', 'Pierre', '23 lot des Peupliers', '1200', 'GENEVE', 4),
(136, 'Monsieur', 'DULONG', 'Florent', '11 rue Paul Bert', '26100', 'ROMANS SUR ISERE', 1),
(137, 'Monsieur', 'MESCOUARN', 'Claude', '22 allée de Varsovie', '27400', 'CANAPPEVILLE', 1),
(138, 'Monsieur', 'INIZAN', 'Gérald', '19 rue Mozart', '750016', 'PARIS', 1),
(139, 'Monsieur', 'FALOUIN', 'Herv', '33 allée du Lac Onéga', '03100', 'MONTLUCON', 1),
(140, 'Monsieur', 'MOBAL', 'Justin', 'All Road south 12', 'SO303', 'SOUTHAMPTON', 2),
(141, 'Madame', 'MONTHUREL', 'Simone', '3 Quai Chateaubriand', '37000', 'TOURS', 1),
(142, 'Madame', 'POREL', 'Lucie', '11 rue du Hétre', '85000', 'LA ROCHE SUR YON', 1),
(143, 'Mademoiselle', 'NOUE', 'Hermine', '44 rue Saint Denis', '10300', 'SAINTE SAVINE', 1),
(144, 'Mademoiselle', 'CHARLES', 'Joélle', '44 rue Saint Denis', '10200', 'DOLANCOURT', 1),
(145, 'Mademoiselle', 'BERDIER', 'Maryvonne', '28 rue de vern', '10100', 'CRANCEY', 1),
(146, 'Mademoiselle', 'BADELOIS', 'Sylvie', '8 Square du Douro', '35200', 'RENNES', 1),
(147, 'Mademoiselle', 'ROULLER', 'Jeannette', '6 avenue du Canada', '35200', 'RENNES', 1),
(148, 'Mademoiselle', 'MONTVOL', 'Doris', '1 Square du Douro', '35200', 'RENNES', 1),
(149, 'Mademoiselle', 'VOUCHER', 'Martine', 'Queen Mary Road 43', 'PL11', 'PLYMOUTH', 2),
(150, 'Mademoiselle', 'MAILLARD', 'Julie', 'La Chesnaie', '06000', 'NICE', 1),
(151, 'Mademoiselle', 'BANELIER', 'Géraldine', '27 rue Ambroise', '35170', 'BRUZ', 1),
(152, 'Mademoiselle', 'BIHAN', 'Juliette', '43 rue Etienne Pinault', '35000', 'RENNES', 1),
(153, 'Mademoiselle', 'BADELOIS', 'Sylvie', '9 Square du Douro', '35200', 'RENNES', 1),
(154, 'Mademoiselle', 'ROULLER', 'Judith', '7 avenue du Canada', '35200', 'RENNES', 1),
(155, 'Mademoiselle', 'MONTVOL', 'Damiana', '2 Square du Douro', '35200', 'RENNES', 1),
(156, 'Mademoiselle', 'VYRSER', 'Julia', 'Queen Street 9', 'OX2', 'TUSMORE', 2),
(157, 'Mademoiselle', 'MAILLARD', 'Julie', 'La Chesnaie', '35235', 'THORIGNE FOUILLARD', 1),
(158, 'Mademoiselle', 'BANELIER', 'Garance', '28 rue Ambroise', '1200', 'GENEVE', 4);

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

CREATE TABLE `pays` (
  `id` int(11) NOT NULL,
  `nom` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `pays`
--

INSERT INTO `pays` (`id`, `nom`) VALUES
(1, 'France'),
(2, 'Grande-Bretagne'),
(3, 'Belgique'),
(4, 'Suisse');

-- --------------------------------------------------------

--
-- Structure de la table `planning`
--

CREATE TABLE `planning` (
  `chambre_numero` int(11) DEFAULT NULL,
  `jour` datetime DEFAULT NULL,
  `reservation` int(11) NOT NULL DEFAULT '0',
  `paye` int(11) NOT NULL DEFAULT '0',
  `client_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `planning`
--

INSERT INTO `planning` (`chambre_numero`, `jour`, `reservation`, `paye`, `client_id`) VALUES
(1, '2018-03-19 00:00:00', -1, -1, 92),
(1, '2018-03-20 00:00:00', -1, -1, 106),
(1, '2018-04-24 00:00:00', -1, -1, 113),
(1, '2018-04-25 00:00:00', 0, -1, 59),
(1, '2018-04-28 00:00:00', -1, -1, 88),
(1, '2018-06-02 00:00:00', -1, -1, 21),
(1, '2018-07-01 00:00:00', 0, -1, 119),
(1, '2018-07-02 00:00:00', -1, -1, 138),
(1, '2018-07-03 00:00:00', -1, 0, 130),
(1, '2018-07-04 00:00:00', -1, -1, 147),
(1, '2018-07-05 00:00:00', -1, -1, 34),
(1, '2018-07-06 00:00:00', -1, -1, 34),
(1, '2018-07-07 00:00:00', -1, -1, 34),
(1, '2018-07-20 00:00:00', -1, 0, 106),
(1, '2018-07-21 00:00:00', -1, 0, 103),
(1, '2018-07-29 00:00:00', 0, -1, 1),
(1, '2018-08-05 00:00:00', -1, -1, 151),
(1, '2018-08-06 00:00:00', -1, -1, 152),
(1, '2018-08-07 00:00:00', -1, -1, 152),
(1, '2018-10-01 00:00:00', -1, -1, 13),
(1, '2018-10-04 00:00:00', -1, -1, 30),
(1, '2018-10-08 00:00:00', -1, -1, 46),
(1, '2018-10-09 00:00:00', 0, -1, 43),
(1, '2018-10-11 00:00:00', -1, -1, 53),
(1, '2018-10-12 00:00:00', -1, -1, 53),
(1, '2018-10-18 00:00:00', -1, -1, 92),
(1, '2018-10-21 00:00:00', 0, -1, 103),
(1, '2018-10-23 00:00:00', -1, -1, 113),
(1, '2018-10-26 00:00:00', -1, -1, 71),
(1, '2018-10-27 00:00:00', -1, -1, 79),
(1, '2018-10-29 00:00:00', -1, -1, 92),
(10, '2018-07-01 00:00:00', -1, -1, 128),
(10, '2018-07-02 00:00:00', 0, -1, 144),
(10, '2018-07-03 00:00:00', -1, -1, 128),
(10, '2018-07-21 00:00:00', -1, 0, 112),
(10, '2018-08-20 00:00:00', -1, -1, 114),
(10, '2018-08-25 00:00:00', -1, -1, 68),
(10, '2018-10-01 00:00:00', -1, -1, 10),
(10, '2018-10-02 00:00:00', 0, -1, 27),
(10, '2018-10-03 00:00:00', -1, -1, 10),
(10, '2018-10-08 00:00:00', -1, -1, 54),
(10, '2018-10-09 00:00:00', 0, -1, 52),
(10, '2018-10-21 00:00:00', 0, -1, 112),
(10, '2018-10-26 00:00:00', -1, -1, 68),
(10, '2018-10-27 00:00:00', 0, -1, 85),
(11, '2018-07-01 00:00:00', 0, -1, 129),
(11, '2018-07-02 00:00:00', -1, -1, 145),
(11, '2018-07-03 00:00:00', 0, -1, 11),
(11, '2018-07-04 00:00:00', -1, -1, 137),
(11, '2018-07-20 00:00:00', 0, -1, 115),
(11, '2018-10-01 00:00:00', -1, -1, 20),
(11, '2018-10-02 00:00:00', -1, -1, 28),
(11, '2018-10-08 00:00:00', 0, -1, 55),
(11, '2018-10-25 00:00:00', 0, -1, 69),
(11, '2018-10-26 00:00:00', -1, -1, 78),
(11, '2018-10-27 00:00:00', -1, -1, 86),
(12, '2018-07-01 00:00:00', 0, -1, 129),
(12, '2018-07-02 00:00:00', 0, -1, 146),
(12, '2018-07-08 00:00:00', -1, -1, 42),
(12, '2018-07-20 00:00:00', -1, 0, 101),
(12, '2018-07-21 00:00:00', -1, 0, 101),
(12, '2018-07-22 00:00:00', -1, -1, 101),
(12, '2018-07-25 00:00:00', -1, 0, 101),
(12, '2018-07-27 00:00:00', -1, -1, 101),
(12, '2018-10-01 00:00:00', 0, -1, 12),
(12, '2018-10-02 00:00:00', 0, -1, 29),
(12, '2018-10-09 00:00:00', -1, -1, 42),
(12, '2018-10-10 00:00:00', -1, -1, 42),
(12, '2018-10-21 00:00:00', -1, -1, 101),
(12, '2018-10-25 00:00:00', -1, -1, 70),
(12, '2018-10-27 00:00:00', 0, -1, 87),
(2, '2018-07-01 00:00:00', -1, -1, 120),
(2, '2018-07-02 00:00:00', 0, -1, 139),
(2, '2018-07-04 00:00:00', 0, -1, 148),
(2, '2018-07-05 00:00:00', -1, -1, 131),
(2, '2018-07-20 00:00:00', -1, 0, 107),
(2, '2018-07-21 00:00:00', -1, 0, 104),
(2, '2018-08-03 00:00:00', -1, -1, 2),
(2, '2018-08-09 00:00:00', 0, -1, 44),
(2, '2018-08-20 00:00:00', 0, -1, 107),
(2, '2018-08-25 00:00:00', -1, -1, 60),
(2, '2018-08-26 00:00:00', -1, -1, 72),
(2, '2018-10-01 00:00:00', -1, -1, 14),
(2, '2018-10-02 00:00:00', 0, -1, 22),
(2, '2018-10-04 00:00:00', 0, -1, 31),
(2, '2018-10-08 00:00:00', 0, -1, 47),
(2, '2018-10-12 00:00:00', -1, -1, 58),
(2, '2018-10-21 00:00:00', 0, -1, 104),
(2, '2018-10-24 00:00:00', -1, -1, 118),
(2, '2018-10-27 00:00:00', 0, -1, 80),
(2, '2018-10-28 00:00:00', 0, -1, 89),
(3, '2018-07-02 00:00:00', -1, -1, 140),
(3, '2018-07-03 00:00:00', 0, -1, 132),
(3, '2018-07-18 00:00:00', 0, -1, 99),
(3, '2018-07-19 00:00:00', -1, 0, 100),
(3, '2018-07-20 00:00:00', -1, 0, 100),
(3, '2018-07-21 00:00:00', -1, 0, 105),
(3, '2018-07-27 00:00:00', -1, -1, 81),
(3, '2018-07-29 00:00:00', -1, 0, 93),
(3, '2018-08-01 00:00:00', 0, -1, 121),
(3, '2018-08-04 00:00:00', 0, -1, 149),
(3, '2018-08-05 00:00:00', 0, -1, 153),
(3, '2018-08-06 00:00:00', 0, -1, 158),
(3, '2018-08-19 00:00:00', 0, -1, 100),
(3, '2018-08-23 00:00:00', -1, -1, 114),
(3, '2018-08-26 00:00:00', 0, -1, 73),
(3, '2018-08-28 00:00:00', 0, -1, 90),
(3, '2018-10-01 00:00:00', 0, -1, 15),
(3, '2018-10-02 00:00:00', -1, -1, 23),
(3, '2018-10-03 00:00:00', 0, -1, 3),
(3, '2018-10-04 00:00:00', 0, -1, 32),
(3, '2018-10-05 00:00:00', 0, -1, 35),
(3, '2018-10-06 00:00:00', 0, -1, 40),
(3, '2018-10-07 00:00:00', 0, -1, 41),
(3, '2018-10-08 00:00:00', 0, -1, 41),
(3, '2018-10-09 00:00:00', 0, -1, 45),
(3, '2018-10-11 00:00:00', -1, -1, 54),
(3, '2018-10-12 00:00:00', -1, -1, 54),
(3, '2018-10-18 00:00:00', 0, -1, 99),
(3, '2018-10-20 00:00:00', 0, -1, 100),
(3, '2018-10-21 00:00:00', 0, -1, 105),
(3, '2018-10-24 00:00:00', -1, -1, 114),
(3, '2018-10-25 00:00:00', 0, -1, 61),
(3, '2018-10-29 00:00:00', 0, -1, 93),
(4, '2018-03-09 00:00:00', 0, -1, 46),
(4, '2018-04-21 00:00:00', 0, -1, 106),
(4, '2018-04-23 00:00:00', -1, -1, 115),
(4, '2018-04-24 00:00:00', -1, -1, 115),
(4, '2018-04-25 00:00:00', -1, -1, 62),
(4, '2018-04-26 00:00:00', -1, -1, 62),
(4, '2018-07-01 00:00:00', -1, -1, 122),
(4, '2018-07-03 00:00:00', -1, -1, 122),
(4, '2018-07-05 00:00:00', 0, -1, 154),
(4, '2018-07-15 00:00:00', 0, -1, 36),
(4, '2018-07-20 00:00:00', -1, 0, 108),
(4, '2018-08-02 00:00:00', -1, -1, 122),
(4, '2018-08-03 00:00:00', -1, -1, 4),
(4, '2018-08-19 00:00:00', -1, 0, 102),
(4, '2018-08-21 00:00:00', -1, 0, 106),
(4, '2018-08-29 00:00:00', -1, 0, 94),
(4, '2018-10-01 00:00:00', -1, -1, 4),
(4, '2018-10-02 00:00:00', -1, -1, 4),
(4, '2018-10-07 00:00:00', 0, -1, 43),
(4, '2018-10-08 00:00:00', -1, -1, 48),
(4, '2018-10-11 00:00:00', -1, -1, 55),
(4, '2018-10-12 00:00:00', -1, -1, 55),
(4, '2018-10-19 00:00:00', 0, -1, 102),
(4, '2018-10-20 00:00:00', -1, -1, 108),
(4, '2018-10-27 00:00:00', -1, -1, 62),
(4, '2018-10-28 00:00:00', -1, -1, 74),
(4, '2018-10-29 00:00:00', 0, -1, 94),
(5, '2018-04-03 00:00:00', -1, -1, 133),
(5, '2018-04-05 00:00:00', -1, -1, 155),
(5, '2018-04-18 00:00:00', -1, -1, 96),
(5, '2018-04-19 00:00:00', -1, 0, 104),
(5, '2018-04-20 00:00:00', -1, 0, 109),
(5, '2018-04-29 00:00:00', -1, 0, 95),
(5, '2018-07-01 00:00:00', 0, -1, 123),
(5, '2018-07-02 00:00:00', -1, -1, 133),
(5, '2018-08-04 00:00:00', -1, -1, 133),
(5, '2018-08-06 00:00:00', -1, -1, 155),
(5, '2018-08-07 00:00:00', -1, -1, 133),
(5, '2018-08-21 00:00:00', -1, 0, 107),
(5, '2018-10-01 00:00:00', -1, -1, 16),
(5, '2018-10-02 00:00:00', -1, -1, 16),
(5, '2018-10-03 00:00:00', -1, -1, 16),
(5, '2018-10-04 00:00:00', -1, -1, 16),
(5, '2018-10-05 00:00:00', -1, -1, 37),
(5, '2018-10-06 00:00:00', -1, -1, 37),
(5, '2018-10-07 00:00:00', 0, -1, 44),
(5, '2018-10-08 00:00:00', 0, -1, 49),
(5, '2018-10-09 00:00:00', 0, -1, 47),
(5, '2018-10-10 00:00:00', 0, -1, 5),
(5, '2018-10-11 00:00:00', -1, -1, 56),
(5, '2018-10-18 00:00:00', -1, -1, 96),
(5, '2018-10-19 00:00:00', 0, -1, 104),
(5, '2018-10-20 00:00:00', 0, -1, 109),
(5, '2018-10-21 00:00:00', 0, -1, 107),
(5, '2018-10-23 00:00:00', -1, -1, 116),
(5, '2018-10-25 00:00:00', 0, -1, 63),
(5, '2018-10-26 00:00:00', -1, -1, 74),
(5, '2018-10-27 00:00:00', -1, -1, 74),
(5, '2018-10-28 00:00:00', -1, -1, 74),
(5, '2018-10-29 00:00:00', -1, -1, 95),
(6, '2018-04-01 00:00:00', 0, -1, 124),
(6, '2018-04-20 00:00:00', -1, 0, 110),
(6, '2018-04-21 00:00:00', -1, 0, 135),
(6, '2018-08-02 00:00:00', 0, -1, 141),
(6, '2018-10-01 00:00:00', 0, -1, 6),
(6, '2018-10-02 00:00:00', 0, -1, 24),
(6, '2018-10-08 00:00:00', -1, -1, 50),
(6, '2018-10-09 00:00:00', 0, -1, 48),
(6, '2018-10-20 00:00:00', -1, -1, 110),
(6, '2018-10-21 00:00:00', 0, -1, 18),
(6, '2018-10-25 00:00:00', 0, -1, 64),
(6, '2018-10-27 00:00:00', 0, -1, 82),
(7, '2018-04-02 00:00:00', 0, -1, 135),
(7, '2018-04-19 00:00:00', -1, 0, 105),
(7, '2018-04-21 00:00:00', -1, 0, 109),
(7, '2018-08-01 00:00:00', -1, -1, 125),
(7, '2018-08-03 00:00:00', 0, -1, 135),
(7, '2018-08-20 00:00:00', -1, 0, 111),
(7, '2018-10-01 00:00:00', 0, -1, 18),
(7, '2018-10-02 00:00:00', 0, -1, 18),
(7, '2018-10-03 00:00:00', -1, -1, 7),
(7, '2018-10-07 00:00:00', 0, -1, 45),
(7, '2018-10-08 00:00:00', 0, -1, 51),
(7, '2018-10-09 00:00:00', 0, -1, 49),
(7, '2018-10-19 00:00:00', 0, -1, 105),
(7, '2018-10-20 00:00:00', 0, -1, 111),
(7, '2018-10-21 00:00:00', 0, -1, 109),
(7, '2018-10-25 00:00:00', -1, -1, 65),
(7, '2018-10-26 00:00:00', 0, -1, 76),
(7, '2018-10-27 00:00:00', 0, -1, 76),
(8, '2018-04-02 00:00:00', 0, -1, 142),
(8, '2018-04-04 00:00:00', 0, -1, 134),
(8, '2018-04-05 00:00:00', -1, -1, 157),
(8, '2018-04-07 00:00:00', -1, -1, 157),
(8, '2018-04-19 00:00:00', -1, 0, 98),
(8, '2018-04-21 00:00:00', -1, 0, 110),
(8, '2018-08-01 00:00:00', -1, -1, 126),
(8, '2018-08-03 00:00:00', -1, -1, 136),
(8, '2018-08-06 00:00:00', -1, -1, 157),
(8, '2018-08-18 00:00:00', -1, -1, 98),
(8, '2018-08-29 00:00:00', -1, 0, 98),
(8, '2018-10-01 00:00:00', -1, -1, 19),
(8, '2018-10-02 00:00:00', 0, -1, 25),
(8, '2018-10-03 00:00:00', -1, -1, 8),
(8, '2018-10-04 00:00:00', 0, -1, 17),
(8, '2018-10-05 00:00:00', -1, -1, 39),
(8, '2018-10-06 00:00:00', -1, -1, 39),
(8, '2018-10-07 00:00:00', -1, -1, 39),
(8, '2018-10-08 00:00:00', -1, -1, 52),
(8, '2018-10-09 00:00:00', 0, -1, 50),
(8, '2018-10-11 00:00:00', -1, -1, 57),
(8, '2018-10-18 00:00:00', -1, -1, 98),
(8, '2018-10-19 00:00:00', -1, -1, 98),
(8, '2018-10-20 00:00:00', -1, -1, 112),
(8, '2018-10-21 00:00:00', 0, -1, 110),
(8, '2018-10-23 00:00:00', -1, -1, 117),
(8, '2018-10-25 00:00:00', -1, -1, 66),
(8, '2018-10-26 00:00:00', -1, -1, 77),
(8, '2018-10-27 00:00:00', 0, -1, 83),
(8, '2018-10-28 00:00:00', 0, -1, 75),
(8, '2018-10-29 00:00:00', -1, -1, 98),
(9, '2018-04-01 00:00:00', 0, -1, 127),
(9, '2018-04-06 00:00:00', 0, -1, 156),
(9, '2018-08-02 00:00:00', -1, -1, 143),
(9, '2018-08-03 00:00:00', 0, 0, 136),
(9, '2018-08-04 00:00:00', -1, -1, 150),
(9, '2018-08-05 00:00:00', 0, -1, 156),
(9, '2018-08-18 00:00:00', 0, -1, 97),
(9, '2018-08-21 00:00:00', -1, 0, 111),
(9, '2018-08-29 00:00:00', 0, 0, 97),
(9, '2018-10-01 00:00:00', 0, -1, 19),
(9, '2018-10-02 00:00:00', -1, -1, 26),
(9, '2018-10-04 00:00:00', -1, -1, 33),
(9, '2018-10-05 00:00:00', 0, -1, 38),
(9, '2018-10-06 00:00:00', 0, -1, 38),
(9, '2018-10-08 00:00:00', 0, -1, 53),
(9, '2018-10-09 00:00:00', 0, -1, 51),
(9, '2018-10-18 00:00:00', 0, -1, 97),
(9, '2018-10-20 00:00:00', 0, -1, 113),
(9, '2018-10-21 00:00:00', 0, -1, 111),
(9, '2018-10-25 00:00:00', 0, -1, 67),
(9, '2018-10-26 00:00:00', 0, -1, 77),
(9, '2018-10-27 00:00:00', -1, -1, 84),
(9, '2018-10-28 00:00:00', -1, -1, 91),
(9, '2018-10-29 00:00:00', 0, -1, 97);

-- --------------------------------------------------------

--
-- Structure de la table `tarifs`
--

CREATE TABLE `tarifs` (
  `id` int(11) NOT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tarifs`
--

INSERT INTO `tarifs` (`id`, `prix`) VALUES
(1, 38),
(2, 49),
(3, 53),
(4, 58),
(5, 68);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `chambres`
--
ALTER TABLE `chambres`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `chambres_tarifs_id_fk` (`tarif_id`);

--
-- Index pour la table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`),
  ADD KEY `clients_pays_id_fk` (`pays_id`);

--
-- Index pour la table `pays`
--
ALTER TABLE `pays`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `planning`
--
ALTER TABLE `planning`
  ADD UNIQUE KEY `planning_chambre_numero_client_id_jour_pk` (`chambre_numero`,`client_id`,`jour`),
  ADD KEY `planning_clients_id_fk` (`client_id`);

--
-- Index pour la table `tarifs`
--
ALTER TABLE `tarifs`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `chambres`
--
ALTER TABLE `chambres`
  MODIFY `numero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT pour la table `clients`
--
ALTER TABLE `clients`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=159;
--
-- AUTO_INCREMENT pour la table `pays`
--
ALTER TABLE `pays`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `tarifs`
--
ALTER TABLE `tarifs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `chambres`
--
ALTER TABLE `chambres`
  ADD CONSTRAINT `chambres_tarifs_id_fk` FOREIGN KEY (`tarif_id`) REFERENCES `tarifs` (`id`);

--
-- Contraintes pour la table `clients`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `clients_pays_id_fk` FOREIGN KEY (`pays_id`) REFERENCES `pays` (`id`);

--
-- Contraintes pour la table `planning`
--
ALTER TABLE `planning`
  ADD CONSTRAINT `planning_chambres_numero_fk` FOREIGN KEY (`chambre_numero`) REFERENCES `chambres` (`numero`),
  ADD CONSTRAINT `planning_clients_id_fk` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
