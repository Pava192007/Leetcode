-- Last updated: 7/17/2026, 9:05:30 AM
# Write your MySQL query statement below
SELECT 
   name,
   population,
   area
FROM World
WHERE area >= 3000000
  OR population >= 25000000