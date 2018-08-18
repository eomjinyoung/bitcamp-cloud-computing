//주제: 템플릿 엔진 사용 - 외부 템플릿 파일 사용 II
const express = require('express')
const app = express();
const handlebars = require('handlebars')

//외부 파일의 경로를 다룰 때 사용할 모듈을 로딩
const path = require('path')

//외부 템플릿 파일의 경로 설정하기
var templatePath = path.join(__dirname, 'ex06_4_template.html')

//템플릿 파일을 읽어들일 모듈 로딩
const fs = require('fs')

// 비동기 방식으로 템플릿 파일의 내용을 읽어 들인다
// => 서버를 시작한 후 당장 템플릿 함수를 사용할 게 아니기 때문에
//    어느정도 시간적인 여유가 있다.
// => 따라서 파일을 읽어 들일 때 비동기 방식으로 읽어서 
//    템플릿 함수를 만들더라도 문제가 없을 것이다.
var templateFn;
var templateSrc = fs.readFile(templatePath, (err, data) => {
    templateFn = handlebars.compile(data.toString());
})
    
app.get('/hello', (req, res) => {
    var resultStr = templateFn(req.query)
    res.writeHead(200, {'Content-Type':'text/html;charset=UTF-8'});
    res.write(resultStr);
    res.end();
});

app.listen(8000, () => {
    console.log('서버 실행 중...');
});






