//주제: 템플릿 엔진 사용
// 템플릿 엔진 모듈을 로딩한다.
const handlebars = require('handlebars')

// 템플릿 소스를 정의한다.
var templateSrc = '{{name}}님 안녕하세요!';

// 템플릿 소스에 데이터를 삽입하여 최종 결과를 만들어 낼 함수를 준비한다.
var templateFn = handlebars.compile(templateSrc);

//템플릿 함수를 호출하여 소스로부터 결과를 얻는다.
// => 소스에 삽입될 데이터를 파라미터로 넘긴다.
var resultStr = templateFn({name: '홍길동'})

console.log(resultStr);






