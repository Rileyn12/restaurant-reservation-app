CREATE TABLE reservation (
                             reservation_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
                             firstName TEXT,
                             lastName TEXT,
                             partySize INT NOT NULL,
                             contactInfo TEXT,
                             time TEXT,
                             date TEXT
);

/*CREATE TABLE login (
                       login_id INT IDENTITY PRIMARY KEY,
                       username VARCHAR(255),
                       password VARCHAR(255)
);

CREATE TABLE oldReservation (
                                reservation_id INT IDENTITY PRIMARY KEY,
                                firstName VARCHAR(255),
                                lastName VARCHAR(255),
                                partySize INT NOT NULL,
                                contactInfo VARCHAR(255),
                                time VARCHAR(255),
                                date VARCHAR(255)
);*/