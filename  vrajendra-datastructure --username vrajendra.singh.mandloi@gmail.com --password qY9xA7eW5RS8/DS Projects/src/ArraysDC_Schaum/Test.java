package ArraysDC_Schaum;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A implements Serializable {
    transient int a = 7;
    static int b = 9;
}
public class Test {
    public static void main(String... args) {
        A a = new A();
        try 
        {
            System.out.println("Before Serialization " + a.a + " " + a.b);
            
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("test.ser"));
            os.writeObject(a);
            os.close();
            
            ++a.b;
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(
                    "test.ser"));
            a = (A) is.readObject();
            is.close();
            
            System.out.print("After Serialization " +a.a + " " + a.b);
        } catch (Exception x) 
        {
            x.printStackTrace();
        }
    }
}