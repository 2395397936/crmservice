/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : crmdb

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 13/06/2023 15:05:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for business_record
-- ----------------------------
DROP TABLE IF EXISTS `business_record`;
CREATE TABLE `business_record`  (
  `br_id` int(0) NOT NULL AUTO_INCREMENT,
  `br_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `br_addr` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `br_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `br_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cus_id` int(0) NULL DEFAULT NULL,
  `br_sale` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`br_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of business_record
-- ----------------------------
INSERT INTO `business_record` VALUES (2, '2023-06-13 12:30:09', '31', '32', 'rr', 2, '234');
INSERT INTO `business_record` VALUES (4, '2023-06-13 12:36:40', '酒店', '开会', 'ok', 2, 'adm');
INSERT INTO `business_record` VALUES (5, '2023-06-13 12:36:41', '酒店', '开会', 'ok', 2, 'adm');

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact`  (
  `con_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '联系人编号',
  `con_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系人姓名',
  `con_sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系人性别：男、女',
  `con_job` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系人职位',
  `con_tel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系人办公电话',
  `con_phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系人手机号码',
  `con_desc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系人备注',
  `cus_id` int(0) NOT NULL COMMENT '客户编号',
  PRIMARY KEY (`con_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES (1, '张三', '男', '经理', '66668888', '15002332655', '喝茅台', 2);
INSERT INTO `contact` VALUES (3, '张三', '男', '经理', '66668888', '15002332655', '喝茅台', 1);
INSERT INTO `contact` VALUES (4, '张三', '男', '经理', '66668888', '15002332655', '喝茅台', 1);
INSERT INTO `contact` VALUES (5, '张三', '男', '经理', '66668888', '15002332655', '喝茅台', 1);
INSERT INTO `contact` VALUES (6, '张三', '男', '经理', '66668888', '15002332655', '喝茅台', 1);
INSERT INTO `contact` VALUES (7, '张三', '男', '经理', '66668888', '15002332655', '喝茅台', 1);
INSERT INTO `contact` VALUES (9, '张三', '男', '经理', '66668888', '15002332655', '喝茅台', 1);
INSERT INTO `contact` VALUES (10, '张三', '男', '经理', '66668888', '15002332655', '喝茅台', 1);
INSERT INTO `contact` VALUES (11, '张三', '男', '经理', '66668888', '15002332655', '喝茅台', 1);
INSERT INTO `contact` VALUES (12, '张三', '男', '经理', '66668888', '15002332655', '喝茅台', 1);
INSERT INTO `contact` VALUES (13, '11', '男', '1111', '111', '11111', '1111', 2);
INSERT INTO `contact` VALUES (16, 'lisis', '女', 'manager', '132222231213', '32132132215', 'ok', 1);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `cus_id` int(0) NOT NULL AUTO_INCREMENT,
  `cus_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cus_region` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cus_industry` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cus_level` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cus_rate` int(0) NULL DEFAULT NULL,
  `cus_credit` int(0) NULL DEFAULT NULL,
  `cus_addr` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cus_postcode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cus_phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cus_url` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cus_fax` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cus_status` int(0) NULL DEFAULT 1,
  PRIMARY KEY (`cus_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '招商银行', '华北', '金融', 'VIP客户', 5, 1, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 0);
INSERT INTO `customer` VALUES (2, '招商银行', '华东', '金融', 'VIP客户', 4, 5, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (3, '招商银行', '华东', '金融', 'VIP客户', 4, 5, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (4, '招商银行', '华东', '金融', 'VIP客户', 3, 5, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (5, '招商银行', '华东', '金融', 'VIP客户', 1, 5, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (6, '招商银行', '华东', '金融', 'VIP客户', 3, 5, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (7, '招商银行', '华东', '金融', 'VIP客户', 5, 5, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (8, '招商银行', '华东', '金融', 'VIP客户', 1, 5, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (9, '招商银行', '华东', '金融', 'VIP客户', 5, 5, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (10, '招商银行', '华东', '金融', 'VIP客户', 5, 5, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (11, '招商银行', '西北', '金融', 'VIP客户', 5, 5, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (12, '招商银行', '华东', '金融', 'VIP客户', 2, 5, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (16, 'fagf', '西北', '教育', '大客户', 1, 3, '52', '52', '52', '555', '55', 1);
INSERT INTO `customer` VALUES (17, 'fagf', NULL, NULL, NULL, 4, 3, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `customer` VALUES (18, '招商银行', '华东', '金融', 'VIP客户', 2, 2, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (19, '招商银行', '华东', '金融', 'VIP客户', 2, 3, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (20, '招商银行', '华东', '金融', 'VIP客户', 2, 4, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (21, '招商银行', '华东', '金融', 'VIP客户', 2, 5, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (22, '招商银行', '华东', '金融', 'VIP客户', 2, 4, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (23, '招商银行', '华东', '金融', 'VIP客户', 2, 5, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (24, '招商银行', '华东', '金融', 'VIP客户', 2, 5, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (25, '招商银行', '华东', '金融', 'VIP客户', 2, 2, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (26, '招商银行', '华东', '金融', 'VIP客户', 2, 3, '上海浦东新区', '4000', '800-154', 'www.zsyh.com', '1561', 1);
INSERT INTO `customer` VALUES (28, 'ef', '西北', '医疗', 'VIP客户', 4, 1, 'sdf', 'sf', 'fsd', 'fs', 'f', 1);

-- ----------------------------
-- Table structure for customer_loss
-- ----------------------------
DROP TABLE IF EXISTS `customer_loss`;
CREATE TABLE `customer_loss`  (
  `cl_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '流失预警ID，主键，自动递增',
  `cus_id` int(0) NULL DEFAULT NULL COMMENT '客户ID',
  `su_id` int(0) NULL DEFAULT NULL COMMENT '客户经理ID',
  `cl_order_time` datetime(0) NULL DEFAULT NULL COMMENT '上次下单时间',
  `cl_pause` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '暂缓流失措施',
  `cl_loss_reason` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '确认流失原因',
  `cl_loss_time` timestamp(0) NULL DEFAULT NULL COMMENT '确认流失时间',
  `cl_status` int(0) NULL DEFAULT NULL COMMENT '状态。1-预警、2-暂缓、3-流失、4-挽回',
  PRIMARY KEY (`cl_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_loss
-- ----------------------------
INSERT INTO `customer_loss` VALUES (1, 1, 5, '2019-11-17 15:22:40', '66\n7', '66', '2023-06-13 11:17:32', 4);
INSERT INTO `customer_loss` VALUES (2, 1, 1, '2021-09-17 11:20:40', NULL, '123', '2023-06-13 11:33:27', 3);
INSERT INTO `customer_loss` VALUES (3, 1, 1, '2021-11-17 15:22:40', NULL, NULL, NULL, 1);
INSERT INTO `customer_loss` VALUES (4, 1, 1, '2019-06-18 21:22:40', NULL, NULL, NULL, 1);
INSERT INTO `customer_loss` VALUES (5, 1, 1, '2020-11-18 18:19:46', NULL, NULL, NULL, 1);
INSERT INTO `customer_loss` VALUES (6, 1, 1, '2021-06-18 14:20:44', NULL, NULL, NULL, 1);
INSERT INTO `customer_loss` VALUES (7, 1, 1, '2021-06-19 14:24:37', NULL, NULL, NULL, 1);
INSERT INTO `customer_loss` VALUES (8, 1, 1, '2019-11-17 13:25:43', NULL, NULL, NULL, 1);
INSERT INTO `customer_loss` VALUES (9, 1, 3, '2019-05-20 15:22:45', NULL, NULL, NULL, 1);
INSERT INTO `customer_loss` VALUES (10, 1, 1, '2022-06-18 13:24:37', NULL, NULL, NULL, 1);
INSERT INTO `customer_loss` VALUES (11, 1, 1, '2019-07-18 15:22:40', NULL, NULL, NULL, 1);
INSERT INTO `customer_loss` VALUES (12, 1, 1, '2020-05-20 12:20:40', NULL, NULL, NULL, 1);
INSERT INTO `customer_loss` VALUES (13, 1, 2, '2020-05-20 12:20:40', NULL, NULL, NULL, 1);
INSERT INTO `customer_loss` VALUES (14, 1, 2, '2020-05-20 12:20:40', NULL, NULL, NULL, 1);
INSERT INTO `customer_loss` VALUES (15, 1, 3, '2020-05-20 12:20:40', NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for dev_plan
-- ----------------------------
DROP TABLE IF EXISTS `dev_plan`;
CREATE TABLE `dev_plan`  (
  `dp_id` int(0) NOT NULL AUTO_INCREMENT,
  `sale_id` int(0) NULL DEFAULT NULL COMMENT '销售机会编号',
  `dp_time` datetime(0) NULL DEFAULT NULL COMMENT '计划日期',
  `dp_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '计划内容',
  `dp_execution_time` datetime(0) NULL DEFAULT NULL COMMENT '执行日期',
  `dp_execution_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '执行结果',
  `dp_executor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '执行人',
  PRIMARY KEY (`dp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dev_plan
-- ----------------------------
INSERT INTO `dev_plan` VALUES (1, 2, '2023-06-26 00:00:00', '001', '2023-06-28 00:00:00', '0', NULL);
INSERT INTO `dev_plan` VALUES (3, 2, '2023-06-23 00:00:00', '03', '2023-06-21 00:00:00', '23', NULL);
INSERT INTO `dev_plan` VALUES (5, 2, '2023-06-20 00:00:00', 'df', NULL, NULL, NULL);
INSERT INTO `dev_plan` VALUES (6, 3, '2023-06-06 00:00:00', '2552', '2023-06-06 00:00:00', '52', 'adm');
INSERT INTO `dev_plan` VALUES (7, 11, '2023-06-06 00:00:00', 'fd', '2023-06-14 00:00:00', '得分', 'adm');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `odr_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '订单编号，主键，自动递增',
  `odr_time` datetime(0) NULL DEFAULT NULL COMMENT '订单日期',
  `odr_amount` decimal(7, 2) NULL DEFAULT NULL COMMENT '订单金额',
  `odr_shipto` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '送货地址',
  `odr_status` int(0) NULL DEFAULT NULL COMMENT '订单状态。1-未付款、2-已付款、3-已发货、4-已收货、5-已退货',
  `cus_id` int(0) NULL DEFAULT NULL COMMENT '客户编号',
  PRIMARY KEY (`odr_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '2019-03-18 15:21:50', 5000.00, '毕节市七星关区', 1, 2);
INSERT INTO `orders` VALUES (2, '2019-11-17 15:22:40', 8000.00, '毕节市高铁站', 2, 2);
INSERT INTO `orders` VALUES (3, '2021-12-28 15:23:13', 10000.00, '贵阳市', 3, 3);
INSERT INTO `orders` VALUES (4, '2021-12-28 15:23:13', 10000.00, '贵阳市', 3, 3);
INSERT INTO `orders` VALUES (5, '2021-12-28 15:23:13', 10000.00, '贵阳市', 3, 3);
INSERT INTO `orders` VALUES (6, '2021-12-28 15:23:13', 10000.00, '贵阳市', 3, 3);
INSERT INTO `orders` VALUES (7, '2021-12-28 15:23:13', 10000.00, '贵阳市', 3, 3);
INSERT INTO `orders` VALUES (8, '2021-12-28 15:23:13', 10000.00, '贵阳市', 3, 3);
INSERT INTO `orders` VALUES (9, '2021-12-28 15:23:13', 10000.00, '贵阳市', 3, 3);
INSERT INTO `orders` VALUES (10, '2021-12-28 15:23:13', 10000.00, '贵阳市', 3, 3);
INSERT INTO `orders` VALUES (11, '2019-03-18 15:21:50', 5000.00, '毕节市七星关区', 1, 2);
INSERT INTO `orders` VALUES (12, '2019-03-18 15:21:50', 5000.00, '毕节市七星关区', 1, 2);
INSERT INTO `orders` VALUES (13, '2019-03-18 15:21:50', 5000.00, '毕节市七星关区', 1, 2);

-- ----------------------------
-- Table structure for sale_chance
-- ----------------------------
DROP TABLE IF EXISTS `sale_chance`;
CREATE TABLE `sale_chance`  (
  `sale_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `sale_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '客户名称',
  `sale_chance_source` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '机会来源：促销、广告、搜索引擎、线上咨询、电话咨询、邮件咨询、客户介绍',
  `sale_contact` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系人',
  `sale_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
  `sale_chance` int(0) NULL DEFAULT NULL COMMENT '成功几率',
  `sale_des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '概要',
  `sale_chance_des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '机会描述',
  `sale_creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `sale_creat_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `sale_assigned_to` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '指派给',
  `sale_assigned_time` datetime(0) NULL DEFAULT NULL COMMENT '指派时间',
  `sale_state` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '销售机会的状态为：未分配、已分配、开发成功、开发失败',
  PRIMARY KEY (`sale_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale_chance
-- ----------------------------
INSERT INTO `sale_chance` VALUES (2, 'fagf', '广告', 'df', '23', 32, '2323', '23223', 'user1', '2023-06-10 11:42:16', '西北', '2023-06-10 14:01:38', '开发成功');
INSERT INTO `sale_chance` VALUES (3, 'adf', '广告', 'afd', 'dsf', 33, 'asfdd', 'adfsdfs', 'user1', '2023-06-11 11:48:57', '西北', '2023-06-11 11:49:07', '已分配');
INSERT INTO `sale_chance` VALUES (4, '得分', '促销', 'df', '333', 33, '333', '333', 'user1', '2023-06-12 11:24:25', '华北', '2023-06-12 11:24:38', '已分配');
INSERT INTO `sale_chance` VALUES (5, 'er', '搜索引擎', 'erer', '3333', 33, 'fd', 'sdf', 'user1', '2023-06-12 14:19:56', 'tom', '2023-06-13 14:39:27', '已分配');
INSERT INTO `sale_chance` VALUES (6, 'er', '搜索引擎', 'erer', '3333', 33, 'fd', 'sdf', 'user1', '2023-06-12 14:19:56', NULL, NULL, '未分配');
INSERT INTO `sale_chance` VALUES (7, 'er', '搜索引擎', 'erer', '3333', 33, 'fd', 'sdf', 'user1', '2023-06-12 14:19:56', NULL, NULL, '未分配');
INSERT INTO `sale_chance` VALUES (8, 'er', '搜索引擎', 'erer', '3333', 33, 'fd', 'sdf', 'user1', '2023-06-12 14:19:56', NULL, NULL, '未分配');
INSERT INTO `sale_chance` VALUES (9, 'er', '搜索引擎', 'erer', '3333', 33, 'fd', 'sdf', 'user1', '2023-06-12 14:19:56', NULL, NULL, '未分配');
INSERT INTO `sale_chance` VALUES (10, 'er', '搜索引擎', 'erer', '3333', 33, 'fd', 'sdf', 'user1', '2023-06-12 14:19:56', NULL, NULL, '未分配');
INSERT INTO `sale_chance` VALUES (11, 'er', '搜索引擎', 'erer', '3333', 33, 'fd', 'sdf', 'user1', '2023-06-12 14:19:56', 'user1', '2023-06-12 14:53:12', '已分配');
INSERT INTO `sale_chance` VALUES (12, 'er', '搜索引擎', 'erer', '3333', 33, 'fd', 'sdf', 'user1', '2023-06-12 14:19:56', NULL, NULL, '未分配');
INSERT INTO `sale_chance` VALUES (13, 'er', '搜索引擎', 'erer', '3333', 33, 'fd', 'sdf', 'user1', '2023-06-12 14:19:56', NULL, NULL, '未分配');
INSERT INTO `sale_chance` VALUES (14, 'er', '搜索引擎', 'erer', '3333', 33, 'fd', 'sdf', 'user1', '2023-06-12 14:19:56', NULL, NULL, '未分配');
INSERT INTO `sale_chance` VALUES (15, 'er', '搜索引擎', 'erer', '3333', 33, 'fd', 'sdf', 'user1', '2023-06-12 14:19:56', NULL, NULL, '未分配');
INSERT INTO `sale_chance` VALUES (16, 'er', '搜索引擎', 'erer', '3333', 33, 'fd', 'sdf', 'user1', '2023-06-12 14:19:56', NULL, NULL, '未分配');
INSERT INTO `sale_chance` VALUES (17, 'df', '促销', 'df', 'fd', 33, 'dfs', 'df', 'adm', '2023-06-12 14:49:49', NULL, NULL, '未分配');
INSERT INTO `sale_chance` VALUES (19, 'bb', '线上咨询', 'aa', '32322', 33, 'fsad', 'sfd', 'adm', '2023-06-13 11:26:44', 'user2', '2023-06-13 11:26:53', '开发成功');

-- ----------------------------
-- Table structure for services
-- ----------------------------
DROP TABLE IF EXISTS `services`;
CREATE TABLE `services`  (
  `services_id` int(0) NOT NULL AUTO_INCREMENT,
  `services_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '服务类型：咨询、投诉、建议',
  `services_outline` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '概要',
  `services_requirement` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '详细要求',
  `cus_id` int(0) NULL DEFAULT NULL COMMENT '客户编号',
  `services_creator` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人：当前登录用户',
  `services_ctime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间：当前系统时间',
  `services_state` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态：新创建、已分配、已处理、已归档',
  `services_atime` datetime(0) NULL DEFAULT NULL COMMENT '分配时间',
  `services_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '处理人',
  `services_method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '处理方法',
  `services_ptime` datetime(0) NULL DEFAULT NULL COMMENT '处理时间',
  `services_feedback` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '客户反馈',
  `services_satisfaction` int(0) NULL DEFAULT NULL COMMENT '客户满意度：12345',
  `services_ftime` datetime(0) NULL DEFAULT NULL COMMENT '反馈时间',
  PRIMARY KEY (`services_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of services
-- ----------------------------
INSERT INTO `services` VALUES (15, '咨询', '1', '1', 1, 'user1', '2023-06-09 15:31:57', '已归档', '2023-06-09 15:32:07', 'user1', 'aaa', '2023-06-09 16:27:29', '3', 3, '2023-06-09 16:27:38');
INSERT INTO `services` VALUES (16, '投诉', 'aaa', 'aa', 1, 'user1', '2023-06-11 09:33:55', '已分配', '2023-06-11 09:34:01', 'user1', 'ok', '2023-06-12 15:04:33', 'ok', 1, '2023-06-12 15:04:48');
INSERT INTO `services` VALUES (17, '投诉', 'dfsdf', 'ff', 2, 'user1', '2023-06-12 14:12:31', '已分配', '2023-06-13 14:41:12', 'tom', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `services` VALUES (18, '投诉', 'dfsdf', 'ff', 2, 'user1', '2023-06-12 14:12:31', '新创建', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `services` VALUES (19, '投诉', 'dfsdf', 'ff', 2, 'user1', '2023-06-12 14:12:31', '新创建', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `services` VALUES (20, '投诉', 'dfsdf', 'ff', 2, 'user1', '2023-06-12 14:12:31', '已分配', '2023-06-12 15:24:06', 'user2', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `services` VALUES (21, '投诉', 'dfsdf', 'ff', 2, 'user1', '2023-06-12 14:12:31', '新创建', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `services` VALUES (22, '投诉', 'dfsdf', 'ff', 2, 'user1', '2023-06-12 14:12:31', '新创建', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `services` VALUES (23, '投诉', 'dfsdf', 'ff', 2, 'user1', '2023-06-12 14:12:31', '已归档', '2023-06-13 14:11:22', 'user1', 'sfd', '2023-06-13 14:11:55', 'fe', 5, '2023-06-13 14:12:07');
INSERT INTO `services` VALUES (24, '投诉', 'dfsdf', 'ff', 2, 'user1', '2023-06-12 14:12:31', '新创建', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `services` VALUES (25, '投诉', 'dfsdf', 'ff', 2, 'user1', '2023-06-12 14:12:31', '新创建', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `services` VALUES (26, '投诉', 'dfsdf', 'ff', 2, 'user1', '2023-06-12 14:12:31', '新创建', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `services` VALUES (27, '投诉', 'dfsdf', 'ff', 2, 'user1', '2023-06-12 14:12:31', '新创建', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `services` VALUES (28, '投诉', 'dfsdf', 'ff', 2, 'user1', '2023-06-12 14:12:31', '新创建', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `services` VALUES (29, '咨询', '1', '1', 1, 'user1', '2023-06-09 15:31:57', '已归档', '2023-06-09 15:32:07', 'user1', 'aaa', '2023-06-09 16:27:29', '3', 3, '2023-06-09 16:27:38');
INSERT INTO `services` VALUES (30, '咨询', '1', '1', 1, 'user1', '2023-06-09 15:31:57', '已归档', '2023-06-09 15:32:07', 'user1', 'aaa', '2023-06-09 16:27:29', '3', 3, '2023-06-09 16:27:38');
INSERT INTO `services` VALUES (31, '咨询', '1', '1', 1, 'user1', '2023-06-09 15:31:57', '已归档', '2023-06-09 15:32:07', 'user1', 'aaa', '2023-06-09 16:27:29', '3', 3, '2023-06-09 16:27:38');
INSERT INTO `services` VALUES (32, '咨询', '1', '1', 1, 'user1', '2023-06-09 15:31:57', '已归档', '2023-06-09 15:32:07', 'user1', 'aaa', '2023-06-09 16:27:29', '3', 3, '2023-06-09 16:27:38');
INSERT INTO `services` VALUES (33, '咨询', '1', '1', 1, 'user1', '2023-06-09 15:31:57', '已归档', '2023-06-09 15:32:07', 'user1', 'aaa', '2023-06-09 16:27:29', '3', 3, '2023-06-09 16:27:38');
INSERT INTO `services` VALUES (34, '咨询', '1', '1', 1, 'user1', '2023-06-09 15:31:57', '已归档', '2023-06-09 15:32:07', 'user1', 'aaa', '2023-06-09 16:27:29', '3', 3, '2023-06-09 16:27:38');
INSERT INTO `services` VALUES (35, '咨询', '1', '1', 1, 'user1', '2023-06-09 15:31:57', '已归档', '2023-06-09 15:32:07', 'user1', 'aaa', '2023-06-09 16:27:29', '3', 3, '2023-06-09 16:27:38');
INSERT INTO `services` VALUES (36, '咨询', '1', '1', 1, 'user1', '2023-06-09 15:31:57', '已归档', '2023-06-09 15:32:07', 'user1', 'aaa', '2023-06-09 16:27:29', '3', 3, '2023-06-09 16:27:38');
INSERT INTO `services` VALUES (37, '咨询', '1', '1', 1, 'user1', '2023-06-09 15:31:57', '已归档', '2023-06-09 15:32:07', 'user1', 'aaa', '2023-06-09 16:27:29', '3', 3, '2023-06-09 16:27:38');
INSERT INTO `services` VALUES (38, '咨询', '1', '1', 1, 'user1', '2023-06-09 15:31:57', '已归档', '2023-06-09 15:32:07', 'user1', 'aaa', '2023-06-09 16:27:29', '3', 3, '2023-06-09 16:27:38');
INSERT INTO `services` VALUES (39, '咨询', '1', '1', 1, 'user1', '2023-06-09 15:31:57', '已归档', '2023-06-09 15:32:07', 'user1', 'aaa', '2023-06-09 16:27:29', '3', 3, '2023-06-09 16:27:38');
INSERT INTO `services` VALUES (40, '咨询', '1', '1', 1, 'user1', '2023-06-09 15:31:57', '已归档', '2023-06-09 15:32:07', 'user1', 'aaa', '2023-06-09 16:27:29', '3', 3, '2023-06-09 16:27:38');
INSERT INTO `services` VALUES (41, '咨询', '1', '1', 1, 'user1', '2023-06-09 15:31:57', '已归档', '2023-06-09 15:32:07', 'user1', 'aaa', '2023-06-09 16:27:29', '3', 3, '2023-06-09 16:27:38');
INSERT INTO `services` VALUES (42, '咨询', '1', '1', 1, 'user1', '2023-06-09 15:31:57', '已归档', '2023-06-09 15:32:07', 'user2', 'aaa', '2023-06-09 16:27:29', '3', 3, '2023-06-09 16:27:38');
INSERT INTO `services` VALUES (43, '咨询', 'hh', 'hh', 6, 'adm', '2023-06-12 15:04:14', '新创建', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `services` VALUES (44, '建议', 'efef', 'fee', 3, 'adm', '2023-06-12 15:06:37', '新创建', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `services` VALUES (45, '建议', 'efef', 'fee', 3, 'adm', '2023-06-12 15:06:37', '新创建', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `services` VALUES (46, '建议', 'efef', 'fee', 3, 'adm', '2023-06-12 15:06:37', '新创建', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `services` VALUES (47, '建议', 'efef', 'fee', 3, 'adm', '2023-06-12 15:06:37', '新创建', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `services` VALUES (48, '建议', 'efef', 'fee', 3, 'adm', '2023-06-12 15:06:37', '新创建', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `services` VALUES (49, '建议', 'aa', 'aa', 3, 'adm', '2023-06-13 14:07:27', '已归档', '2023-06-13 14:07:37', 'user2', 'fdsd', '2023-06-13 14:07:44', 'ok', 3, '2023-06-13 14:07:58');
INSERT INTO `services` VALUES (50, '投诉', 'sdffsd', 'sfdsdf', 3, 'adm', '2023-06-13 14:11:13', '新创建', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `su_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户编号，主键，自动递增',
  `su_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `su_pwd` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `su_role` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户角色',
  PRIMARY KEY (`su_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '$10$IzbTf2fN2PI2OUJQfI4TpeAQcAU8Ci/5WFyZwdKNv5KAkLro3R6hi', 'ADMIN');
INSERT INTO `sys_user` VALUES (2, 'user1', '$10$IzbTf2fN2PI2OUJQfI4TpeAQcAU8Ci/5WFyZwdKNv5KAkLro3R6hi', 'SALES');
INSERT INTO `sys_user` VALUES (3, 'user2', '$10$IzbTf2fN2PI2OUJQfI4TpeAQcAU8Ci/5WFyZwdKNv5KAkLro3R6hi', 'SALES');
INSERT INTO `sys_user` VALUES (5, 'adm', '$2a$10$IzbTf2fN2PI2OUJQfI4TpeAQcAU8Ci/5WFyZwdKNv5KAkLro3R6hi', 'MANAGER');
INSERT INTO `sys_user` VALUES (10, 'tom', '$2a$10$vLgUlJ5SNjIvdzEYUnJMcesOTqQZdnt6g1/ZbD6hK2V8/Yl0agoqi', 'SALES');
INSERT INTO `sys_user` VALUES (11, 'bob', '$2a$10$UJJf.qAglTdsJ3JYWa9tuOIDVUZaf.N9j/m4QrbZNKrO.J3VN8OKe', '销售主管');
INSERT INTO `sys_user` VALUES (12, 'qwer', '$2a$10$46tnzDf7HxIgyWKPKcB4teLDeGAsYEe2VwyqcH4csQslLbetpyJ/2', '高管');
INSERT INTO `sys_user` VALUES (13, 'ff', '$2a$10$/kMfB6FHnkGEEY/JarlL.uS6sKgXJ3flc2eD/ROidfFVP6PbAiFX6', '销售主管');

SET FOREIGN_KEY_CHECKS = 1;
