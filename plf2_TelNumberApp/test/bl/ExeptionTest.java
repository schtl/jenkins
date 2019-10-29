/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import org.junit.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author SF
 */
@RunWith(value = Parameterized.class)
public class ExeptionTest {

  @Parameter(value = 0)
  public String strInput;
  @Parameter(value = 1)
  public String expResult;

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
      {"+43/12x/12.34.56", "NF-Exception"},
      {"+43/12/1x.34.56", "NF-Exception"},
      {"+43/12/12.3x.56", "NF-Exception"},
      {"+43/12/12.34.5x6", "NF-Exception"}
    });
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of getArea method, of class PhoneNumberBL.
   */
  @Test(expected = NumberFormatException.class)
  public void testExceptions() {
    System.out.println("checkException (" + strInput + ") ");
    PhoneNumberBL.checkPhoneNumber(strInput);
  }

  /**
   * Test of checkPhoneNumber method, of class PhoneNumberBL.
   */
}
