// 주제: 모듈을 정의하고 사용하기
//

// => exports에 저장된 함수 받기 
var obj1 = require('./ex08_m');
var obj2 = require('./ex08_m');

obj1.plus(100); // result = 100
obj1.minus(7); // result = 93

obj2.plus(100); // result = 193
obj2.multiple(7); // result = 193 * 7 = 1351

console.log(obj1.getResult());
console.log(obj2.getResult());

// => require()가 리턴하는 객체의 함수는 
//    같은 모듈 변수를 사용한다.






