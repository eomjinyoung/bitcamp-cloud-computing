// 모듈 정의 VIII
// - 모듈 변수와 글로벌 변수
//

// 모듈 변수는 이 파일 내에서만 사용할 수 있다.
var v1 = 100;
console.log("ex10_m", v1);

// 글로벌 변수는 모든 모듈이 공유한다.
console.log("global", global.v1);

// 모듈에서 글로벌 변수의 값을 바꾸기
global.v1 = 300;







