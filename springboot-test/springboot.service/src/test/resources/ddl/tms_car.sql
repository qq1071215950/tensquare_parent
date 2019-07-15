/******************************************/
/*   数据库全名 = wdk_tms_trunk   */
/*   表名称 = tms_car   */
/******************************************/
DROP TABLE `tms_car` IF EXISTS;
CREATE TABLE `tms_car` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `merchant_code` varchar(32) NOT NULL COMMENT '商家编码',
  `code` varchar(32) NOT NULL COMMENT '车辆编码',
  `car_model_code` varchar(32) COMMENT '车型编码',
  `plate_number` varchar(32) NOT NULL COMMENT '车牌号',
  `owner_type` char(1) DEFAULT NULL COMMENT '车辆归属',
  `owner_phone` varchar(32) DEFAULT NULL COMMENT '归属人手机号',
  `owner_trans_code` varchar(32) DEFAULT NULL COMMENT '归属运营商',
  `driver_code` varchar(32) DEFAULT NULL COMMENT '司机编码',
  `certificate_code` varchar(32) DEFAULT NULL COMMENT '证件编码',
  `state` char(1) NOT NULL DEFAULT '0' COMMENT '业务状态',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `gmt_create` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `creator` varchar(2000) DEFAULT NULL COMMENT '创建者',
  `modifier` varchar(2000) DEFAULT NULL COMMENT '修改者',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `is_gps` char(1) DEFAULT '0' COMMENT '是否装备GPS',
  `energy_type` char(1) DEFAULT '0' COMMENT '能源类型',
  `gps_manufacturers` varchar(8) DEFAULT NULL COMMENT 'GPS厂商',
  `door_num` int(11) DEFAULT NULL COMMENT '车门数',
  `last_loading_station_code` varchar(32) DEFAULT NULL COMMENT '最后调度站点编码',
  PRIMARY KEY (`id`),
--  UNIQUE KEY `uk_code` (`code`),
--  KEY `idx_plate_number` (`plate_number`)
) COMMENT='车辆'
;
