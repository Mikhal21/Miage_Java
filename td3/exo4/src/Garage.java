package fr.dauphine.javaavance.td3.exo4.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

public class Garage {
  ArrayList<Vehicule> myGarage = new ArrayList<Vehicule>();
  private int id;
  private static int counter;

  public Garage() {
    this.id = counter;
    counter++;
  }

  public Garage(ArrayList<Vehicule> myGarage) {
    this.myGarage = myGarage;
    this.id = counter;
    counter++;
  }

  public int getId() {
    return this.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(myGarage);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Garage other = (Garage) obj;
    return Objects.equals(myGarage, other.myGarage);
  }

  @SuppressWarnings("unused")
  public void add(Vehicule oneVehicle) {
    Objects.requireNonNull(oneVehicle);
    this.myGarage.add(oneVehicle);
    Collections.sort(this.myGarage);
  }

  public void remove(Car oneCar) throws IllegalStateException {
    if (this.myGarage.isEmpty()) {
      throw new IllegalStateException();
    }
    this.myGarage.remove(oneCar);
  }

  public int getValue() {
    int valueG = 0;
    Iterator<Vehicule> iteratorGarage = this.myGarage.iterator();
    while (iteratorGarage.hasNext()) {
      valueG += iteratorGarage.next().getValue();
    }
    return valueG;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Id du garage : " + this.getId() + "\n \n");
    Iterator<Vehicule> iteratorGarage = this.myGarage.iterator();
    while (iteratorGarage.hasNext()) {
      sb.append(iteratorGarage.next() + "\n");
    }
    return sb.toString();
  }

  public Vehicule firstCarByBrand(String oneBrand) throws NullPointerException {
    if (oneBrand.equals(null)) {
      throw new NullPointerException();
    }
    Iterator<Vehicule> iteratorGarage = this.myGarage.iterator();
    while (iteratorGarage.hasNext()) {
      Vehicule oneVehicle = iteratorGarage.next();
      if (oneVehicle.getBrand().equals(oneBrand)) {
        return oneVehicle;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    ArrayList<Vehicule> al = new ArrayList<Vehicule>();
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
