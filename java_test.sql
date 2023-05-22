/*
 Navicat MySQL Data Transfer

 Source Server         : 来
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : java_test

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 22/05/2023 20:10:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cargo
-- ----------------------------
DROP TABLE IF EXISTS `cargo`;
CREATE TABLE `cargo`  (
  `cargo_id` int NOT NULL AUTO_INCREMENT,
  `cargo_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cargo_start` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cargo_end` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cargo_num` int NULL DEFAULT NULL,
  `cargo_time` datetime NULL DEFAULT NULL,
  `cargo_owner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cargo_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`cargo_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cargo
-- ----------------------------
INSERT INTO `cargo` VALUES (8, '书本', '北京', '上海', 111, '2023-04-26 14:51:35', 'ss', '0');
INSERT INTO `cargo` VALUES (14, '手机', '北京', '哈尔滨', 70, '2023-05-22 17:25:13', 'ss', '0');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES (0, 'ROLE_USER');
INSERT INTO `roles` VALUES (1, 'ROLE_CARRIER');
INSERT INTO `roles` VALUES (2, 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for tb_cart
-- ----------------------------
DROP TABLE IF EXISTS `tb_cart`;
CREATE TABLE `tb_cart`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int NULL DEFAULT 1,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_number` int NULL DEFAULT NULL,
  `link_picture` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_price` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_cart
-- ----------------------------

-- ----------------------------
-- Table structure for tb_examine
-- ----------------------------
DROP TABLE IF EXISTS `tb_examine`;
CREATE TABLE `tb_examine`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_number` int NULL DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_examine
-- ----------------------------

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_sold` int NULL DEFAULT 0,
  `status` int NULL DEFAULT 1,
  `goods_group` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_number` int NULL DEFAULT NULL,
  `link_picture` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_price` int NULL DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO `tb_goods` VALUES (1, '小米12', 0, 1, 'phone', 1, 'imgs/xiaomi12.png', 3499, 'zhao');
INSERT INTO `tb_goods` VALUES (2, '荣耀50Pro', 0, 1, 'phone', 8, 'imgs/rongyao50Pro.png', 2188, 'zhao');
INSERT INTO `tb_goods` VALUES (3, '苹果12', 0, 1, 'phone', 8, 'imgs/Apple12.png', 4899, 'zhao');
INSERT INTO `tb_goods` VALUES (4, '床', 0, 1, 'furniture', 20, 'imgs/bed.jpg', 4900, 'zhao');
INSERT INTO `tb_goods` VALUES (5, '桌子', 0, 1, 'furniture', 1, 'imgs/table.jpg', 1250, 'zhao');
INSERT INTO `tb_goods` VALUES (6, '书架', 0, 1, 'furniture', 6, 'imgs/shelf.jpg', 880, 'zhao');
INSERT INTO `tb_goods` VALUES (7, '小米11', 0, 1, 'phone', 10, 'imgs/xiaomi11.png', 4449, 'zhao');
INSERT INTO `tb_goods` VALUES (8, '小米10s', 0, 1, 'phone', 10, 'imgs/xiaomi10s.png', 2699, 'zhao');

-- ----------------------------
-- Table structure for tb_list
-- ----------------------------
DROP TABLE IF EXISTS `tb_list`;
CREATE TABLE `tb_list`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_number` int NULL DEFAULT NULL,
  `send_addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `get_addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_list
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `identity` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'amy', '123', '0');
INSERT INTO `tb_user` VALUES (2, 'fu', '123', '0');
INSERT INTO `tb_user` VALUES (3, 'li', '123', '0');
INSERT INTO `tb_user` VALUES (4, 'lin', '123', '2');
INSERT INTO `tb_user` VALUES (5, 'liu', '123', '0');
INSERT INTO `tb_user` VALUES (6, 'zhao', '123', '1');
INSERT INTO `tb_user` VALUES (7, 'zheng', '123', '1');
INSERT INTO `tb_user` VALUES (13, 'ss', '$2a$10$Or3XtSRchDfNuqUNwDD8RO7LGE/oUlMSrdpJ2fEAx.ybEHNskgRWa', '0');

SET FOREIGN_KEY_CHECKS = 1;
