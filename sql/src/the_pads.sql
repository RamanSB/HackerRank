--PROBLEM (THE PADS) | https://www.hackerrank.com/challenges/the-pads/problem?h_r=next-challenge&h_v=zen--

CREATE TABLE OCCUPATIONS (
	Name VARCHAR(200),
	Occupation VARCHAR(200)
);

INSERT INTO OCCUPATIONS (Name, Occupation)
VALUES
('Samantha', 'Doctor'),
('Julia', 'Actor'),
('Maria', 'Actor'),
('Meera', 'Singer'),
('Ashely', 'Professor'),
('Ketty', 'Professor'),
('Christeen', 'Professor'),
('Jane', 'Actor'),
('Jenny', 'Doctor'),
('Priya','Singer');

SELECT CONCAT(Name, '(', left(occupation, 1),')') FROM OCCUPATIONS
ORDER BY Name;

SELECT CONCAT(Name, '(', left(Occupation, 1),')') FROM OCCUPATIONS
ORDER BY Name;

SELECT CONCAT('There are a total of ', COUNT(1), ' ', LOWER(Occupation),'s.') FROM OCCUPATIONS
GROUP BY Occupation
ORDER BY COUNT(1) ASC;