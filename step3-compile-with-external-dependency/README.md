Step 3 - 외부 의존성과 함께 컴파일

이 단계에서는 외부 라이브러리(Jackson JSON)을 사용하여 Java 프로젝트를 컴파일하고 실행하는 방법을 학습합니다.
수동으로 의존성을 관리하는 과정을 통해 빌드 도구의 필요성을 이해할 수 있습니다.

### 1. 프로젝트 구조 생성
```
step3-compile-with-external-dependency/
├── src/
│   └── main/
│       └── java/
│           ├── JsonApp.java
│           └── model/
│               ├── Person.java
│               └── JsonProcessor.java
├── lib/
│   ├── jackson-core-2.15.2.jar
│   ├── jackson-databind-2.15.2.jar
│   └── jackson-annotations-2.15.2.jar
└── build/
    └── classes/
```

### 2. 외부 의존성 다운로드
Jackson 라이브러리를 수동으로 다운로드해야 합니다:

⚠️ **주의**: 라이브러리를 다운로드하기 전까지는 IDE에서 import 오류가 표시됩니다. 이는 정상적인 현상입니다.

```bash
# lib 디렉터리 생성
mkdir -p lib

# Jackson 라이브러리 다운로드 (Maven Central에서)
curl -o lib/jackson-core-2.15.2.jar https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.15.2/jackson-core-2.15.2.jar
curl -o lib/jackson-databind-2.15.2.jar https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.15.2/jackson-databind-2.15.2.jar
curl -o lib/jackson-annotations-2.15.2.jar https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.15.2/jackson-annotations-2.15.2.jar
```

### 3. 빌드 디렉터리 생성
```bash
mkdir -p build/classes
```

### 4. 외부 의존성과 함께 컴파일
```bash
# 클래스패스에 외부 라이브러리 포함하여 컴파일
javac -cp "lib/*" -d build/classes $(find ./src/main/java -name "*.java")
```
- 컴파일러가 소스코드를 이해하고 .class 파일을 생성하기 위해 -cp에 "lib/*"를 설정함.
- import 문 해석하고 타입 체킹을 진행.
- 🚨 외부 라이브러리 코드는 포함되지 않음!

### 5. 외부 의존성과 함께 실행
```bash
# 클래스패스에 빌드된 클래스와 외부 라이브러리 모두 포함
# 주의: 패키지명을 포함한 완전한 클래스명 사용
java -cp "build/classes:lib/*" main.java.JsonApp
```
- `:`는 경로 구분자. 클래스패스 경로들을 구분함.
- `-cp`를 이용하여 클래스 패스에 있는 컴파일 및 빌드 결과물들을 포함시킴. 

⚠️ **주의**: `JsonApp`이 아닌 `main.java.JsonApp`으로 실행해야 합니다. Java는 패키지가 있는 클래스를 실행할 때 완전한 클래스명(FQCN)이 필요합니다.

### 6. 문제점 인식
- 🔴 **의존성 수동 관리**: 각 JAR 파일을 개별적으로 다운로드
- 🔴 **버전 관리 어려움**: 라이브러리 간 호환성 확인 필요
- 🔴 **복잡한 클래스패스**: 컴파일과 실행 시 모든 의존성 명시
- 🔴 **완전한 클래스명 필요**: `main.java.JsonApp` 같은 클래스 명을 기억해야 함
- 🔴 **의존성 전이**: Jackson이 의존하는 다른 라이브러리들도 수동 관리
- 🔴 **프로젝트 공유 어려움**: 다른 개발자가 동일한 환경 구성하기 복잡

### 7. 다음 단계 (Step 4)
Step 4에서는 Gradle을 사용하여 이러한 문제들이 어떻게 해결되는지 확인할 예정입니다.