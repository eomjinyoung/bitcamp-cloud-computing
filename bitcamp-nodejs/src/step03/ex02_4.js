// 주제: 클라이언트에게 출력하기 - 멀티라인 처리
//

const http = require('http')
const server = http.createServer((req, res) => {
    console.log('요청 받았음!')
    
    res.writeHead(200, {
        'Content-Type': 'text/html;charset=UTF-8'
    });
    
    // write()를 사용하여 콘텐트를 출력할 수 있다.
    res.write('<html>\n\
<head>\n\
  <title>Node.js</title>\n\
</head>\n\
<body>\n\
  <h1>안녕!</h1>\n\
</body>\n\
</html>\n');
    res.end(); // end()에서 꼭 출력할 필요는 없다.
});

server.listen(8000, () => {
    console.log('서버가 시작됨!')
})









