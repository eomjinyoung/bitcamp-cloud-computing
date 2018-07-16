## bitcamp-web-11 : Spring + Mybatis 연동하기
- 기존에 직접 만든 SqlSessionFactoryBean 대신에 Mybatis가 제공하는 SqlSessionFactoryBean을 사용한다.

## 라이브러리 추가
- mvnrepository.com 에서 "mybatis spring" 라이브러를 찾는다.
- build.gradle에 의존 라이브러리 정보를 추가한다.
- 'gradle cleanEclipse'를 실행하여 기존 이클립스 설정을 제거한다.
- 'gradle eclipse'를 실행하여 이클립스 관련 설정 파일을 새로 만든다.
- 이때 추가한 의존 라이브러리가 자동으로 다운로드 될 것이다.
- 웹 프로젝트를 리프래시 하여 라이브러리 정보를 갱신한다. 

## Mybatis에서 제공하는 SqlSessionFactoryBean 객체 사용하기
- 기존의 SqlSessionFactoryBean 대신에 Mybatis-Spring에서 제공하는 클래스 사용.
- Mybatis를 Spring과 연동하면 DataSource는 Spring 설정된 것을 사용해야 한다.
- Mybatis 설정 파일에 등록된 DataSource는 사용하지 않는다.

## Spring에 DataSource 등록하기
- mvnrepository.com에서 "commons dbcp"를 검색하여 라이브러리를 찾는다.
- 라이브러리를 build.gradle 파일에 등록하고, gradle을 이용해 가져온다.
- 웹프로젝트를 리프래시 한다. 
- application-context.xml 스프링 설정 파일에 DataSource를 설정한다.
- Spring에서 DataSource를 설정할 때는 "spring-jdbc"라이브러리를 추가해야 한다.


## ApplicationContext 클래스 제거한다.

## 우리가 작성한 애노테이션 제거한다.
- @Component 애노테이션 제거
- @Controller 애노테이션 제거
- @Repository 애노테이션 제거
- @Autoworied 애노테이션 제거

## DAO와 페이지 컨트롤러에서 사용한 애노테이션 패키지를 변경한다.
- 스프링 애노테이션으로 변경한다.







