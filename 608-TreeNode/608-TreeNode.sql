-- Last updated: 7/17/2026, 9:05:18 AM
# Write your MySQL query statement below
SELECT
    id,
    CASE
        WHEN p_id IS NULL THEN 'Root'
        WHEN id IN (SELECT DISTINCT p_id
                    FROM Tree
                    WHERE p_id IS NOT NULL) THEN 'Inner'
        ELSE 'Leaf'
    END AS type
FROM Tree;