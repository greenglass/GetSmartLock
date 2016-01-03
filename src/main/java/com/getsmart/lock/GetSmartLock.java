package com.getsmart.lock;

import com.getsmart.lock.blo.InformationBLO;
import com.getsmart.lock.blo.RetryMultipleQuestions;
import com.getsmart.lock.dto.InformationDTO;

public class GetSmartLock {
  public static void main(String[] args) {

    int numberOfQuestions = 4;
    int numberOfRetries = 1;
    InformationDTO appData = new InformationDTO(numberOfRetries);
    InformationBLO appLogic = new InformationBLO(appData);

    RetryMultipleQuestions logicRetry = new RetryMultipleQuestions(appLogic, numberOfQuestions);
    logicRetry.askQuestion();
  }

}
