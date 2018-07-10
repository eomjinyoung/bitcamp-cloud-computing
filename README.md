# bitcamp-cloud-computing
비트캠프 클라우드 컴퓨팅 과정

## web-01 : 웹 프로젝트 폴더 준비
- gradle을 이용하여 프로젝트 폴더를 만드는 방법 

## web-02 : 서블릿 + JDBC
- 서블릿으로 웹 애플리케이션을 만들고 배포하는 방법
- JDBC를 이용하여 데이터를 다루는 방법

## web-03 : DAO + DTO(VO) + ServletContextListener
- 데이터 처리를 전문으로 하는 DAO 객체를 도입
- ServletContextListener에서 DAO 객체를 준비한다.
- ServletContext 보관소에 DAO 객체를 저장한다.
- 서블릿은 ServletContext 보관소에서 DAO를 꺼내 사용한다.

## web-04 : 서블릿 + DAO + JSP = MVC 아키텍처
- JSP 기술을 사용하여 출력을 단순화하는 방법
- MVC 아키텍처의 개념 

## web-05 : Persistence Framework 도입 
- DAO에 mybatis 프레임워크를 적용하여 코드와 SQL문을 분리한다.
- 반복적으로 작성했던 JDBC 코드를 캡슐화한다.