function parseQuery(url) {
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
}