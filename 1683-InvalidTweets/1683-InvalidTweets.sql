-- Last updated: 10/1/2026, 9:54:52 AM
# Write your MySQL query statement below
SELECT 
    tweet_id
FROM 
    Tweets
WHERE 
    LENGTH(content) > 15;