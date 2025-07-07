Step 4 - Gradle로 빌드하기

이 단계에서는 Gradle 빌드 도구를 사용하여 step3의 모든 복잡함을 간단하게 해결하는 방법을 학습합니다.
Gradle이 어떻게 의존성 관리, 컴파일, 실행을 자동화하는지 확인할 수 있습니다.

## 🎯 Step 3 vs Step 4 비교

### Step 3 (수동 관리)의 문제점들:
- 🔴 Jackson JAR 파일 3개를 수동으로 다운로드
- 🔴 복잡한 컴파일 명령어: `javac -cp "lib/*" -d build/classes $(find ./src/main/java -name "*.java")`
- 🔴 복잡한 실행 명령어: `java -cp "build/classes:lib/*" main.java.JsonApp`
- 🔴 완전한 클래스명(FQCN) 기억 필요
- 🔴 의존성 버전 호환성을 수동으로 확인
- 🔴 프로젝트 공유 시 다른 개발자가 동일 환경 구성 어려움

### Step 4 (Gradle)의 해결책:
- ✅ 의존성을 `build.gradle`에 선언만 하면 자동 다운로드
- ✅ 간단한 컴파일: `./gradlew build`
- ✅ 간단한 실행: `./gradlew run`
- ✅ 메인 클래스 자동 실행
- ✅ 의존성 버전 충돌 자동 해결
- ✅ 프로젝트 공유 시 `./gradlew build`만 실행하면 끝

## 📁 Gradle 표준 프로젝트 구조

```
step4-build-with-gradle/
├── build.gradle          # 빌드 설정 파일
├── settings.gradle       # 프로젝트 설정
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew              # Unix/Linux/macOS용 래퍼 스크립트
├── gradlew.bat          # Windows용 래퍼 스크립트
└── src/
    └── main/
        └── java/
            ├── JsonApp.java
            └── model/
                ├── Person.java
                └── JsonProcessor.java
```

## 🚀 Gradle 사용법

### 1. Gradle Wrapper 초기화 (이미 완료됨)
```bash
# 최초 1회만 실행 (이미 설정되어 있음)
gradle wrapper
```


### 2. 의존성 자동 다운로드 및 컴파일
```bash
# 의존성 다운로드 + 컴파일 + 테스트 (한 번에 모든 것)
./gradlew build
```

### 3. 애플리케이션 실행
```bash
# 메인 클래스 자동 실행
./gradlew run
```

### 4. 클린 빌드
```bash
# build 디렉터리 정리 후 다시 빌드
./gradlew clean build
```

### 5. 의존성 확인
```bash
# 프로젝트에서 사용하는 모든 의존성 확인
./gradlew dependencies
```

## 🔧 핵심 파일들

### build.gradle
- 프로젝트 설정, 의존성, 플러그인 정의
- Maven Central에서 자동으로 라이브러리 다운로드
- 컴파일, 테스트, 실행 등 모든 빌드 프로세스 자동화

### Gradle Wrapper (gradlew)
- 프로젝트에 특정 Gradle 버전을 고정
- 다른 개발자가 Gradle을 별도 설치하지 않아도 됨
- `./gradlew` 명령어로 일관된 빌드 환경 보장

## 🎉 Step 3 → Step 4 변화 요약

| 작업 | Step 3 (수동) | Step 4 (Gradle) |
|------|---------------|-----------------|
| 의존성 다운로드 | 수동으로 3개 JAR 다운로드 | `build.gradle`에 선언만 |
| 컴파일 | `javac -cp "lib/*" -d build/classes $(find ...)` | `./gradlew build` |
| 실행 | `java -cp "build/classes:lib/*" main.java.JsonApp` | `./gradlew run` |
| 프로젝트 공유 | 복잡한 환경 설정 필요 | `./gradlew build` 한 번만 |
| 의존성 관리 | 수동 버전 확인 | 자동 충돌 해결 |

## 🔍 학습 포인트

1. **빌드 도구의 필요성**: 복잡한 수동 작업을 자동화
2. **표준화**: 모든 Java 프로젝트가 비슷한 구조와 명령어 사용
3. **의존성 관리**: Maven Central Repository 활용한 자동 다운로드
4. **재현 가능한 빌드**: Gradle Wrapper로 환경 통일
5. **생산성 향상**: 개발자가 코드에만 집중 가능

다음으로 실제 Gradle 프로젝트를 실행해보면서 이 모든 장점들을 직접 체험해보겠습니다! 🚀