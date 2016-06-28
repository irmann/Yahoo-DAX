CREATE TABLE `history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `symbol` varchar(20),
  `date` date,
  `open` DOUBLE,
  `high` DOUBLE,
  `low` DOUBLE,
  `close` DOUBLE,
  `volume` DOUBLE,
  PRIMARY KEY (`id`)
);
