SELECT S.student_id, S.student_name, SUB.subject_name,
count(E.subject_name) AS attended_exams
FROM Students S
CROSS JOIN Subjects SUB
LEFT OUTER JOIN Examinations E
ON S.student_id = E.student_id AND SUB.subject_name = E.subject_name
GROUP BY S.student_id, S.student_name, SUB.subject_name
ORDER BY S.student_id, SUB.subject_name


--This SQL query retrieves information about students, their attendance in examinations for different subjects, and the count of exams attended by each student for each subject. Let's break down the query step by step:
--
--SELECT statement:
--
--S.student_id, S.student_name: Selects the student ID and name from the Students table.
--SUB.subject_name: Selects the subject name from the Subjects table.
--count(E.subject_name) AS attended_exams: Counts the number of attended exams for each combination of student and subject. It uses the Examinations table and counts the non-null values of the subject_name column.
--FROM clause:
--
--Students S CROSS JOIN Subjects SUB: Performs a cross join between the Students and Subjects tables, generating all possible combinations of students and subjects. This creates a temporary table with columns student_id, student_name, and subject_name.
--LEFT OUTER JOIN clause:
--
--Examinations E LEFT OUTER JOIN: Joins the Examinations table to the temporary table created by the cross join. It matches records based on the student ID and subject name. If a match is found, it includes the record from the Examinations table; otherwise, it includes NULL values.
--ON clause:
--
--ON S.student_id = E.student_id AND SUB.subject_name = E.subject_name: Specifies the conditions for joining the tables. It matches rows where the student ID matches and the subject name matches.
--GROUP BY clause:
--
--GROUP BY S.student_id, S.student_name, SUB.subject_name: Groups the result set by student ID, student name, and subject name. This is necessary because the query includes aggregate function (COUNT) and non-aggregate columns in the SELECT clause.
--ORDER BY clause:
--
--ORDER BY S.student_id, SUB.subject_name: Orders the result set first by student ID and then by subject name.
--In summary, the query generates a list of all students with all subjects they could potentially attend, along with the count of examinations attended for each subject by each student. If a student didn't attend an exam for a particular subject, the count will be 0.
--
