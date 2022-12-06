/*
 Navicat Premium Data Transfer

 Source Server         : 锅巴
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : db2022

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 28/06/2022 14:24:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `serial` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16525 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES (6, 'success');
INSERT INTO `payment` VALUES (16515, 'guoba666666');
INSERT INTO `payment` VALUES (16516, NULL);
INSERT INTO `payment` VALUES (16517, NULL);
INSERT INTO `payment` VALUES (16518, NULL);
INSERT INTO `payment` VALUES (16519, NULL);
INSERT INTO `payment` VALUES (16520, NULL);
INSERT INTO `payment` VALUES (16521, NULL);
INSERT INTO `payment` VALUES (16522, NULL);
INSERT INTO `payment` VALUES (16523, 'aaaaa1');
INSERT INTO `payment` VALUES (16524, 'aaaaa1');

SET FOREIGN_KEY_CHECKS = 1;
