SELECT product_id , year AS first_year , quantity , price
FROM sales
WHERE (product_id , year) IN
(SELECT product_id , MIN(year) AS year FROM sales GROUP BY product_id)


--"SELECT product_id , MIN(year) AS year FROM sales GROUP BY product_id" this sub-query gets the product_id and min year.
--then we extract the other details from that list