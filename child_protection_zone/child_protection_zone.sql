CREATE TABLE `child_protection_zone` (
  `id` int NOT NULL AUTO_INCREMENT,
  `facility_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `target_facility_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `road_name` varchar(50) NOT NULL,
  `address` varchar(40) DEFAULT NULL,
  `latitude` double NOT NULL,
  `hardness` double NOT NULL,
  `organization_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `police_station_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `whether_install` varchar(1) DEFAULT NULL,
  `count_install` int DEFAULT '0',
  `base_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=841 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci