public class Constructor {
    int a;
    float b;
    String c;
    Constructor(){
        System.out.println("Default Constructor");
    }
    Constructor(int a){
        this.a=a;
        System.out.println("Parameterized Constructor with int");
    }
    Constructor(int a,float b){
        this.a=a;
        this.b=b;
        System.out.println("Parameterized Constructor with int and float");
    }
    Constructor(int a,float b,String c){
        this.a=a;
        this.b=b;
        this.c=c;
        System.out.println("Parameterized Constructor with int,float and String");
    }

    public static void main(String[] args) {
        Constructor obj1=new Constructor();
        Constructor obj2=new Constructor(10);
        System.out.println("Inside object2:- "+"a: "+obj2.a+", b: "+obj2.b+", c: "+obj2.c);
        Constructor obj3=new Constructor(10,20.5f);
        System.out.println("Inside object3:- "+"a: "+obj3.a+", b: "+obj3.b+", c: "+obj3.c);
        Constructor obj4=new Constructor(10,20.5f,"Hello");
        System.out.println("Inside object4:- "+"a: "+obj4.a+", b: "+obj4.b+", c: "+obj4.c);
    }
}