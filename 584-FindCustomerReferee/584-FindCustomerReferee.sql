-- Last updated: 7/17/2026, 9:05:41 AM
# Write your MySQL query statement below
SELECT name
FROM Customer
WHERE referee_id != 2
   OR referee_id IS NULL;