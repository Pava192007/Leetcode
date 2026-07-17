-- Last updated: 7/17/2026, 9:05:28 AM
# Write your MySQL query statement below
SELECT class
FROM COurses
GROUP BY class
HAVING COUNT(student) >= 5