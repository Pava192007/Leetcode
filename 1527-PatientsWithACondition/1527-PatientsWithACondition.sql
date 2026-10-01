-- Last updated: 10/1/2026, 9:55:13 AM
# Write your MySQL query statement below
SELECT
    patient_id,
    patient_name,
    conditions
FROM Patients
WHERE conditions REGEXP '(^| )DIAB1';