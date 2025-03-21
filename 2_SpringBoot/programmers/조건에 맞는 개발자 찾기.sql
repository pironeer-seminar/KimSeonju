-- 특정 언어가 포함되어있으면 0보다 큰 값이 리턴될 것
-- 한 개발자가 "Python"과 "C#"을 모두 보유한 경우, 같은 ID가 중복될 수 있음.
select distinct(D.ID), D.EMAIL, D.FIRST_NAME, D.LAST_NAME
from  DEVELOPERS as D, SKILLCODES as S
where (D.SKILL_CODE & S.CODE) > 0 and S.NAME in ("Python", "C#")
order by ID