# MyBatis에서의 IF문

```SQL

★ MyBatis에는 Boolean형이 없기 때문에 String으로 가져와서 .equals로 true인지 false인지 비교해주어야한다.


<select id="selectEmpMgr" resultType="EmpVO">
SELECT
	empno,
	ename,
	mgr
FROM
	emp
WHERE 1=1
-- test='' : if절의 조건문에 속한다.
	<if test='isMgr.equals("true")'>
		AND mgr IS NOT NULL
	</if>
	<if test='isMgr.equals("false")'>
		AND mgr IS NULL
	</if>
</select>

```
