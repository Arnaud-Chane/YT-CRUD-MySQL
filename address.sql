CREATE TABLE Address (
    id INT AUTO_INCREMENT,
    number INT,
    street VARCHAR(255),
    postcode VARCHAR(255),
    PRIMARY KEY (id)
);

INSERT INTO Address (number, street, postcode) VALUES
(123, 'Baker Street', 'NW1 6XE'),
(456, 'Fleet Street', 'EC4A 2BH'),
(789, 'King’s Road', 'SW3 5XP'),
(101, 'Oxford Street', 'W1D 2LA'),
(112, 'Brick Lane', 'E1 6RL');

--DROP TABLE address;