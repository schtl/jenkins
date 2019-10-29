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
public class NumberTest {

  @Parameter(value = 0)
  public String telNr;
  @Parameter(value = 1)
  public boolean expResult;
  @Parameter(value = 2)
  public String type;

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
      {"+43/12/12.34.56", true, "+43"},
      {"+44/12/12.34.56", false, "+43"},
      {"43/12/12.34.56", false, "+43"},
      {"+43/12.12.34.56", false, "/"},
      {"+43/1/12.34.56", true, "Vorwahl"},
      {"+43/12345/12.34.56", true, "Vorwahl"},
      {"+43/2/12.34.56", true, "Vorwahl"},
      {"+43/2123/12.34.56", true, "Vorwahl"},
      {"+43/3/12.34.56", true, "Vorwahl"},
      {"+43/4/12.34.56", true, "Vorwahl"},
      {"+43/56/12.34.56", true, "Vorwahl"},
      {"+43/65/12.345.567", true, "Vorwahl"},
      {"+43/676/12.345.567", true, "Vorwahl"},
      {"+43/778/12.34.56", true, "Vorwahl"},
      {"+43/123456/12.34.56", false, "Vorwahl"},
      {"+43/6543221/12.344.564", false, "Vorwahl"},
      {"+43/12/02.45.56", false, "Nummer"},
      {"+43/65/02.456.567", false, "Nummer"},
      {"+43/64/12.45.56", true, "Nummer"},
      {"+43/65/12.456.567", true, "Nummer"},
      {"+43/65/02.456.567", false, "Nummer"},
      {"+43/75/09.45.67", false, "Nummer"},
      {"+43/65/123.456.567", false, "Nummer"},
      {"+43/12/123.45.56", false, "Nummer"},
      {"+43/12/12.456.67", false, "Nummer"},
      {"+43/12/12.45.567", false, "Nummer"},
      {"+43/65/123.456.567", false, "Nummer"},
      {"+43/65/12.56.678", false, "Nummer"},
      {"+43/65/12.456.67", false, "Nummer"},
      {"+43/65/123.567", false, "."},
      {"+43/65/1.2.3", false, "."},
      {"+43/65/123.567", false, "."}
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
  public void testNumberCheck() {
    System.out.println("checkPhoneNumber (" + telNr + ") " + type + " -> " + expResult);
    boolean result = PhoneNumberBL.checkPhoneNumber(telNr);
    assertEquals(expResult, result);
  }

  /**
   * Test of checkPhoneNumber method, of class PhoneNumberBL.
   */
}
