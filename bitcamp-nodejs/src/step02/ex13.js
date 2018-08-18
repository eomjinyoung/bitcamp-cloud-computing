// 주제: 데이터베이스 프로그래밍 - insert 실행 후 auto_increment PK 컬럼 값 알아내기

const mysql = require('mysql');

var con = mysql.createConnection({
    host: '13.209.35.254', 
    //port: '3306',
    database: 'studydb',
    user: 'study',
    password: '1111'
});

con.connect(function(err) {
    if (err) throw err; 
    
    console.log('연결 성공입니다!');
});

var title = '제목입니다.';
var content = '내용입니다.';

con.query(
    'insert into pms2_board(titl,cont,cdt) values(?,?,now())',
    [title, content],
    function(err, result) {
        if (err) throw err;
        
        console.log('입력 성공!');
        console.log(result.insertId);
});


con.end(function(err) {
    if (err) throw err; 
    console.log('연결을 끊었습니다!')
}); 

console.log('select 실행!');












