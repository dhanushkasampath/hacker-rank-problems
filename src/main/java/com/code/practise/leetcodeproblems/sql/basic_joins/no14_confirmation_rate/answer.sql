SELECT l.user_id,
ROUND(avg(if(r.action="confirmed",1,0)),2) AS confirmation_rate
FROM Signups l
LEFT JOIN Confirmations r
ON l.user_id = r.user_id
GROUP BY l.user_id



--Approach
--left join Signups table with Confirmations table, group by user_id.
--we have to display user_id and confirmation_rate :
--user_id will be simply displayed.
--to display confirmation_rate , we need to find average using aggregation function avg(),
--here using if clause we specified that if action is confirmed we count it as 1 and else if null or timeout we will count it as 0.