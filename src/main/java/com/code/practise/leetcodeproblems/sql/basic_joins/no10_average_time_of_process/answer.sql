solution 1.

--Here what they have done is getting the average of all end time of machine id 0 and average of all start time of machine id 0.
--then reduce start time from end time
--then roundoff the value to 3 decimal places.

SELECT a.machine_id,
ROUND(
(SELECT AVG(a1.timestamp) FROM Activity a1 WHERE a1.activity_type = 'end' AND a1.machine_id = a.machine_id -
SELECT AVG(a1.timestamp) FROM Activity a1 WHERE a1.activity_type = 'start' AND a1.machine_id = a.machine_id), 3)
AS processing_time
FROM Activity a
GROUP BY a.machine_id

Solution 2.

SELECT a.machine_id,
ROUND(
AVG(CASE WHEN a.activity_type = 'end' THEN a.timestamp END) -
AVG(CASE WHEN a.activity_type = 'start' THEN a.timestamp END), 3)
AS processing_time
FROM activity a
GROUP BY
a.machine_id;