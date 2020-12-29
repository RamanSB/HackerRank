-- CREATE TABLE hackers (
-- 	hacker_id INTEGER,
--     name VARCHAR(200)
-- );

-- CREATE TABLE challenges (
-- 	challenge_id INTEGER,
--     hacker_id INTEGER
-- );

-- INSERT INTO hackers (hacker_id, name)
-- VALUES
-- (5077, 'Rose'),
-- (21283, 'Angela'),
-- (62743, 'Frank'),
-- (88255, 'Patrick'),
-- (96196, 'Lisa');

-- INSERT INTO challenges (challenge_id, hacker_id)
-- VALUES
-- (61654, 5077),
-- (58302, 21283),
-- (40587, 88255),
-- (29477, 5077),
-- (1220, 21283),
-- (69514, 21283),
-- (46561, 62743),
-- (58077, 62743),
-- (18483, 88255),
-- (76766, 21283),
-- (52382, 5077),
-- (74467, 21283),
-- (33625, 96196),
-- (26053, 88255),
-- (42665, 62743),
-- (70094, 21283),
-- (34599, 88255),
-- (54680, 88255),
-- (61881, 5077);

-- INSERT INTO challenges (challenge_id, hacker_id)
-- VALUES
-- (12859, 62743);

-- Sorting constraints: Sort your results by the total number of challenges in descending order.
-- If more than one student created the same number of challenges, then sort the result by hacker_id.

-- Row display constraints:  If more than one student created the same number of challenges and the count is less than the maximum number of challenges created,
-- then exclude those students from the result.

-- This is the starting point
-- I was thinking to store the max count in a variable and use it in a HAVING clause, but hackerrank solutions with variables don't always pass.
-- SET @max_count=0;

-- SELECT @max_count:=COUNT(1) as challenge_count FROM hackers h
-- JOIN challenges c ON h.hacker_id = c.hacker_id
-- GROUP BY h.hacker_id, h.name
-- ORDER BY challenge_count DESC
-- LIMIT 1;


-- This query is responsible for finding the challenge counts that only appear once, i.e. the #challenges that are unique.
SELECT challenge_count FROM
	(SELECT challenge_count, COUNT(1) as counters_count FROM
		(SELECT COUNT(1) as challenge_count FROM challenges
		GROUP BY hacker_id) intermediate_table_2
	GROUP BY challenge_count
	HAVING counters_count = 1) intermediate_table_3;



SELECT h.hacker_id, h.name, COUNT(1) as challenge_count FROM hackers h
JOIN challenges c ON h.hacker_id = c.hacker_id
GROUP BY h.hacker_id, h.name
HAVING challenge_count = (SELECT MAX(intermediate_table.challenge_count) as max_challenge_count FROM
	(SELECT hacker_id, COUNT(challenge_id) as challenge_count FROM challenges
	GROUP BY hacker_id) intermediate_table)
OR challenge_count IN (
	SELECT challenge_count FROM
		(SELECT challenge_count, COUNT(1) as counters_count FROM
			(SELECT COUNT(1) as challenge_count FROM challenges
			GROUP BY hacker_id) intermediate_table_2
		GROUP BY challenge_count
		HAVING counters_count = 1) intermediate_table_3
)
ORDER BY challenge_count DESC, h.hacker_id; -- Sorting required for sorting constraint above






