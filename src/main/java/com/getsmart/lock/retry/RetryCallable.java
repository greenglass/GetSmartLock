package com.getsmart.lock.retry;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

public class RetryCallable<T> implements Callable<T> {

  private Callable<T> task;
  public static final int DEFAULT_NUMBER_OF_RETRIES = 3;
  public static final long DEFAULT_WAIT_TIME = 1000;

  private int numberOfRetries; // total number of tries
  private int numberOfTriesLeft; // number left
  private long timeToWait; // wait interval

  public RetryCallable(Callable<T> task) {
    this(DEFAULT_NUMBER_OF_RETRIES, DEFAULT_WAIT_TIME, task);
  }

  public RetryCallable(int numberOfRetries, Callable<T> task) {
    this(numberOfRetries, DEFAULT_WAIT_TIME, task);   
  }

  public RetryCallable(int numberOfRetries, long timeToWait,
      Callable<T> task) {
    this.numberOfRetries = numberOfRetries;
    numberOfTriesLeft = numberOfRetries;
    this.timeToWait = timeToWait;
    this.task = task;
  }

  public T call() throws Exception {
    while (true) {
      try {
        return task.call();
      }
      catch (InterruptedException e) {
        throw e;
      }
      catch (CancellationException e) {
        throw e;
      }
      catch (Exception e) {
        numberOfTriesLeft--;
        if (numberOfTriesLeft < 1) {
          String exceptionMessage = String.format(
              "%s attempt to retry failed at %sms interval",
              numberOfRetries, timeToWait);
          throw new RetryException(exceptionMessage, e);
        }
        Thread.sleep(timeToWait);
      }
    }
  }
}
