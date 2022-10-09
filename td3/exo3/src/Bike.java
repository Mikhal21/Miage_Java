package fr.dauphine.javaavance.td3.exo3.src;

import java.util.Objects;

public class Bike extends Vehicule {
  private final long valueBike = 100;

  public Bike(String brand) {
    super(brand);
  }

  public Bike(String brand, Discount discount) {
    super(brand, discount);
  }

  @Override
  public long getValue() throws IllegalStateException {
    if (!(Objects.isNull(this.getDiscount()))) {
      return this.getDiscount().getValue();
    }
    return this.valueBike;
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueBike);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Bike other = (Bike) obj;
    return valueBike == other.valueBike;
  }

  public static void main(String[] args) {
    Discount d = new Discount(150);
    Bike b = new Bike("lalala", d);
    System.out.println(b.getValue());
    Bike b2 = new Bike("lilili", null);
    System.out.println(b2.getValue());
  }
}
