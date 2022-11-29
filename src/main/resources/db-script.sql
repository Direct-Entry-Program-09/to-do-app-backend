CREATE TABLE user(
    username VARCHAR(40) PRIMARY KEY ,
    password VARCHAR(100) NOT NULL ,
    fullName VARCHAR(200) NOT NULL
);

CREATE TABLE todo_item(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  username VARCHAR(40) NOT NULL ,
  description VARCHAR(200) NOT NULL ,
  status ENUM('DONE','NOTDONE') NOT NULL ,
  CONSTRAINT fk FOREIGN KEY (username) REFERENCES user(username)
);
INSERT INTO user VALUES ('Rashmi','Abc@123','Rashmi Jayasekara'),('Dinithi','Athula@789','Dinithi Lakma');

INSERT INTO todo_item VALUES (3,'Rashmi','Complete DAO Layer','DONE'),(4,'Dinithi','Complete Service Layer','NOTDONE');