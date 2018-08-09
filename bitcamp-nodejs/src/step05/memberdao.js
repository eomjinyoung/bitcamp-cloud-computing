// 주제: DAO 모듈 만들기

var pool;

exports.setConnectionPool = (connectionPool) => {
    pool = connectionPool;
};

exports.list = (pageNo = 1, pageSize = 3, handler) => {
    var startIndex = (pageNo - 1) * pageSize;
    
    pool.query('select mid, email from pms2_member limit ?, ?',
            [startIndex, pageSize],
            function(err, results) {
        handler(err, results);
    });
};

exports.add = (data, handler) => {
    pool.query(
        'insert into pms2_member(mid,email,pwd)\
        values(?, ?, password(?))',
        [data.id, data.email, data.password],
        function(err, result) {
            handler(err, result);
    });
};

exports.update = (data, handler) => {
    pool.query(
        'update pms2_member set\
         email=?,\
         pwd=?\
         where mid=?',
        [data.email,
         data.password,
         data.id],
        function(err, result) {
            handler(err, result);
    });
};

exports.remove = (data, handler) => {
    pool.query(
        'delete from pms2_member where mid=?',
        [data.id],
        function(err, result) {
            handler(err, result);
    });
};
















