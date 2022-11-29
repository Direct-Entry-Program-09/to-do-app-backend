
DROP TABLE IF EXISTS `todo_item`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `username` varchar(40) NOT NULL,
                        `password` varchar(100) NOT NULL,
                        `fullName` varchar(200) NOT NULL,
                        PRIMARY KEY (`username`)
) ;

INSERT INTO `user` VALUES ('nipunija','nip123','nipuni jayathilaka'),('pavijaya','jaya123','pavithra jayathilaka');

CREATE TABLE `todo_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `description` varchar(200) NOT NULL,
  `status` enum('DONE','NOT-DONE') NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
);

INSERT INTO `todo_item` VALUES (1,'nipunija','wakingup','DONE');

