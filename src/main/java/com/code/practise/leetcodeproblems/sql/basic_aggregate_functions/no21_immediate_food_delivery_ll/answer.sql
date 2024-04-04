SELECT
    ROUND(SUM(CASE WHEN order_date = customer_pref_delivery_date THEN 1 ELSE 0 END) * 100.0 / COUNT(DISTINCT customer_id), 2) AS immediate_percentage
FROM Delivery
WHERE (customer_id, order_date) IN (
    SELECT customer_id, MIN(order_date) AS first_order_date
    FROM Delivery
    GROUP BY customer_id
);

--
--The inner subquery (SELECT customer_id, MIN(order_date) AS first_order_date FROM Delivery GROUP BY customer_id)
--finds the first order date for each customer by selecting the minimum order date for each customer_id.
--
--The WHERE clause filters the rows to only include the first orders of each customer by checking if the
--(customer_id, order_date) pair matches the result of the subquery.
--
--The CASE WHEN statement is used to determine if an order is immediate or not based on the
--condition order_date = customer_pref_delivery_date. If true, it increments the count of immediate orders, otherwise,
--it increments the count of scheduled orders.
--
--The SUM function calculates the total count of immediate orders, and COUNT(DISTINCT customer_id) calculates
--the total count of first orders for all customers.
--
--The percentage of immediate orders is calculated by dividing the count of immediate orders by the total count of
--first orders and then multiplying by 100.
--
--The ROUND function is used to round the percentage to 2 decimal places.