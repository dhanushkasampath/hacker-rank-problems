SELECT p.project_id, ROUND(AVG(e.experience_years), 2) AS average_years
FROM Project p
LEFT JOIN Employee e
ON p.employee_id = e.employee_id
GROUP BY p.project_id;

--since this problem ask for each project, that means we need to GROUP BY project_id.
--Also we need to join these two tables by employee_id since its common for both tables.
--
--we need to take Project table as left table since the output also has project_id column.
--
--then we can use the AVG function to get the average of experience_years. Since we apply GROUP BY to
--project_id. the average is calculated based on that particular groups
