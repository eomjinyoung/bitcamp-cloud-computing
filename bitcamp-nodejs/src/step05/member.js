// 주제: DAO 분리

const mysql = require('mysql')
const express = require('express')
const router = express.Router();
const memberdao = require('./memberdao')

var pool = mysql.createPool({
    connectionLimit: 10,
    host: '13.209.35.254', 
    //port: '3306',
    database: 'studydb',
    user: 'study',
    password: '1111'
});

memberdao.setConnectionPool(pool);


// get 요청에 대해 핸들러를 등록하기
router.get('/list', (req, res) => {
    res.writeHead(200, {'Content-Type':'text/plain;charset=UTF-8'});
    var pageNo = 1;
    var pageSize = 3;
    
    if (req.query.pageNo) {
        pageNo = parseInt(req.query.pageNo)
    }
    if (req.query.pageSize) {
        pageSize = parseInt(req.query.pageSize)
    }
    
    memberdao.list(pageNo, pageSize, (err, results) => {
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

router.get('/add', (req, res) => {
    res.writeHead(200, {'Content-Type':'text/plain;charset=UTF-8'});
    memberdao.add(req.query, (err, result) => {
        if (err) {
            res.end('데이터 처리 중 예외 발생!')
            return;
        }
        
        res.write('등록성공!\n')
        res.end();
    });
});

router.get('/update', (req, res) => {
    res.writeHead(200, {'Content-Type':'text/plain;charset=UTF-8'});
    memberdao.update(req.query, (err, result) => {
        if (err) {
            res.end('DB 조회 중 예외 발생!')
            return;
        }
        
        res.write('변경 성공!')
        res.end();
    });
});

router.get('/delete', (req, res) => {
    res.writeHead(200, {'Content-Type':'text/plain;charset=UTF-8'});
    memberdao.remove(req.query, (err, result) => {
        if (err) {
            res.end('DB 조회 중 예외 발생!')
            return;
        }
        res.write('삭제 성공!')
        res.end();
    });
});


module.exports = router;





