SELECT COALESCE((
    SELECT num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(num) = 1
    ORDER BY num DESC
    LIMIT 1
), NULL) AS num;

--Below is the initial query.
--
--SELECT num
--FROM MyNumbers
--GROUP BY num
--HAVING COUNT(num) = 1 AND MAX(num)
--ORDER BY num DESC
--LIMIT 1;
--
--if you want null then have to update it as above


--Alternative way


--SELECT MAX(num) AS num
--FROM (SELECT num FROM MyNumbers GROUP BY num HAVING COUNT(num)=1)
--AS n;