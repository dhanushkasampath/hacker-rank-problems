(SELECT u.name AS results
FROM MovieRating m
LEFT JOIN Users u
ON m.user_id = u.user_id
GROUP BY m.user_id
ORDER BY COUNT(*) DESC, u.name ASC
LIMIT 1)

UNION ALL

(SELECT mo.title AS results
FROM MovieRating m
LEFT JOIN Movies mo
ON m.movie_id = mo.movie_id
WHERE EXTRACT(YEAR_MONTH FROM created_at) = 202002
GROUP BY m.movie_id
ORDER BY AVG(rating) DESC, mo.title ASC
LIMIT 1)



--in this type of problems approach the question step by step.
--AVG(rating) could be used with ORDER BY
--
--UNION ALL is used to aggregate two result sets together