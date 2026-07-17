-- Last updated: 7/17/2026, 9:08:29 AM
# Write your MySQL query statement below
SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(email) > 1;