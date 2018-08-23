// 메서드
package bitcamp.step04

// 리턴 타입을 지정하지 않으면 기본이 Object이다.
def f1() {
    "Hello!" // return을 생략하면 마지막 문자의 결과가 리턴된다.
}
println f1()

def f2() {
    return "Hello!"
}
println f2()