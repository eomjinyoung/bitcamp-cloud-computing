//주제: express 사용하기 - 서버 실행하기 II

//=> express 모듈 로딩과 웹서버 객체 준비를 한 번에 하기
const app = require('express')()

app.get('/test01', (req, res) => {
    res.writeHead(200, {'Content-Type':'text/plain;charset=UTF-8'});
    res.write('test01....ok');
    res.end();
});

app.listen(8000, () => {
    console.log('서버 실행 중...')
})