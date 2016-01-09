package com.getsmart.lock.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.getsmart.lock.dto.InformationDTO;

public class QuestionProvider {

  private InformationDTO infoData;
  //Arrays are mimicing a database for the time being
  private String[] questionsArray = {"what is my name?", "what date is it?", "what grade did you learn cs?"};
  private String[] answersArray = {"derek", "saturday", "college"};
  private ArrayList<String> questions = new ArrayList<>(Arrays.asList(questionsArray));
  private ArrayList<String> answers = new ArrayList<>(Arrays.asList(answersArray));

  public QuestionProvider() {
    this(new InformationDTO());
  }

  public QuestionProvider(InformationDTO info) {
    this.infoData = info;
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
    infoData.setIndex(randomIndex);
    infoData.setQuestion(getInformation(randomIndex, questions));
    infoData.setAnswer(getInformation(randomIndex, answers));

    return infoData;
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
   * Gets information from the provided list based on the index provided.
   */
  public String getInformation(int index, ArrayList<String> getFromList) {
    return getFromList.get(index);
  }

  /**
   * Ask the user the question.
   */
  public void provideQuestion() {
    System.out.println(infoData.getQuestion());
  }

}
