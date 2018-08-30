package bitcamp.mvc.vo;

public class Member {
    String id;
    String email;
    String password;
    String name;
    int age;
    
    @Override
    public String toString() {
        return "Member [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", age=" + age
                + "]";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
