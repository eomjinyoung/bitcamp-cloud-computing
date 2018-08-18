// 주제: 클라이언트에게 출력하기 - 콘텐트 타입 설정하기
//

const http = require('http')
const server = http.createServer((req, res) => {
    console.log('요청 받았음!')
    
    // 출력하는 콘텐트의 타입을 설정해야 한글이 깨지지 않는다.
    // 응답 헤더로 'Content-Type'을 지정하라!
    res.writeHead(200, {
        'Content-Type': 'text/plain;charset=UTF-8'
    });
    
    res.end('안녕!');
});

server.listen(8000, () => {
    console.log('서버가 시작됨!')
})









