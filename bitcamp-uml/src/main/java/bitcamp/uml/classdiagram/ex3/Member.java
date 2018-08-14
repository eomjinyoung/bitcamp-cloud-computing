package bitcamp.uml.classdiagram.ex3;

//Composition(합성)
//=> 한 객체가 다른 객체를 포함하는 관계.
//=> Container와 Containee가 라이프사이클을 함께한다.
// 즉 Container가 소멸될 때 Containee도 함께 소멸된다.
public class Member {
    
    // 합성 관계에서는 보통 Containee를 Container에서 생성한다.
    Address juso;
    
    public Member() {
        juso = new Address("11122", "기본주소", "상세주소");
    }
}
