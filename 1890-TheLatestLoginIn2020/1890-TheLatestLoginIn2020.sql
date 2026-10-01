-- Last updated: 10/1/2026, 9:54:28 AM
# Write your MySQL query statement below
SELECT 
    user_id, 
    MAX(time_stamp) AS last_stamp
FROM Logins
WHERE YEAR(time_stamp) = 2020
GROUP BY user_id;