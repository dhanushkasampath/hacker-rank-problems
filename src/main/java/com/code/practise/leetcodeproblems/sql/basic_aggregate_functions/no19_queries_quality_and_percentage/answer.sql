SELECT query_name, ROUND(AVG(RATING/POSITION), 2) AS quality,
round(SUM(CASE WHEN rating < 3 THEN 1 ELSE 0 END) * 100 / count(*), 2) AS poor_query_percentage
FROM Queries
WHERE query_name IS NOT NULL
GROUP BY query_name;

--we can use "SUM(CASE WHEN rating < 3 THEN 1 ELSE 0 END)" as a count one by one which match the given condition