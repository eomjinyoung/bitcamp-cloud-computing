package bitcamp.java106.step13.ex2;

import org.springframework.stereotype.Component;

@Component 
public class X {
    public X() {
        System.out.println("X 객체 생성됨");
    }
    public void m1() {
        System.out.println("X.m1()");
    }
}
