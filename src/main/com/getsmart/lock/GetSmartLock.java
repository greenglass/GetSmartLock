package main.com.getsmart.lock;

import main.com.getsmart.lock.blo.InformationBLO;
import main.com.getsmart.lock.blo.InformationBLORetryCallable;

public class GetSmartLock {
  public static void main(String[] args) {

    InformationBLO appLogic = new InformationBLO();

    appLogic.populateInformationDTO();

    InformationBLORetryCallable logicRetry = new InformationBLORetryCallable(appLogic);
    boolean correctAnswer = logicRetry.promptForAnswer();      

    System.out.println("Was answer correct?: " + correctAnswer);

  }

}
