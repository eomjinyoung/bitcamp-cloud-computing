// 메서드 - 메서드 호출
package bitcamp.step04

// 파라미터 타입을 생략하면 기본이 Object이다.
def f1(a, b) {
    a + b
}

// 파라미터 값을 지정할 때 기존의 자바 문법처럼 괄호를 사용할 수 있다.
sum1 = f1(100, 200)
println sum1

// 또는 괄호를 생략할 수도 있다.
sum2 = f1 100, 200
println sum2