# Inventory Management System

## 개요
이 프로젝트는 재고 관리 시스템입니다. 사용자는 재고를 추가, 수정, 삭제하고, 재고 내역을 조회할 수 있습니다.

## 주요 기능
- 재고 CRUD 기능
- 재고 검색 및 필터링 기능
- RESTful API 제공

## 기술 스택
- **언어**: Java
- **프레임워크**: Spring Boot
- **데이터베이스**: MariaDB
- **JPA**: Hibernate
- **메시징 시스템**: Apache Kafka
- **캐싱**: Redis
- **빌드 도구**: Maven
- **버전 관리**: Git
- **CI/CD**: Jenkins, GitHub Actions
- **아티팩트 관리**: Nexus

## 역할 및 기여도
- 전체 시스템 설계 및 아키텍처 구성
- RESTful API 설계 및 구현
- CI/CD 파이프라인 구성 및 자동화 배포 설정

## Completed Tasks
- 기술 스택 인프라 구축 및 설정 완료
    - Java
    - Spring Boot
    - MariaDB
    - Hibernate (JPA)
    - Kafka
    - Redis
    - Maven
    - Git
    - Jenkins, GitHub Actions (CI/CD)
    - Nexus
- Docker를 이용한 컨테이너화
- Swagger를 이용한 API 문서화

## To-Do List
- [ ] 재고 CRUD 기능 및 검색 필터링 기능
- [ ] 사용자 활동 로그 기능 추가
- [ ] 사용자 인증 및 권한 관리
- [ ] Nexus를 활용한 모듈화
- [ ] 코드 리팩토링 및 테스트 커버리지 향상
    - [ ] 핵심 비즈니스 로직에 대한 유닛 테스트 작성
    - [ ] 모든 서비스 클래스에 대한 유닛 테스트 추가
    - [ ] 컨트롤러 레이어에 대한 유닛 테스트 작성
    - [ ] 주요 기능 흐름에 대한 통합 테스트 작성