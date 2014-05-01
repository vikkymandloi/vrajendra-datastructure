package java1_variablesPKG;

class ClassTest { 
    public    void mCPublic()    {}
    protected void mCProtected() {} 
              void mCDefault()   {}
    private   void mCPrivate()   {} 
} 

interface InterfaceTest {
    void mI();
}

class ClassInterface extends ClassTest implements InterfaceTest{
    public void mI() {}
}

class Test{
    <T extends ClassTest & InterfaceTest>
    void test(T t) { 	
        t.mI();           // OK
        t.mCPublic();     // OK 
        t.mCProtected();  // OK 
        t.mCDefault();    // OK
       // t.mCPrivate();    // Compile-time error
    } 
}


public class MembersAndTypeVariables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t1 = new Test();
	}

}
