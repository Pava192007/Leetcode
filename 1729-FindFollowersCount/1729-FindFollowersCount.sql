-- Last updated: 10/1/2026, 9:54:47 AM
# Write your MySQL query statement below
SELECT 
    user_id,
    COUNT(follower_id) AS followers_count
FROM 
    Followers
GROUP BY 
    user_id
ORDER BY 
    user_id ASC;