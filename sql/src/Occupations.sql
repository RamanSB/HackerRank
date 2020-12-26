-- START
-- Name, Occupation
-- 'Samantha','Doctor'
-- 'Julia','Actor'
-- 'Maria','Actor'
-- 'Meera','Singer'
-- 'Ashely','Professor'
-- 'Ketty','Professor'
-- 'Christeen','Professor'
-- 'Jane','Actor'
-- 'Jenny','Doctor'
-- 'Priya','Singer'

-- END
-- Doctor, Professor, Singer, Actor
-- Jenny    Ashley     Meera  Jane
-- Samantha Christeen  Priya  Julia
-- NULL     Ketty      NULL   Maria


SELECT * FROM OCCUPATIONS;

SELECT
	(CASE
		WHEN Occupation = 'Doctor' THEN Name
	END) As Doctor,
    (CASE
		WHEN Occupation = 'Professor' THEN Name
	END) As Actor,
    (CASE
		WHEN Occupation = 'Singer' THEN Name
	END) AS Singer,
    (CASE
		WHEN Occupation = 'Actor' THEN Name
	END) AS Actor
FROM OCCUPATIONS
ORDER BY Name;

--SQL currently returns the below

--NULL,'Ashely',NULL,NULL
--NULL,'Christeen',NULL,NULL
--NULL,NULL,NULL,'Jane'
--'Jenny',NULL,NULL,NULL
--NULL,NULL,NULL,'Julia'
--NULL,'Ketty',NULL,NULL
--NULL,NULL,NULL,'Maria'
--NULL,NULL,'Meera',NULL
--NULL,NULL,'Priya',NULL
--'Samantha',NULL,NULL,NULL
