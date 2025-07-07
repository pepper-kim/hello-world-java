package main.java;

import main.java.model.Person;
import main.java.model.JsonProcessor;

public class JsonApp {
  public static void main(String[] args) {
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