--@block
CREATE TABLE Address (
  id INT AUTO_INCREMENT,
  number INT,
  street VARCHAR(255),
  postcode VARCHAR(255),
  PRIMARY KEY (id)
);
--@block
INSERT INTO Address (number, street, postcode) VALUES
(123, 'Main St', '12345'),
(456, 'Oak St', '67890'),
(789, 'Pine St', '11121'),
(123, 'Main St', '12345'),
(456, 'Oak St', '67890'),
(789, 'Pine St', '11121'),
(321, 'Elm St', '22243'),
(654, 'Maple St', '33365'),
(987, 'Cedar Mt', '44487'),
(321, 'Elm St', '22243'),
(654, 'Maple St', '33365'),
(987, 'Cedar Mt', '44487'),
(135, 'Birch St', '55509'),
(246, 'Walnut St', '66621'),
(357, 'Cherry St', '77743'),
(135, 'Birch Mt', '55509'),
(246, 'Walnut St', '66621'),
(357, 'Cherry Mt', '77743'),
(123, 'Main St', '12345'),
(456, 'Oak St', '67890');
--@block
DROP TABLE address;
--@block
SELECT *
FROM Address;




--@block
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO user (username, password) VALUES
('user1', 'password1'),
('user2', 'password2'),
('user3', 'password3'),
('user4', 'password4'),
('user5', 'password5');

--@block
DROP TABLE user;
--@block
SELECT *
FROM user;