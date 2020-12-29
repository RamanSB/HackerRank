-- CREATE TABLE employees (
-- 	ID INTEGER AUTO_INCREMENT,
--     Name VARCHAR(200),
--     Salary INTEGER,
--     PRIMARY KEY (ID)
-- );

-- INSERT INTO employees (Name, Salary)
-- VALUES
-- ('Kristeen', 1420),
-- ('Ashley', 2006),
-- ('Julia', 2210),
-- ('Maria', 3000);

-- Task
-- Find the average salary in the salary column with all 0 values excluded
-- Find the average salary in the salary column with all 0 values included
-- Find the difference between these 2 values.

SELECT CEIL(AVG(Salary) - AVG(REPLACE(Salary, 0, ""))) FROM employees;