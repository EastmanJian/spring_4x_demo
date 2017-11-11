SELECT * FROM world.city;
SELECT count(*)
FROM world.city;

DROP TABLE student;
CREATE TABLE student (
  ID   INT         NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(20) NOT NULL,
  AGE  INT         NOT NULL,
  PRIMARY KEY (ID)
);

INSERT INTO student (name, age) VALUES ('Zara', 11);
INSERT INTO student (name, age) VALUES ('Nuha', 20);
INSERT INTO student (name, age) VALUES ('Ayan', 15);
SELECT * FROM student;

DELETE FROM student WHERE id > 0;


DELIMITER $$

DROP PROCEDURE IF EXISTS `TEST`.`getRecord` $$
CREATE PROCEDURE `TEST`.`getRecord`(
  IN  in_id    INTEGER,
  OUT out_name VARCHAR(20),
  OUT out_age  INTEGER)
  BEGIN
    SELECT name, age
    INTO out_name, out_age
    FROM Student
    WHERE id = in_id;
  END $$

DELIMITER ;

SET @id = 3;
CALL `test`.`getRecord`(@id, @studentName, @age);
SELECT @studentName, @age;
