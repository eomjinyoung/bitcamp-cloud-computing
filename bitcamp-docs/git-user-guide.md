# 깃 사용법

## git init
- 존재하는 폴더를 깃 저장소로 만든다. 
- .git 폴더를 생성한다.
    - 깃 저장소 관련 파일을 두는 폴더이다.
```
예) ~/git/myProject 폴더를 깃 저장소로 설정하기
~/git/myProject$ git init
```

## git add [파일]
- 깃 저장소에서 보관할 대상을 선정한다.

```
예1) 현재 폴더에서 확장자가 c인 파일을 대상으로 선정한다.
$ git add *.c 

예2) 현재 폴더에서 LICENSE 이름을 가진 파일을 선정한다.
$ git add LICENSE

예3) 현재 폴더 및 모든 하위 폴더의 파일을 대상으로 선정한다.
$ git add . 
```

## git commit -m '저장할 대상에 대한 설명'
- `git add` 명령으로 선정된 대상을 저장소에 보관한다.
```
$ git commit -m '첫 번째 버전'
```

## git clone [url] [폴더]
- url로 지정한 서버의 저장소를 로컬로 복제한다.
- 폴더 이름을 지정하지 않으면 저장소 이름으로 폴더를 만들어 복제한다.
- 폴더 이름을 지정하면 그 이름으로 폴더를 만들어 복제한다.
```
예1) github.com의 저장소를 로컬에 복제하기
$ git clone https://github.com/eomjinyoung/myProject

예2) github.com의 저장소를 myProject2라는 이름으로 폴더를 만들어 로컬에 복제하기
$ git clone https://github.com/eomjinyoung/myProject myProject2

```

## git status
- 작업 파일의 상태를 조회한다.
```
[Untracked] [Unmodified] [Modified] [Staged]
    +---------------------------------->>     : git add
                              +-------->>     : git add
                <<----------------------+     : git commit
                +------------>>               : 파일 편집
    <<----------+                             : 파일 삭제 

Untracked  : 아직 저장소에 보관되지 않은 상태. 즉 git의 버전 관리 대상이 아닌 상태.
Unmodified : 깃에 의해 버전 관리되는 파일. 아직 변경되지 않은 상태. 
Modified   : 깃에 의해 버전 관리되는 파일. 변경된 상태.
Staged     : 새 버전을 부여할 대상 파일. 
```
