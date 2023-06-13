package mypack;

abstract class AbstractClass {
    public abstract void abstractMethod(); 
}

class OuterClass {
    static int i = 10; 
    int instanceVariable = 20; 

    public void method() {
        System.out.println("i == " + ++i); 
    }

    static class InnerClass extends AbstractClass {
      

        public void display() {
            System.out.println("i == " + i);
            // System.out.println("instanceVariable == " + instanceVariable); 
        }

        @Override
        public void abstractMethod() {
            System.out.println("Abstract method implementation"); 
        }
    }

    public static void main(String[] a) {
        OuterClass.InnerClass ic = new OuterClass.InnerClass();
        ic.display(); 
        ic.abstractMethod(); 

        OuterClass oc = new OuterClass();
        oc.method(); 
    }
}
