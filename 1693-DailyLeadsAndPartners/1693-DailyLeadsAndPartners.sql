-- Last updated: 10/1/2026, 9:54:49 AM
# Write your MySQL query statement below
SELECT 
    date_id,
    make_name,
    COUNT(DISTINCT lead_id) AS unique_leads,
    COUNT(DISTINCT partner_id) AS unique_partners
FROM 
    DailySales
GROUP BY 
    date_id, 
    make_name;