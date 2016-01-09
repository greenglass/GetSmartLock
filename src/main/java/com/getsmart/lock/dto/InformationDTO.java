package com.getsmart.lock.dto;

public class InformationDTO {

  private static final int DEFAULT_NUMBER_OF_TRIES = 1;
  private String question;
  private String answer;
  private int index;
  private String userAnswer;
  private int numberOfTries;
  private boolean isAnswerValid;

  public InformationDTO() {
    this(null, null, -1, null, DEFAULT_NUMBER_OF_TRIES, false);
  }

  public InformationDTO(int numberOfTries) {
    this(null, null, -1, null, numberOfTries, false);
  }

  public InformationDTO(String question, String answer, 
      int index, String userAnswer, int numberOfTries,
      boolean isAnswerValid) {
    this.question = question;
    this.answer = answer;
    this.index = index;
    this.userAnswer = userAnswer;
    this.numberOfTries = numberOfTries;
    this.isAnswerValid = isAnswerValid;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public String getUserAnswer() {
    return userAnswer;
  }

  public void setUserAnswer(String userAnswer) {
    this.userAnswer = userAnswer;
  }

  public int getNumberOfTries() {
    return numberOfTries;
  }

  public void setNumberOfTries(int numberOfTries) {
    this.numberOfTries = numberOfTries;
  }

  public boolean getIsAnswerValid() {
    return isAnswerValid;
  }

  public void setIsAnswerValid(boolean isAnswerValid) {
    this.isAnswerValid = isAnswerValid;
  }
}
