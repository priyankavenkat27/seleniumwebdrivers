package mypackage;
 
import org.testng.annotations.Test;
 
public class tc_10_groupstestng {
  @Test(groups= {"smoke"},priority=2)
  public void test1() {
	  System.out.println("This is smoketest1");
  }
  @Test(groups= {"regression"},priority=1)
  public void test2() {
	  System.out.println("This is regressiontest1");
  }
  @Test(groups= {"regression"},priority=3)
  public void test3() {
	  System.out.println("This is  regressiontest2");
  }
  @Test(groups= {"smoke"},priority=4,enabled=false)
  public void test4() {
	  System.out.println("This is smoketest2");
  }
}