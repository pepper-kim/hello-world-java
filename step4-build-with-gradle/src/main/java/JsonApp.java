import model.Person;
import model.JsonProcessor;

public class JsonApp {
  public static void main(String[] args) {
    System.out.println("=== 🚀 Step 4: Gradle로 빌드하기 ===");
    System.out.println("Step 3의 모든 복잡함이 Gradle로 간단해졌습니다!\n");

    // JsonProcessor 인스턴스 생성
    JsonProcessor jsonProcessor = new JsonProcessor();

    // 1. Person 객체 생성
    Person person = new Person("김철수", 30, "kim@example.com");

    System.out.println("1. 생성된 Person 객체들:");
    System.out.println("  " + person);
    System.out.println();

    // 2. Person 객체를 JSON으로 변환
    String json = jsonProcessor.personToJson(person);

    System.out.println("2. Person 객체를 JSON으로 변환:");
    System.out.println("  김철수 JSON: " + json);
    System.out.println();
  }
}