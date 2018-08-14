package bitcamp.uml.classdiagram.ex4;

// Dependancy(의존)
// => 특정 메서드에서 일시적으로 사용하는 객체와의 관계
// => 보통 파라미터로 받은 객체를 사용할 때 의존 관계를 형성한다.
//
// 실무!
// => 실무에서는 association, aggregation, composition, dependancy
//    관계를 따로 구분하지 않고 모두 association으로 표현한다.
// => 반드시 그 관계를 명확하게 표현하는 것이 더 나은 이해를 제공한다면,
//    그 때는 이런 관계를 명확히 표현할 것이다.
// => 그러나 대부분 그 관계가 모호한 경우가 많기 때문에
//    더 명확히 표현하는 것이 오히려 이해를 방해하는 경우가 많다.
//    그래서 실무에서는 가능한 association 관계만 사용한다.
//    
public class MemberController {
    
    // MemberController와 HttpSession은 '의존 관계'이다.
    public String login(
            String id, 
            String pwd, 
            HttpSession session) {
        
        // Member 객체를 준비한 후
        Member member = new Member();
        
        // 로그인을 처리하기 위해 세션에 보관해야 한다.
        // 이 작업을 위해서 파라미터로 받은 객체를 사용해야 한다.
        session.setAttribute("loginUser", member);
        
        return "auth/login.jsp";
    }
}
