import java.util.ArrayList;
import java.util.Random;

class GetSmartLock {
  public static void main(String[] args) {
    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String> answers = new ArrayList<>();

    storeInformation("what is my name?", questions);
    storeInformation("what date is it?", questions);
    storeInformation("what grade did you learn cs?", questions);

    storeInformation("derek", answers);
    storeInformation("saturday", answers);
    storeInformation("college", answers);

    int count = questions.size();
    System.out.println("Count: " + count);

    for(int i=0; i < questions.size(); i++) {
      String info = getInformation(i, questions);
      int index = getIndexOfInformation(info, questions);
      System.out.println(String.format("%d : %s", index, info));
    }

    for(int i=0; i < answers.size(); i++) {
      String info = getInformation(i, answers);
      int index = getIndexOfInformation(info, answers);
      System.out.println(String.format("%d : %s", index, info));
    }

    int index = getIndexOfInformation("what is my name?", questions);
    String getQuestion = getInformation(index, questions);   
    String getAnswer = getInformation(index, answers);
    System.out.println(String.format("%s : %s", getQuestion, getAnswer));

    System.out.println("testing random: " + getRandomIndexList(questions));

  }

  private static int getRandomIndexList(ArrayList<String> list) {
    Random randomObj = new Random();
    int randomIndex = 0;
    int listSize = list.size();

    if (listSize < 1) {
      //TODO : throw exception or handle this case somehow.      
    }

    randomIndex = randomObj.nextInt(listSize);
    return randomIndex;
  }

  private static void storeInformation(String info, ArrayList<String> storeToList) {
    storeToList.add(info);  
  }

  private static String getInformation(int index, ArrayList<String> getFromList) {
    return getFromList.get(index);
  }

  private static int getIndexOfInformation(String info, ArrayList<String> getFromList) {
    return getFromList.indexOf(info);
  }
}
