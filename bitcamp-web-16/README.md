## web-16 : 서비스 컴포넌트 도입
- 페이지 컨트롤러에서 비즈니스 로직을 분리하여 별도의 클래스로 정의한다.
- 이 클래스를 서비스 객체라 부른다.
- 서비스 객체는 비즈니스 로직과 트랜잭션 처리를 담당한다.

## 서비스 객체 생성
- MemberService 클래스 작성

## 페이지 컨트롤러는 DAO 대신 Service 객체를 사용한다.
- 페이지 컨트롤러 변경

## 페이지 이동 처리
- /WEB-INF/jsp/member/list.jsp 변경
- MemberMapper.xml 변경
- MemberDao 변경
- MemberService 변경
- MemberController 변경











