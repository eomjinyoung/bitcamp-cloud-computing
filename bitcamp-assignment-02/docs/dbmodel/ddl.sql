-- 회원
DROP TABLE IF EXISTS P2_MEMB RESTRICT;

-- 명함
DROP TABLE IF EXISTS P2_BIZCARD RESTRICT;

-- 회원
CREATE TABLE P2_MEMB (
    MNO   INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
    EMAIL VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
    NAME  VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
    PWD   VARCHAR(100) NOT NULL COMMENT '암호' -- 암호
)
COMMENT '회원';

-- 회원
ALTER TABLE P2_MEMB
    ADD CONSTRAINT PK_P2_MEMB -- 회원 기본키
        PRIMARY KEY (
            MNO -- 회원번호
        );

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX UIX_P2_MEMB
    ON P2_MEMB ( -- 회원
        EMAIL ASC -- 이메일
    );

ALTER TABLE P2_MEMB
    MODIFY COLUMN MNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 명함
CREATE TABLE P2_BIZCARD (
    BCNO  INTEGER     NOT NULL COMMENT '명함번호', -- 명함번호
    MNO   INTEGER     NOT NULL COMMENT '회원번호', -- 회원번호
    NAME  VARCHAR(50) NOT NULL COMMENT '이름', -- 이름
    MTEL  VARCHAR(30) NULL     COMMENT '휴대전화', -- 휴대전화
    TEL   VARCHAR(30) NULL     COMMENT '일반전화', -- 일반전화
    FAX   VARCHAR(30) NULL     COMMENT '팩스', -- 팩스
    EMAIL VARCHAR(40) NULL     COMMENT '이메일', -- 이메일
    MEMO  TEXT        NULL     COMMENT '메모' -- 메모
)
COMMENT '명함';

-- 명함
ALTER TABLE P2_BIZCARD
    ADD CONSTRAINT PK_P2_BIZCARD -- 명함 기본키
        PRIMARY KEY (
            BCNO -- 명함번호
        );

-- 명함 인덱스
CREATE INDEX IX_P2_BIZCARD
    ON P2_BIZCARD( -- 명함
        NAME ASC -- 이름
    );

ALTER TABLE P2_BIZCARD
    MODIFY COLUMN BCNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '명함번호';

-- 명함
ALTER TABLE P2_BIZCARD
    ADD CONSTRAINT FK_P2_MEMB_TO_P2_BIZCARD -- 회원 -> 명함
        FOREIGN KEY (
            MNO -- 회원번호
        )
        REFERENCES P2_MEMB ( -- 회원
            MNO -- 회원번호
        );