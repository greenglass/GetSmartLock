package com.getsmart.lock;

import java.util.ArrayList;

import com.getsmart.lock.dto.InformationDTO;
import com.getsmart.lock.dto.UnlockDTO;
import com.getsmart.lock.question.QuestionProvider;
import com.getsmart.lock.unlock.RetryMultipleUnlockProcess;

public class GetSmartLock {
  public static void main(String[] args) {

    int numberOfQuestions = 3;
    int numberOfRetries = 5;
    InformationDTO infoData = new InformationDTO(numberOfQuestions, numberOfRetries);
    QuestionProvider provider = new QuestionProvider(infoData);
    infoData = provider.populateInformationDTO();

    ArrayList<String> qs = infoData.getQuestions();
    ArrayList<String> as = infoData.getAnswers();

    for(int i = 0; i < qs.size(); i++) {
      System.out.println(qs.get(i) + " : " + as.get(i));
    }

    UnlockDTO procData = new UnlockDTO(numberOfQuestions);

    //UnlockProcess process = new UnlockProcess(infoData);
    //RetryUnlockProcess process = new RetryUnlockProcess(infoData);
    RetryMultipleUnlockProcess process = new RetryMultipleUnlockProcess(procData, infoData);
    System.out.println("unlocked? " + process.unlockPhone());
  }

}
