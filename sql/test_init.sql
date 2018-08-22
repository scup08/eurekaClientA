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

-- -----------------------------------------------------
-- Table `account_db`.`t_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_db`.`t_test`(  
  `id` BIGINT(19) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'uuid',
  `mobile` VARCHAR(20) COMMENT '手机号',
  PRIMARY KEY (`id`)
);

create table IF NOT EXISTS t_test_audio
(
   uuid                 BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT 'uuid',
   name                varchar(100) COMMENT '标题',
   url                  varchar(100) COMMENT '路径',
   size                 int comment '文件大小，单位字节b',
   user_id              bigint(19) comment '上传人id',
   extension_name       varchar(5) comment '文件扩展名',
   duration             int comment '音频文件长度',
   PRIMARY KEY (`uuid`)
);

create table IF NOT EXISTS t_audio_dynamic_info
(
   uuid                 bigint(19) NOT NULL AUTO_INCREMENT COMMENT 'uuid',
   push_no              int comment '推送量',
   push_level           int comment '推送级别',
   push_flag            char(1) comment '推送标志  0-正常推送 1-停止推送',
   play_no              int comment '播放量',
   appreciate_no        int comment '点赞量',
   appreciate_rate      double(5,2) comment '点赞率',
   comment_no           int comment '评论量',
   comment_rate         double(5,2) comment '评论率',
   forward_no           int comment '转发量',
   forward_rate         double(5,2) comment '转发率',
   complete_no          int comment '完播量',
   complete_rate        double(5,2) comment '完播率',
   audio_id             bigint(19) comment '音频id'
   PRIMARY KEY (`uuid`)
);

create table IF NOT EXISTS t_audio_follow_recommend
(
   uuid                 bigint(19) NOT NULL AUTO_INCREMENT COMMENT 'uuid',
   user_id              bigint(19) comment '被推荐用户id',
   audio_id             bigint(19) comment '音频id',
   PRIMARY KEY (`uuid`)
);

create table IF NOT EXISTS t_audio_recommend_info
(
   uuid                 bigint(19) NOT NULL AUTO_INCREMENT COMMENT 'uuid',
   recommend_name       varchar(50) comment '推荐池名称',
   recommend_code       varchar(50) comment '推荐池code',
   recommend_no         int comment '最大推荐次数',
   recommend_level      int comment '推荐池等级',
   PRIMARY KEY (`uuid`)
);

create table IF NOT EXISTS t_audio_recommend_1
(
   uuid                 bigint(19) NOT NULL AUTO_INCREMENT COMMENT 'uuid',
   audio_id             bigint(19) comment '音频id',
   random_no            int comment '随机数',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   PRIMARY KEY (`uuid`)
);

create table IF NOT EXISTS t_audio_recommend_2
(
   uuid                 bigint(19) NOT NULL AUTO_INCREMENT COMMENT 'uuid',
   audio_id             bigint(19) comment '音频id',
   random_no            int comment '随机数',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   PRIMARY KEY (`uuid`)
);

create table IF NOT EXISTS t_audio_recommend_3
(
   uuid                 bigint(19) NOT NULL AUTO_INCREMENT COMMENT 'uuid',
   audio_id             bigint(19) comment '音频id',
   random_no            int comment '随机数',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   PRIMARY KEY (`uuid`)
);

create table IF NOT EXISTS t_audio_recommend_4
(
   uuid                 bigint(19) NOT NULL AUTO_INCREMENT COMMENT 'uuid',
   audio_id             bigint(19) comment '音频id',
   random_no            int comment '随机数',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   PRIMARY KEY (`uuid`)
);

create table IF NOT EXISTS t_audio_recommend_5
(
   uuid                 bigint(19) NOT NULL AUTO_INCREMENT COMMENT 'uuid',
   audio_id             bigint(19) comment '音频id',
   random_no            int comment '随机数',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   PRIMARY KEY (`uuid`)
);

create table IF NOT EXISTS t_audio_recommend_6
(
   uuid                 bigint(19) NOT NULL AUTO_INCREMENT COMMENT 'uuid',
   audio_id             bigint(19) comment '音频id',
   random_no            int comment '随机数',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   PRIMARY KEY (`uuid`)
);

create table IF NOT EXISTS t_audio_recommend_7
(
   uuid                 bigint(19) NOT NULL AUTO_INCREMENT COMMENT 'uuid',
   audio_id             bigint(19) comment '音频id',
   random_no            int comment '随机数',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   PRIMARY KEY (`uuid`)
);

create table IF NOT EXISTS t_audio_play_history
(
   uuid                 bigint(19) NOT NULL AUTO_INCREMENT COMMENT 'uuid',
   user_id              bigint(19) comment '用户id',
   audio_id             bigint(19) comment '音频id',
   play_time            datetime comment '浏览时间',
   PRIMARY KEY (`uuid`)
);