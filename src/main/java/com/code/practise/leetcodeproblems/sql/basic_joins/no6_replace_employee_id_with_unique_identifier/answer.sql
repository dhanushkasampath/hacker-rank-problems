SELECT r.unique_id, l.name
FROM Employees l
LEFT JOIN EmployeeUNI r
ON l.id = r.id;