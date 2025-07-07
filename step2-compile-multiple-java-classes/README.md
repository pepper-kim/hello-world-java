Step 2 - compile multiple java code

### 1. 빌드 파일 저장할 디렉토리 생성
mkdir -P build/classes

### 2. 컴파일 진행
javac -d build/classes $(find ./src/main/java -name "*.java")

### 3. 바이트 코드 실행
java -cp build/classes main.java.HelloWorldApp

✅ 명심 : Java는 클래스패스 루트부터 패키지 디렉토리의 구조가 일치 해야 함.
