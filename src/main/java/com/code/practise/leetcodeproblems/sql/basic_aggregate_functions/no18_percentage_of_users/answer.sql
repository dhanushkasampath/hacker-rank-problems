SELECT r.contest_id,
ROUND(COUNT(DISTINCT r.user_id) * 100 /(SELECT COUNT(u.user_id) FROM Users u), 2) AS percentage
FROM Register r
GROUP BY r.contest_id
ORDER BY percentage DESC, r.contest_id ASC;

--This problem doesn't want a join.
--First we need to identify that we need to GROUP BY contest_id. and ORDER BY percentage in desc first and r.contest_id in ASC second
--When we apply GROUP BY the rows belong to that group act as a separate table. So we can use
--"COUNT(DISTINCT r.user_id)" to get the no of users relevant to that particular group.
--Then we can use sub-query "SELECT COUNT(u.user_id) FROM Users u" to return the total number of users in Users table.
--
--Then we can pass the calculation to ROUND function

T