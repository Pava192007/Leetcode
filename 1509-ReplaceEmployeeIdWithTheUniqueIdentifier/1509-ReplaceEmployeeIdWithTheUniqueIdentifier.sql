-- Last updated: 7/17/2026, 9:03:48 AM
# Write your MySQL query statement below
SELECT
    eu.unique_id,
    e.name
FROM Employees e
LEFT JOIN EmployeeUNI eu
ON e.id = eu.id;