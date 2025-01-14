-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema derrap
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema derrap
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `derrap` DEFAULT CHARACTER SET utf8 ;
USE `derrap` ;

-- -----------------------------------------------------
-- Table `derrap`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrap`.`usuario` (
  `dni` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `perfil` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`dni`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `derrap`.`servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrap`.`servicio` (
  `nombre` VARCHAR(45) NOT NULL,
  `precio` INT NOT NULL,
  PRIMARY KEY (`nombre`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `derrap`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrap`.`cliente` (
  `dni` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`dni`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `derrap`.`vehiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrap`.`vehiculo` (
  `matricula` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `cliente_dni` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`matricula`),
  INDEX `fk_vehiculo_cliente1_idx` (`cliente_dni` ASC) VISIBLE,
  CONSTRAINT `fk_vehiculo_cliente1`
    FOREIGN KEY (`cliente_dni`)
    REFERENCES `derrap`.`cliente` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `derrap`.`orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrap`.`orden` (
  `referencia` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `proceso` VARCHAR(45) NOT NULL,
  `fecha_ingreso` DATE NOT NULL,
  `mecanico_dni` VARCHAR(45) NOT NULL,
  `servicio_nombre` VARCHAR(45) NOT NULL,
  `vehiculo_matricula` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NULL,
  `fecha_salida` DATE NULL,
  PRIMARY KEY (`referencia`),
  INDEX `fk_orden_mecanico1_idx` (`mecanico_dni` ASC) VISIBLE,
  INDEX `fk_orden_servicio1_idx` (`servicio_nombre` ASC) VISIBLE,
  INDEX `fk_orden_vehiculo1_idx` (`vehiculo_matricula` ASC) VISIBLE,
  CONSTRAINT `fk_orden_mecanico1`
    FOREIGN KEY (`mecanico_dni`)
    REFERENCES `derrap`.`usuario` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_servicio1`
    FOREIGN KEY (`servicio_nombre`)
    REFERENCES `derrap`.`servicio` (`nombre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_vehiculo1`
    FOREIGN KEY (`vehiculo_matricula`)
    REFERENCES `derrap`.`vehiculo` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `derrap`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrap`.`factura` (
  `referencia` INT NOT NULL,
  `orden_referencia` VARCHAR(45) NOT NULL,
  `fecha` VARCHAR(45) NULL,
  `total` DOUBLE NULL,
  PRIMARY KEY (`referencia`),
  INDEX `fk_factura_orden_idx` (`orden_referencia` ASC) VISIBLE,
  CONSTRAINT `fk_factura_orden`
    FOREIGN KEY (`orden_referencia`)
    REFERENCES `derrap`.`orden` (`referencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `derrap`.`almacen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrap`.`almacen` (
  `id_pieza` INT NOT NULL,
  `nombre_pieza` VARCHAR(45) NOT NULL,
  `stock` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_pieza`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `derrap`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrap`.`proveedor` (
  `nombre` VARCHAR(45) NOT NULL,
  `almacen_id_pieza` INT NOT NULL,
  PRIMARY KEY (`nombre`),
  INDEX `fk_proveedor_almacen1_idx` (`almacen_id_pieza` ASC) VISIBLE,
  CONSTRAINT `fk_proveedor_almacen1`
    FOREIGN KEY (`almacen_id_pieza`)
    REFERENCES `derrap`.`almacen` (`id_pieza`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `derrap`.`repuesto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrap`.`repuesto` (
  `id_repuesto` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `orden_referencia` VARCHAR(45) NOT NULL,
  `almacen_id_pieza` INT NOT NULL,
  PRIMARY KEY (`id_repuesto`),
  INDEX `fk_repuesto_orden1_idx` (`orden_referencia` ASC) VISIBLE,
  INDEX `fk_repuesto_almacen1_idx` (`almacen_id_pieza` ASC) VISIBLE,
  CONSTRAINT `fk_repuesto_orden1`
    FOREIGN KEY (`orden_referencia`)
    REFERENCES `derrap`.`orden` (`referencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_repuesto_almacen1`
    FOREIGN KEY (`almacen_id_pieza`)
    REFERENCES `derrap`.`almacen` (`id_pieza`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `derrap`.`cita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrap`.`cita` (
  `id_cita` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `vehiculo_matricula` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_cita`),
  INDEX `fk_cita_vehiculo1_idx` (`vehiculo_matricula` ASC) VISIBLE,
  CONSTRAINT `fk_cita_vehiculo1`
    FOREIGN KEY (`vehiculo_matricula`)
    REFERENCES `derrap`.`vehiculo` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `derrap`.`pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrap`.`pedidos` (
  `id` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `total` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `derrap`.`solicitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrap`.`solicitud` (
  `pedidos_id` INT NOT NULL,
  `orden_referencia` VARCHAR(45) NOT NULL,
  INDEX `fk_solicitud_pedidos_pedidos1_idx` (`pedidos_id` ASC) VISIBLE,
  INDEX `fk_solicitud_pedidos_orden1_idx` (`orden_referencia` ASC) VISIBLE,
  CONSTRAINT `fk_solicitud_pedidos_pedidos1`
    FOREIGN KEY (`pedidos_id`)
    REFERENCES `derrap`.`pedidos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitud_pedidos_orden1`
    FOREIGN KEY (`orden_referencia`)
    REFERENCES `derrap`.`orden` (`referencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

ALTER TABLE `derrap`.`cliente` 
ADD COLUMN `telefono` INT(9) NULL AFTER `apellidos`;

ALTER TABLE `derrap`.`proveedor` 
ADD COLUMN `telefono` INT(9) NULL AFTER `almacen_id_pieza`;

ALTER TABLE `derrap`.`usuario` 
ADD COLUMN `estado` INT NULL AFTER `perfil`;

ALTER TABLE `derrap`.`repuesto` 
ADD COLUMN `nombre` VARCHAR(45) NULL AFTER `id_repuesto`,
ADD COLUMN `marca` VARCHAR(45) NULL AFTER `nombre`,
ADD COLUMN `precio_compra` DOUBLE NULL AFTER `marca`,
ADD COLUMN `precio_venta` DOUBLE NULL AFTER `precio_compra`;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
