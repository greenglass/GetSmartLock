package com.getsmart.lock.blo;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

import com.getsmart.lock.blo.InformationBLO;
import com.getsmart.lock.dto.InformationDTO;

public class InformationBLO_UT extends TestCase {

  private InformationBLO testLogic;
  private static final String initStr = "init";
  private static String[] testArray = {initStr};
  private static final ArrayList<String> testList = new ArrayList<String>(Arrays.asList(testArray));
  private InformationDTO testInfo;
  private static final String question = "test question";
  private static final String answer = "test answer";
  private static final int index = 10;
  private static final String userAnswer = "test user answer";
  private static final int numberOfTries = 1;

  protected void setUp() {
    testInfo = new InformationDTO(question, answer, index, userAnswer, numberOfTries);
    testLogic = new InformationBLO(testInfo);
  }

  /**
   * Test that an empty list will throw an exception.
   */
  public void testGetRandomIndexListException() {
    ArrayList<String> emptyList = new ArrayList<String>();
    try {
      testLogic.getRandomIndexList(emptyList);
      fail("Exception should have been caught when getting index of empty list");
    } catch (Exception e) {
      //Empty catch so the test will continue and pass.
    }
  }

  /**
   * Tests getting the InformationDTO object has the same information of the internal
   * InformationDTO in the InformationBLO object.
   */
  public void testGetInformationDTO() {
    InformationDTO testDTO = testLogic.getInformationDTO();
    assertEquals(question, testDTO.getQuestion());
    assertEquals(answer, testDTO.getAnswer());
    assertEquals(index, testDTO.getIndex());
    assertEquals(userAnswer, testDTO.getUserAnswer());
    assertEquals(numberOfTries, testDTO.getNumberOfTries());
  }

  /**
   * Tests that the internal InformationDTO object in the InformationBLO object gets
   * updated with the new InformationDTO object information.
   */
  public void testUpdateInformationDTO() {
    String newQuestion = "new question";
    String newAnswer = "new answer";
    int newIndex = 100;
    String newUserAnswer = "new user answer";
    int newNumberOfTries = 100;
    InformationDTO newTestDTO = new InformationDTO(newQuestion, newAnswer, newIndex, newUserAnswer, newNumberOfTries);

    testLogic.updateInformationDTO(newTestDTO);

    InformationDTO updatedDTO = testLogic.getInformationDTO();
    assertEquals(newQuestion, updatedDTO.getQuestion());
    assertEquals(newAnswer, updatedDTO.getAnswer());
    assertEquals(newIndex, updatedDTO.getIndex());
    assertEquals(newUserAnswer, updatedDTO.getUserAnswer());
    assertEquals(newNumberOfTries, updatedDTO.getNumberOfTries());
  }

  /**
   * Tests new information can get stored into the list.
   */
  public void testStoreInformation() {
    String info = "test in test";
    testLogic.storeInformation(info, testList);
    assertEquals(info, testList.get(1));
  }

  /**
   * Tests information can be gotten from the list.
   */
  public void testGetInformation() {
    String info = testLogic.getInformation(0, testList);
    assertEquals(initStr, info);
  }

  /**
   * Tests that the stored answer and the users provided answer returns true when
   * they are equal.
   */
  public void testCheckAnswerSuccess() {
    InformationDTO inData = testInfo;
    inData.setUserAnswer(answer);
    InformationBLO inLogic = new InformationBLO(inData);
    assertTrue(inLogic.checkAnswer());
  }

  /**
   * Tests that the stored answer and the users provided answer returns false when
   * they are not equal.
   */
  public void testCheckAnswerFailure() {
    assertFalse(testLogic.checkAnswer());
  }

}
