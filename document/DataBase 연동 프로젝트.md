# DataBase 연동 프로젝트

## database table 의 구분

- master table, work table 의 구분
-  `master data` :어플리케이션을 사용하는 초기에 대량의 데이터를 추가하고, 운영하는 과정에서는 주로 조회(SELECT)를 수행하는 데이터
- `work data` : 어플리케이션을 (계속) 운영하는 과정에서 수시로 데이어의 insert 가 이루어지는 데이터

- master data 를 보관하는 table 을 master table 이라고 한다.
- work data 를 보관하는 table 을 work table 또는 dlave table 이라고 한다.

## Entity 와 relation 의 구분

- 주로 master data 데이터에 해당하는 부분을 entity 라고 한다.
- work data 에 해당하는 부분은 주로 relation 이라고 한다.
- wokr data 는 master data 인 entity 와 항상 연동되는 데이터이다
