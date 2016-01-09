package com.getsmart.lock.dto;

import junit.framework.TestCase;

public class UnlockDTO_UT extends TestCase {

  private static UnlockDTO testDTO;
  private static final int numberOfQuestions = 5;

  protected void setUp() {
    testDTO = new UnlockDTO(numberOfQuestions);
  }

  public void testEmptyConstructor() {
    UnlockDTO emptyDTO = new UnlockDTO();
    assertEquals(1, emptyDTO.getNumberOfQuestions());
  }

  public void testGetNumberOfQuestions() {
    assertEquals(numberOfQuestions, testDTO.getNumberOfQuestions());
  }

  public void testSetNumberOfQuestions() {
    int newNumberOfQuestions = 10;
    testDTO.setNumberOfQuestions(newNumberOfQuestions);
    assertEquals(newNumberOfQuestions, testDTO.getNumberOfQuestions());
  }
}

