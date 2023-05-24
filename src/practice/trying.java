package practice;

public class trying {
    public static void main(String[] args) {
        A a = new A();
        A b = new B();
        A c= new C();
        boolean bool1= a instanceof B;
        boolean bool2= c instanceof B;
    }


}
class A {

}
class B extends A {

}
class C extends B{

}