package fr.dauphine.javaavance.td2;

public class Add extends TwoArguments {

  public Add(Expr exp1, Expr exp2) {
    super(exp1, exp2);
  }

  @Override
  public double eval() {
    return this.exp1.eval() + this.exp2.eval();
  }
}
