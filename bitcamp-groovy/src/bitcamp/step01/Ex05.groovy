// groovy - 클래스 정의
package bitcamp.step01

// 자바와 똑 같이 클래스를 만들 수 있다.
// => 단 groovy.lang.GroovyObject를 상속 받는다.
class Ex05 {
    
    // 직접 클래스를 정의한다면 main() 메서드를 직접 만들어야 한다.
    public static void main(String[] args) {
        // 그루비 문법과 자바 문법을 혼용해도 된다.
        println "Hello"
    }
}


// => 직접 클래스를 정의할 때는 클래스 밖에 코드를 둘 수 없다.
//println "Hello" // 컴파일 오류!