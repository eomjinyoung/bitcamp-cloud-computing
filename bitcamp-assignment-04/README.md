# 실기 시험 (2018-08-10)

## 평가내용	
- 주어진 주제의 시스템에 대한 기능 구현 여부를 평가한다.
- UI 프로토타입 : https://ovenapp.io/view/U1sBifsUKVsxN5CKRYj3NvrGupTBF54F/fTMo8

## 프로젝트 주제	
개인 명함관리시스템

## 구현기능	
- 회원가입(15점)
- 로그인(10점)
- 로그아웃(5점)
- 회원탈퇴(5점)
- 명함등록(15점)
- 명함목록조회(10점)
- 명함상세조회(10점)
- 명함변경(10점)
- 명함삭제(5점)
- 명함목록조회에서 검색 기능 추가(15점)


## 평가기준	
- 구현 완료(15점/10점/5점)
- 구현 부족(13점/9점/4점)
- 미구현(11점/8점/3점)

## 구현

### 1단계 - 요구사항정의 및 DB 모델링
- Use Case Model 작성
    - Actor 식별
    - Actor를 통해 Use Case 식별
- Use Case 명세서 작성
    - 회원가입탈퇴 명세서 작성
    - 회원인증 명세서 작성
    - 명함관리 명세서 작성
- DB 모델링
    - DB 모델 작성
    - Database에 테이블 생성
        
### 2단계 - 웹 프로젝트 준비
- 웹 프로젝트 폴더 생성
    - 'mkdir bitcamp-assignment-02' 실행
- gradle 설정 파일 준비
    - 'gradle init' 실행
- 소스 디렉토리 준비
    - src/main/java
    - src/main/resources
    - src/main/webapp
    - src/test/java
    - src/test/resources
- 이클립스 설정 파일 준비
    - 'build.gradle' 파일 편집
        - 플러그인 추가: java, eclipse-wtp, war
    - 'gradle eclipse' 실행
    - 이클립스로 웹 프로젝트 임포트 

### 3단계 - Spring WebMVC 프레임워크 적용
- 의존 라이브러리 설정
    - 'build.gradle' 파일 편집. 기존 프로젝트의 파일 내용을 복사하라!
    - 'gradle eclipse' 실행. 이클립스 설정 파일을 갱신하라!
    - 이클립스 프로젝트에서 로딩된 라이브러리를 확인하라!
- web.xml 파일 준비
    - 기존 프로젝트에서 복사해 온다.
    - 현재 프로젝트에 맞춰서 web.xml 파일을 편집한다.
- Spring 설정 파일 준비
    - 패키지 폴더(src/main/resources/bitcamp/assignment/config)를 생성한다.
    - 기존 프로젝트에서 복사해 온다.
    - 현재 프로젝트에 맞춰서 파일을 편집한다.
- 테스트 용 소스 작성 및 확인
    - 테스트 용 페이지 컨트롤러와 JSP 작성하여 실행 확인한다.
    - 톰캣 서버에 웹 프로젝트를 추가한다.
    - 톰캣 서버를 실행한다. 
    - 콘솔 창에 출력된 로그를 보고 설정 오류가 없는지 확인한다.
    - 웹브라우저로 요청하여 실행 여부를 확인한다.

### 4단계 - 기능구현
- 회원 가입 구현
    - 페이지 컨트롤러 작성(MemberController.java)
    - 회원 가입 폼 작성(signUp.html, signUp.js)
    - package.json 작성(외부 라이브러리 추가)
    - 'npm install' 실행하여 프론트엔드 라이브러리 가져온다.
    - 공통 코드 작성(common.css, common.js, jquery.bit.js, footer.html)
    - MemberService.java, MemberServiceImpl.java 작성
    - MemberRepository.java, MemberMapper.xml 작성
- 로그인 구현
    - 로그인 폼 작성(signIn.html, signIn.js)
    - 페이지 컨트롤러 작성(AuthController.java)
    - MemberService.java, MemberServiceImpl.java 에 메서드 추가
    - MemberRepository.java 에 메서드 추가 
    - MemberMapper.xml 에 SQL 문 추가 
- 명함관리 메인화면
    - 메인화면 작성(businesscard/index.html)






