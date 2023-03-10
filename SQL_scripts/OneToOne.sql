CREATE TABLE Person
(
    id   INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(100) NOT NULL,
    age  INT CHECK ( age < 100 )
);

CREATE TABLE Passport(
    id int GENERATED BY DEFAULT AS IDENTITY ,
    passport_number INT NOT NULL,
    person_id int UNIQUE REFERENCES Person(id) ON DELETE CASCADE

);
