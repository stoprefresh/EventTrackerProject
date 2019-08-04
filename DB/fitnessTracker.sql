-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema fitnessTracker
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `fitnessTracker` ;

-- -----------------------------------------------------
-- Schema fitnessTracker
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fitnessTracker` DEFAULT CHARACTER SET utf8 ;
USE `fitnessTracker` ;

-- -----------------------------------------------------
-- Table `myTracker`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `myTracker` ;

CREATE TABLE IF NOT EXISTS `myTracker` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date_start` DATETIME NULL,
  `date_end` DATETIME NULL,
  `comment` LONGTEXT NULL,
  `workout_types` VARCHAR(45) NULL,
  `location` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS mm@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'mm'@'localhost' IDENTIFIED BY 'mm';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'mm'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `myTracker`
-- -----------------------------------------------------
START TRANSACTION;
USE `fitnessTracker`;
INSERT INTO `myTracker` (`id`, `date_start`, `date_end`, `comment`, `workout_types`, `location`) VALUES (1, '2019-08-02 11:00:00', '2019-08-02 11:30:00', 'Quick bike ride at the Gym.', 'Stationary Bike', '24-hr Fitness');

COMMIT;

