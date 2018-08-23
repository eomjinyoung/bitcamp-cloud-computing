// switch
package bitcamp.step03

switch (new Date()) {
// 조건으로 주어진 값이 숫자일 때
// 그 숫자에 해당하는 문자열이 있을 경우 같다고 판단한다.
// 따라서 문자열 500과 숫자 500을 명확히 구분하고 싶다면 
// 숫자를 먼저 검사하라!
case 500: println "500(숫자) 입니다."; break;
case "500": println "500(문자열) 입니다."; break;

case [2, 3, 5, 7, 11]: println "소수 입니다."; break;

case 100..700: println "100 이상 700 이하의 수입니다."; break;

case Number: println "Number 타입입니다."; break;

case String: println "String 타입입니다."; break;

default: println "기타입니다."
}




