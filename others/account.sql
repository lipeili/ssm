/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : bank

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 09/03/2020 16:13:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `cardNo` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `money` int(10) DEFAULT NULL,
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of account
-- ----------------------------
BEGIN;
INSERT INTO `account` VALUES ('6029621011001', '韩梅梅', 1090, 1);
INSERT INTO `account` VALUES ('6029621011000', '李大雷', 1000, 2);
INSERT INTO `account` VALUES ('8888888', 'admin', 2222, 10);
INSERT INTO `account` VALUES ('56576', 'batch', 6867, 11);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
