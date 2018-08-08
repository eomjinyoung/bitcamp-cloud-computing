// 주제: HTTP 서버 만들기 - 클라이언트에게 응답 완료하기

const http = require('http')
const server = http.createServer((req, res) => {
    console.log('요청 받았음!')
    
    // HTTP 응답을 완료해서 웹 브라우저의 기다림이 멈춘다.
    res.end();
});

server.listen(8000, () => {
    console.log('서버가 시작됨!')
})









