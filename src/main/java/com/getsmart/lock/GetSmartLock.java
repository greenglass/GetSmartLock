package com.getsmart.lock;

import com.getsmart.lock.dto.InformationDTO;
import com.getsmart.lock.dto.UnlockDTO;
import com.getsmart.lock.unlock.RetryMultipleUnlockProcess;

public class GetSmartLock {
  public static void main(String[] args) {

    int numberOfQuestions = 3;
    int numberOfRetries = 5;
    InformationDTO infoData = new InformationDTO(numberOfQuestions, numberOfRetries);

    //infoData = Database.populateDTO(infoData);

    UnlockDTO procData = new UnlockDTO(numberOfQuestions);

    //UnlockProcess process = new UnlockProcess(infoData);
    //RetryUnlockProcess process = new RetryUnlockProcess(infoData);
    RetryMultipleUnlockProcess process = new RetryMultipleUnlockProcess(procData, infoData);
    System.out.println("unlocked? " + process.unlockPhone());
  }

}
