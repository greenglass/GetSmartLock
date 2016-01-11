package com.getsmart.lock.dto;

import java.util.ArrayList;

public class InformationDTO {

  private static final int DEFAULT_NUMBER_OF_TRIES = 1;
  private static final int DEFAULT_NUMBER_OF_QUESTIONS = 1;
  private int index;
  private String userAnswer;
  private int numberOfTries;
  private boolean isAnswerValid;
  private ArrayList<String> questions, answers;
  private int numberOfQuestions;

  public InformationDTO() {
    this(DEFAULT_NUMBER_OF_QUESTIONS, -1, null, DEFAULT_NUMBER_OF_TRIES, false);
  }

  public InformationDTO(int numberOfQuestions, int numberOfTries) {
    this(numberOfQuestions, -1, null, numberOfTries, false);
  }

  public InformationDTO(int numberOfQuestions, int index, String userAnswer, int numberOfTries, boolean isAnswerValid) {
    this.numberOfQuestions = numberOfQuestions;
    this.index = index;
    this.userAnswer = userAnswer;
    this.numberOfTries = numberOfTries;
    this.isAnswerValid = isAnswerValid;
  }

  public void addQuestion(String question) {
    questions.add(question);  
  }

  public ArrayList<String> getQuestions() {
    return questions;
  }

  public void addAnswer(String answer) {
    answers.add(answer);
  }

  public ArrayList<String> getAnswer() {
    return answers;
  }

  public int getNumberOfQuestions() {
    return numberOfQuestions;
  }

  public void setNumberOfQuestions(int numberOfQuestions) {
    this.numberOfQuestions = numberOfQuestions;
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
