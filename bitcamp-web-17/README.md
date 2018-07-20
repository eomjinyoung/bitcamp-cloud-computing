## web-17 : 서비스 컴포넌트에 트랜잭션 적용
- 트랜잭션 관리자를 설정하여 서비스 메서드에 트랜잭션을 적용한다.

## @Transactional 애노테이션으로 트랜잭션 관리하기
- 서비스 객체의 각 메서드에 대해 애노테이션을 붙여 트랜잭션을 지정할 수 있다.

### Spring IoC 설정 파일에 트랜잭션 애노테이션을 처리할 객체를 등록한다.
```
<tx:annotation-driven transaction-manager="txManager"/>
```

### 서비스 객체의 메서드에 @Transactional 애노테이션을 붙인다.

## XML로 트랜잭션 관리하기

### AOP 관련 의존 라이브러리 추가 
- mvnrepository에서 'aspectj weaver' 라이브러리 검색
- build.gradle 파일에 추가 
- 'gradle eclipse' 실행
- 프로젝트 리프래시

### 스프링 IoC 컨테이너 설정 파일에 트랜잭션 설정 추가
```
<!-- 애노테이션이 아닌 AOP를 이용하여 트랜잭션을 관리할 수 있다. -->
  <!-- 메서드 별로 어떻게 트랜잭션을 적용할 지 설정한다. -->
  <tx:advice id="txAdvice" transaction-manager="txManager">
    <tx:attributes>
       <tx:method name="get*" read-only="true"/>
       <tx:method name="list*" read-only="true"/>
       <tx:method name="*"/>
    </tx:attributes>
  </tx:advice>
  
  <!-- 트랜잭션을 적용할 대상을 설정한다. -->
  <aop:config>
      <!-- 트랜잭션을 적용할 대상의 규칙을 선언 -->
      <aop:pointcut id="serviceOperation" 
        expression="execution(* bitcamp.pms.service.*.*(..))"/>
      
      <!-- 대상에 대해 어떤 트랜잭션을 적용할 지 설정한다. -->
      <aop:advisor advice-ref="txAdvice" 
        pointcut-ref="serviceOperation"/>
  </aop:config>
```



















