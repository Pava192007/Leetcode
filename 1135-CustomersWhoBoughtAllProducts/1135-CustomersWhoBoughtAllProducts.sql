-- Last updated: 7/17/2026, 9:04:43 AM
# Write your MySQL query statement below
SELECT 
    customer_id
FROM 
    Customer
GROUP BY 
    customer_id
HAVING 
    (COUNT(DISTINCT product_key)) = (SELECT COUNT(DISTINCT product_key) FROM Product);