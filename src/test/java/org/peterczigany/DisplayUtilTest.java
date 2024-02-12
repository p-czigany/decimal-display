package org.peterczigany;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class DisplayUtilTest {

  @Test
  void true_assertion() {
    assertTrue(true);
  }

  @Test
  void print_zero() {
    assertEquals("0", DisplayUtil.print(BigDecimal.ZERO));
  }

  @Test
  void print_one() {
    assertEquals("1", DisplayUtil.print(BigDecimal.ONE));
  }

  @Test
  void print_comma() {
    assertEquals("1,1", DisplayUtil.print(BigDecimal.valueOf(1.1)));
  }

  @Test
  void print_zeroes() {
    assertEquals("1,01", DisplayUtil.print(BigDecimal.valueOf(1.01000)));
  }

  @Test
  void print_very_precise() {
    assertEquals("1,000000000000001", DisplayUtil.print(BigDecimal.valueOf(1.000000000000001)));
  }

  @Test
  void convert_zero() {
    assertEquals("0", DisplayUtil.convert("0"));
  }

  @Test
  void convert_one() {
    assertEquals("1", DisplayUtil.convert("1"));
  }

  @Test
  void convert_comma() {
    assertEquals("1,1", DisplayUtil.convert("1.1"));
  }

  @Test
  void convert_zeroes() {
    assertEquals("1,01", DisplayUtil.convert("1,01000"));
  }

  @Test
  void convert_very_precise() {
    assertEquals("1,000000000000001", DisplayUtil.convert("1.000000000000001"));
  }

  @Test
  void convert_scientific() {
    assertEquals("5312", DisplayUtil.convert("5.312E+03"));
  }

  @Test
  void convert_scientific_comma() {
    assertEquals("5312", DisplayUtil.convert("5,312E+03"));
  }

  @Test
  void very_small() {
    assertEquals("0,000000005312", DisplayUtil.convert("0,000000005312"));
  }
}
