-- Last updated: 10/1/2026, 9:55:56 AM
# Write your MySQL query statement below
SELECT person_name
FROM (
    SELECT person_name,
           SUM(weight) OVER (ORDER BY turn) AS total_weight
    FROM Queue
) q
WHERE total_weight <= 1000
ORDER BY total_weight DESC
LIMIT 1;