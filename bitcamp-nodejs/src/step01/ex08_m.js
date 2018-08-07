// 모듈 정의 VI
// - 모듈 변수 사용하기
//

var result = 0;

module.exports = {
    plus(value) {result += value},
    minus(value) {result -= value},
    multiple(value) {result *= value},
    divide(value) {result /= value},
    getResult() {return result}
};









