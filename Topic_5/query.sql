SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `high-school` ;
CREATE SCHEMA IF NOT EXISTS `high-school` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `high-school` ;

-- -----------------------------------------------------
-- Table `high-school`.`Student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `high-school`.`Student` ;

CREATE TABLE IF NOT EXISTS `high-school`.`Student` (
  `registration_number` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `date_of_birth` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`registration_number`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `high-school`.`Teacher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `high-school`.`Teacher` ;

CREATE TABLE IF NOT EXISTS `high-school`.`Teacher` (
  `idTeacher` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `date_of_birth` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTeacher`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `high-school`.`Course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `high-school`.`Course` ;

CREATE TABLE IF NOT EXISTS `high-school`.`Course` (
  `idCourse` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `assigned_teacher` INT NOT NULL,
  `hours_by_week` INT NOT NULL,
  PRIMARY KEY (`idCourse`),
  INDEX `assigned_teacher_idx` (`assigned_teacher` ASC),
  CONSTRAINT `assigned_teacher`
    FOREIGN KEY (`assigned_teacher`)
    REFERENCES `high-school`.`Teacher` (`idTeacher`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `high-school`.`Hour`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `high-school`.`Hour` ;

CREATE TABLE IF NOT EXISTS `high-school`.`Hour` (
  `idHour` INT NOT NULL,
  `init_hour` TIME NOT NULL,
  `finish_hour` TIME NOT NULL,
  PRIMARY KEY (`idHour`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `high-school`.`Day`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `high-school`.`Day` ;

CREATE TABLE IF NOT EXISTS `high-school`.`Day` (
  `idDay` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDay`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `high-school`.`Schedule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `high-school`.`Schedule` ;

CREATE TABLE IF NOT EXISTS `high-school`.`Schedule` (
  `idCourse` INT NOT NULL,
  `idDay` INT NOT NULL,
  `idHour` INT NOT NULL,
  PRIMARY KEY (`idCourse`, `idDay`, `idHour`),
  INDEX `idDay_idx` (`idDay` ASC),
  INDEX `idHour_idx` (`idHour` ASC),
  CONSTRAINT `idDay`
    FOREIGN KEY (`idDay`)
    REFERENCES `high-school`.`Day` (`idDay`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idHour`
    FOREIGN KEY (`idHour`)
    REFERENCES `high-school`.`Hour` (`idHour`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idCourse`
    FOREIGN KEY (`idCourse`)
    REFERENCES `high-school`.`Course` (`idCourse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `high-school`.`StudentCourse`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `high-school`.`StudentCourse` ;

CREATE TABLE IF NOT EXISTS `high-school`.`StudentCourse` (
  `idCourse` INT NOT NULL,
  `registration_number` INT NOT NULL,
  `first_partial` INT NOT NULL,
  `second_partial` INT NOT NULL,
  `third_partial` INT NOT NULL,
  `final` INT NOT NULL,
  PRIMARY KEY (`idCourse`, `registration_number`),
  CONSTRAINT `idCourseFK`
    FOREIGN KEY (`idCourse`)
    REFERENCES `high-school`.`Course` (`idCourse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idStudentFK`
    FOREIGN KEY (`registration_number`)
    REFERENCES `high-school`.`Student` (`registration_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `high-school`.`Student`
-- -----------------------------------------------------
START TRANSACTION;
USE `high-school`;
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (1, 'Juan', 'Perez', '12/05/1998');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (2, 'Pedro', 'Juarez', '16/05/1995');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (3, 'Maria', 'Hernandez', '08/07/1989');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (4, 'Alan', 'Rodriguez', '23/11/1997');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (5, 'Esteban', 'García', '03/06/1999');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (6, 'Armando', 'Gonzalez', '02/01/1994');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (7, 'Juliana', 'Estevez', '19/06/1995');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (8, 'Florencia', 'Narvaez', '27/08/1997');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (9, 'Sofia', 'Vivas', '09/04/1996');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (10, 'Laura', 'Morelli', '07/09/1996');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (11, 'Ricardo', 'Ramirez', '02/08/1992');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (12, 'Pablo', 'Flores', '04/04/1991');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (13, 'Diego', 'Sosa', '12/12/1990');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (14, 'Nicolas', 'Cordoba', '23/11/1989');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (15, 'Noelia', 'Manzano', '11/03/1992');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (16, 'Marina', 'Suarez', '09/04/1994');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (17, 'Natalia', 'Gimenez', '02/10/1998');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (18, 'Pamela', 'Velez', '21/08/1991');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (19, 'Agustin', 'Torres', '23/08/1998');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (20, 'Fernando', 'Valdez', '30/10/1997');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (21, 'Romina', 'Aguero', '18/05/1995');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (22, 'Camila', 'Aguirre', '25/06/1998');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (23, 'Gonzalo', 'Camara', '31/10/1998');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (24, 'Octavio', 'Corso', '26/12/1996');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (25, 'Nahuel', 'Araya', '23/05/1992');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (26, 'Lucas', 'Campos', '14/10/1991');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (27, 'Melina', 'Casas', '14/09/1989');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (28, 'Melisa', 'Gomez', '27/02/1997');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (29, 'Susana', 'Martinez', '19/04/1995');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (30, 'Brenda', 'Romero', '03/02/1993');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (31, 'Georgina', 'Picco', '21/06/1999');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (32, 'Dahiana', 'Villagran', '29/07/1993');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (34, 'Abril', 'Gazquez', '19/08/1994');
INSERT INTO `high-school`.`Student` (`registration_number`, `first_name`, `last_name`, `date_of_birth`) VALUES (35, 'Lara', 'Hernandez', '23/05/1994');

COMMIT;


-- -----------------------------------------------------
-- Data for table `high-school`.`Teacher`
-- -----------------------------------------------------
START TRANSACTION;
USE `high-school`;
INSERT INTO `high-school`.`Teacher` (`idTeacher`, `first_name`, `last_name`, `date_of_birth`) VALUES (14290580, 'Leticia', 'Constable', '15/08/1960');
INSERT INTO `high-school`.`Teacher` (`idTeacher`, `first_name`, `last_name`, `date_of_birth`) VALUES (18256894, 'Carena', 'Gonzalo', '05/02/1968');
INSERT INTO `high-school`.`Teacher` (`idTeacher`, `first_name`, `last_name`, `date_of_birth`) VALUES (34128896, 'Montalvan', 'Natalia', '25/11/1988');

COMMIT;


-- -----------------------------------------------------
-- Data for table `high-school`.`Course`
-- -----------------------------------------------------
START TRANSACTION;
USE `high-school`;
INSERT INTO `high-school`.`Course` (`idCourse`, `name`, `assigned_teacher`, `hours_by_week`) VALUES (11, 'Fisica I', 34128896, 2);
INSERT INTO `high-school`.`Course` (`idCourse`, `name`, `assigned_teacher`, `hours_by_week`) VALUES (12, 'Algoritmos y Estructuras de Datos', 18256894, 3);
INSERT INTO `high-school`.`Course` (`idCourse`, `name`, `assigned_teacher`, `hours_by_week`) VALUES (13, 'Analisis Matematico I', 14290580, 2);
INSERT INTO `high-school`.`Course` (`idCourse`, `name`, `assigned_teacher`, `hours_by_week`) VALUES (21, 'Fisica II', 34128896, 1);
INSERT INTO `high-school`.`Course` (`idCourse`, `name`, `assigned_teacher`, `hours_by_week`) VALUES (22, 'Analisis Matematico II', 14290580, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `high-school`.`Hour`
-- -----------------------------------------------------
START TRANSACTION;
USE `high-school`;
INSERT INTO `high-school`.`Hour` (`idHour`, `init_hour`, `finish_hour`) VALUES (1, '08:00', '09:20');
INSERT INTO `high-school`.`Hour` (`idHour`, `init_hour`, `finish_hour`) VALUES (2, '09:30', '10:50');
INSERT INTO `high-school`.`Hour` (`idHour`, `init_hour`, `finish_hour`) VALUES (3, '11:00', '12:20');

COMMIT;


-- -----------------------------------------------------
-- Data for table `high-school`.`Day`
-- -----------------------------------------------------
START TRANSACTION;
USE `high-school`;
INSERT INTO `high-school`.`Day` (`idDay`, `name`) VALUES (1, 'Monday');
INSERT INTO `high-school`.`Day` (`idDay`, `name`) VALUES (2, 'Tuesday');
INSERT INTO `high-school`.`Day` (`idDay`, `name`) VALUES (3, 'Wednesday');
INSERT INTO `high-school`.`Day` (`idDay`, `name`) VALUES (4, 'Thursday');
INSERT INTO `high-school`.`Day` (`idDay`, `name`) VALUES (5, 'Friday');

COMMIT;


-- -----------------------------------------------------
-- Data for table `high-school`.`StudentCourse`
-- -----------------------------------------------------
START TRANSACTION;
USE `high-school`;
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 1, 4, 2, 7, 8);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 2, 4, 8, 8, 5);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 3, 5, 9, 9, 2);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 4, 6, 5, 5, 10);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 5, 7, 3, 6, 9);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 6, 8, 6, 8, 10);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 7, 9, 7, 4, 8);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 8, 10, 4, 5, 7);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 9, 4, 5, 6, 4);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 10, 5, 9, 9, 2);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 11, 8, 8, 7, 3);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 12, 9, 5, 4, 5);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 13, 8, 10, 5, 2);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 14, 7, 5, 2, 7);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 15, 6, 9, 3, 8);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 16, 4, 6, 6, 9);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 17, 5, 8, 9, 10);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 18, 8, 7, 8, 2);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 19, 9, 10, 5, 4);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (11, 20, 5, 3, 4, 7);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 21, 4, 10, 7, 5);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 22, 7, 9, 8, 2);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 23, 6, 8, 5, 8);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 24, 10, 5, 9, 9);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 25, 10, 7, 6, 6);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 26, 5, 9, 5, 3);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 27, 2, 10, 3, 2);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 28, 6, 9, 7, 5);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 29, 8, 7, 8, 6);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 30, 9, 5, 9, 7);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 31, 10, 6, 10, 8);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 32, 2, 3, 4, 2);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 33, 4, 4, 8, 9);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 34, 7, 8, 9, 10);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 35, 9, 9, 7, 1);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 1, 6, 10, 5, 10);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 2, 5, 7, 9, 7);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 3, 8, 8, 8, 9);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 4, 2, 9, 5, 8);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (12, 5, 3, 5, 9, 5);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 6, 4, 6, 7, 2);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 7, 9, 7, 6, 3);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 8, 7, 4, 4, 9);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 9, 2, 3, 8, 4);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 10, 10, 2, 9, 6);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 11, 1, 5, 10, 5);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 12, 2, 9, 9, 7);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 13, 8, 8, 10, 9);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 14, 9, 5, 7, 8);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 15, 9, 6, 8, 9);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 16, 8, 7, 6, 8);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 17, 4, 9, 5, 3);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 18, 5, 10, 4, 4);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 19, 8, 1, 3, 2);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 20, 7, 2, 1, 5);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 21, 6, 8, 2, 9);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 22, 3, 9, 5, 8);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 23, 5, 5, 9, 3);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 24, 9, 4, 8, 6);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (13, 25, 2, 6, 7, 8);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 26, 10, 10, 6, 9);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 27, 2, 7, 9, 2);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 28, 9, 9, 8, 5);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 29, 8, 5, 6, 7);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 30, 5, 6, 9, 8);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 31, 7, 10, 10, 4);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 32, 4, 5, 9, 6);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 33, 9, 9, 7, 9);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 34, 5, 7, 10, 5);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 35, 6, 8, 9, 7);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 1, 10, 6, 4, 6);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 2, 2, 5, 7, 8);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 3, 5, 4, 8, 9);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 4, 8, 10, 6, 2);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 5, 9, 2, 3, 5);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 6, 6, 8, 10, 9);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 7, 7, 6, 2, 7);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 8, 9, 9, 8, 8);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 9, 8, 4, 9, 1);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (21, 10, 5, 7, 2, 2);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 11, 7, 8, 4, 9);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 12, 10, 9, 7, 7);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 13, 3, 10, 8, 8);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 14, 8, 5, 6, 2);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 15, 9, 6, 7, 7);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 16, 6, 4, 9, 8);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 17, 7, 8, 5, 9);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 18, 5, 2, 2, 4);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 19, 4, 9, 9, 5);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 20, 10, 10, 7, 6);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 21, 9, 9, 5, 7);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 22, 7, 7, 9, 8);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 23, 8, 5, 8, 9);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 24, 6, 8, 7, 4);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 25, 5, 6, 6, 5);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 26, 2, 9, 5, 6);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 27, 3, 2, 4, 7);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 28, 7, 3, 3, 8);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 29, 4, 5, 2, 9);
INSERT INTO `high-school`.`StudentCourse` (`idCourse`, `registration_number`, `first_partial`, `second_partial`, `third_partial`, `final`) VALUES (22, 30, 10, 8, 10, 10);

COMMIT;

