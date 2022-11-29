CREATE TABLE user(
    username VARCHAR(40) PRIMARY KEY ,
    password VARCHAR(100) NOT NULL ,
    fullName VARCHAR(200) NOT NULL
);

CREATE TABLE todo_item(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  username VARCHAR(40) NOT NULL ,
  description VARCHAR(200) NOT NULL ,
  status ENUM('DONE','NOT-DONE') NOT NULL ,
  CONSTRAINT fk FOREIGN KEY (username) REFERENCES user(username)
);
