# bitcamp-web-02 : 서블릿
pms2_member 테이블에 대한 CRUD 서블릿을 만들기

## 패키지 생성
bitcamp.pms.servlet 패키지 생성한다.

## 회원 관리 서블릿 만들기
- servlet-api 의존 라이브러리 추가하기
  - mvnrepository.com에서 sevlet-api 라이브러리 검색
  - build.gradle에 라이브러리 등록
  - 'gradle eclipse' 실행하여 .classpath 파일 갱신
  - 이클립스 프로젝트 refresh
- mysql jdbc driver 의존 라이브러리 추가하기  
- bitcamp.pms.servlet.member 패키지 생성
- MemberListServlet, MemberViewServlet, MemberAddServlet, MemberUpdateServlet, MemberDeleteServlet 클래스 생성
