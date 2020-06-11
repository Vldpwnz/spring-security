DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS(
id INT AUTO_INCREMENT PRIMARY KEY,
user_name VARCHAR(30),
password VARCHAR(60),
role ENUM('ADMIN', 'USER')
);

INSERT INTO USERS(user_name, password, role)
VALUES
('vldpwnz', 'password', 'admin'),
('badpwnz', 'password', 'user'),
('usb', 'password', 'user');