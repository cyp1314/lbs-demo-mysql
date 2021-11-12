CREATE TABLE `nearby_user` (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `name` varchar(255) DEFAULT NULL COMMENT '名称',
                               `longitude` double DEFAULT NULL COMMENT '经度',
                               `latitude` double DEFAULT NULL COMMENT '纬度',
                               `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
