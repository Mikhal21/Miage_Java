package fr.dauphine.javaavance.td3.exo3.src;

import java.util.Objects;

public class Vehicule {
  private final String brand;
  private long value;
  private Discount discount;

  public Vehicule(String brand) {
    this.brand = brand;
  }

  public Vehicule(String brand, long value) {
    this.brand = brand;
    this.value = value;
  }

  public Vehicule(String brand, Discount discount) {
    this.brand = brand;
    this.discount = discount;
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
      return "Marque du véhicule : " + this.getBrand() + "\nVéhicule non soldé \n";
    }
    return "Marque du véhicule : " + this.getBrand() + "\nPrix du véhicule en solde : "
        + this.getDiscount().getValue() + " euros \n";
  }

  public void setDiscount(Discount discount2) {
    this.discount = discount2;
  }
}
