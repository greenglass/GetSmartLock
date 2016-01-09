package com.getsmart.lock.input;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.getsmart.lock.dto.InformationDTO;

import junit.framework.TestCase;

public class InputHandler_UT extends TestCase {

  private InputHandler testHandler;
  private InformationDTO testDTO;
  private static final String answer = "answer";

  protected void setUp() {
    testDTO = new InformationDTO();
    testHandler = new InputHandler(testDTO);
  }

  public void testInsertAnswerIntoDTO() {
    testDTO = testHandler.insertAnswerIntoDTO(answer);
    assertEquals(answer, testDTO.getUserAnswer());
  }

  public void testWaitForAnswerFromStream() {
    InputStream is = new ByteArrayInputStream(answer.getBytes());
    String obtainedAnswer = testHandler.waitForAnswerFromStream(is);
    assertEquals(answer, obtainedAnswer);
  }
}
