package org.peterczigany;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class DisplayUtilsTest {

  @Test
  void true_assertion() {
    assertTrue(true);
  }

  @Test
  void print_zero() {
    assertEquals("0", DisplayUtils.print(BigDecimal.ZERO));
  }

  @Test
  void print_one() {
    assertEquals("1", DisplayUtils.print(BigDecimal.ONE));
  }

  @Test
  void print_comma() {
    assertEquals("1,1", DisplayUtils.print(BigDecimal.valueOf(1.1)));
  }

  @Test
  void print_zeroes() {
    assertEquals("1,01", DisplayUtils.print(BigDecimal.valueOf(1.01000)));
  }

  @Test
  void print_very_precise() {
    assertEquals("1,000000000000001", DisplayUtils.print(BigDecimal.valueOf(1.000000000000001)));
  }

  @Test
  void convert_zero() {
    assertEquals("0", DisplayUtils.convert("0"));
  }

  @Test
  void convert_one() {
    assertEquals("1", DisplayUtils.convert("1"));
  }

  @Test
  void convert_comma() {
    assertEquals("1,1", DisplayUtils.convert("1.1"));
  }

  @Test
  void convert_zeroes() {
    assertEquals("1,01", DisplayUtils.convert("1,01000"));
  }

  @Test
  void convert_very_precise() {
    assertEquals("1,000000000000001", DisplayUtils.convert("1.000000000000001"));
  }

  @Test
  void convert_scientific() {
    assertEquals("5312", DisplayUtils.convert("5.312E+03"));
  }

  @Test
  void convert_scientific_comma() {
    assertEquals("5312", DisplayUtils.convert("5,312E+03"));
  }

  @Test
  void very_small() {
    assertEquals("0,000000005312", DisplayUtils.convert("0,000000005312"));
  }
}
