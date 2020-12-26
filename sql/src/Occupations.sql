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

-- Declaring variables
SET @d=0, @p=0, @s=0, @a=0;
SELECT MAX(intermediate.Doctor), MAX(intermediate.Professor), MAX(intermediate.Singer), MAX(intermediate.Actor) FROM
	(SELECT
		(CASE
			WHEN Occupation = 'Doctor' THEN (@d:=@d+1)
			WHEN Occupation = 'Professor' THEN (@p:=@p+1)
			WHEN Occupation = 'Singer' THEN (@s:=@s+1)
			WHEN Occupation = 'Actor' THEN (@a:=@a+1)
		END) as Count,
		(CASE
			WHEN Occupation = 'Doctor' THEN Name
		END) As Doctor,
		(CASE
			WHEN Occupation = 'Professor' THEN Name
		END) As Professor,
		(CASE
			WHEN Occupation = 'Singer' THEN Name
		END) AS Singer,
		(CASE
			WHEN Occupation = 'Actor' THEN Name
		END) AS Actor
	FROM OCCUPATIONS
	ORDER BY Name) intermediate
GROUP BY intermediate.count -- This ensures that where a value exists with column value set to 1, all corresponding names will be on the same row - the same applies for rows 2 & 3
-- however when invoking GROUP BY we must ensure we use an aggregate function
-- https://www.w3schools.com/sql/sql_groupby.asp#:~:text=The%20GROUP%20BY%20statement%20groups,by%20one%20or%20more%20columns.
