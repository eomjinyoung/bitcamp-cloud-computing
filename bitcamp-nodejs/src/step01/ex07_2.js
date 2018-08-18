// 주제: 모듈을 정의하고 사용하기
//

// => exports에 저장된 함수 받기 
var fn = require('./ex07_m');

// => 클로저만 접근할 수 있는 변수이기에 객체마다 고유하다.
var obj1 = fn();
var obj2 = fn();

// obj1에 들어 있는 클로저가 사용하는 result 변수와 
// obj2에 들어 있는 클로저가 사용하는 result 변수가 다르다.
obj1.plus(100);
obj1.minus(7);

obj2.plus(100);
obj2.multiple(7);

console.log(obj1.getResult());
console.log(obj2.getResult());

//결론!
//=> 다음과 같이 require()가 함수를 리턴하고,
//   var fn = require(...);
//=> 그 함수가 객체를 리턴하는 상황이라면,
//   var obj = fn();
//=> 리턴된 객체마다 고유의 값을 다루기 위해 그렇게 모듈을 만든 것이라 생각하라!
//

















