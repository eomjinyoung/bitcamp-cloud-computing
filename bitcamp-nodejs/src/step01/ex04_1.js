// 주제: 모듈을 정의하고 사용하기
//

// => 모듈명에서 ".js" 확장자를 생략해도 된다.
// => "./" 경로를 생략하면 모듈명으로 인식한다.
// => 모듈명으로 찾을 때는 npm이 설치한 모듈 경로에서 찾기 때문에
//    소스 경로에서 찾을 수 없다.
var obj = require('./ex04_m');

console.log(obj.plus(10, 20));
console.log(obj.minus(10, 20));
console.log(obj.multiple(10, 20));
console.log(obj.divide(10, 20));