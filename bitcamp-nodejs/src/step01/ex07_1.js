// 주제: 모듈을 정의하고 사용하기
//

// => exports에 저장된 함수 받기 
var fn = require('./ex07_m');

var obj = fn();

obj.plus(100);
obj.minus(7);

// result 변수는 리턴된 객체에 들어 있지 않다.
// plus(), minus() 등 클로저가 공유하는 메모리에 들어있다.
// 그래서 외부에서 직접 접근할 수 없다.
// 자바 문법으로 따지면 일종의 private 변수가 된 것이다.
console.log(obj.result);

// 클로저가 공유하는 변수의 값을 알고 싶다면,
// 그 변수의 값을 꺼내는 클로저를 호출해야 한다.
// 일종의 자바의 getter라고 할 수 있다.
console.log(obj.getResult());






