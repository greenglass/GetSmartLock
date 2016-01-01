package test.com.getsmart.lock;

import junit.framework.*;

import java.util.ArrayList;
import java.util.Arrays;

import main.com.getsmart.lock.*;

public class GetSmartLock_UT extends TestCase {
  protected ArrayList<String> questions, answers;
  private static final String testStr = "initialize test";
  private static final int testStrIndex = 0;

  protected void setUp(){
    questions = new ArrayList<String>(Arrays.asList(testStr));
    answers = new ArrayList<String>();
  }

  public void testStoreInformation() {
    String storeStr = "store test";
    GetSmartLock.storeInformation(storeStr, questions);
    assertEquals(storeStr, questions.get(1));
  }

  public void testGetInformation() {
    String getInfo = GetSmartLock.getInformation(testStrIndex, questions);
    assertEquals(testStr, getInfo);
  }

  public void testGetIndexOfInformation() {
    int getIndex = GetSmartLock.getIndexOfInformation(testStr, questions);
    assertEquals(testStrIndex, getIndex);
  } 

  public void testGetRandomIndexListThrowException() {
    try {
      GetSmartLock.getRandomIndexList(new ArrayList<String>());
      fail("exception was supposed to be caught for no items in list");
    } catch (Exception e) {
      //if we get here then the exception was caught as expected, let continue so it passes.
    } 
  }
}
