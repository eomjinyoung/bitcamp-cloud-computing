## bitcamp-web-12 : Spring WebMVC의 ContextLoaderListener 사용하기
- 기존에 직접 만든 ContextLoaderListener 대신에 Spring WebMVC에서 제공하는 클래스를 사용한다.

## 라이브러리 추가
- mvnrepository.com 에서 "spring webmvc" 라이브러를 찾는다.
- build.gradle에 의존 라이브러리 정보를 추가한다.
- 'gradle cleanEclipse'를 실행하여 기존 이클립스 설정을 제거한다.
- 'gradle eclipse'를 실행하여 이클립스 관련 설정 파일을 새로 만든다.
- 이때 추가한 의존 라이브러리가 자동으로 다운로드 될 것이다.
- 웹 프로젝트를 리프래시 하여 라이브러리 정보를 갱신한다. 

## Spring WebMVC의 ContextLoaderListener 사용하기
- 기존에 직접 작성했던 ContextLoaderListener 대신에 Spring WebMVC에서 제공하는 ContextLoaderListener 클래스를 사용한다.
- /WEB-INF/web.xml에 리스너를 등록해야 한다.

## DispatcherServlet 변경
- Spring의 ContextLoaderListener에서 준비한 IoC 컨테이너를 사용하도록 DispatcherServlet을 변경한다.

## Spring의 CharacterEncodingFilter 사용하기
- 기존에 직접 작성한 CharacterEncodingFilter 대신에 Spring의 필터를 사용하여 POST 한글 파라미터 값을 깨지지 않도록 처리한다.

 













