/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

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
public class AreaTest {

  @Parameter(value = 0)
  public String strInput;
  @Parameter(value = 1)
  public String expResult;

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
      {"+43/1/12.34.56", "W"},   
      {"+43/2/12.34.56", "NÖ"},
      {"+43/3/12.34.56", "ST"},
      {"+43/4/12.34.56", "K"},
      {"+43/5/12.34.56", "T-V"},
      {"+43/60/12.34.56", "S"},
      {"+43/61/12.34.56", "S"},
      {"+43/64/12.34.56", "S"},
      {"+43/65/12.34.56", "Mobil"},
      {"+43/667/12.34.56", "Mobil"},
      {"+43/69/12.34.56", "Mobil"},
      {"+43/7/12.34.56", "OÖ"}
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
  @Test
  public void testArea() {
    System.out.println("getArea (" + strInput + ") " + expResult);
    String result = PhoneNumberBL.getArea(strInput);
    assertEquals(expResult, result);
  }

  /**
   * Test of checkPhoneNumber method, of class PhoneNumberBL.
   */
}
