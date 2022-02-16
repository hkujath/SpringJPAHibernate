package de.hkujath.springjpahibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "de.hkujath.springjpahibernate")
public class MainApp {

   public static void main(String[] args) {
      SpringApplication.run(MainApp.class, args);
   }

}
