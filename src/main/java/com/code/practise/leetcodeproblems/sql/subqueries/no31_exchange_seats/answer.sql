SELECT CASE
           WHEN s.id % 2 <> 0 AND s.id = (SELECT COUNT(*) FROM Seat) THEN s.id
           WHEN s.id % 2 = 0 THEN s.id - 1
           ELSE
               s.id + 1
           END AS id,
        student
FROM Seat s
ORDER BY id ASC;






SELECT CASE
           WHEN s.id % 2 <> 0 AND s.id = (SELECT COUNT(*) FROM Seat) THEN s.id    --> <> is operator is used for not equals  AND chech whther id is the last of the records. if so do not change the positipn
           WHEN s.id % 2 = 0 THEN s.id - 1  ---> if id is even move it up
           ELSE
               s.id + 1  --> this occurs when id is odd
           END AS id,  --> AS is needed at the end of the case. cz its what is returned.
        student
FROM Seat s
ORDER BY id ASC;