-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3307
-- Tiempo de generación: 30-06-2020 a las 19:39:01
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_recurso_humano`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_categoria`
--

CREATE TABLE `tb_categoria` (
  `id_categoria` int(5) NOT NULL,
  `nom_categoria` varchar(50) NOT NULL,
  `estado_categoria` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_categoria`
--

INSERT INTO `tb_categoria` (`id_categoria`, `nom_categoria`, `estado_categoria`) VALUES
(1, 'Frutas', 1),
(3, 'Mariscos', 1),
(4, 'Lacteos', 1),
(5, 'Bebidas', 1),
(6, 'Retornables', 1),
(9, 'Cosmeticos', 1),
(10, 'Salud', 1),
(11, 'Varios', 1),
(12, 'Guaro', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_persona`
--

CREATE TABLE `tb_persona` (
  `dui_persona` varchar(10) NOT NULL,
  `apellidos_personas` varchar(30) NOT NULL,
  `nombre_persona` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_persona`
--

INSERT INTO `tb_persona` (`dui_persona`, `apellidos_personas`, `nombre_persona`) VALUES
('02323202-4', 'Ostorga', 'Melissa'),
('05969355-6', 'Job', 'Hernandez '),
('05969355-9', 'Ostorga', 'Mauriciio'),
('11111111-1', 'Flores', 'Guillermo'),
('23355639-4', 'Juan', 'Perez'),
('45893849-0', 'Roxana', 'Aparico'),
('98475869-2', 'America', 'Lopez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_producto`
--

CREATE TABLE `tb_producto` (
  `id_producto` int(9) NOT NULL,
  `nom_producto` varchar(50) NOT NULL,
  `stock` decimal(6,3) DEFAULT NULL,
  `precio` decimal(6,3) DEFAULT NULL,
  `unidad_de_medida` varchar(20) DEFAULT NULL,
  `estado_producto` tinyint(1) DEFAULT NULL,
  `categoria` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tb_producto`
--

INSERT INTO `tb_producto` (`id_producto`, `nom_producto`, `stock`, `precio`, `unidad_de_medida`, `estado_producto`, `categoria`) VALUES
(1, 'Manzana Verde', '9.990', '1.450', 'x lb', 1, 1),
(2, 'Pepsi Cola Lite 2ml', '9.990', '1.250', 'ml', 1, 5),
(4, 'Coca Cola 3 Lts', '7.000', '2.000', 'L', 1, 5),
(5, 'Camaron Delta', '6.000', '4.000', 'Lb', 1, 3),
(6, 'Loratadina MK', '22.000', '0.750', 'mg', 1, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_usuario`
--

CREATE TABLE `tb_usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre_u` varchar(60) NOT NULL,
  `apellido_u` varchar(60) NOT NULL,
  `correo` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `clave` varchar(30) NOT NULL,
  `tipo` tinyint(4) NOT NULL,
  `estado` tinyint(4) DEFAULT NULL,
  `pregunta` varchar(60) DEFAULT NULL,
  `repuesta` varchar(30) NOT NULL,
  `f_registro` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_usuario`
--

INSERT INTO `tb_usuario` (`id_usuario`, `nombre_u`, `apellido_u`, `correo`, `usuario`, `clave`, `tipo`, `estado`, `pregunta`, `repuesta`, `f_registro`) VALUES
(1, 'Guillermo Mauricio', 'Palacios Ortiz', 'thepal@xddmail.com', 'admin', '123 ', 1, 1, 'Como se llama tu primera ex', 'Patricia', '2020-06-26 21:30:18'),
(2, 'Guillermo Mauri', 'Palacios Ortiz', 'mauri@hotmail.es', 'mauri', '1234', 1, 1, 'Que procesador tiene tu pc (2019)', 'Ryzen', '2020-06-27 00:07:21');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tb_categoria`
--
ALTER TABLE `tb_categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `tb_persona`
--
ALTER TABLE `tb_persona`
  ADD PRIMARY KEY (`dui_persona`);

--
-- Indices de la tabla `tb_producto`
--
ALTER TABLE `tb_producto`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `categoria` (`categoria`);

--
-- Indices de la tabla `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_categoria`
--
ALTER TABLE `tb_categoria`
  MODIFY `id_categoria` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `tb_producto`
--
ALTER TABLE `tb_producto`
  MODIFY `id_producto` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tb_usuario`
--
ALTER TABLE `tb_usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tb_producto`
--
ALTER TABLE `tb_producto`
  ADD CONSTRAINT `tb_producto_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`id_categoria`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
