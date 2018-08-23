// 변수 선언 - 동적 타입 변수
package bitcamp.step02

// 동적 타입 변수는 def 로 변수를 선언한다.
def a = 10
println a

// => 타입이 지정되지 않았기 때문에 다른 타입의 값을 저장할 수 있다.
a = "Hello" // 컴파일 오류!
println a

// => 부동소수점 값이 그래도 변수에 저장된다.
a = 3.14
println a

// 원리
// => 타입을 지정하지 않으면 Object 타입의 변수로 선언된다.
