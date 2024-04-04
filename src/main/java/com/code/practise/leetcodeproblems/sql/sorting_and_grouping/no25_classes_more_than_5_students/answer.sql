SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(student)>=5;

-- we put HAVING at the end of the query