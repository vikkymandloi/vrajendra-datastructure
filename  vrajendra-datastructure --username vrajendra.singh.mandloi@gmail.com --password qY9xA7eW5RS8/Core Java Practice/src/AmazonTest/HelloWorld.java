package AmazonTest;

import java.io.IOException;

class hello1{
    public static void method() throws Throwable
    {
        System.out.println("Helllo A");
    }
}

public class HelloWorld extends hello1{
    
    public static void method() throws IOException
    {
        System.out.println("Helllo B");
    }
    
    public static void main(String []args) throws Exception {
    	HelloWorld h1 = new HelloWorld();
         h1.method();
    }
}