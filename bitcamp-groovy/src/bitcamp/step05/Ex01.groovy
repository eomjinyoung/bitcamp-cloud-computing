// 클래스 정의
package bitcamp.step05

// groovy는 기본적으로 다음 패키지들을 import한다.
// => 즉 다음 패키지의 클래스를 사용할 때는 따로 import 할 필요가 없다.
/*
import java.util.*;
import java.math.*;
import java.io.*;
import java.net.*;
import groovy.lang.*;
import groovy.util.*;
 */

// 클래스를 정의하면 groovy.lang.GroovyObject 인터페이스를 
// 자동으로 구현한다.
class Ex01 implements Serializable {
    void hello() {
        println "안녕하세요!"
        Socket s;
    }
}