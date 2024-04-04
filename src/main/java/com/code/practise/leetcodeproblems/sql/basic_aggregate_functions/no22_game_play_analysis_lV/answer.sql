SELECT
  ROUND(COUNT(DISTINCT a1.player_id) / (SELECT COUNT(DISTINCT a2.player_id) FROM Activity a2), 2) AS fraction
FROM
  Activity a1
WHERE
  (a1.player_id, DATE_SUB(a1.event_date, INTERVAL 1 DAY))
  IN (
    SELECT a3.player_id, MIN(a3.event_date) AS first_login FROM Activity a3 GROUP BY a3.player_id
  )

--
--
--
--
--To calculate the fraction of players who logged in again on the day after their first login, you need to count
-- the number of players who have their first login date followed by a consecutive login on the next day. Then,
-- you divide this count by the total number of distinct players.
--
--Approach
--We want to calculate the fraction of players who logged in again on the day after their first login. To do this,
--we need to count two things: the number of players who logged in on consecutive days and the total number of players.
--
--To count the number of players who logged in on consecutive days, we need to find the first login date for
--each player and check if there is a login on the day after their first login.
--
--We use a subquery to calculate the total number of distinct players in the Activity table. This gives us
--the denominator for calculating the fraction.
--
--In the main query, we filter the rows where the player's ID and the date of the event (after subtracting 1 day)
--match the player's first login date. This ensures that we only consider players who logged in on consecutive days.
--
--We then count the distinct player IDs in the filtered rows to get the numerator for calculating the fraction.
--
--Finally, we divide the numerator by the denominator and round the result to 2 decimal places using the ROUND function.
--
--Complexity
--Time complexity:
--The subquery (SELECT player_id, MIN(event_date) as first_login FROM Activity GROUP BY player_id) has a time complexity
--of O(n)O(n)O(n), where n is the number of records in the Activity table.
--The main query involves a nested subquery with a comparison (player_id, DATE_SUB(event_date, INTERVAL 1 DAY)) IN (...).
--This comparison has a time complexity of O(n)O(n)O(n), resulting in an overall time complexity of O(n2)O(n^2)O(n
--2
-- ).
--
--Space complexity:
--The subquery (SELECT player_id, MIN(event_date) as first_login FROM Activity GROUP BY player_id) creates a temporary
--table that stores player_id and their respective minimum event_date for each player. The space complexity is O(n)O(n)O(n)
--as it depends on the number of distinct players in the Activity table.