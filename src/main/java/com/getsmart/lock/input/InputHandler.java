package com.getsmart.lock.input;

import java.util.Scanner;

import com.getsmart.lock.dto.InformationDTO;

public class InputHandler {

  InformationDTO infoData;
  Scanner userInputReader;

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
    userInputReader = new Scanner(System.in);
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
