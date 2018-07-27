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

## web-06 : Front Controller 도입
- 서블릿들이 공통으로 수행하는 작업을 프론트 컨트롤러에게 맡긴다.
- 나머지 서블릿들은 "Page Controller"로 부른다.

## web-07 : Page Controller를 POJO로 변환
- 프론트 컨트롤러가 도입되면 페이지 컨트롤러는 일반 자바 객체로 만들어도 된다. 

## web-08 : 애노테이션으로 요청 핸들러 다루기
- 요청 핸들러(Request Handler) : 클라이언트 요청이 들어 왔을 때 호출되는 메서드이다. 즉 클라이언트 요청을 처리하는 메서드.
- 인터페이스를 구현하는 대신에 애노테이션으로 요청 핸들러를 표시하여 프론트 컨트롤러가 찾게 한다.
- 이렇게 함으로써 페이지 컨트롤러를 만들 때 특정 인터페이스에 종속되지 않게 한다.

## web-09 : 객체 생성을 자동화하기 위해 IoC 컨테이너를 만들기
- IoC 컨테이너를 통해 페이지 컨트롤러의 객체를 자동 생성한다.
- 페이지 컨트롤러의 의존 객체를 자동으로 주입한다.

## web-10 : Spring IoC 컨테이너 도입
- 기존 직접 만든 IoC 컨테이너 대신에 스프링 컨테이너를 사용한다.

## web-11 : Spring + Mybatis 연동하기
- 기존에 직접 만든 SqlSessionFactoryBean 대신에 Mybatis가 제공하는 SqlSessionFactoryBean을 사용한다.
- DB 커넥션풀은 Mybatis 대신에 Spring에서 관리한다.
- 트랜잭션을 다룰 수 있도록 트랜잭션 관리자를 설정한다.
- Proxy 패턴을 사용한 DAO 자동 생성 기능을 이용한다.

## web-12 : Spring WebMVC의 ContextLoaderListener 사용하기
- 기존에 직접 만든 ContextLoaderListener 대신에 Spring WebMVC에서 제공하는 클래스를 사용한다.

## web-13 : Spring WebMVC의 DispatcherServlet 사용하기
- 기존에 직접 만든 DispatcherServlet 대신에 Spring WebMVC에서 제공하는 클래스를 사용한다.

## web-14 : InternalResourceViewResolver 사용하기
- JSP 경로를 /WEB-INF/ 폴더 아래로 옮긴다.
- /WEB-INF 폴더 아래로 JSP를 옮기면 클라이언트에서 직접 요청할 수 없다. 

## web-15 : 요청 핸들러의 파라미터와 리턴 값 다루기
- 요청 핸들러의 파라미터 다루기
- 요청 핸들러의 리턴 다루기

## web-16 : 서비스 컴포넌트 도입
- 페이지 컨트롤러에서 비즈니스 로직을 분리하여 별도의 클래스로 정의한다.
- 이 클래스를 서비스 객체라 부른다.
- 서비스 객체는 비즈니스 로직과 트랜잭션 처리를 담당한다.

## web-17 : 서비스 컴포넌트에 트랜잭션 적용
- 트랜잭션 관리자를 설정하여 서비스 메서드에 트랜잭션을 적용한다.

## web-18 : AJAX를 이용하여 Back-end와 Font-end 분리하기
- JSP에서 HTML을 렌더링하는 대신에 HTML의 자바스크립트를 이용하여 서버에서 데이터를 받아서 UI를 출력하는 방식으로 바꾼다.


