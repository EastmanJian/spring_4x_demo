DROP TABLE student;
CREATE TABLE student (
  ID   INT         NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(20) NOT NULL,
  AGE  INT         NOT NULL,
  PRIMARY KEY (ID)
);

DROP TABLE Marks;
CREATE TABLE Marks (
  SID   INT NOT NULL,
  MARKS INT NOT NULL,
  YEAR  INT NOT NULL
);

INSERT INTO student (name, age) VALUES ('Zara', 11);
INSERT INTO student (name, age) VALUES ('Nuha', 20);
INSERT INTO student (name, age) VALUES ('Ayan', 15);

SELECT * FROM student;
SELECT * FROM Marks;

DELETE FROM student
WHERE id > 0;


