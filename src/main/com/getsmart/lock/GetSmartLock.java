package main.com.getsmart.lock;

import java.util.Scanner;

import main.com.getsmart.lock.blo.InformationBLO;
import main.com.getsmart.lock.dto.InformationDTO;

public class GetSmartLock {
  public static void main(String[] args) {

    InformationDTO appData = new InformationDTO();
    InformationBLO appLogic = new InformationBLO();

    appData = appLogic.populateInformationDTO();

    System.out.println(appData.getQuestion());

    Scanner userInputReader = new Scanner(System.in);
    String userAnswer = userInputReader.next();
    userInputReader.close();

    appData.setUserAnswer(userAnswer);
    appLogic.updateInformation(appData);

    boolean correctAnswer = appLogic.checkAnswer();
    System.out.println("Was answer correct?: " + correctAnswer);
  }

}
