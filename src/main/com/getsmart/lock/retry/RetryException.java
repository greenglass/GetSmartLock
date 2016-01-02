package main.com.getsmart.lock.retry;

public class RetryException extends Exception {

  private static final long serialVersionUID = -1L; 

  public RetryException() {
  }

  public RetryException(String message) {
    super(message);
  }

  public RetryException(Throwable cause) {
    super(cause);
  }

  public RetryException(String message, Throwable cause) {
    super(message, cause);
  }

}

