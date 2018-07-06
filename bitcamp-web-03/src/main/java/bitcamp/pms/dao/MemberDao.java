package bitcamp.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.pms.domain.Member;

public class MemberDao {
    public static List<Member> selectList() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://13.125.81.120:3306/studydb",
                "study", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "select mid, email from pms2_member");
            ResultSet rs = stmt.executeQuery();) {
            
            ArrayList<Member> list = new ArrayList<>();
            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getString("mid"));
                member.setEmail(rs.getString("email"));
                list.add(member);
            }
            return list;
        }
    }
    
    public static Member selectOne(String id) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://13.125.81.120:3306/studydb",
                "study", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "select mid,email from pms2_member where mid=?");) {
            
            stmt.setString(1, id);
            
            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next()) {
                    return null;
                }
                
                Member member = new Member();
                member.setId(rs.getString("mid"));
                member.setEmail(rs.getString("email"));
                return member;
            }
        }  
    }
    
    public static int update(Member member) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://13.125.81.120:3306/studydb",
                "study", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "update pms2_member set email=?, pwd=password(?) where mid=?");) {
            
            stmt.setString(1, member.getEmail());
            stmt.setString(2, member.getPassword());
            stmt.setString(3, member.getId());
            
            return stmt.executeUpdate();
        }
    }
    
    public static int delete(String id) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://13.125.81.120:3306/studydb",
                    "study", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "delete from pms2_member where mid=?");) {
            
            stmt.setString(1, id);
            
            return stmt.executeUpdate();
        } 
    }
    
    public static void insert(Member member) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://13.125.81.120:3306/studydb",
                    "study", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "insert into pms2_member(mid,email,pwd) values(?,?,password(?))");) {
            
            stmt.setString(1, member.getId());
            stmt.setString(2, member.getEmail());
            stmt.setString(3, member.getPassword());
        
            stmt.executeUpdate();
        }
    }
}
