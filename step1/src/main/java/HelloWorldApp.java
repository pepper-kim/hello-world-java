package main.java;

import main.java.model.Greeting;

public class HelloWorldApp {
  public static void main(String[] args) {
    Greeting greeting = new Greeting();
    greeting.sayHello();
    greeting.sayGoodbye();
  }
}