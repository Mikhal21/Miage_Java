package fr.dauphine.javaavance.td3.exo4.src;

import java.util.Objects;

public class Vehicule implements Comparable<Vehicule> {
  private final String brand;
  private long value;
  private Discount discount;

  public Vehicule(String brand) {
    this.brand = brand;
  }

  public Vehicule(String brand, Discount discount) {
    this.brand = brand;
    this.discount = discount;
  }

  public Vehicule(String brand, long value) {
    this.brand = brand;
    this.value = value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(brand, discount, value);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Vehicule other = (Vehicule) obj;
    return Objects.equals(brand, other.brand) && Objects.equals(discount, other.discount)
        && value == other.value;
  }

  @Override
  public int compareTo(Vehicule v) {

    // Compare class, we choose top place Bike beofre Car
    Class currentVehicule = this.getClass();
    Class otherVehicule = v.getClass();
    if (currentVehicule != otherVehicule) {
      if (this instanceof Bike) {
        return -1;
      }
      return 1;
    }

    // Compare brand
    if (this.getBrand() != v.getBrand()) {
      return this.getBrand().compareTo(v.getBrand());
    }

    // Compare value
    Long currentValue = this.getValue();
    Long otherValue = v.getValue();
    if (currentValue != otherValue) {
      return currentValue.compareTo(otherValue);
    }

    // Compare discount
    if (this.getDiscount() != null || v.getDiscount() != null) {
      if (this.getDiscount() == null) {
        return -1;
      }
      if (v.getDiscount() == null) {
        return 1;
      }
      Long currentDiscount = this.getDiscount().getValue();
      Long otherDiscount = v.getDiscount().getValue();
      if (currentDiscount != otherDiscount) {
        return currentDiscount.compareTo(otherDiscount);
      }
    }
    return 0;
  }

  public String getBrand() {
    return this.brand;
  }

  public Discount getDiscount() {
    return this.discount;
  }

  public long getValue() {
    return this.value;
  }

  @Override
  public String toString() {
    if (Objects.isNull(this.getDiscount())) {
      return "Marque du véhicule : " + this.getBrand() + "\nVéhicule non soldé\n";
    }
    return "Marque du véhicule : " + this.getBrand() + "\nPrix du véhicule en solde : "
        + this.getDiscount().getValue() + " euros \n";
  }

  public void setDiscount(Discount discount2) {
    this.discount = discount2;
  }
}
