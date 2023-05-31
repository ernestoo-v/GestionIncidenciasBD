-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-05-2023 a las 11:12:09
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdincidencias`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteIncidencia` (IN `idincidenciaV` INT(11))   BEGIN
    DELETE FROM user_has_incidencias WHERE incidencia_id= idincidenciaV;
  DELETE FROM incidencias WHERE idincidencia  = idincidenciaV;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteUser` (IN `iduserV` INT(11))   BEGIN
    DELETE FROM user_has_incidencias WHERE user_id= iduserV;
  DELETE FROM users WHERE iduser = iduserV;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarUser` (IN `nombreUser` VARCHAR(50), IN `emailUser` VARCHAR(50), IN `idIncidenciaV` INT)   IF (SELECT EXISTS(SELECT 1 FROM incidencias WHERE idincidencia = idIncidenciaV)) THEN
    INSERT INTO users (iduser, nombre, email) VALUES (NULL, nombreUser, emailUser);
    INSERT INTO user_has_incidencias (id_user_has_incidencia, fecha, user_id,incidencia_id) VALUES (NULL,CURDATE(),(SELECT max(iduser) as lastID FROM users),idIncidenciaV);
    
   /* SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='id no existe';*/
    end if$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarUser_has_incidencia` (IN `iduserV` INT, IN `idincidenciaV` INT)   IF (SELECT EXISTS(SELECT 1 FROM incidencias WHERE idincidencia = idIncidenciaV)) THEN
	IF (SELECT EXISTS(SELECT 1 FROM users WHERE iduser = iduserV)) THEN
	 INSERT INTO user_has_incidencias (id_user_has_incidencia, fecha, user_id,incidencia_id) VALUES (NULL,CURDATE(),iduserV,idIncidenciaV);
     end if;
     end if$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidencias`
--

CREATE TABLE `incidencias` (
  `idincidencia` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `incidencias`
--

INSERT INTO `incidencias` (`idincidencia`, `descripcion`) VALUES
(1, '\"Error en el envío\"'),
(2, '\"Mal embalaje\"'),
(3, '\"Error en la fecha de envio\"'),
(4, '\"Error contenido\"'),
(8, 'Mal paquete');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `iduser` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`iduser`, `nombre`, `email`) VALUES
(1, 'desd', 'desd'),
(2, 'Jane Doe', 'jane@example.com'),
(3, 'bobi', ''),
(4, 'Alice Jones', 'alice@example.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_has_incidencias`
--

CREATE TABLE `user_has_incidencias` (
  `id_user_has_incidencia` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `user_id` int(11) NOT NULL,
  `incidencia_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user_has_incidencias`
--

INSERT INTO `user_has_incidencias` (`id_user_has_incidencia`, `fecha`, `user_id`, `incidencia_id`) VALUES
(2, '2023-04-10', 4, 2),
(64, '2023-05-23', 2, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `incidencias`
--
ALTER TABLE `incidencias`
  ADD PRIMARY KEY (`idincidencia`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`iduser`);

--
-- Indices de la tabla `user_has_incidencias`
--
ALTER TABLE `user_has_incidencias`
  ADD PRIMARY KEY (`id_user_has_incidencia`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `incidencia_id` (`incidencia_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `incidencias`
--
ALTER TABLE `incidencias`
  MODIFY `idincidencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT de la tabla `user_has_incidencias`
--
ALTER TABLE `user_has_incidencias`
  MODIFY `id_user_has_incidencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `user_has_incidencias`
--
ALTER TABLE `user_has_incidencias`
  ADD CONSTRAINT `user_has_incidencias_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`iduser`),
  ADD CONSTRAINT `user_has_incidencias_ibfk_2` FOREIGN KEY (`incidencia_id`) REFERENCES `incidencias` (`idincidencia`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
