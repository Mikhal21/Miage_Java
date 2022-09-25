package fr.dauphine.javaavance.td2;

public class Value extends Expr {
  private double d;

  public Value(double d) {
    this.d = d;
  }

  @Override
  public double eval() {
    return this.d;
  }
}
