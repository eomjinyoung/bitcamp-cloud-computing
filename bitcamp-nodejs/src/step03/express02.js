// 요청 핸들러를 관리 + 호출

const http = require('http')
const url = require('url')

module.exports = function() { 
    return {
        requestHandlerMap: {},
        
        add(url, handler) {
            this.requestHandlerMap[url] = handler;
        },
        
        getHandler(url) {
            return this.requestHandlerMap[url];
        },
        
        listen(port, callback) {
            var mapper = this;
            
            const server = http.createServer((req, res) => {
                var urlInfo = url.parse(req.url, true);
                
                if (urlInfo.pathname === '/favicon.ico') {
                    res.end();
                    return;
                }
                
                res.writeHead(200, {
                    'Content-Type': 'text/plain;charset=UTF-8'
                });
                
                var handler = mapper.getHandler(urlInfo.pathname);
                
                if (handler) {
                    try {
                        handler(urlInfo, req, res);
                    } catch (err) {
                        res.end('실행 중 오류 발생!');
                    }
                } else {
                    res.end('해당 URL을 지원하지 않습니다!');
                    return;
                }
                
            });
            
            
            server.listen(port, callback);
        }
    }; // return
}; // function()
