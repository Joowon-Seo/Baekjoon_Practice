-- 코드를 입력하세요
SELECT 	MCDP_CD as '진료과 코드', COUNT(MCDP_CD) as '5월예약건수'
FROM APPOINTMENT
WHERE DATE(APNT_YMD) BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY MCDP_CD
ORDER BY COUNT(MCDP_CD) ASC, MCDP_CD ASC