//주제: express 사용하기 - 서버 실행하기

//=> express 모듈 로딩
const express = require('express')

//=> 웹서버 객체 준비
const app = express();

//=> URL에 대해 함수를 연결한다.
app.get('/test01', (req, res) => {
    res.writeHead(200, {'Content-Type':'text/plain;charset=UTF-8'});
    res.write('test01....ok');
    res.end();
});

//=> 서버 실행하기
app.listen(8000, () => {
    console.log('서버 실행 중...')
})