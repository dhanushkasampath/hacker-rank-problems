SELECT e.name
FROM Employee e
INNER JOIN Employee e1
ON e.id = e1.managerId
GROUP BY e1.managerId
HAVING COUNT(e1.managerId) >=5;


--here joining of same table happensScreenshot from 2024-04-01 13-02-56