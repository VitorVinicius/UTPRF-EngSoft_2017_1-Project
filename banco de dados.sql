-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema locadora
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema locadora
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `locadora` DEFAULT CHARACTER SET utf8 ;
USE `locadora` ;

-- -----------------------------------------------------
-- Table `locadora`.`pessoa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `locadora`.`pessoa` ;

CREATE TABLE IF NOT EXISTS `locadora`.`pessoa` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `rua` VARCHAR(100) NULL,
  `numero` INT NULL,
  `cep` VARCHAR(20) NULL,
  `bairro` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `tipo` VARCHAR(25) NULL,
  `cpf` VARCHAR(25) NULL,
  `dataNascimento` DATE NULL,
  `razaoSocial` VARCHAR(45) NULL,
  `nomeFantasia` VARCHAR(45) NULL,
  `incricaoEstadual` VARCHAR(45) NULL,
  `cnpj` VARCHAR(30) NULL,
  `uf` VARCHAR(3) NULL,
  `pessoacol` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC),
  UNIQUE INDEX `cnpj_UNIQUE` (`cnpj` ASC),
  UNIQUE INDEX `incricaoEstadual_UNIQUE` (`incricaoEstadual` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locadora`.`funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `locadora`.`funcionario` ;

CREATE TABLE IF NOT EXISTS `locadora`.`funcionario` (
  `id` BIGINT NOT NULL,
  `nis` VARCHAR(45) NOT NULL,
  `salario` DOUBLE NOT NULL,
  `dataAdmissao` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nis_UNIQUE` (`nis` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_funcionario_idPessoa`
    FOREIGN KEY (`id`)
    REFERENCES `locadora`.`pessoa` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locadora`.`concessionaria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `locadora`.`concessionaria` ;

CREATE TABLE IF NOT EXISTS `locadora`.`concessionaria` (
  `id` BIGINT NOT NULL,
  `nomeResponsavel` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_concessionaria_idPessoa`
    FOREIGN KEY (`id`)
    REFERENCES `locadora`.`pessoa` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locadora`.`equipamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `locadora`.`equipamento` ;

CREATE TABLE IF NOT EXISTS `locadora`.`equipamento` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `fabricante` VARCHAR(45) NOT NULL,
  `valorDiaria` FLOAT NOT NULL,
  `valorPatriomonio` FLOAT NOT NULL,
  `ean` VARCHAR(45) NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  `dataCompra` DATE NOT NULL,
  `proximaRevisao` DATE NULL,
  `validade` DATE NULL,
  `statusEquipamento` SMALLINT(2) NOT NULL,
  `idFuncionario` BIGINT NOT NULL,
  `idConcessionaria` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ean_UNIQUE` (`ean` ASC),
  INDEX `idConcessionaria_idx` (`idConcessionaria` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_equipamento_idFuncionario`
    FOREIGN KEY (`id`)
    REFERENCES `locadora`.`funcionario` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_equipamento_idConcessionaria`
    FOREIGN KEY (`idConcessionaria`)
    REFERENCES `locadora`.`concessionaria` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locadora`.`pagamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `locadora`.`pagamento` ;

CREATE TABLE IF NOT EXISTS `locadora`.`pagamento` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `idPessoa` BIGINT NOT NULL,
  `formaPagamento` FLOAT NOT NULL,
  `referencia` FLOAT NOT NULL,
  `parcela` INT NOT NULL,
  `totalParcelas` INT NOT NULL,
  `pendente` TINYINT NOT NULL,
  `dataPagamento` DATE NOT NULL,
  PRIMARY KEY (`id`, `idPessoa`),
  INDEX `idPessoa_idx` (`idPessoa` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_pagamento_idPessoa`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `locadora`.`pessoa` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locadora`.`locacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `locadora`.`locacao` ;

CREATE TABLE IF NOT EXISTS `locadora`.`locacao` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `idPessoa` BIGINT NULL,
  `idEquipamento` BIGINT NULL,
  `dataLocacao` DATE NOT NULL,
  `dataDevolucao` DATE NOT NULL,
  `status` TINYINT(2) NOT NULL,
  `valorDiaria` FLOAT NOT NULL,
  `totalLocacao` FLOAT NOT NULL,
  `multaAtraso` FLOAT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idPessoa_idx` (`idPessoa` ASC),
  INDEX `idEquipamento_idx` (`idEquipamento` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_locacao_idPessoa`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `locadora`.`pessoa` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_locacao_idEquipamento`
    FOREIGN KEY (`idEquipamento`)
    REFERENCES `locadora`.`equipamento` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locadora`.`historico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `locadora`.`historico` ;

CREATE TABLE IF NOT EXISTS `locadora`.`historico` (
  `id` BIGINT NOT NULL,
  `idPessoa` BIGINT NULL,
  `idEquipamento` BIGINT NULL,
  `tipoOcorrencia` TINYINT(2) NOT NULL,
  `descricao` TEXT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idPessoa_idx` (`idPessoa` ASC),
  INDEX `idEquipamento_idx` (`idEquipamento` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_historico_idPessoa`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `locadora`.`pessoa` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_historico_idEquipamento`
    FOREIGN KEY (`idEquipamento`)
    REFERENCES `locadora`.`equipamento` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

USE `locadora`;

DELIMITER $$

USE `locadora`$$
DROP TRIGGER IF EXISTS `locadora`.`pessoa_BEFORE_INSERT` $$
USE `locadora`$$
CREATE DEFINER = CURRENT_USER TRIGGER `locadora`.`pessoa_BEFORE_INSERT` BEFORE INSERT ON `pessoa` FOR EACH ROW
BEGIN
	IF (NEW.tipo <> "PessoaJuridica" and NEW.tipo <> "PessoaFisica")
    THEN
		 SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'Um locatário só pode ser pessoa física ou jurídica';
       
    END IF;
END$$


USE `locadora`$$
DROP TRIGGER IF EXISTS `locadora`.`pessoa_BEFORE_UPDATE` $$
USE `locadora`$$
CREATE DEFINER = CURRENT_USER TRIGGER `locadora`.`pessoa_BEFORE_UPDATE` BEFORE UPDATE ON `pessoa` FOR EACH ROW
BEGIN
	IF (NEW.tipo <> "PessoaJuridica" and NEW.tipo <> "PessoaFisica")
    THEN
		 SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'Um locatário só pode ser pessoa física ou jurídica';
       
    END IF;
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
