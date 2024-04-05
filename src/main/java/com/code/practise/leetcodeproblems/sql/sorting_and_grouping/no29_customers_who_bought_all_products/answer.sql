SELECT customer_id
FROM Customer
GROUP BY customer_id
HAVING COUNT(DISTINCT product_key) = (SELECT COUNT(product_key) FROM Product);

--In the sub-query it counted the no of product keys available.
--Then using the HAVING keyword it check whether that count is equal to the distinct product_key count in grouped result


--Below also correct
SELECT c.customer_id
FROM Customer c
GROUP BY c.customer_id
HAVING COUNT(DISTINCT c.product_key) = (SELECT COUNT(p.product_key) FROM Product p);