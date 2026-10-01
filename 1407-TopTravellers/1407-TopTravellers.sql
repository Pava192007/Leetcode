-- Last updated: 10/1/2026, 9:55:24 AM
# Write your MySQL query statement below
SELECT
    u.name,
    COALESCE(SUM(r.distance), 0) AS travelled_distance
FROM Users u
LEFT JOIN Rides r
ON u.id = r.user_id
GROUP BY
    u.id,
    u.name
ORDER BY
    travelled_distance DESC,
    u.name ASC;