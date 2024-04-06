SELECT p.product_name, SUM(o.unit) AS unit
FROM Orders o
LEFT JOIN Products p
ON p.product_id = o.product_id
WHERE MONTH(o.order_date) = 2 AND YEAR(o.order_date) = 2020
GROUP BY o.product_id
HAVING unit >=100;


--where is executed before GROUP BY.
--here WHERE and HAVING both are used.