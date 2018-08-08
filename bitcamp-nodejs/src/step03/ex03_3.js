// 주제: 요청 정보 다루기 - 요청 파라미터 값 꺼내기
//

const http = require('http')

// URL 분석에 사용할 모듈 로딩
const url = require('url')

const server = http.createServer((req, res) => {
    console.log('요청 받았음!')
    
    res.writeHead(200, {
        'Content-Type': 'text/plain;charset=UTF-8'
    });
    
    // query 객체에서 파라미터 명을 사용하여 값을 꺼내고 싶다면,
    // 두 번째 파라미터의 값을 true로 설정하라!
    // => parse() 함수가 파라미터 값을 꺼내기 쉽도록 
    //    query 객체에 프로퍼티 형태로 담아 준다.
    var urlInfo = url.parse(req.url, true);
    
    // 파라미터 값을 꺼낼 때는 그냥 
    // "query.파라미터명" 으로 지정하면 된다. 
    res.write(`name=${urlInfo.query.name}\n`)
    res.write(`age=${urlInfo.query.age}\n`)
    res.end()
});

server.listen(8000, () => {
    console.log('서버가 시작됨!')
})









