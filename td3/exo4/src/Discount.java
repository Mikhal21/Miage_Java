package fr.dauphine.javaavance.td3.exo4.src;

import java.util.Objects;

public class Discount {
  private long valueDiscount;

  public Discount(long valueDiscount) throws IllegalArgumentException {
    if (valueDiscount < 0) {
      throw new IllegalArgumentException();
    }
    this.valueDiscount = valueDiscount;
  }

  public long getValue() {
    return this.valueDiscount;
  }

  public void setDiscount(long value) {
    this.valueDiscount = value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueDiscount);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Discount other = (Discount) obj;
    return valueDiscount == other.valueDiscount;
  }
}
