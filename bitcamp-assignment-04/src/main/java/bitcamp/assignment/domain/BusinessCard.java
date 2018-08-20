package bitcamp.assignment.domain;

import java.io.Serializable;

public class BusinessCard implements Serializable {
    private static final long serialVersionUID = 1L;
    
    protected int no;
    protected int memberNo;
    protected String name;
    protected String mobileTel;
    protected String tel;
    protected String fax;
    protected String email;
    protected String memo;
    
    @Override
    public String toString() {
        return "BusinessCard [no=" + no + ", memberNo=" + memberNo + ", name=" + name + ", mobileTel=" + mobileTel
                + ", tel=" + tel + ", fax=" + fax + ", email=" + email + ", memo=" + memo + "]";
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public int getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMobileTel() {
        return mobileTel;
    }
    public void setMobileTel(String mobileTel) {
        this.mobileTel = mobileTel;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    
    
}
