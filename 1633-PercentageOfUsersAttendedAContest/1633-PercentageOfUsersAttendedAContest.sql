-- Last updated: 10/1/2026, 9:55:04 AM
select r.contest_id, 
ROUND(count(r.user_id)*100.0/u_total.total, 2) as percentage 
from Register r cross join 
(select count(*) as total from users)u_total
group by r.contest_id, u_total.total
order by
percentage desc,
r.contest_id asc;