-- Last updated: 10/1/2026, 9:55:28 AM
# Write your MySQL query statement below
SELECT
    eu.unique_id,
    e.name
FROM Employees e
LEFT JOIN EmployeeUNI eu
ON e.id = eu.id;