# Gradle User Guide

## Gradle 파일 및 환경 정보

- 스크립트 파일
    - 초기화 스크립트(init.gradle)
        - 사용자 정보, 실행환경, 초기 선언 값 등 초기 설정 정보를 기술.
        - Gradle 객체가 이 스크립트 파일의 설정 정보를 사용한다.
    - 설정 스크립트(settings.gradle)
        - 빌드 대상이 되는 프로젝트 정의.
        - 이 파일이 존재하면 multiple 프로젝트로 취급하고 없으면 single 프로젝트로 취급한다.
        - Settings 객체가 이 스크립트 파일의 설정 정보를 사용한다.
    - 빌드 스크립트(build.gradle)
        - 빌드 수행과 관련된 의존 관계 정의, 태스크 정의.
        - 이 스크립트를 실행할 때 settings.gradle과 init.gradle의 설정 정보를 참조한다.
        - Project 객체가 이 스크립트 파일의 설정 정보를 사용한다.
- gradle.properties 속성 파일
    - 빌드를 실행할 때 참조하는 파일이다.
    - 빌드 스크립트에 기술하지 않은 빌드 환경과 관련된 정보를 기술한다.
- 환경 변수
    - Gradle을 설치할 때 시스템에 등록된 내용이다.
- 명령어 옵션
    - Gradle 실행할 때 넘겨 주는 값이다.
    - 사용법: `$ gradle -P이름=값 [태스크]`
    - 예: `$ gradle -Pname=Hong hello`
- buildSrc
    - 빌드를 실행할 때 참조하는 클래스나 플러그인이 들어 이는 디렉토리이다.
    - 빌드 스크립트들이 공통으로 참조하는 내용을 모아 둔다.

## Gradle 빌드 수행 단계

Gradle은 빌드를 수행할 때 다음과 같이 6단계로 진행된다.

```
다음 명령을 실행한다면,
$ gradle -Pname=HongKilDong hello
```

- 명령어 해석 및 수행
    - 명령어 옵션이나 아규먼트 유효성 확인
- Gradle 실행
    - 프로젝트 및 프로젝트의 루트 디렉토리 확인
    - 관련 속성 파일을 참조
    - 명령어 옵션을 통해 실행 모드를 판단
        - GUI 모드 : --gui 옵션이 있다면
        - daemon 모드 : --daemon 옵션이 있다면
        - CLI 모드 : 실행 모드 옵션이 없다면
    - 명령어를 실행
- 스크립트 초기화
    - 스크립트 파일 확인 및 읽기
    - 도메인 객체 생성
    - settings.gradle 유무에 따라 멀티 및 싱글 프로젝트 여부 판단
    - Project 객체 생성
    - 명령어에 있는 옵션 및 아규먼트를 설정
- 프로젝트 설정 
    - 프로젝트에서 참조하는 라이브러리 확인
    - Task 객체 생성
    - 태스크 그래프 생성
        - 빌드를 수행하기 위해 정의된 태스크 확인
        - 태스크들 사이의 의존 관계 확인
        - 실행 순서를 정의하는 **태스크 실행 그래프** 생성
- 태스크 실행
    - 태스크 실행 그래프를 따라가며 태스크 추출 및 실행 
- 결과 출력
    - 빌드 수행과 관련된 결과 및 결과와 관련된 정보 출력

## Gradle 도메인 객체

### Project 객체

- 생명주기
    - 빌드를 수행하기 위한 Settings 객체 생성
    - settings.gradle 스크립트에 따라 Settings 객체 설정
    - Settings 정보에 따라 Project 객체의 계층 구조 생성
        - 부모 Project 객체부터 생성한 다음 자식 Project 객체를 생성
- 관련 객체
    - TaskContainer
        - 클래스 컴파일, 단위 테스트 실행, WAR 배포 파일 생성 등을 수행하여 프로젝트에 추가
        - 태스크를 생성, 조회 등 관리
    - ConfigurationContainer
        - 프로젝트 구성을 관리
    - DependencyHandler
        - 의존 관계를 관리
    - ArtifactHandler
        - 프로젝트를 결과물을 관리
    - RepositoryHandler
        - 프로젝트 저장 공간을 관리
    - Gradle
        - Gradle 정보 참조
- 주요 속성
    - version - 프로젝트나 결과물의 버전
    - description - 프로젝트 설정
    - name - 프로젝트 이름 
    - state - 프로젝트 빌드 상태
    - status - 프로젝트 결과물의 상태
    - path - 프로젝트 path(':'으로 경로 구분). 예) pms:web
    - projectDir - 프로젝트 기준 디렉토리
    - group - 프로젝트가 속한 그룹
    - buildDir - 프로젝트 빌드 디렉토리(기본값: projectDir/build)
    - plugins - Project 객체에 적용된 플러그인의 컨테이너
    - project - 현재 프로젝트 레퍼런스
    - rootProject - 루트 프로젝트 레퍼런스
    - parent - 상위 프로젝트 레퍼런스
    - childProjects - 바로 밑 하위 프로젝트 레퍼런스들(Map 타입). 하위의 하위 프로젝트들은 포함하지 않음.
    - allprojects - 현재 프로젝트 및 모든 하위 프로젝트 레퍼런스(Map 타입)
    - subprojects - 현재 프로젝트를 제외한 하위 프로젝트 레퍼런스(Map 타입)

### single-project

```
프로젝트 디렉토리 구조
projectDir/ 
    |--- gradle.properties
    |--- build.gradle
```

### multi-project

```
프로젝트 디렉토리 구조
projectDir/ 
    |--- settings.gradle
    |--- build.gradle
    |--- Child Project
            |--- Grandchild Project
```

## Gradle 명령

### 사용 가능한 태스크 조회하기

```
$ gradle tasks --all
```

### 태스크 실행할 때 프로퍼티 설정하기

```
$ gradle -Pname=value 태스크명
```

### 태스크 실행할 때 시스템 속성 설정하기

```
$ gradle -Dname=value 태스크명
```


