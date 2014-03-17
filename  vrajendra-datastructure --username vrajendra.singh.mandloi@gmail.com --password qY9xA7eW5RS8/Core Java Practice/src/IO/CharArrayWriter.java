package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CharArrayWriter {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		java.io.CharArrayWriter c1 = new java.io.CharArrayWriter();
		c1.write("Hi This is Vrajendra");
		FileWriter f1 = new FileWriter(new File("d:\\text6.txt"));
		FileWriter f2 = new FileWriter(new File("d:\\text7.txt"));
		c1.writeTo(f1);
		c1.writeTo(f2);
		System.out.println("Success");
		c1.close();
		f1.close();
		f2.close();
	}
}
