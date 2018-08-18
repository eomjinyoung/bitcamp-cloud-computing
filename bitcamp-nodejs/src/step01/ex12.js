// 주제: Node.js에서 제공하는 객체(빌트인 객체)
//

// node가 실행하는 소스 파일의 디렉토리 알아내기
console.log(__dirname);

// 디렉토리 및 파일 이름까지 포함
console.log(__filename);

// 'path' 모듈을 이용하면 더 다양하게 경로를 다룰 수 있다.
// => 보통 모듈을 실행한 후에 값을 리턴 받는 변수는 모듈명과 같은 이름으로 짓는다.
var path = require('path');

// path.join('경로1', '경로2', '경로3', ...) 
// => 여러 개의 경로를 붙여 한 경로를 만들어 리턴한다.
// => 각 경로 앞에 /를 붙이지 않아도 자동으로 경로와 경로 사이에 /가 붙는다.
console.log(path.join('c:/apps', '/aaa', 'bbb', 'okok.js'));

// 기존 파일의 경로를 기준으로 다른 파일의 경로를 설정하기
console.log(path.join(__dirname, 'ex12_m.js'));

// 물론 경로에서 . 또는 ..을 사용할 수 있다.
console.log(path.join(__dirname, '../step02/ex12_m.js'));












