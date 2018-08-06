// 주제: Node.js 소개 
// Node.js?
// - 구글에서 공개한 V8 자바스크립트 엔진을 사용하여 
//   웹브라우저 밖에서도 자바스크립트를 실행할 수 있도록 만든 프로그램이다.
// - 자바스크립트 기본 API를 그대로 사용할 수 있다.
// - 웹브라우저에서 실행하는 것이 아니기 때문에 
//   웹브라우저에서 제공하는 window, history, location, navigator, 
//   screen, document API는 사용할 수 없다.
// - Node.js는 데스크톱의 자원을 직접 사용할 수 있도록 별도의 라이브러리를 제공한다.
// - 주로 마이크로서비스를 만들 때 Node.js를 사용하기 때문에 
//   Node.js를 서버 프로그램 용으로 오해하는 경우가 많다.
// 
// 
// 사용법
// > node 파일명
// > node ex01.js
// > node src/step01/ex01.js
//
console.log("Hello!");
//console.log(window); // 실행 오류!
//console.log(history); // 실행 오류!
//console.log(location); // 실행 오류!
//console.log(navigator); // 실행 오류!
//console.log(screen); // 실행 오류!
//console.log(document); // 실행 오류!