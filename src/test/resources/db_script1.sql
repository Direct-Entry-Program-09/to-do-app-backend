CREATE TABLE `user` (
                        `username` varchar(40) NOT NULL,
                        `password` varchar(100) NOT NULL,
                        `fullName` varchar(200) NOT NULL,
                        PRIMARY KEY (`username`)
);

CREATE TABLE `todo_item` (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `username` varchar(40) NOT NULL,
                             `description` varchar(200) NOT NULL,
                             `status` enum('DONE','NOTDONE') NOT NULL,
                             PRIMARY KEY (`id`),
                             CONSTRAINT `fk` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
);

INSERT INTO `user` VALUES ('Dinithi','Athula@789','Dinithi Lakma'),('Rashmi','Abc@123','Rashmi Jayasekara');

INSERT INTO `todo_item` VALUES (1,'Rashmi','Complete DAO Layer','DONE'),(2,'Dinithi','Complete Service Layer','NOTDONE');




