package com.getsmart.lock.dto;

public class InformationDTO {
  private String question;
  private String answer;
  private int index;
  private String userAnswer;

  public InformationDTO() {
    this.question = null;
    this.answer = null;
    this.index = -1;
    this.userAnswer = null;
  }

  public InformationDTO(String question, String answer, int index, String userAnswer) {
    this.question = question;
    this.answer = answer;
    this.index = index;
    this.userAnswer = userAnswer;
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
}
