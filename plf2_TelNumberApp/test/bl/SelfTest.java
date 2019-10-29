/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author SF
 */
public class SelfTest {

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
  public void testGetArea() {
    int sum = 0;
      for (int i = 0; i < 100; i++) {
        String telNr = PhoneNumberBL.createPhoneNumber();
        System.out.println("Selftest: (telnr: " + telNr + ") ");
        assertEquals(true, PhoneNumberBL.checkPhoneNumber(telNr));
        sum++;
      }
      System.out.println("Selftest: (sum: " + sum + ") ");
    }

    /**
     * Test of checkPhoneNumber method, of class PhoneNumberBL.
     */
  }
