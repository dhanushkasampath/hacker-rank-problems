SELECT teacher_id, COUNT(DISTINCT subject_id) AS cnt
FROM Teacher
GROUP BY teacher_id;


--once we used GROUP BY  that particular group act as a new table.