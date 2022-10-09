package fr.dauphine.javaavance.td3.exos1et2.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Garage {
  ArrayList<Car> myGarage = new ArrayList<Car>();
  private int id;
  private static int counter;

  public Garage() {
    this.id = counter;
    counter++;
  }

  public Garage(ArrayList<Car> myGarage) {
    this.myGarage = myGarage;
    this.id = counter;
    counter++;
  }

  public int getId() {
    return this.id;
  }

  @SuppressWarnings("unused")
  public void add(Car oneCar) {
    Objects.requireNonNull(oneCar);
    this.myGarage.add(oneCar);
  }

  public void remove(Car oneCar) throws IllegalStateException {
    if (this.myGarage.isEmpty()) {
      throw new IllegalStateException();
    }
    this.myGarage.remove(oneCar);
  }

  public int getValue() {
    int valueG = 0;
    Iterator<Car> iteratorGarage = this.myGarage.iterator();
    while (iteratorGarage.hasNext()) {
      valueG += iteratorGarage.next().getValue();
    }
    return valueG;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Id du garage : " + this.getId() + "\n \n");
    Iterator<Car> iteratorGarage = this.myGarage.iterator();
    while (iteratorGarage.hasNext()) {
      sb.append(iteratorGarage.next() + "\n");
    }
    return sb.toString();
  }

  public Car firstCarByBrand(String oneBrand) throws NullPointerException {
    if (oneBrand.equals(null)) {
      throw new NullPointerException();
    }
    Iterator<Car> iteratorGarage = this.myGarage.iterator();
    while (iteratorGarage.hasNext()) {
      Car oneCar = iteratorGarage.next();
      if (oneCar.getBrand().equals(oneBrand)) {
        return oneCar;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    ArrayList<Car> al = new ArrayList<Car>();
    Garage test = new Garage(al);
    Car c = new Car("Audi", 100000, 2);
    Car c2 = new Car("Renault", 50000);
    Car c3 = new Car("Citroen", 20000);
    test.add(c);
    test.add(c2);
    test.add(c3);
    System.out.println(test);

  }
}
