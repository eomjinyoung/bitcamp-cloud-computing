// 메서드 - 클로저
package bitcamp.step04

// {}를 이용하여 함수를 정의할 수 있다.
plus = {int a, int b -> 
    return a + b
}
result = plus 100, 200
println result

// 파라미터의 타입과 return 명령을 생략할 수 있다.
plus2 = {a, b ->
    a + b
}
result = plus2 100, 200
println result

// 파라미터가 없으면 파라미터 선언부를 작성하지 않아도 된다.
hello = {println "Hello"}
hello()

// 파라미터가 있으면 파라미터 선언부를 작성하면 된다.
hello2 = {name -> println name + "님 안녕하세요!"}
hello2 "홍길동"
