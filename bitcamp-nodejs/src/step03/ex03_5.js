// 주제: 요청 정보 다루기 - Quiz: 계산기를 만들라!
// [실행 URL]
// => 100 + 200 : http://localhost:8000/calc?a=100&b=200&op=%2b
// => 100 - 200 : http://localhost:8000/calc?a=100&b=200&op=-
// => 100 * 200 : http://localhost:8000/calc?a=100&b=200&op=*
// => 100 / 200 : http://localhost:8000/calc?a=100&b=200&op=/
// [출력 결과]
// => 100 + 200 = 300


const http = require('http')

// URL 분석에 사용할 모듈 로딩
const url = require('url')

const server = http.createServer((req, res) => {
    var urlInfo = url.parse(req.url, true);
    
    if (urlInfo.pathname === '/favicon.ico') {
        res.end();
        return;
    }
    
    console.log('요청 받았음!');
            
    res.writeHead(200, {
        'Content-Type': 'text/plain;charset=UTF-8'
    });
    
    if (urlInfo.pathname !== '/calc') {
        res.end('해당 URL을 지원하지 않습니다!');
        return;
    }
    
    var a = parseInt(urlInfo.query.a)
    var b = parseInt(urlInfo.query.b)
    var op = urlInfo.query.op
    var result = 0;
    
    switch (op) {
    case '+': result = a + b; break;
    case '-': result = a - b; break;
    case '*': result = a * b; break;
    case '/': result = a / b; break;
    default:
        res.write('${op} 연산자를 지원하지 않습니다.')
        res.end();
        return;
    }

    res.write(`${a} ${op} ${b} = ${result}\n`)
    res.end()
});

server.listen(8000, () => {
    console.log('서버가 시작됨!')
})









