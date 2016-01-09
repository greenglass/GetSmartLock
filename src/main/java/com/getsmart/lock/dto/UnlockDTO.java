package com.getsmart.lock.dto;

public class UnlockDTO {

  private static final int DEFAULT_NUMBER_OF_QUESTIONS = 1;
  private int numberOfQuestions;

  public UnlockDTO() {
    this(DEFAULT_NUMBER_OF_QUESTIONS);
  }

  public UnlockDTO(int numberOfQuestions) {
    this.numberOfQuestions = numberOfQuestions;
  }

  public void setNumberOfQuestions(int numberOfQuestions) {
    this.numberOfQuestions = numberOfQuestions;
  }

  public int getNumberOfQuestions() {
    return this.numberOfQuestions;
  }

}
