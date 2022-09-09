<<<<<<< HEAD
public class Test2 {
    int i;
    public Test2(int x){
        i = x;
        System.out.println("From Cons");
    }
    public void print1(){
        System.out.println("Hello from parent 1");
    }
    public void print2(){
        System.out.println("Hello from parent 2");
    }
}

class Test3 extends Test2{
    Test3(){
        super(5);
    }

    public void print1(){
        System.out.println("Hello " + super.i + " " + i);
        super.print1();
        super.print2();

    }
}
=======
public class Test2 {
    int i;
    public Test2(int x){
        i = x;
        System.out.println("From Cons");
    }
    public void print1(){
        System.out.println("Hello from parent 1");
    }
    public void print2(){
        System.out.println("Hello from parent 2");
    }
}

class Test3 extends Test2{
    Test3(){
        super(5);
    }

    public void print1(){
        System.out.println("Hello " + super.i + " " + i);
        super.print1();
        super.print2();

    }
}
>>>>>>> ef0240ffc7654e56ba10f5d059856e4d7b556e41
