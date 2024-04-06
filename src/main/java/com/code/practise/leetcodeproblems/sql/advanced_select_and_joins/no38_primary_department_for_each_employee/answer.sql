-- SELECT e.employee_id, e.department_id
-- FROM Employee e
-- WHERE e.primary_flag = 'Y'
-- GROUP BY e.employee_id
-- HAVING COUNT(*) = 1


SELECT e1.employee_id, e1.department_id
FROM Employee e1
WHERE e1.primary_flag = 'Y' OR employee_id IN (
    SELECT e2.employee_id
    FROM Employee e2
    GROUP BY e2.employee_id
    HAVING COUNT(e2.primary_flag) = 1
)



--where clause can not be used to aggregate functions
--having clause can not be used to check conditions without aggregate functions
--
--At first I tried to use WHERE and HAVING in the same main query. but its not possible.
