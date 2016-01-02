package com.getsmart.lock.dto;

import junit.framework.TestCase;

import com.getsmart.lock.dto.InformationDTO;

public class InformationDTO_UT extends TestCase {

  private static InformationDTO testDTO;
  private static final String question = "test question";
  private static final String answer = "test answer";
  private static final int index = 10;
  private static final String userAnswer = "test user answer";

  protected void setUp(){
    testDTO = new InformationDTO(question, answer, index, userAnswer);
  }

  public void testEmptyConstructor() {
    InformationDTO emptyDTO = new InformationDTO();
    assertEquals(null, emptyDTO.getQuestion());
    assertEquals(null, emptyDTO.getAnswer());
    assertEquals(-1, emptyDTO.getIndex());
    assertEquals(null, emptyDTO.getUserAnswer());
  }

  public void testGetQuestion() {
    assertEquals(question, testDTO.getQuestion());
  }

  public void testSetQuestion() {
    String newQuestion = "new test question";
    testDTO.setQuestion(newQuestion);
    assertEquals(newQuestion, testDTO.getQuestion());
  }

  public void testGetAnswer() {
    assertEquals(answer, testDTO.getAnswer());
  } 

  public void testSetAnswer() {
    String newAnswer = "new test answer";
    testDTO.setAnswer(newAnswer);
    assertEquals(newAnswer, testDTO.getAnswer());
  }

  public void testGetIndex() {
    assertEquals(index, testDTO.getIndex());
  }

  public void testSetIndex() {
    int newIndex = 1;
    testDTO.setIndex(newIndex);
    assertEquals(newIndex, testDTO.getIndex());
  }

  public void testGetUserAnswer() {
    assertEquals(userAnswer, testDTO.getUserAnswer());
  }

  public void testSetUserAnswer() {
    String newUserAnswer = "new user answer";
    testDTO.setUserAnswer(newUserAnswer);
    assertEquals(newUserAnswer, testDTO.getUserAnswer());
  }
}
