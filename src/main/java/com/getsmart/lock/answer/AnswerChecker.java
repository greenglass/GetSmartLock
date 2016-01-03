package com.getsmart.lock.answer;

import com.getsmart.lock.dto.InformationDTO;

public class AnswerChecker {

  private InformationDTO infoData;

  public AnswerChecker() {
    this(new InformationDTO());
  }

  public AnswerChecker(InformationDTO info) {
    this.infoData = info;
  }

  /**
   *
   */
  public InformationDTO checkAnswer(InformationDTO info) {
    boolean isValid = info.getAnswer().equals(info.getUserAnswer());
    infoData.setIsAnswerValid(isValid);
    return infoData;
  } 

}
