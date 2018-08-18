// 주제: 코드를 모듈로 분리 - 요청 핸들러를 호출하는 코드 분리

const mysql = require('mysql')
const express = require('./express02')

var pool = mysql.createPool({
    connectionLimit: 10,
    host: '13.209.35.254', 
    //port: '3306',
    database: 'studydb',
    user: 'study',
    password: '1111'
});

const app = express();


app.add('/member/list', (urlInfo, req, res) => {
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

app.add('/member/add', (urlInfo, req, res) => {
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

app.add('/member/update', (urlInfo, req, res) => {
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

app.add('/member/delete', (urlInfo, req, res) => {
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


app.add('/hello', (urlInfo, req, res) => {
    res.write(`${urlInfo.query.name}님 안녕하세요!`);
    res.end();
});

app.listen(8000, () => {
    console.log('서버 실행 중...');
});






