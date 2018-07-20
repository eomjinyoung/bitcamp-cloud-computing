## ## web-14 : InternalResourceViewResolver 사용하기
- JSP 경로를 /WEB-INF/ 폴더 아래로 옮긴다.
- /WEB-INF 폴더 아래로 JSP를 옮기면 클라이언트에서 직접 요청할 수 없다. 
- 이렇게 하면 JSP를 실행하기 위해 반드시 페이지 컨트롤러를 경유하도록 제한할 수 있다.

## /webapp 에 존재하는 JSP 파일을 /WEB-INF 폴더로 옮긴다.
- /member 폴더를 /WEB-INF/jsp 폴더로 옮기다.
- 프론트 컨트롤러(DispatcherServlet)에 기본으로 설정되어 있는 ViewResolver를 
   다른 뷰 리졸버(InternalResourceViewResolver)로 교체한다.
   
## 페이지 컨트롤러의 리턴 값을 변경한다.
- 옮겨진 JSP 파일의 경로와 InternalResourceViewResolver에 설정된 접두사/접미사에 
  맞춰 view 이름을 리턴한다.
    
