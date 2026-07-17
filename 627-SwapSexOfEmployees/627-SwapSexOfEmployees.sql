-- Last updated: 7/17/2026, 9:05:12 AM
# Write your MySQL query statement below
UPDATE Salary
SET sex = CASE
            WHEN sex = 'm' THEN 'f'
            ELSE 'm'
          END;