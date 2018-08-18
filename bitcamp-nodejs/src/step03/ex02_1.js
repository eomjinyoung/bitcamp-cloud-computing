// 주제: 클라이언트에게 출력하기
//

const http = require('http')
const server = http.createServer((req, res) => {
    console.log('요청 받았음!')
    
    // 출력하는 데이터의 콘텐트 타입을 웹 브라우저에게 알려주지 않았기 때문에
    // 웹 브라우저는 제대로 출력하지 못한다. 한글 깨진다.
    res.end('안녕!');
});

server.listen(8000, () => {
    console.log('서버가 시작됨!')
})









