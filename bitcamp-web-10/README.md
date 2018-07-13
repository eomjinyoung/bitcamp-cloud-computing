# bitcamp-web-10 : Spring IoC 컨테이너 도입
- 기존에 작성한 IoC 컨테이너 대신에 Spring IoC 컨테이너를 사용한다.

## 라이브러리 추가
- mvnrepository.com 에서 spring-context 라이브러를 찾는다.
- build.gradle에 의존 라이브러리 정보를 추가한다.
- 'gradle cleanEclipse'를 실행하여 기존 이클립스 설정을 제거한다.
- 'gradle eclipse'를 실행하여 이클립스 관련 설정 파일을 새로 만든다.
- 이때 추가한 의존 라이브러리가 자동으로 다운로드 될 것이다.
- 웹 프로젝트를 리프래시 하여 라이브러리 정보를 갱신한다. 

## 회원 관리 서블릿 만들기
- servlet-api 의존 라이브러리 추가하기
  - mvnrepository.com에서 sevlet-api 라이브러리 검색
  - build.gradle에 라이브러리 등록
  - 'gradle eclipse' 실행하여 .classpath 파일 갱신
  - 이클립스 프로젝트 refresh
- mysql jdbc driver 의존 라이브러리 추가하기  
- bitcamp.pms.servlet.member 패키지 생성
- MemberListServlet, MemberViewServlet, MemberAddServlet, MemberUpdateServlet, MemberDeleteServlet 클래스 생성
