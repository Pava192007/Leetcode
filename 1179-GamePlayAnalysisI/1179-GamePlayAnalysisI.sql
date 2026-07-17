-- Last updated: 7/17/2026, 9:04:31 AM
# Write your MySQL query statement below
SELECT
    player_id,
    MIN(event_date) AS first_login
FROM Activity
GROUP BY player_id;