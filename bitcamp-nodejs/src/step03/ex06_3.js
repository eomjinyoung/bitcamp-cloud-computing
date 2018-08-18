//주제: 템플릿 엔진 사용 - HTML 출력하기
const express = require('express')
const app = express();

const handlebars = require('handlebars')
var templateSrc = 
'<html>\
<head>\
<title>테스트</title>\
</head>\
<body>\
<h1>환영합니다!</h1>\
<p>{{name}}님 안녕하세요!</p>\
</body>\
</html>';
var templateFn = handlebars.compile(templateSrc);
    
app.get('/hello', (req, res) => {
    var resultStr = templateFn(req.query)
    res.writeHead(200, {'Content-Type':'text/html;charset=UTF-8'});
    res.write(resultStr);
    res.end();
});

app.listen(8000, () => {
    console.log('서버 실행 중...');
});






