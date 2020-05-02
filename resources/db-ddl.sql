CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(20) NOT NULL,
  `age` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



CREATE TABLE  `auditlog` (
       `AUDIT_LOG_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
       `ACTION` varchar(100) NOT NULL,
       `DETAIL` text NOT NULL,
       `CREATED_DATE` date NOT NULL,
       `ENTITY_ID` bigint(20) unsigned NOT NULL,
       `ENTITY_NAME` varchar(255) NOT NULL,
       PRIMARY KEY (`AUDIT_LOG_ID`)
 ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
 
 
 
  CREATE TABLE `advertiser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `address` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


 CREATE TABLE `insertion_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `advertiser_id`int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (advertiser_id) REFERENCES advertiser(id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

