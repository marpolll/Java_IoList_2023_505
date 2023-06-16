# Java IoList project

- java, oracle를 사용한 Console project
- 이클립스의 콘솔 환경에서 java 를 사용한 DBMS 핸들링
- 상품관리, 고객관리, 상품구매(장바구니)를 관리하는 프로젝트

## 필요한 3rd party LIB

- ojjbc*.jar, mybatis*.jar

## Maven project

- java project 로 설정된 기본 형식을 Maven project 로 변환한다 : 프로젝트에서 우클릭 >> configure >> convert maven project
- pom.xml 이라는 파일이 생성된다

### POM.xml

- POM : `Project Object Model` 프로젝트에 필요한 3rd JDK 를 쉽게 관리하기 위한 도구
- Maven project 를 컴파일 하고, build 하는데 필요한 설정 정보를 담고있는 파일
