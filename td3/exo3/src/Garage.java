package fr.dauphine.javaavance.td3.exo3.src;

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
    return Objects.hash(id, myGarage);
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
    return id != other.id && Objects.equals(myGarage, other.myGarage);
  }

  @SuppressWarnings("unused")
  public void add(Vehicule oneVehicle) {
    Objects.requireNonNull(oneVehicle);
    this.myGarage.add(oneVehicle);
  }

  public void remove(Vehicule oneVehicle) throws IllegalStateException {
    if (this.myGarage.isEmpty()) {
      throw new IllegalStateException();
    }
    this.myGarage.remove(oneVehicle);
  }

  public long getValue() {
    long garageValue = 0;
    Iterator<Vehicule> iteratorGarage = this.myGarage.iterator();
    while (iteratorGarage.hasNext()) {
      garageValue += iteratorGarage.next().getValue();
    }
    return garageValue;
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

  public Vehicule firstCarByBrand(String oneBrand) {
    Iterator<Vehicule> iteratorGarage = this.myGarage.iterator();
    while (iteratorGarage.hasNext()) {
      Vehicule oneVehicle = iteratorGarage.next();
      if (oneVehicle.getBrand().equals(oneBrand)) {
        return oneVehicle;
      }
    }
    return null;
  }

  public void protectionism(String brand) {
    Iterator<Vehicule> iteratorGarage = this.myGarage.iterator();
    while (iteratorGarage.hasNext()) {
      Vehicule vehicleToRemove = iteratorGarage.next();
      if (vehicleToRemove.getBrand().equals(brand)) {
        iteratorGarage.remove();
      }
    }
  }

  public static void main(String[] args) {
    Discount carD = new Discount(15000);
    Discount bikeD = new Discount(200);
    ArrayList<Vehicule> al = new ArrayList<>();
    Garage garage = new Garage(al);
    Vehicule c = new Car("Audi", 100000, carD, 3);
    Vehicule c2 = new Car("Citroen", 50000, null, 2);
    Bike b = new Bike("Audi", bikeD);
    Bike b2 = new Bike("titi", null);

    garage.add(c2);
    garage.add(b);
    garage.add(c);
    garage.add(b2);
    System.out.println(garage);
    garage.protectionism("Audi");
    System.out.println(garage);

  }
}
