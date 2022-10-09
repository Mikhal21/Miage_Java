package fr.dauphine.javaavance.td3.exo3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import fr.dauphine.javaavance.td3.exo3.src.Bike;
import fr.dauphine.javaavance.td3.exo3.src.Car;
import fr.dauphine.javaavance.td3.exo3.src.Discount;
import fr.dauphine.javaavance.td3.exo3.src.Vehicule;
import org.junit.jupiter.api.Test;

public class BikeTest {

  @Test
  public void sameValue() {
    Bike bike1 = new Bike("Topbike", null);
    Bike bike2 = new Bike("Topbike", null);
    assertEquals(bike1.getValue(), bike2.getValue());
  }

  @Test
  public void sameValue2() {
    Bike bike1 = new Bike("Topbike", new Discount(100));
    Bike bike2 = new Bike("Topbike", null);
    assertEquals(bike1.getValue(), bike2.getValue());
  }

  @Test
  public void testEquals() {
    Bike bike1 = new Bike("Cannondale");
    assertEquals(bike1, new Bike("Cannondale"));
  }

  @Test
  public void testEquals2() {
    Bike bike1 = new Bike("Cannondale");
    assertFalse(bike1.equals(new Car("a", 1)));
  }

  @Test
  public void testEquals3() {
    Vehicule bike1 = new Bike("Cannondale");
    assertFalse(bike1.equals(new Car("a", 1)));
  }

  @Test
  public void testEquals4() {
    Vehicule bike1 = new Bike("Cannondale");
    assertEquals(bike1, new Bike("Cannondale"));
  }
}
