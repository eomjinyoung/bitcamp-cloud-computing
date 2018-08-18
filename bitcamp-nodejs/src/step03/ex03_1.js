// 주제: 요청 정보 다루기 - URL 알아내기
//

const http = require('http')
const server = http.createServer((req, res) => {
    console.log('요청 받았음!')
    
    res.writeHead(200, {
        'Content-Type': 'text/plain;charset=UTF-8'
    });
    
    //클라이언트가 요청한 url을 보기
    //=> http://localhost:8000/aaa/bbb/ccc?name=hong&age=20
    res.write(req.url);
    res.end();
});

server.listen(8000, () => {
    console.log('서버가 시작됨!')
})









