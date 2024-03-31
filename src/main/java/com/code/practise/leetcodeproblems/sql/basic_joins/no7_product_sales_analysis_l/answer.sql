SELECT l.product_name, r.year, r.price
FROM Product l
INNER JOIN Sales r
ON l.product_id = r.product_id;