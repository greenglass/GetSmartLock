package main.com.getsmart.lock.blo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import main.com.getsmart.lock.dto.InformationDTO;

/**
 * The logic that will handle operations on the InformationDTO. Since the DTO is used for
 * holding the data and retreiving the data this class handles manipulating the data.
 */
public class InformationBLO implements BusinessLogic {

  //Arrays are mimicing a database for the time being
  private String[] questionsArray = {"what is my name?", "what date is it?", "what grade did you learn cs?"};
  private String[] answersArray = {"derek", "saturday", "college"};
  private ArrayList<String> questions = new ArrayList<>(Arrays.asList(questionsArray));
  private ArrayList<String> answers = new ArrayList<>(Arrays.asList(answersArray));
  private static InformationDTO appInfo;
  private Scanner userInputReader;

  /**
   *  Public empty contructor.
   */
  public InformationBLO() {
    appInfo = new InformationDTO();
  }

  /**
   * Public constructor that will set the InformationDTO with the provided one.
   */
  public InformationBLO(InformationDTO info) {
    appInfo = info;
  }

  /**
   * Populates the InformationDTO with a random index, the corresponding answer and questions
   * already defined in the databse.
   */
  public InformationDTO populateInformationDTO() {
    int randomIndex = -1;
    try {
      randomIndex = getRandomIndexList(questions);
    } catch (Exception e) {
      //TODO : Exception handling
    }
    appInfo.setIndex(randomIndex);
    appInfo.setQuestion(getInformation(randomIndex, questions));
    appInfo.setAnswer(getInformation(randomIndex, answers));

    return appInfo;
  }

  /**
   * Gets a random index from the provided list. 
   *
   * @param list The list to get a random index number from based on its size
   * @throws Exception If the list size is < 1
   */
  public int getRandomIndexList(ArrayList<String> list) throws Exception {
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
   *
   */
  public InformationDTO getInformationDTO() {
    return appInfo;
  }

  /**
   * Update the InformationDTO with the provided DTO. Assuming this new DTO
   * has some new or updated information.
   */
  public void updateInformationDTO(InformationDTO updatedInfo) {
    appInfo = updatedInfo;
  }

  /**
   * Stores the given information into the provided list.
   */
  public void storeInformation(String info, ArrayList<String> storeToList) {
    storeToList.add(info);  
  }

  /**
   * Gets information from the provided list based on the index provided.
   */
  public String getInformation(int index, ArrayList<String> getFromList) {
    return getFromList.get(index);
  }

  /**
   * Check to see if the user answer and the stored answer match for a correct answer.
   */
  public boolean checkAnswer() {
    boolean correctAnswer = false;

    correctAnswer = appInfo.getAnswer().equals(appInfo.getUserAnswer());

    return correctAnswer;
  }

  /**
   *
   */
  @Override
    public boolean promptForAnswer() {
      System.out.println(appInfo.getQuestion());
      userInputReader = new Scanner(System.in);
      String userAnswer = userInputReader.nextLine();
      userInputReader.reset();
      appInfo.setUserAnswer(userAnswer);
      return checkAnswer();
    }

  /**
   *
   */
  public void closeInputScanner() {
    userInputReader.close();
  }
}
