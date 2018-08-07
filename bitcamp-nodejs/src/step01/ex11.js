// 주제: require() 동작 원리
//

var obj1 = require2('m1');
console.log(obj1);

var obj2 = require2('m2');
console.log(obj2);

var obj3 = require2('m1');
console.log(obj3);

function require2(moduleName) {
    // 1) npm이 모듈들을 저장하는 폴더에 해당 이름의 모듈이 있는지 찾아본다.
    //    => 만약 있다면 그 모듈 파일을 읽어 들여 실행한다.
    // 2) 없다면, 파일 경로에서 해당 파일을 찾아 실행한다.
    // 3) 모듈에서 exports에 보관한 객체를 꺼내 따로 이름을 붙여 관리한다.
    // 4) 그리고 그 객체를 리턴한다.
    
    // 위의 설명을 가상으로 만들어 보자!
    if (!global.moduleMap)
        global.moduleMap = {};
    
    if (!global.moduleMap[moduleName]) { // 해당 모듈이 없다면,
        // 모듈을 실행한 후 그 모듈 이름으로 exports 값을 보관한다.
        // => 다음은 exports 값을 보관했다고 가정하는 것이다.
        global.moduleMap[moduleName] = {
            value: parseInt(Math.random() * 100)
        };
    }
    
    return global.moduleMap[moduleName];
}














