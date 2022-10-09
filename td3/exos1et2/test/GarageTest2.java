package fr.dauphine.javaavance.td3.exos1et2.test;

import static org.junit.Assert.assertNull;

import fr.dauphine.javaavance.td3.exos1et2.src.Car;
import fr.dauphine.javaavance.td3.exos1et2.src.Garage;
import org.junit.Test;

public class GarageTest2 {

  // exo2
  @Test(expected = IllegalStateException.class)
  public void garageRemoveNotExist() {
    Garage garage = new Garage();
    garage.remove(new Car("BMW", 20000));
  }

  @Test
  public void garageAddRemove() {
    Garage garage = new Garage();
    garage.add(new Car("Ford", 25000));
    garage.remove(new Car("Ford", 25000));
    assertNull(garage.firstCarByBrand("Ford"));
  }

  @Test(expected = NullPointerException.class)
  public void findACarByModelNull() {
    Garage garage = new Garage();
    garage.firstCarByBrand(null);
  }
}
