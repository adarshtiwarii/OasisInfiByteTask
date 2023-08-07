import java.util.Scanner;

  class User {
      String username;
      String password;
      String name;
      String email;
  
      // Constructor
      public User(String username, String password, String name, String email) {
          this.username = username;
          this.password = password;
          this.name = name;
          this.email = email;
      }
  }
  
  class Question {
      String question;
      String[] options;
      int correctAnswer;
  
      public Question(String question, String[] options, int correctAnswer) {
          this.question = question;
          this.options = options;
          this.correctAnswer = correctAnswer;
      }
  }
  
  public class online {
      public static void main(String[] args) {
          
          User[] users = {
              new User("adarshtwari", "tiwari123", "Adarsh", "adarsht072@gmail.com"),
             new User("Ramtwari", "tiwari123", "Ram", "ramt072@gmail.com"),
          };
  
          
          Question[] questions = {
              new Question("What is the capital of Inadia?", 
                           new String[]{"A) New Delhi", "B) Paris", "C) Berlin", "D) Rome"}, 
                           1),
              new Question("Which planet is known as the Red Planet?", 
                           new String[]{"A) Venus", "B) Mars", "C) Jupiter", "D) Saturn"}, 
                           1)
          };
  
        
          User currentUser = login(users);
      
          updateProfile(currentUser);
  
          takeExam(questions);
  
          logout();
      }
  

      public static User login(User[] users) {
          Scanner scanner = new Scanner(System.in);
          System.out.print("Enter your username: ");
          String username = scanner.nextLine();
          System.out.print("Enter your password: ");
          String password = scanner.nextLine();
  
          for (User user : users) {
              if (user.username.equals(username) && user.password.equals(password)) {
                  System.out.println("Login successful!");
                  return user;
              }
          }
  
          System.out.println("Login failed. Invalid username or password.");
          return null;
      }
  
      public static void updateProfile(User user) {
          Scanner scanner = new Scanner(System.in);
          System.out.println("Update Profile Information:");
          System.out.print("Name: ");
          user.name = scanner.nextLine();
          System.out.print("Email: ");
          user.email = scanner.nextLine();
          System.out.print("New Password: ");
          user.password = scanner.nextLine();
          System.out.println("Profile updated successfully!");
      }
  
      public static void takeExam(Question[] questions) {
          Scanner scanner = new Scanner(System.in);
          int score = 0;
  
          System.out.println("Start Exam:");
          for (int i = 0; i < questions.length; i++) {
              System.out.println("Question " + (i + 1) + ": " + questions[i].question);
              for (String option : questions[i].options) {
                  System.out.println(option);
              }
              System.out.print("Enter your answer (A, B, C, D): ");
              String answer = scanner.nextLine().toUpperCase();
  
              int selectedOption = -1;
              switch (answer) {
                  case "A":
                      selectedOption = 0;
                      break;
                  case "B":
                      selectedOption = 1;
                      break;
                  case "C":
                      selectedOption = 2;
                      break;
                  case "D":
                      selectedOption = 3;
                      break;
                  default:
                      break;
              }
  
              if (selectedOption == questions[i].correctAnswer) {
                  score++;
              }
          }
  
          System.out.println("Exam completed. Your score: " + score + "/" + questions.length);
      }
  
      public static void logout() {
          System.out.println("Logged out successfully.");
      }
  }
  
  

