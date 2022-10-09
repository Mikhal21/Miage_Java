package fr.dauphine.javaavance.td3.exos1et2.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Car {
  private final String brand;
  private long value;
  private int obsolescence;

  public Car(String brand, long value) throws NullPointerException {
    if (brand.equals(null)) {
      throw new NullPointerException();
    }
    if (value < 0) {
      throw new IllegalArgumentException();
    }
    this.brand = brand;
    this.value = value;
  }

  public Car(String brand, long value, int obsolescence)
      throws NullPointerException, IllegalArgumentException {
    if (brand.equals(null)) {
      throw new NullPointerException();
    }
    if (value < 0) {
      throw new IllegalArgumentException();
    }
    if ((value - (1000 * obsolescence)) < 0) {
      throw new IllegalArgumentException();
    }
    this.brand = brand;
    this.value = value;
    this.obsolescence = obsolescence;
  }

  public String getBrand() {
    return this.brand;
  }

  public long getValue() {
    if (this.obsolescence > 0) {
      return this.value - (1000 * this.obsolescence);
    }
    return this.value;
  }

  public int getObsolescence() {
    return this.obsolescence;
  }

  @Override
  public String toString() {
    return "Marque de la voiture : " + this.getBrand() + "\nPrix de la voiture : " + this.getValue()
        + " euros\n";
  }

  @Override
  public int hashCode() {
    return Objects.hash(brand, obsolescence, value);
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
    return Objects.equals(brand, other.brand) && obsolescence == other.obsolescence
        && value == other.value;
  }

  public static void main(String[] args) {
    Car a = new Car("Audi", 10000);
    Car b = new Car("BMW", 9000);
    Car c = new Car("BMW", 9000);
    Car d = a;
    ArrayList<Car> list = new ArrayList<>();
    list.add(a);
    list.add(b);
    HashSet<Car> set = new HashSet<Car>();
    set.add(b);
    System.out.println(list.indexOf(c));
    System.out.println(set.contains(c));
    System.out.println();
    System.out.println();
    Car e = new Car("Peugeot", 12000, 200);
    System.out.println(e.getValue());
  }
}
