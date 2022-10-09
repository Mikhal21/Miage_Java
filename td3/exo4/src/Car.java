package fr.dauphine.javaavance.td3.exo4.src;

import java.util.Objects;

public class Car extends Vehicule {
  private int obsolescence;
  private long valueCar;

  public Car(String brand, long valueCar) {
    super(brand, valueCar);
  }

  public Car(String brand, long valueCar, Discount discount) {
    super(brand, discount);
    this.valueCar = valueCar;
  }

  public Car(String brand, long valueCar, int obsolescence) {
    super(brand);
    this.valueCar = valueCar;
    this.obsolescence = obsolescence;
  }

  public Car(String brand, long valueCar, Discount discount, int obsolescence) {
    super(brand, discount);
    this.obsolescence = obsolescence;
    this.valueCar = valueCar;
  }

  @Override
  public int compareTo(Vehicule v) {
    int range = super.compareTo(v);
    if (range != 0) {
      return range;
    }
    Car c = (Car) v;
    Integer currentObsolescence = this.getObsolescence();
    Integer otherObsolescence = c.getObsolescence();
    return currentObsolescence.compareTo(otherObsolescence);
  }

  @Override
  public int hashCode() {
    return Objects.hash(obsolescence, valueCar);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Car other = (Car) obj;
    return obsolescence == other.obsolescence && valueCar == other.valueCar;
  }

  public int getObsolescence() {
    return this.obsolescence;
  }

  @Override
  public long getValue() throws IllegalStateException {
    if (!(Objects.isNull(this.getDiscount()))) {
      return this.getDiscount().getValue();
    }
    if (this.obsolescence > 0) {
      return this.valueCar - (1000 * this.obsolescence);
    }
    return this.valueCar;
  }

  public static void main(String[] args) {
    Discount d1 = new Discount(3000);
    Car c = new Car("Renault", 50000, d1, 3);
    System.out.println(c.getValue());
    Car c2 = new Car("Peugeot", 20000, null, 4);
    System.out.println(c2.getValue());

  }
}
