import java.util.ArrayList;

class GetSmartLock {
  public static void main(String[] args) {
    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String> answers = new ArrayList<>();

    questions.add("what is my name?");
    questions.add("what date is it?");
    questions.add("what grade did you learn cs?");

    answers.add("derek");
    answers.add("saturday");
    answers.add("college");

    int count = questions.size();
    System.out.println("Count: " + count);
  }
}
