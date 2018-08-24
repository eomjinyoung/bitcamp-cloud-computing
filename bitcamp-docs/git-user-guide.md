# Git 사용법

## git config
- git의 사용 환경을 설정한다.
- /etc/gitconfig 설정 파일
  - 시스템의 모든 사용자와 모든 저장소에 적용되는 설정.
  - `git config --system` 옵션으로 이 파일을 읽고 쓴다.
  - Windows OS의 경로 - C:/ProgramData/Git/config
- ~/.gitconfig, ~/.config/git/config 설정 파일
  - 특정 사용자만 적용되는 설정.
  - `git config --global` 옵션으로 이 파일을 읽고 쓴다.
  - Windows OS의 경로 - C:/Users/사용자홈/.gitconfig
- .git/config
  - 특정 저장소에만 적용되는 설정.
  - `git config` 옵션을 지정하지 않으면 이 파일을 읽고 쓸 수 있다.
```
예1) 사용자 이름 설정하기
$ git config --global user.name "Jinyoung Eom"
$ git config --global user.email "jinyoung.eom@gmail.com"

예2) 기본 텍스트 편집기 설정하기
$ git config --global core.editor emacs

예3) 설정 확인하기
$ git config --list

예4) 특정 값 확인하기
$ git config user.name
```

## git help [명령], git [명령] --help
- 명령어에 대한 도움말을 볼 수 있다.
```
예1) config 명령에 대한 도움말 보기
$ git help config
$ git config --help
```

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
         Working Directory         | Staging Area | .git Directory(Repository)
[Untracked] [Unmodified] [Modified]|[   Staged   ]|     
-----------------------------------|--------------|---------------------------
    +------------------------------------->>                      : git add
                              +----------->>                      : git add
                                           +---------------->>    : git commit
                  <<-----------------------+                  
                  +---------->>                                   : 파일 편집
    <<------------+                                               : 파일 삭제
```

- Working Directory
  - 특정 버전을 checkout하면 .git 디렉토리에 있는 압축된 데이터베이스에서 파일을 가져와서 작업 디렉토리를 만든다.
  - **Untracked 상태** - 작업 디렉토리에 새로 추가한 파일. 즉 아직 저장소에 저장되지 않은 파일로서 git의 버전 관리 대상이 아닌 상태.
  - **Unmodified 상태** - 깃에 의해 버전 관리되는 파일로서 작업 디렉토리에 가져온 파일. 아직 변경되지 않은 상태.
  - **Modified 상태** - 깃에 의해 버전 관리되는 파일로서 작업 디렉토리에 가져온 파일. 변경된 상태.
- Staging Area
  - commit 할 파일의 정보를 담고 있는 파일. git 디렉토리에 있음.
  - 인덱스라는 명칭으로도 불림. Staging Area 용어가 대세.
  - **Staged 상태** - 파일이 저장소에 저장될 대상으로 선정된 상태.
- .git Directory
  - 프로젝트의 메타데이터와 객체 데이터베이스를 저장하는 곳.
  - 원격 저장소를 clone 할 때 생성됨.

```
예1) 현재 작업 디렉토리의 파일 상태 보기
$ git status
On branch master
Your branch is up to date with 'origin/master'.

Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

	modified:   src/main/webapp/test01.html
	modified:   src/main/webapp/test02.html
	new file:   src/main/webapp/test04.html

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

	modified:   src/main/webapp/index.html
	modified:   src/main/webapp/test01.html

Untracked files:
  (use "git add <file>..." to include in what will be committed)

	src/main/webapp/test05.html

예2) 현재 작업 디렉토리의 파일 상태를 짤막하게 보기
$ git status --short
 M src/main/webapp/index.html
M  src/main/webapp/test01.html
MM src/main/webapp/test02.html
?? src/main/webapp/test03.html
A  src/main/webapp/test04.html
AM src/main/webapp/test05.html
```
[출력 결과 보는 법]
- [Staged 상태][Unstaged 상태] [파일 경로]
- `_M src/main/webapp/index.html`
  - 작업 디렉토리에 있는 파일을 변경한 경우.
- `M_ src/main/webapp/test01.html`
  - 작업 디렉토리에 있는 파일을 변경한 후,
    'git add' 명령으로 Stated 상태로 만든 경우.
- `MM src/main/webapp/test02.html`
  - Staged 상태의 파일을 다시 변경한 경우.
- `?? src/main/webapp/test03.html`
  - 작업 디렉토리에 새로 파일을 추가한 경우.
- `A_ src/main/webapp/test04.html`
  - 새로 추가한 파일을 'git add' 명령으로 Stating Area에 등록한 경우.
- `AM src/main/webapp/test05.html`
  - 새로 추가한 파일을 Staged 상태로 만든 후, 다시 변경한 경우.


## git checkout [파일]
- 작업 디렉토리의 파일을 변경한 후 원래 저장소에 있던 파일로 되돌릴 때 사용한다.
```
예) src/main/webapp/index.html 파일을 편집한 후 원래 저장소에 있던 파일로 되돌리기
$ git checkout src/main/webapp/index.html
```

## .gitignore 파일
- Git으로 관리할 필요가 없는 파일을 지정한다.
- 로그 파일(.log)이나 빌드 도구가 자동으로 생성한 파일 또는 디렉토리가 그 대상이다.
- 
















끝
