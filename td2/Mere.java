package fr.dauphine.javaavance.td2;

class Mere {

  public void a() {
    System.out.println("Mere_a");
  }

  void b(Fille fille) {
    System.out.println("Mere_b(Fille)");
  }

  void c() {
    System.out.println("Mere_c");
  }

  void c(Mere mere) {
    System.out.println("Mere_c(Mere)");
  }

  static void d() {
    System.out.println("static Mere_d");
  }

  private void f() {
    System.out.println("Mere_f");
  }

  public void printF() {
    f();
  }

  Object g() {
    System.out.println("Mere_g");
    return 2;
  }

  void j() throws Exception {
    System.out.println("Mere_j");
  }

  void l() throws Exception {
    System.out.println("Mere_l");
  }

  void m() throws Exception, ArrayIndexOutOfBoundsException {
    System.out.println("Mere_m");
  }
}
