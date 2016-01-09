package com.getsmart.lock.unlock;

import java.util.concurrent.Callable;

import com.getsmart.lock.dto.InformationDTO;
import com.getsmart.lock.retry.RetryCallable;

public class RetryUnlockProcess {

  private UnlockProcess process;
  private int numberOfChances;

  public RetryUnlockProcess(InformationDTO info) {
    this.numberOfChances = info.getNumberOfTries();
    this.process = new UnlockProcess(info);
  }

  public boolean unlockPhoneInteraction() {
    boolean correctAnswer = false;
    Callable<Boolean> unlockOp = new Callable<Boolean>() {

      @Override
        public Boolean call() throws Exception {
          boolean questionAnsweredCorrectly = process.unlockPhoneInteraction();
          if (!questionAnsweredCorrectly) {
            throw new Exception("Answer was incorrect, retrying...");
          }
          return questionAnsweredCorrectly;
        }

    };

    RetryCallable<Boolean> prompt = new RetryCallable<Boolean>(numberOfChances, unlockOp);

    try {
      process.unlockPhoneInformation();
      correctAnswer = prompt.call();
    } catch (Exception e) {

    }
    return correctAnswer;
  }

  /**
   *
   */
  public boolean unlockPhone() {
    process.unlockPhoneInformation();
    return unlockPhoneInteraction();
  }
}
