import java.util.ArrayList;
import java.util.Scanner;

public class SelectorMember {

    public static void main(String[] args) throws Exception {
        String[] names = {
            "한동희", "박철현", "유승리", "정회진", "최성윤",
            "최성진", "강성현", "구민우", "김경미", "김도연",
            "김동수", "박진웅", "배혜림", "송민석", "양종훈",
            "이성민", "조재영", "한관영", "김석희"
        };
        
        ArrayList<String> list = new ArrayList<>();
        for (String name : names) {
            list.add(name);
        }
        
        Scanner keyScan = new Scanner(System.in);
        while (list.size() > 0) {
            keyScan.nextLine();
            int no = (int)(Math.random() * list.size());
            System.out.println(list.remove(no));
        }
        

    }

}
