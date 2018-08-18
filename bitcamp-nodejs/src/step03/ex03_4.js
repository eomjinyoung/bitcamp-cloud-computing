// 주제: 요청 정보 다루기 - URL에 따라 작업을 분리하기
//

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
    
    if (urlInfo.pathname === '/board/list') {
        res.write('게시물 목록')
    } else if (urlInfo.pathname === '/board/add') {
        res.write('게시물 등록')
    } else {
        res.write('해당 URL을 지원하지 않습니다!')
    }

    res.end()
});

server.listen(8000, () => {
    console.log('서버가 시작됨!')
})









