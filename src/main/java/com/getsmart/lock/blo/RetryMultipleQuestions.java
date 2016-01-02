package com.getsmart.lock.blo;

import java.util.concurrent.Callable;

import com.getsmart.lock.retry.RetryCallable;

public class RetryMultipleQuestions {

  private InformationBLO classLogic;
  private InformationBLORetryCallable logicRetry;
  private int numberOfQuestions;
  private int questionsAsked;

  public RetryMultipleQuestions(InformationBLO logic, int numberOfQuestions) {
    this.classLogic = logic;
    this.logicRetry = new InformationBLORetryCallable(this.classLogic);
    this.numberOfQuestions = numberOfQuestions;
    this.questionsAsked = 0;
  }

  public void askQuestion() {
    Callable<Void> answerPromptOp = new Callable<Void>() {

      @Override
        public Void call() throws Exception {
          questionsAsked++;
          classLogic.populateInformationDTO();
          boolean correctAnswer = logicRetry.promptForAnswer();
          System.out.println("Answered correctly: " + correctAnswer);
          if (questionsAsked != numberOfQuestions) {
            throw new Exception("Answer was incorrect, retrying...");
          }
          return null;
        }

    };

    RetryCallable<Void> ask = new RetryCallable<Void>(numberOfQuestions, answerPromptOp);

    try {
      ask.call();
    } catch (Exception e) {

    }
  }
}
