# bitcamp-web-10 : Spring IoC 컨테이너 도입
- 기존에 작성한 IoC 컨테이너 대신에 Spring IoC 컨테이너를 사용한다.

## 라이브러리 추가
- mvnrepository.com 에서 spring-context 라이브러를 찾는다.
- build.gradle에 의존 라이브러리 정보를 추가한다.
- 'gradle cleanEclipse'를 실행하여 기존 이클립스 설정을 제거한다.
- 'gradle eclipse'를 실행하여 이클립스 관련 설정 파일을 새로 만든다.
- 이때 추가한 의존 라이브러리가 자동으로 다운로드 될 것이다.
- 웹 프로젝트를 리프래시 하여 라이브러리 정보를 갱신한다. 

## ContextLoaderListener에서 Spring IoC 컨테이너 준비하기
- 기존의 ApplicationContext 대신에 Spring IoC 컨테이너 객체를 생성한다.
- bitcamp/pms/config/application-context.xml 파일을 생성한다.

## DispatcherServlet에서 Spring IoC 컨테이너를 사용하기
- 기존의 ApplicationContext 대신에 Spring IoC 컨테이너에 들어 있는 페이지 컨트롤러를 찾아 실행한다.

## ApplicationContext 클래스 제거한다.

## 우리가 작성한 애노테이션 제거한다.
- @Component 애노테이션 제거
- @Controller 애노테이션 제거
- @Repository 애노테이션 제거
- @Autoworied 애노테이션 제거

## DAO와 페이지 컨트롤러에서 사용한 애노테이션 패키지를 변경한다.
- 스프링 애노테이션으로 변경한다.







