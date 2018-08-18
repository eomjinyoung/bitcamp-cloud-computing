// 주제: HTTP 서버 만들기 - single thread
// => Node.js는 single thread로 동작한다.
// => 즉 한 클라이언트의 요청을 처리할 때까지 다른 클라이언트는 기다려야 한다.
// => 그래서 Node.js의 HTTP 서버는 
//    시간이 오래 걸리는 동시 요청을 처리하기에 적합하지 않다.
//    그런 용도가 아니다.
// => 작업 시간이 짧은 단타성 요청을 처리하기에 적합하다.
//

const http = require('http')
const server = http.createServer((req, res) => {
    console.log('요청 받았음!')
    
    // 클라이언트 요청이 들어오면 10초 후에 응답해보자!
    // => 테스트 방법: 웹브라우저 탭을 두 개를 띄운 다음에
    //    이 서버에 접속해 보라!
    setTimeout(() => {
        res.end();
    }, 20000)
});

server.listen(8000, () => {
    console.log('서버가 시작됨!')
})









