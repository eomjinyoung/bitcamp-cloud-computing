// 주제: 모듈을 실행하는 과정 알아보기
//

// require()를 여러 번 호출할 때 리턴 값은?
// => 모듈은 한 번만 실행된다.
// => 그래서 리턴 값은 같다.
var obj = require('./ex09_m');
obj.test = 100;
console.log(obj);
console.log('------------------');

var obj2 = require('./ex09_m');
obj2.test2 = 200;

console.log(obj);
console.log(obj2);
console.log('------------------');

var obj3 = require('./ex09_m');
console.log(obj3);


// 결론!
// => 모듈은 오직 한 번만 실행된다.
// => 그래서 리턴 객체는 같다.
// => 즉 모듈 변수는 오직 한 개만 존재한다.
// => 따라서 객체마다 고유의 값을 갖게 하려면 모듈 변수를 사용해서는 안된다.
//
















