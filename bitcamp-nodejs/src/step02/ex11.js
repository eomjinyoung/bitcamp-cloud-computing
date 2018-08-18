// 주제: 데이터베이스 프로그래밍 - 커넥션 풀 사용 I

const mysql = require('mysql');

var pool = mysql.createPool({
    connectionLimit: 10,
    host: '13.209.35.254', 
    //port: '3306',
    database: 'studydb',
    user: 'study',
    password: '1111'
});

// 커넥션 풀에서 연결 객체를 한 개 얻는다.
pool.getConnection(function(err, con) {
    if (err) throw err; 
    
    console.log('연결 객체를 얻었다.');
    
    // 연결에 성공했을 때만 SQL을 실행하라고 예약한다.
    con.query('select * from pms2_member', function(err, results) {
        if (err) throw err;
        
        // results 파라미터에 결과가 들어 있다.
        for (var row of results) {
            // row 객체에서 값을 꺼낼 때는 SQL에서 지정한 컬럼명 또는 별명을 사용한다.
            console.log(row.email, row.mid, row.pwd);
        }
        
        con.release(); // 커넥션 풀에 연결 객체를 반납한다.
        
        //프로그램을 종료하고 싶다면 작업이 끝난 후 커넥션 풀의 모든 커넥션을 닫아야 한다.
        //보통 서버로서 실행하다가 종료할 때 커넥션 풀을 닫는다.
        //커넥션 풀을 닫지 않으면 Node.js의 메인 스레드가 종료되지 않는다.
        //물론 서버로 실행할 때는 당연히 그래야 하지만,
        //이 프로그램 예제처럼 그냥 간단히 사용하고 종료하고 싶다면
        //다음과 같이 질의를 완료한 후에 커넥션 풀을 닫아라.
        //=> 이런 단일 프로그램은 커넥션 풀을 사용할 필요가 없다.
        //=> 서버에서 사용할 것을 대비해 만든 예제이기 때문에
        //   질의가 끝난 후 닫는 것이다.
        //=> 일반적으로 이렇게 프로그램 하지 않는다.
        pool.end();
    });
    
});



console.log('select 실행!');












