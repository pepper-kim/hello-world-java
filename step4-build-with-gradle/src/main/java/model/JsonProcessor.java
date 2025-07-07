package model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public class JsonProcessor {
  private ObjectMapper objectMapper;

  public JsonProcessor() {
    this.objectMapper = new ObjectMapper();
  }

  /**
   * Person 객체를 JSON 문자열로 변환
   */
  public String personToJson(Person person) {
    try {
      return objectMapper.writeValueAsString(person);
    } catch (JsonProcessingException e) {
      System.err.println("JSON 변환 중 오류 발생: " + e.getMessage());
      return null;
    }
  }

  /**
   * JSON 문자열을 Person 객체로 변환
   */
  public Person jsonToPerson(String json) {
    try {
      return objectMapper.readValue(json, Person.class);
    } catch (IOException e) {
      System.err.println("JSON 파싱 중 오류 발생: " + e.getMessage());
      return null;
    }
  }

  /**
   * JSON 문자열을 예쁘게 포맷팅
   */
  public String formatJson(String json) {
    try {
      Object jsonObject = objectMapper.readValue(json, Object.class);
      return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
    } catch (IOException e) {
      System.err.println("JSON 포맷팅 중 오류 발생: " + e.getMessage());
      return json;
    }
  }
}