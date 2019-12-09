/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50549
Source Host           : 127.0.0.1:3306
Source Database       : loading

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2019-12-09 14:51:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_loading
-- ----------------------------
DROP TABLE IF EXISTS `t_loading`;
CREATE TABLE `t_loading` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loading_no` varchar(32) NOT NULL COMMENT '运输单号',
  `send_station_id` int(11) NOT NULL COMMENT '首发站点',
  `end_station_id` int(11) NOT NULL COMMENT '末站点',
  `price_quote` varchar(32) NOT NULL COMMENT '报价方式',
  `line_name` varchar(32) NOT NULL COMMENT '站点名称',
  `transfer_type` varchar(255) DEFAULT NULL COMMENT '运输方式',
  `station_count` int(11) NOT NULL COMMENT '线路站点数量',
  `plan_arrival_time` datetime NOT NULL COMMENT '计划到达首站时间',
  `plan_send_time` datetime NOT NULL COMMENT '首站点计划发车时间',
  `plan_complate_time` datetime NOT NULL COMMENT '计划完成时间',
  `actual_arrival_time` datetime DEFAULT NULL COMMENT '实际到达首站点时间',
  `actual_send_time` datetime DEFAULT NULL COMMENT '首站点实际发车时间',
  `actual_complate_time` datetime DEFAULT NULL COMMENT '实际完成时间',
  `loading_state` varchar(10) NOT NULL COMMENT '运单状态',
  `saler` varchar(10) NOT NULL COMMENT '商家',
  `forwarder` varchar(32) NOT NULL COMMENT '运输商',
  `plate_no` varchar(10) NOT NULL COMMENT '车牌',
  `temperature_layer` varchar(32) DEFAULT NULL COMMENT '温层',
  `driver_name` varchar(16) NOT NULL COMMENT '司机',
  `tel` varchar(11) NOT NULL COMMENT '联系电话',
  `createor` varchar(16) DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(16) DEFAULT NULL COMMENT '修改人',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_loading
-- ----------------------------
INSERT INTO `t_loading` VALUES ('1', '1113110851', '1', '2', '', 'jx-hn', null, '2', '2019-12-06 14:41:24', '2019-12-06 16:41:21', '2019-12-06 15:41:42', '2019-12-06 16:41:52', '2019-12-06 16:41:55', '2019-12-07 14:42:47', 'complate', 'dd', 'dd', '111', '10', '张', '111', null, null, null, null);

-- ----------------------------
-- Table structure for t_loadingstation
-- ----------------------------
DROP TABLE IF EXISTS `t_loadingstation`;
CREATE TABLE `t_loadingstation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loading_id` int(11) NOT NULL COMMENT '运单id',
  `station_id` int(11) NOT NULL COMMENT '站点id',
  `station_status` varchar(16) DEFAULT NULL COMMENT '站点状态',
  `seq` int(11) DEFAULT NULL,
  `plan_arrival_time` datetime NOT NULL COMMENT '计划到达时间',
  `plan_send_time` datetime NOT NULL COMMENT '计划发车时间',
  `actual_arrival_time` datetime DEFAULT NULL COMMENT '实际到达时间',
  `actual_send_time` datetime DEFAULT NULL COMMENT '实际发车时间',
  `createor` varchar(16) DEFAULT NULL,
  `modifier` varchar(16) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_loadingstation
-- ----------------------------
INSERT INTO `t_loadingstation` VALUES ('1', '1', '1', 'complate', '1', '2019-12-06 14:45:11', '2019-12-06 14:45:13', '2019-12-06 14:45:15', '2019-12-06 14:45:18', null, null, null, null);
INSERT INTO `t_loadingstation` VALUES ('2', '1', '2', 'complate', '2', '2019-12-06 15:45:52', '2019-12-06 15:45:57', '2019-12-06 15:46:00', '2019-12-06 15:46:03', null, null, null, null);

-- ----------------------------
-- Table structure for t_loading_station
-- ----------------------------
DROP TABLE IF EXISTS `t_loading_station`;
CREATE TABLE `t_loading_station` (
  `id` int(11) DEFAULT NULL,
  `loading_id` int(11) NOT NULL COMMENT '运单id',
  `station_id` int(11) NOT NULL COMMENT '站点id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_loading_station
-- ----------------------------
INSERT INTO `t_loading_station` VALUES ('1', '1', '1');
INSERT INTO `t_loading_station` VALUES ('2', '1', '2');

-- ----------------------------
-- Table structure for t_station
-- ----------------------------
DROP TABLE IF EXISTS `t_station`;
CREATE TABLE `t_station` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(8) NOT NULL COMMENT '编码',
  `name` varchar(8) NOT NULL COMMENT '站点名称',
  `province_code` varchar(16) DEFAULT NULL COMMENT '省',
  `province_name` varchar(16) DEFAULT NULL,
  `city_code` varchar(16) DEFAULT NULL COMMENT '市',
  `city_name` varchar(16) DEFAULT NULL,
  `area_code` varchar(16) DEFAULT NULL,
  `area_name` varchar(16) DEFAULT NULL,
  `createor` varchar(16) DEFAULT NULL,
  `modifier` varchar(16) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_station
-- ----------------------------
INSERT INTO `t_station` VALUES ('1', 'jn', '测试点1', 'hn', '湖南', 'cs', '长沙', 'yl', '岳麓', null, null, null, null);
INSERT INTO `t_station` VALUES ('2', 'zj', '测试点2', 'zj', '浙江', 'hz', '杭州', 'mj', '美景', null, null, null, null);
