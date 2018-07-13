package bitcamp.pms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bitcamp.pms.domain.Member;

@Repository
public class MemberDao {
    
    SqlSessionFactory sqlSessionFactory;

    public MemberDao() {}
    
    public MemberDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Member> selectList(Map<String,Object> params) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectList("member.selectList", params);
        }
    }
    
    public Member selectOne(String id) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectOne("member.selectOne", id);
        }
    }
    
    public int update(Member member) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int count = sqlSession.update("member.update", member);
            sqlSession.commit();
            return count;
        }
    }
    
    public int delete(String id) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int count = sqlSession.delete("member.delete", id);
            sqlSession.commit();
            return count;
        }
    }
    
    public int insert(Member member) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int count = sqlSession.insert("member.insert", member);
            sqlSession.commit();
            return count;
        }
    }
}



