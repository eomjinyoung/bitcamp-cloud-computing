// 주제: 여러 개의 요청 처리하기 - 조건문을 없애고 URL과 함수를 자동 연결하기
// => 요청 핸들러(요청이 들어왔을 때 호출되는 함수)를 좀 더 관리하기 쉽게 
//    등록을 자동화한다.


const http = require('http')
const url = require('url')
const mysql = require('mysql');

var pool = mysql.createPool({
    connectionLimit: 10,
    host: '13.209.35.254', 
    //port: '3306',
    database: 'studydb',
    user: 'study',
    password: '1111'
});

const express = {
    reqMap: {},
    add(url, handler) {
        this.reqMap[url] = handler;
    },
    getHandler(url) {
        return this.reqMap[url];
    }
};

const server = http.createServer((req, res) => {
    var urlInfo = url.parse(req.url, true);
    
    if (urlInfo.pathname === '/favicon.ico') {
        res.end();
        return;
    }
            
    res.writeHead(200, {
        'Content-Type': 'text/plain;charset=UTF-8'
    });
    
    var handler = express.getHandler(urlInfo.pathname);
    
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


server.listen(8000, () => {
    console.log('서버가 시작됨!')
})

express.add('/member/list', (urlInfo, req, res) => {
    var pageNo = 1;
    var pageSize = 3;
    
    if (urlInfo.query.pageNo) {
        pageNo = parseInt(urlInfo.query.pageNo)
    }
    if (urlInfo.query.pageSize) {
        pageSize = parseInt(urlInfo.query.pageSize)
    }
    
    var startIndex = (pageNo - 1) * pageSize;
    
    pool.query('select mid, email from pms2_member limit ?, ?',
            [startIndex, pageSize],
            function(err, results) {
        if (err) {
            res.end('DB 조회 중 예외 발생!')
            return;
        }
        
        for (var row of results) {
            res.write(`${row.email}, ${row.mid}\n`);
        }
        res.end();
    });
});

express.add('/member/add', (urlInfo, req, res) => {
    pool.query(
            'insert into pms2_member(mid,email,pwd)\
            values(?, ?, password(?))',
        [urlInfo.query.id, urlInfo.query.email, urlInfo.query.password],
        function(err, results) {
            if (err) {
                res.end('데이터 처리 중 예외 발생!')
                return;
            }
            
            res.write('등록성공!\n')
            res.end();
    });
});

express.add('/member/update', (urlInfo, req, res) => {
    pool.query(
            'update pms2_member set\
             email=?,\
             pwd=?\
             where mid=?',
        [urlInfo.query.email,
         urlInfo.query.password,
         urlInfo.query.id],
        function(err, results) {
            if (err) {
                res.end('DB 조회 중 예외 발생!')
                return;
            }
            
            res.write('변경 성공!')
            res.end();
    });
});

express.add('/member/delete', (urlInfo, req, res) => {
    pool.query('delete from pms2_member where mid=?',
        [urlInfo.query.id],
        function(err, results) {
            if (err) {
                res.end('DB 조회 중 예외 발생!')
                return;
            }
            
            res.write('삭제 성공!')
            res.end();
    });
});


express.add('/hello', (urlInfo, req, res) => {
    res.write(`${urlInfo.query.name}님 안녕하세요!`);
    res.end();
});








