DROP TABLE IF EXISTS video;
DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY ,
   username VARCHAR(20) NOT NULL UNIQUE
   );

create table video(
    id INT AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL ,
    tag VARCHAR(255) not null,
    likes INT NOT NULL,
    dislikes INT NOT NULL,
    views INT NOT NULL,
    userId INT NOT NULL,
    PRIMARY KEY (id, tag),
    FOREIGN KEY (userId) REFERENCES user(id)
);