-- Last updated: 7/17/2026, 9:08:02 AM
DELETE FROM person
WHERE id IN (
    SELECT id FROM (
        SELECT id,
               ROW_NUMBER() OVER (PARTITION BY email ORDER BY id) AS rn
        FROM person
    ) t
    WHERE rn > 1
);