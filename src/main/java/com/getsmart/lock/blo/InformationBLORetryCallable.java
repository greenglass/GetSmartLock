package com.getsmart.lock.blo;

import java.util.concurrent.Callable;

import com.getsmart.lock.retry.RetryCallable;

public class InformationBLORetryCallable implements BusinessLogic {

  private InformationBLO classLogic;

  public InformationBLORetryCallable(InformationBLO logic) {
    this.classLogic = logic;
  }

  @Override
    public boolean promptForAnswer() {
      boolean correctAnswer = false;
      Callable<Boolean> answerPromptOp = new Callable<Boolean>() {

        @Override
          public Boolean call() throws Exception {
            boolean innerAnswer = classLogic.promptForAnswer();
            //boolean innerAnswer = classLogic.checkAnswer();
            if (!innerAnswer) {
              throw new Exception("Answer was incorrect, retrying...");
            }
            return innerAnswer;
          }

      };

      RetryCallable<Boolean> prompt = new RetryCallable<Boolean>(answerPromptOp);

      try {
        correctAnswer = prompt.call();
        classLogic.closeInputScanner();
      } catch (Exception e) {

      }
      return correctAnswer;
    }
}
