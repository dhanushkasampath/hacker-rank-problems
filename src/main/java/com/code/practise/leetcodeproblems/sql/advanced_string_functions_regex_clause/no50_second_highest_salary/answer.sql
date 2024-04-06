SELECT (SELECT DISTINCT SALARY FROM EMPLOYEE
ORDER BY SALARY DESC
LIMIT 1, 1) AS SecondHighestSalary;

-- This query will skip the first record (offset of 1) and then return the next record.