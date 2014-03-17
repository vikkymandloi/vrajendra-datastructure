package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStr {
	/*	Read the data from 2 files and write the same into another file.
	*/
	public static void sequenceInputStr() throws Exception{
		File filePath = new File("D://text1.txt");
		FileInputStream out = new FileInputStream(filePath.getAbsolutePath());
		File filePath1 = new File("D://text.txt");
		FileInputStream out1 = new FileInputStream(filePath1.getAbsolutePath());
		// sequence stream for writing the data to a stream from 2 different streams
		SequenceInputStream sios = new SequenceInputStream(out,out1);
		
		File filePath2 = new File("D://text3.txt");
		FileOutputStream fout = new FileOutputStream(filePath2.getAbsolutePath());
		
		int i=0;
		while((i=sios.read())!= -1){
			fout.write((char)i);
		}
		
		fout.close();
		sios.close();
		out1.close();
		out.close();
	}
	
	/*	Read the data from multiple files and write the same into another file.
	*/
	public static void sequenceInputStr2() throws Exception{
		File filePath = new File("D://text1.txt");
		FileInputStream out = new FileInputStream(filePath.getAbsolutePath());
		File filePath1 = new File("D://text.txt");
		FileInputStream out1 = new FileInputStream(filePath1.getAbsolutePath());
		File filePath2 = new File("D://text3.txt");
		FileInputStream out2 = new FileInputStream(filePath2.getAbsolutePath());
		// add the files to a vector
		Vector vec = new Vector();
		vec.add(out);
		vec.add(out1);
		vec.add(out2);
		
		Enumeration Emp = vec.elements();
		
		SequenceInputStream sios = new SequenceInputStream(Emp);
		
		int i=0;
		while((i=sios.read())!= -1){
			System.out.print((char)i);
		}
		
		sios.close();
		out2.close();
		out1.close();
		out.close();
	}
	
	public static void main(String[] args) throws Exception {
		//sequenceInputStr();
		sequenceInputStr2();
	}
}
