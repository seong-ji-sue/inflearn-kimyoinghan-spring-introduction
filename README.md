
# 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술

- [강의 링크](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard)
- [노션 정리 페이지](https://www.notion.so/MVC-DB-f51deea0c6f042349dd65b588cc05050)

<aside>
📢 해당 강의는 코드에 대한 자세한 설명보다는 스프링의 전체적인 흐름만 짚어주는 강의 입니다.

</aside>

<aside>
📢 자바를 완벽하게 이해 했다는 가정하에 들으시면 좋습니다.
Optional, List, Interface 등 내용이 나옵니다.

</aside>

## Summary

1. **프로젝트 생성 및 빌드**
2. **스프링 컨텐츠 종류 및 동작 방식**
3. **데이터 객체(domain), Repository, Service, Controller 및 테스트 케이스**
4. **DI 의존성 주입**
5. **DB 연결 및 JDBC Template, JPA**

---

## 프로젝트 생성 및 빌드

### 알게된 것

1. 스프링 프로젝트를 생성하고 실행해서 웹 브라이우저에 Error 페이지를 띄울수 있음

### 정리

[스프링 프로젝트 생성 및 빌드](https://www.notion.so/6f5b607513fd4a35a48558959b792388)

---
## 스프링 컨텐츠 종류 및 동작 방식

### 알게된것

1. 웹 브라우저에 검색했을 때 스프링이 동작하는 방식
2. 각 폴더와 파일의 역할과 우선 순위
3. Json 데이터로 전달, 파일만 웹 브라우저에 전달 하는 방법

### 정리

[스프링 컨텐츠 종류 및 동작 방식](https://www.notion.so/171ffa6ccb4d42c889c126a2b2820e2b)

---
## 데이터 객체(domain), Repository, Service, Controller 및 테스트 케이스

<aside>
📢 데이터 베이스 없는 상태에서 개발을 진행 하였습니다.

</aside>

### 알게된것

1. domain, repository, service, controller 의 역할
2. 테스트 케이스를 작성하는 이유와 방법, 각각의 상황대로 단위하는 방법
3. 일반적으로 MVC 방식으로 회원 관리 메뉴를 작성

### 정리

[데이터 객체(domain), Repository, Service, Controller 및 테스트 케이스](https://www.notion.so/domain-Repository-Service-Controller-c744a64ec3834b93b9017fa0c1bc3466)
\
---
## DI 의존성 주입

### 알게된것

1. 의존성 주입  의 종류(생성자, setter, 필드), 역할, 좋은점
2. 의존관계 설정하는 방법(컴포넌트 스캔, 수동으로 빈 등록)
3. 어노테이션 모르는 것

### 정리

[DI, 의존성 주입](https://www.notion.so/DI-b7419e125d324f608b4365bd81888844)

---
## DB 연결 및 JDBC Template, JPA

### 알게된것

1. H2 데이터 베이스를 설치 및 테이블 생성
2. 20년 전에 썼던 JDBC 연결 방법
3. 중복코드 제거한 JDBC 방법
4. JPA와 데이터 JPA

### 정리

[DB 연결 및 JDBC Template, JPA ](https://www.notion.so/DB-JDBC-Template-JPA-59792b94ee7a48d4ab0143f9262fc32d)

