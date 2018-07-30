// 자주 사용할 함수를 라이브러리화 시킨다.
let bit = function(value) {
    var e;
    if (value.startsWith("<")) {
        e = document.createElement(
                value.substr(1, value.length - 2));
    } else {
        e = document.querySelector(value);
    }
    
    // 개발자가 쓰기 좋은 함수를 추가해서 리턴하자!
    e.html = function(value) {
        e.innerHTML = value;
        return e;
    };
    
    e.append = function(child) {
        e.appendChild(child);
        return e;
    };
    
    e.appendTo = function(parent) {
        parent.appendChild(e);
        return e;
    };
    
    return e;
};

bit.parseQuery = function(url) {
    var paramMap = {};

    var qs = url.split('?');
    if (qs.length > 1) {
        var params = qs[1].split('&');
        for (var param of params) {
            var kv = param.split('=')
            paramMap[kv[0]] = kv[1];
        }
    }
    return paramMap;
};

let $ = bit;












