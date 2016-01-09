package com.getsmart.lock.unlock;

import java.util.concurrent.Callable;

import com.getsmart.lock.dto.InformationDTO;
import com.getsmart.lock.dto.UnlockDTO;
import com.getsmart.lock.retry.RetryCallable;

public class RetryMultipleUnlockProcess {

  private RetryUnlockProcess retryProcess;
  private int numberOfQuestions;
  private int numberOfAskedQuestions;

  public RetryMultipleUnlockProcess(UnlockDTO unlockData, InformationDTO info) {
    this.numberOfQuestions = unlockData.getNumberOfQuestions();
    this.retryProcess = new RetryUnlockProcess(info);
    this.numberOfAskedQuestions = 0;
  }

  public boolean unlockPhone() {
    boolean phoneUnlocked = false;
    Callable<Boolean> unlockOp = new Callable<Boolean>() {

      @Override
        public Boolean call() throws Exception {
          retryProcess.unlockPhone();
          numberOfAskedQuestions++;
          if ((numberOfQuestions != numberOfAskedQuestions)) {
            throw new Exception("Answer was incorrect, retrying...");
          }
          return true;
        }

    };

    RetryCallable<Boolean> prompt = new RetryCallable<Boolean>(numberOfQuestions, unlockOp);

    try {
      phoneUnlocked = prompt.call();
    } catch (Exception e) {

    }
    return phoneUnlocked;
  }

}
