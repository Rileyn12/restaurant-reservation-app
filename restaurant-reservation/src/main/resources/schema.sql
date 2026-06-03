CREATE TABLE reservation (
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    party_size INT NOT NULL,
    contact_info VARCHAR(255),
    time VARCHAR(255),
    date VARCHAR(255)
);

CREATE TABLE completedelete (
    id INT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    party_size INT NOT NULL,
    contact_info VARCHAR(255),
    time VARCHAR(255),
    date VARCHAR(255)
);

CREATE TABLE login (
    login_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255)
)