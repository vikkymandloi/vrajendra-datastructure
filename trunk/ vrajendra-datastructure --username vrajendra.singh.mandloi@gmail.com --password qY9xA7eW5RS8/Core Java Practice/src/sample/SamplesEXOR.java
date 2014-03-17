package sample;

class sample
{
	public void Hello() throws Exception{
		System.out.println("Hello from Sample");
	}
}


public class SamplesEXOR extends sample{
	@Override
	public void Hello() {
		System.out.println("Hello from SamplesEXOR");
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		sample s1 = new SamplesEXOR();
		s1.Hello();
	}
}
