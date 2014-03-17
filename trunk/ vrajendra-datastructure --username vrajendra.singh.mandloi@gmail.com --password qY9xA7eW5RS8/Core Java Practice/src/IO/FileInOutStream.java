package IO;

import java.io.File;
import java.io.*;

public class FileInOutStream {

	public void FileOutputStr() throws Exception {			// FileOutputStream
		File filepath = new File("d://text.txt");
		FileOutputStream out = new FileOutputStream(filepath.getCanonicalPath());
		out.write("This is my First File 11".toString().getBytes());
		out.flush();
		out.close();
		System.out.println("File Writing Done");
	}
	
	public void FileInputStream() throws Exception {			// FileInputStream
		File filepath = new File("d://text.txt");
		FileInputStream out = new FileInputStream(filepath.getAbsolutePath());
		int i=0;
		while((i=out.read())!=-1)
			System.out.print((char)i);
		out.close();
		System.out.println("File Reading Done");
	}
	
	public static void main(String[] args) throws Exception{
		//new StreamingTest().FileOutputStr();
		new FileInOutStream().FileInputStream();
	}
}
