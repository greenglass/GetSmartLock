package com.getsmart.lock.answer;

import com.getsmart.lock.dto.InformationDTO;

import junit.framework.TestCase;

public class AnswerChecker_UT extends TestCase {

  private static AnswerChecker checker;
  private static InformationDTO infoData;
  private static final String questionAnswer = "getsmart";
  private static final String correctAnswer = "getsmart";
  private static final String wrongAnswer = "wrong answer";

  protected void setUp() {
    infoData = new InformationDTO();
    infoData.setQuestion(questionAnswer);
    infoData.setAnswer(questionAnswer);
    checker = new AnswerChecker(infoData);
  }

  public void testCheckAnswerCorrect() {
    infoData.setUserAnswer(correctAnswer);
    infoData = checker.checkAnswer(infoData);
    assertTrue(infoData.getIsAnswerValid());
  }

  public void testCheckAnswerIncorrect() {
    infoData.setUserAnswer(wrongAnswer);
    infoData = checker.checkAnswer(infoData);
    assertFalse(infoData.getIsAnswerValid());
  }
}

