# 프로그래밍 준비
## 개발 도구 설치
- openjdk 10.0.1
- eclipse photon
- visual studio code
- git client
- scoop (package manager)
- scoop install gradle
- scoop install mysql
- scoop install nodejs

## mysql 설정
```
서버에 접속
> mysql -uroot -p
Enter password: (암호 없기 때문에 그냥 엔터 친다.)

root 사용자의 암호 설정
mysql>  update user set 
authentication_string=password('1111') 
where user='root';

암호 변경 후 권한 갱신
mysql> flush privileges;
mysql> quit

다시 접속
>mysql -uroot -p
Enter password: 1111
...

애플리케이션에서 DB에 접속할 때 사용할 사용자를 추가한다.
mysql> create user 'study'@'localhost' identified by '1111';

study 사용자가 사용할 데이터베이스 생성한다.
mysql> create database studydb 
character set utf8 
collate utf8_general_ci;

studydb 데이터베이스의 사용 권한을 study 사용자에게 부여한다.
mysql> grant all privileges on studydb.* to 'study'@'localhost';

study 사용자로 접속한다.
mysql> quit 또는 exit
> mysql -ustudy -p
Enter password: 1111
...

study 사용자가 사용할 수 있는 데이터베이스 목록 보기.
mysql> show databases;

사용할 데이터베이스 선택
mysql> use studydb;

studydb에 존재하는 테이블 목록 보기
mysql> show tables;

studydb에 테이블 생성
=> bitcamp-sql/pms-ddl.sql 실행
mysql> SQL을 복사하여 붙여 넣는다.

```

## Tomcat 설치

```
1) 톰캣 다운로드
- tomcat.apache.org 에서 다운로드

2) 톰캣 설치 
- c:\apps 폴더에 압축 푼다.
```

## eclipse 설정

```
워크스페이스 설정
1) 문자집합을 utf-8 로 설정한다.
- Preferences/General/Workspace/Text file encoding
  - UTF-8로 설정한다.
2) 에디터 기본 환경 설정
- Preferences/General/Editors/Text Editors
  - 탭 크기를 2 또는 4로 설정
  - 탭을 스페이스로 표현한다.
  - 한 줄 크기는 80자 정도.
  - 탭이나 공백에 대해 흐릿하게 표시.
3) 자바 환경 설정
- Preferences/Java/
  - Installed JRE : JDK 위치 지정하기
  - Code Style/Formatter : 자바 에디터 탭 정보 설정
  - Compiler: 기본 컴파일 버전 설정
4) 웹 환경 설정
- Preferences/Web/
  - CSS Files : 문자 집합을 UTF-8로 설정
  - HTML Files : 문자 집합을 UTF-8로 설정
  - JSP Files : 문자 집합을 UTF-8로 설정
5) WAS 서버 환경 설정
- Preferences/Servers/
  - Runtime Environments : 톰캣 서버 위치 설정
6) 애플리케이션을 배포하고 테스트할 톰캣 실행 환경 설정
- Servers 뷰 
  - 테스트용 실행 서버 추가
```



## 웹 프로젝트 폴더 준비

```
1) 예제 프로젝트 복사
- java106-java-project 를 bitcamp-cloud-computing 폴더로 복사한다.

2) 프로젝트 폴더를 이클립스 프로젝트로 만든다.
- 'gradle eclipse'를 실행하여 이클립스 설정 파일을 생성한다.
  - .project, .classpath, .settings/ 등이 있어야만 이클립스는 해당 프로젝트를 import 할 수 있다. 

```
