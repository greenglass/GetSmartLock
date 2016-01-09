package com.getsmart.lock.unlock;

import com.getsmart.lock.answer.AnswerChecker;
import com.getsmart.lock.dto.InformationDTO;
import com.getsmart.lock.input.InputHandler;
import com.getsmart.lock.question.QuestionProvider;

public class UnlockProcess {

  private InformationDTO infoData;
  private QuestionProvider provider;
  private InputHandler handler;
  private AnswerChecker checker;

  public UnlockProcess() {
    this(new InformationDTO());
  }

  public UnlockProcess(InformationDTO info) {
    this.infoData = info;
    provider = new QuestionProvider(infoData);
    handler = new InputHandler(infoData);
    checker = new AnswerChecker(infoData);
  }

  /**
   *
   */
  public boolean unlockPhone() {
    infoData = provider.populateInformationDTO();
    return unlockPhoneInteraction();
  }

  /**
   *
   */
  public void unlockPhoneInformation() {
    infoData = provider.populateInformationDTO();
  }

  /**
   *
   */
  public boolean unlockPhoneInteraction() {
    provider.provideQuestion();

    String userAnswer = handler.waitForAnswer();
    infoData = handler.insertAnswerIntoDTO(userAnswer);

    infoData = checker.checkAnswer(infoData);
    return infoData.getIsAnswerValid();
  }
}
