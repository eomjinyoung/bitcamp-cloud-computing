// 메서드 - 파라미터
package bitcamp.step04

// 파라미터 타입을 생략하면 기본이 Object이다.
def f1(a, b) {
    a + b
}
println f1(100, 200)

// 물론 타입을 지정할 수 있다.
def f2(int a, int b) {
    a - b;
}
println f2(100, 200)