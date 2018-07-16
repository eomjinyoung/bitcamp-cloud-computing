## web-13 : Spring WebMVC의 DispatcherServlet 사용하기
- 기존에 직접 만든 DispatcherServlet 대신에 Spring WebMVC에서 제공하는 클래스를 사용한다.

## 프론트 컨트롤러를 Spring WebMVC 클래스로 교체한다.
- 기존에 직접 만든 DispatcherServlet을 Spring 클래스로 교체한다.
- web.xml에 servlet을 등록해야 한다.

## 페이지 컨트롤러의 @Controller에 지정한 URL을 @RequestMapping으로 옮긴다.
- 페이지 컨트롤러의 이름으로 지정했던 URL을 요청 핸들러의 @RequestMapping으로 옮긴다.

## @RequestMapping 애노테이션을 처리할 객체를 등록한다.
- 요청핸들러에 붙인 @RequestMapping을 처리할 객체를 Spring에 따로 등록해야 한다.
- 직접 해당 객체를 등록하지 말고, 단축 태그를 이용해 등록하라

```
  <mvc:annotation-driven/>
```  
