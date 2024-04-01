SELECT l.name, r.bonus
FROM Employee l
LEFT JOIN Bonus r
ON l.empId = r.empId
WHERE r.bonus<1000
OR r.bonus IS NULL;
