// 메서드 - 클로저와 it 배열 
package bitcamp.step04

// it 배열은 자바스크립트의 arguments와 유사한다.
plus = { 
    return it[0] + it[1]
}

// 함수를 호출할 때 배열을 넘기면,
// => 함수 안에서는 빌트인 변수 it으로 받을 수 있다.
result = plus([100, 200])
println result


