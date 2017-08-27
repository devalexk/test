CREATE SCHEMA `joins` DEFAULT CHARACTER SET utf8 ;
CREATE TABLE `joins`.`country` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `joins`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `country_id` INT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
INSERT INTO `joins`.`country` (`name`) VALUES ('Ukraine');
INSERT INTO `joins`.`country` (`name`) VALUES ('Sweden');
INSERT INTO `joins`.`country` (`name`) VALUES ('Canada');
INSERT INTO `joins`.`country` (`name`) VALUES ('USA');
INSERT INTO `joins`.`city` (`country_id`, `name`) VALUES ('1', 'Kyiv');
INSERT INTO `joins`.`city` (`country_id`, `name`) VALUES ('1', 'Lviv');
INSERT INTO `joins`.`city` (`country_id`, `name`) VALUES ('1', 'Ivano-Frankivsk');
INSERT INTO `joins`.`city` (`country_id`, `name`) VALUES ('2', 'Stockholm');
INSERT INTO `joins`.`city` (`country_id`, `name`) VALUES ('4', 'Shelby');
INSERT INTO `joins`.`city` (`country_id`, `name`) VALUES ('4', 'Milwaukee');
INSERT INTO `joins`.`city` (`name`) VALUES ('Paris');

select * from country inner join city on country.id = country_id;
select * from country left join city on country.id = country_id;
select * from country right join city on country.id = country_id;
select * from country right join city on country.id = country_id where country_id is null;
select * from country left join city on country.id = country_id
  union select * from country right join city on country.id = country_id;
