// 주제: 데이터베이스 프로그래밍 - select 실행

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


// query(sql, 실행  후 호출될 함수);
// =>SQL 실행 예약! 지금 당장 실행하는 것이 아니다.
con.query('select * from pms2_member', function(err, results) {
    if (err) throw err;
    
    console.log('결과를 가져왔다!');
});


con.end(function(err) {
    if (err) throw err; 
    
    console.log('연결을 끊었습니다!')
}); 

console.log('select 실행!');












