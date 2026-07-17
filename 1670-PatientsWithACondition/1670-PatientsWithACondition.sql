-- Last updated: 7/17/2026, 9:03:29 AM
# Write your MySQL query statement below
SELECT
    patient_id,
    patient_name,
    conditions
FROM Patients
WHERE conditions REGEXP '(^| )DIAB1';