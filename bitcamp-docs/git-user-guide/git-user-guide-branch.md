# Git 브랜치 사용법

## 커밋 정보

Git에서 commit을 수행하면 다음의 절차에 따라 커밋 정보를 저장한다.

- `git add` 실행
  - **Blob** 생성
    - Git 저장소에 저장되는 파일이다.
    - 각 파일은 SHA-1 해시 알고르즘으로 계산된 40바이트 크기의 고유의 체크섬(checksum) 값을 가진다.
  - Staging Area에 Blob의 체크섬을 기록한다.
- `git commit` 실행
  - 트리 객체 생성
    - 디렉토리와 파일의 구조 정보가 들어 있다.
    - 파일 정보는 Blob의 체크섬이다. 
    - 각 트리를 구분하기 위한 SHA-1 해시로 생성한 체크섬을 가진다.
  - 커밋 객체 생성
    - 작성자, 커미터, 커밋 메시지 등 메타 정보가 들어 있다.
    - 트리 객체를 가리키는 정보가 들어 있다.
    - 각 커밋을 식별하기 위한 SHA-1 해시로 생성한 체크섬을 가진다.
    - 이전 커밋을 가리키기 위해 이전 커밋의 체크섬이 들어 있다.
- 객체들 간의 관계
  - [커밋 객체]----> [트리 객체]----> [Blob 객체들]     

## 브랜치

- Git의 브랜치는 커밋 사이를 이동할 때 사용하는 포인터 같은 것이다.
- 커밋의 체크섬을 이용하여 여러 커밋들 중에서 한 커밋을 가리킨다.
- 즉 새 브랜치를 만드는 것은 단순히 41바이트(40바이트 체크섬 + 1바이트 줄 바꿈 문자)의 파일을 하나 만드는 것에 불과하다. 따라서 브랜치를 여러 개 만들어도 전혀 상관없다. 
- Git은 브랜치를 만들어 작업하고 나중에 merge 하는 것을 권장한다.
- 하루에 수십 번씩 해도 괜찮다고 제안하고 있다. 

### master 브랜치

- `git init`를 통해 Git 저장소를 만들 때 'master'라는 이름으로 기본 브랜치를 생성한다.
- master 브랜치로 작업하는 동안에는 항상 가장 마지막 커밋을 가리킨다.

### HEAD

- 현재 작업 중인 로컬 브랜치를 가리키는 특수한 포인터이다.


## 브랜치 명령

### git branch [새 브랜치 이름]

- 브랜치를 새로 만든다.
- 새로 만든 브랜치도 지금 작업하고 있는 커밋을 가리킨다.
- HEAD 포인터는 브랜치 생성과 상관없이 기존의 브랜치를 계속 가리킨다.

```
예1) b1 이라는 이름으로 브랜치를 새로 만든다.
$ git branch b1
$ git log --oneline                   <=== 커밋 정보를 한 줄 씩 출력한다.
f559e21 (HEAD -> master, b1) v0.3
5896279 v0.2
8dd76bf v0.1
5d8d97b (origin/master, origin/HEAD) Initial commit 
```

### git checkout [브랜치 이름]

- HEAD 포인터가 다른 브랜치를 가리키게 한다.
- HEAD 포인터가 가리키는 브랜치가 바뀌면, 작업 디렉토리도 그 브랜치의 커밋 정보에 따라 바뀐다.

```
예1) HEAD 포인터를 b1 브랜치로 옮긴다.
$ git checkout b1
$ git log --oneline                   <=== 로그 정보를 확인해 보라.
f559e21 (HEAD -> b1, master) v0.3     <=== HEAD는 b1을 가리키고 있다. 
5896279 v0.2
8dd76bf v0.1
5d8d97b (origin/master, origin/HEAD) Initial commit
```

```
예2) test04.txt를 만들어 b1 브랜치에 추가하기
    test04.txt 파일을 만들었다고 가정하자!
$ git add test04.txt
$ git commit -m 'v0.4'
$ git log --oneline
9cf510e (HEAD -> b1) v0.4    <=== b1은 새로 커밋한 스냅샷을 가리킨다. HEAD는 현재 작업 브랜치인 b1을 가리킨다.
f559e21 (master) v0.3        <=== master가 가리키는 스냅샷은 변경되지 않는다. 
5896279 v0.2
8dd76bf v0.1
5d8d97b (origin/master, origin/HEAD) Initial commit
```

```
예3) test05.txt를 만들어 b1 브랜치에 추가하기
    test05.txt 파일을 만들었다고 가정하자!
$ git add test05.txt
$ git commit -m 'v0.5'
$ git log --oneline
34fda9c (HEAD -> b1) v0.5    <=== b1은 새로 커밋한 스냅샷을 가리킨다. HEAD는 현재 작업 브랜치인 b1을 가리킨다.
9cf510e v0.4    
f559e21 (master) v0.3        <=== master가 가리키는 스냅샷은 변경되지 않는다. 
5896279 v0.2
8dd76bf v0.1
5d8d97b (origin/master, origin/HEAD) Initial commit
```

```
예4) 작업할 브랜치를 b1에서 다시 master로 교체하기
    브랜치를 교체한 후 작업 디렉토리를 확인해 보면, 다시 master가 가리키는 스냅샷으로 돌아 온 것을 확인할 수 있다.
$ git checkout master
$ git log --oneline
f559e21 (HEAD -> master) v0.3    <=== 전체 스냅샷 중에서 master 브랜치와 연결된 스냅샷만 화면에 출력된다.
5896279 v0.2
8dd76bf v0.1
5d8d97b (origin/master, origin/HEAD) Initial commit
```

```
예5) test06.txt를 만들어 master 브랜치에 추가하고 커밋 내력 확인하기
    test06.txt 파일을 만들었다고 가정하자!
$ git add test06.txt
$ git commit -m 'v0.6'
$ git log --oneline
6f4725e (HEAD -> master) v0.6
f559e21 v0.3
5896279 v0.2
8dd76bf v0.1
5d8d97b (origin/master, origin/HEAD) Initial commit
```

```
예6) 현재 HEAD가 가리키는 브랜치의 역사 뿐만 아니라 다른 브랜치의 역사까지 출력하기
$ git log --oneline --graph --all
* 6f4725e (HEAD -> master) v0.6
| * 34fda9c (b1) v0.5
| * 9cf510e v0.4
|/  
* f559e21 v0.3
* 5896279 v0.2
* 8dd76bf v0.1
* 5d8d97b (origin/master, origin/HEAD) Initial commit
```

```
예7) 체크아웃 할 때 자동으로 새 브랜치를 만들기
    'git branch' + 'git checkout' = git checkout -b [새 브랜치 이름] 
$ git checkout -b b2
$ git log --oneline --all --graph
* 6f4725e (HEAD -> b2, master) v0.6
| * 34fda9c (b1) v0.5
| * 9cf510e v0.4
|/  
* f559e21 v0.3
* 5896279 v0.2
* 8dd76bf v0.1
* 5d8d97b (origin/master, origin/HEAD) Initial commit
```

```
예8) 새로 만든 b2 브랜치에 test07.txt 파일을 추가하고 커밋하기
$ git add test07.txt
$ git commit -m 'v0.7'
$ git log --oneline --all --graph
* 33c8c8d (HEAD -> b2) v0.7
* 6f4725e (master) v0.6
| * 34fda9c (b1) v0.5
| * 9cf510e v0.4
|/  
* f559e21 v0.3
* 5896279 v0.2
* 8dd76bf v0.1
* 5d8d97b (origin/master, origin/HEAD) Initial commit
```

### git merge [브랜치 이름]

- 현재 브랜치의 커밋에 다른 브랜치의 커밋 내용을 합친다.

```
예1) 합치려는 브랜치가 현 브랜치 보다 Upstream(이후 버전)일 경우,
    별도의 merge 과정이 필요없고, 해당 브랜치의 최신 버전의 커밋으로 이동한다.
    이런 merge 방식을 'fast forward'라 부른다.
$ git checkout master
$ git merge b2
$ git log --oneline --all --graph
* 33c8c8d (HEAD -> master, b2) v0.7   <=== master가 b2가 가리키는 커밋으로 이동한다.
* 6f4725e v0.6
| * 34fda9c (b1) v0.5
| * 9cf510e v0.4
|/  
* f559e21 v0.3
* 5896279 v0.2
* 8dd76bf v0.1
* 5d8d97b (origin/master, origin/HEAD) Initial commit
```

```
예2) 더 이상 필요없는 b2 브랜치를 삭제하기
$ git branch -d b2
$ git log --oneline --all --graph
* 33c8c8d (HEAD -> master) v0.7
* 6f4725e v0.6
| * 34fda9c (b1) v0.5
| * 9cf510e v0.4
|/  
* f559e21 v0.3
* 5896279 v0.2
* 8dd76bf v0.1
* 5d8d97b (origin/master, origin/HEAD) Initial commit
[~/git/git-test]$ 
```

```
예3) master 브랜치에 b1 브랜치 커밋 내용을 합치기
$ git checkout master     <=== 현재 브랜치가 master가 아니라면 이 명령을 수행한다.
$ git merge b1
$ git log --oneline --all --graph
*   58489d3 (HEAD -> master) v0.8    <=== master 브랜치에 b1 브랜치를 합친 새 커밋이 생성된다.
|\  
| * 34fda9c (b1) v0.5
| * 9cf510e v0.4
* | 33c8c8d v0.7
* | 6f4725e v0.6
|/  
* f559e21 v0.3
* 5896279 v0.2
* 8dd76bf v0.1
* 5d8d97b (origin/master, origin/HEAD) Initial commit

더 이상 필요없는 b1 브랜치를 삭제하기
$ git branch -d b1
[~/git/git-test]$ git log --oneline --all --graph
*   58489d3 (HEAD -> master) v0.8
|\  
| * 34fda9c v0.5
| * 9cf510e v0.4
* | 33c8c8d v0.7
* | 6f4725e v0.6
|/  
* f559e21 v0.3
* 5896279 v0.2
* 8dd76bf v0.1
* 5d8d97b (origin/master, origin/HEAD) Initial commit
```














끝
