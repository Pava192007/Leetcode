-- Last updated: 10/1/2026, 9:56:32 AM
# Write your MySQL query statement below
SELECT 
    p.project_id,
    ROUND(AVG(e.experience_years), 2) AS average_years
FROM Project p
JOIN Employee e
ON p.employee_id = e.employee_id
GROUP BY p.project_id;