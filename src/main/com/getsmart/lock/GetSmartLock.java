package main.com.getsmart.lock;

import java.util.ArrayList;
import java.util.Random;

public class GetSmartLock {
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

    try {
      int randomInt = getRandomIndexList(questions); 
      System.out.println("testing random: " + randomInt);
    } catch (Exception e) {

    }

  }

  /**
   * Gets a random index from the provided list. 
   *
   * @param list The list to get a random index number from based on its size
   * @throws Exception If the list size is < 1
   */
  public static int getRandomIndexList(ArrayList<String> list) throws Exception {
    Random randomObj = new Random();
    int randomIndex = 0;
    int listSize = list.size();

    if (listSize < 1) {
      throw new Exception("List has size < 1 and can't get information");
    }

    randomIndex = randomObj.nextInt(listSize);
    return randomIndex;
  }

  /**
   * Stores the given information into the provided list.
   */
  public static void storeInformation(String info, ArrayList<String> storeToList) {
    storeToList.add(info);  
  }

  /**
   * Gets information from the provided list based on the index provided.
   */
  public static String getInformation(int index, ArrayList<String> getFromList) {
    return getFromList.get(index);
  }

  /**
   * Gets the index of the info provided. If no info is found a -1 is returned.
   */
  public static int getIndexOfInformation(String info, ArrayList<String> getFromList) {
    return getFromList.indexOf(info);
  }
}
