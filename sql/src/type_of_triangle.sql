---PROBLEM (Type of Triangle): https://www.hackerrank.com/challenges/what-type-of-triangle/problem---

CREATE TABLE triangles (
	A INT,
    B INT,
    C INT
);

INSERT INTO triangles (A, B, C)
VALUES
(20,20,23),
(20,20,20),
(20,21,22),
(13,14,30);

SELECT
CASE WHEN A + B > C THEN
        CASE
            WHEN (A=B AND B=C) THEN 'Equilateral'  -- This case is 1st as all equilaterals classify satisfy being isosoceles.
            WHEN (A=B OR B=C OR A=C) THEN 'Isosceles'
            ELSE 'Scalene'
        END
     ELSE 'Not A Triangle'
END
FROM triangles;

