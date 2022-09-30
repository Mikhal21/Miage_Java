package fr.dauphine.javaavance.td2;

public abstract class TwoArguments extends Expr {
  protected Expr exp1;
  protected Expr exp2;

  public TwoArguments(Expr exp1, Expr exp2) {
    this.exp1 = exp1;
    this.exp2 = exp2;
  }
}
