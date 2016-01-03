package com.getsmart.lock.input;

import java.io.InputStream;
import java.util.Scanner;

import com.getsmart.lock.dto.InformationDTO;

public class InputHandler {

  private InformationDTO infoData;
  private Scanner userInputReader;

  public InputHandler() {
    this(new InformationDTO());
  }

  public InputHandler(InformationDTO info) {
    this.infoData = info;
  }

  /**
   *
   */
  public String waitForAnswer() {
    return waitForAnswerFromStream(System.in);    
  }

  /**
   *
   */
  public String waitForAnswerFromStream(InputStream in) {
    userInputReader = new Scanner(in);
    String userAnswer = userInputReader.nextLine();
    userInputReader.reset();
    return userAnswer;
  }

  /**
   *
   */
  public void closeInputReader() {
    userInputReader.close();
  }

  /**
   *
   */
  public InformationDTO insertAnswerIntoDTO(String answer) {
    infoData.setUserAnswer(answer);
    return infoData;
  }

}
