-- -----------------------------------------------------
-- Schema account_db
-- -----------------------------------------------------
CREATE DATABASE `test_db`
	DEFAULT CHARACTER SET utf8
	DEFAULT COLLATE utf8_general_ci;
USE 'test_db';

-- -----------------------------------------------------
-- Table `account_db`.`t_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_db`.`t_test_user`(  
  `id` BIGINT(19) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'uuid',
  `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '跟新时间',
  `delete_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '删除时间',
  `delete_flag` INT DEFAULT 0 COMMENT '0-正常，1-已删除',
  `mobile` VARCHAR(20) COMMENT '手机号',
  `login_pwd` VARCHAR(128) COMMENT '登录密码',
  `pwd_salt` VARCHAR(128) COMMENT '密码盐',
  `balance` BIGINT(19) DEFAULT 10000000 COMMENT '余额, 单位分',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uq_t_account_user` (`mobile`)
);

