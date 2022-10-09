package fr.dauphine.javaavance.td3.exo4.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import fr.dauphine.javaavance.td3.exo4.src.Bike;
import fr.dauphine.javaavance.td3.exo4.src.Car;
import fr.dauphine.javaavance.td3.exo4.src.Discount;
import fr.dauphine.javaavance.td3.exo4.src.Garage;
import org.junit.jupiter.api.Test;

public class GarageTest4 {

  @Test
  public void garageEquality() {
    Garage garage1 = new Garage();
    Garage garage2 = new Garage();

    Car car1 = new Car("BMW", 90000);
    Car car2 = new Car("Lada", 6500, 2);
    Car car3 = new Car("Lada", 5500, 1);
    Bike bike1 = new Bike("Scott");
    Bike bike2 = new Bike("Merlin", new Discount(50));
    Bike bike3 = new Bike("Merlin");

    garage1.add(car1);
    garage1.add(bike1);
    garage1.add(car2);
    garage1.add(bike2);
    garage1.add(car3);
    garage1.add(bike3);

    garage2.add(bike1);
    garage2.add(car1);
    garage2.add(car3);
    garage2.add(car2);
    garage2.add(bike3);
    garage2.add(bike2);

    assertEquals(garage1, garage2);
  }
}
